package br.com.edu.foodfusion.api.order.service;

import br.com.edu.foodfusion.api.customer.service.CustomerService;
import br.com.edu.foodfusion.api.establishments.restaurant.search.SearchRestaurantService;
import br.com.edu.foodfusion.shared.database.entity.customer.CustomerEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.MenuItemEntity;
import br.com.edu.foodfusion.shared.database.entity.establishment.restaurant.RestaurantEntity;
import br.com.edu.foodfusion.shared.database.entity.order.OrderEntity;
import br.com.edu.foodfusion.shared.database.entity.order.OrderItemEntity;
import br.com.edu.foodfusion.shared.database.enums.OrderStatusEnum;
import br.com.edu.foodfusion.shared.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SearchRestaurantService searchRestaurantService;

    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public OrderEntity findById(long orderId) {
        return orderRepository
                .findById(orderId)
                .orElse(null);
    }

    public List<OrderEntity> findByStatus(String status) {
        OrderStatusEnum orderStatus = OrderStatusEnum.valueOf(status);

        return orderRepository
                .findByStatus(orderStatus)
                .orElse(null);
    }

    public OrderEntity create(long establishmentId, long customerId, List<Long> itemsId) {

        RestaurantEntity establishmentFound = searchRestaurantService.getById(establishmentId);
        CustomerEntity customerFound = customerService.findById(customerId);

        if (establishmentFound == null) {
            throw new NoSuchElementException("Establishment not found with given id: " + establishmentId);
        }

        if (customerFound == null) {
            throw new NoSuchElementException("Customer not found with given id: " + customerId);
        }

        List<MenuEntity> menus = establishmentFound.getMenus();
        if (menus == null) {
            throw new NoSuchElementException("Menu not found! Create a Menu first before creating orders.");
        }

        Map<Long, MenuItemEntity> menuItemById = menus.stream()
                .flatMap(menu -> menu.getItems().stream())
                .collect(Collectors.toMap(MenuItemEntity::getId, item -> item));

        OrderEntity order = new OrderEntity();
        order.setEstablishment(establishmentFound);
        order.setCustomer(customerFound);

        List<OrderItemEntity> orderItems = new ArrayList<>();

        for (Long itemId : itemsId) {
            MenuItemEntity item = menuItemById.get(itemId);
            if (item != null) {
                OrderItemEntity orderItem = new OrderItemEntity();
                orderItem.setTitle(item.getName());
                orderItem.setUnitPrice(BigDecimal.valueOf(item.getUnitPrice()));
                orderItem.setQuantity(1);
                orderItem.setOrder(order);
                orderItems.add(orderItem);
            } else {
                throw new NoSuchElementException("MenuItem not found with id: " + itemId);
            }
        }

        order.setItems(orderItems);

        double total = order.getItems()
                .stream()
                .mapToDouble(orderItem -> orderItem.getUnitPrice().doubleValue() * orderItem.getQuantity())
                .sum();

        order.setTotal(BigDecimal.valueOf(total));
        order.setStatus(OrderStatusEnum.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }
}
