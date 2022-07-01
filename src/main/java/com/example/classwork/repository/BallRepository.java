package com.example.classwork.repository;

import com.example.classwork.model.Ball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;


public interface BallRepository extends JpaRepository<Ball, Long> {
    List<Ball> findBallBySize(Integer size);

    List<Ball> findBallByWeight(Float weight);

    List<Ball> findBallByColor(String color);


//    @Query(value = "SELECT st FROM Ball st WHERE st.size >= ?1")
//    Collection<Ball> findAllBallbySize(Integer size);



}
//jpql query equals
//spring data custom query