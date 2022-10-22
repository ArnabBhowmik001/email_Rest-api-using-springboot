package com.example.webapp.repository;

import com.example.webapp.entities.users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface USERREPOSITORY extends CrudRepository<users, Integer> {
    @Query(value = "select * from users u", nativeQuery = true)
    public List<users> findAll();
}

