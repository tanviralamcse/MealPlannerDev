package com.example.demo12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo12.models.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
