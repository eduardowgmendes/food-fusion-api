package br.com.edu.foodfusion.api.order.controller;

import br.com.edu.foodfusion.api.order.service.OrderService;
import br.com.edu.foodfusion.shared.database.entity.order.OrderEntity;
import br.com.edu.foodfusion.shared.database.entity.order.OrderItemEntity;
import br.com.edu.foodfusion.shared.database.enums.OrderStatusEnum;
import br.com.edu.foodfusion.shared.dto.order.OrderDTO;
import br.com.edu.foodfusion.shared.dto.order.OrderItemDTO;
import br.com.edu.foodfusion.shared.request.CreateOrderRequest;
import br.com.edu.foodfusion.shared.response.DefaultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "List all orders that has been registered.", description = "Return all orders enrolled.")
    @GetMapping
    public ResponseEntity<DefaultResponse<List<OrderDTO>>> findAll() {
        List<OrderEntity> allOrders = orderService.findAll();

        if (allOrders.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(DefaultResponse.create(true, format("These are all the orders found: %d Orders", allOrders.size()),
                allOrders
                        .stream()
                        .map(OrderEntity::toDTO)
                        .collect(Collectors.toList())));
    }


    @Operation(summary = "Find a specific order by its ID.", description = "Return a order that matches the provided orderId path variable.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found successfully."),
            @ApiResponse(responseCode = "404", description = "Order not found for the given ID.")
    })
    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DefaultResponse<OrderDTO>> findById(@PathVariable(name = "orderId") long orderId) {
        OrderEntity orderFound = orderService.findById(orderId);
        if (orderFound != null)
            return ResponseEntity.ok(DefaultResponse.create(true, "We found this order.", OrderEntity.toDTO(orderFound)));
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Find all orders by a specific Status.", description = "Find all orders that have been flagged with a specific status.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders found successfully."),
            @ApiResponse(responseCode = "404", description = "Nothing found with provided status.")
    })
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
