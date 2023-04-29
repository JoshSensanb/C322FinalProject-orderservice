package edu.iu.c322.group10.orderservice.controller;

import edu.iu.c322.group10.orderservice.model.Item;
import edu.iu.c322.group10.orderservice.model.Order;
import edu.iu.c322.group10.orderservice.repository.ItemRepository;
import edu.iu.c322.group10.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;


    public OrderController(OrderRepository orderRepository, ItemRepository itemRepository){
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
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

    @GetMapping("/status/get/{id}")
    public String getOrderStatus(@PathVariable int id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order order = optionalOrder.get();
        return order.getOrderStatus();
    }
    @PutMapping("/status/update/{id}")
    public int updateOrderStatus(@RequestBody Order order,@PathVariable int id){
        Order newRefund = order;
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order oldOrder = optionalOrder.get();
        oldOrder.setOrderStatus(newRefund.getOrderStatus());

        orderRepository.save(oldOrder);
        return oldOrder.getOrderId();
    }
    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable int id){
        Optional<Order> optionalOrder =orderRepository.findById(id);
        Order order = optionalOrder.get();
        return order;

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