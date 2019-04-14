package br.com.fiap.orderservice.controllers;

import br.com.fiap.orderservice.bean.Order;
import br.com.fiap.orderservice.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import io.swagger.annotations.*;

@Slf4j
@RestController
@Api(value = "Order", description = "Order Controller REST API")
public class OrderController {

    private OrderService service;

    public OrderController() {
        this.service = new OrderService();
    }

    @ApiOperation(httpMethod = "GET", value = "Find order by ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Returns order object", response = Order.class)
    })
    @GetMapping("/findById/{id}")
    public ResponseEntity<Order> find(@PathVariable("id") int id){
        Order order = this.service.findById(id);
        if (order == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "POST", value = "Save new order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns created order and current status", response = Order.class)
    })
    @PostMapping("/save")
    public ResponseEntity<Object> saveOrder(@RequestBody Order order){
        Order savedOrder = this.service.save(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/findById/{id}")
                .buildAndExpand(savedOrder.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(httpMethod = "PATCH", value = "Update order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns success message")
    })
    @PatchMapping("/update")
    public ResponseEntity updateOrder(@RequestBody Order order){
        if (!this.service.update(order))
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);

        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "DELETE", value = "Delete order by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retuns success message")
    })
    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") int id){
        if (this.service.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
