package edu.iu.c322.group10.orderservice.repository;

import edu.iu.c322.group10.orderservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
