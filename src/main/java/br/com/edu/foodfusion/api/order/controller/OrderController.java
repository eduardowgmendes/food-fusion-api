package br.com.edu.foodfusion.api.order.controller;

import br.com.edu.foodfusion.api.order.service.OrderService;
import br.com.edu.foodfusion.shared.database.entity.order.OrderEntity;
import br.com.edu.foodfusion.shared.database.enums.OrderStatusEnum;
import br.com.edu.foodfusion.shared.dto.order.OrderDTO;
import br.com.edu.foodfusion.shared.request.CreateOrderRequest;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<DefaultResponse<List<OrderDTO>>> findAll() {
        List<OrderEntity> allOrders = orderService.findAll();
        if (allOrders.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DefaultResponse.create(true, format("These are all the orders found: %d Orders", allOrders.size()), allOrders
                .stream()
                .map(OrderEntity::toDTO).collect(Collectors.toList())));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<DefaultResponse<OrderDTO>> findById(@PathVariable(name = "orderId") long orderId) {
        OrderEntity orderFound = orderService.findById(orderId);
        if (orderFound != null)
            return ResponseEntity.ok(DefaultResponse.create(true, "We found this order.", OrderEntity.toDTO(orderFound)));
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-status")
    public ResponseEntity<DefaultResponse<List<OrderDTO>>> findByStatus(@RequestParam("status") String status) {
        List<OrderEntity> ordersFound = orderService.findByStatus(status);
        if (ordersFound.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DefaultResponse.create(true, format("These are all the orders found: %d Orders", ordersFound.size()), ordersFound.stream().map(OrderEntity::toDTO).collect(Collectors.toList())));
    }

    @PostMapping("/create")
    public ResponseEntity<DefaultResponse<OrderDTO>> create(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        long establishmentId = createOrderRequest.getEstablishmentId();
        long customerId = createOrderRequest.getCustomerId();
        List<Long> itemsIds = createOrderRequest.getItemIds();

        OrderEntity orderCreated = orderService.create(establishmentId, customerId, itemsIds);

        if (orderCreated != null)
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(DefaultResponse.create(true, "New order has been created.", OrderEntity.toDTO(orderCreated)));

        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .build();
    }

}
