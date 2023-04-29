package edu.iu.c322.group10.orderservice.controller;

import edu.iu.c322.group10.orderservice.model.Item;
import edu.iu.c322.group10.orderservice.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    ItemRepository repository;

    public ItemController(ItemRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Item> findAll(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Item item){
        Item newItem = repository.save(item);
        return newItem.getItemId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Item item, @PathVariable int id){
        item.setItemId(id);
        repository.save(item);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        Item item = new Item();
        item.setItemId(id);
        repository.delete(item);
    }
}
