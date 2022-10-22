package com.example.webapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.webapp.entities.EMAIL;

import java.util.List;

public interface EMAILREPOSITORY extends CrudRepository<EMAIL, Integer> {

@Query(value = "select count(*) from emails e where e.users_id = ?1", nativeQuery = true)
public int countByUsersId(int id);

    @Query(value = "select * from emails e", nativeQuery = true)
 public List<EMAIL> findAll();
}

