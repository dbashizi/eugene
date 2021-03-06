package com.example;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
    Event findById(Integer id);
    Event findByName(String name);
}
