package edu.iu.c322.group10.orderservice.controller;

import edu.iu.c322.group10.orderservice.model.Order;
import edu.iu.c322.group10.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(Order order){
        Order newOrder = orderRepository.save(order);
        return newOrder.getOrderId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Order order, @PathVariable int id){
        order.setOrderId(id);
        orderRepository.save(order);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Order order = new Order();
        order.setOrderId(id);
        orderRepository.delete(order);
    }
}