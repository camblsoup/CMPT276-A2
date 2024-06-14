package com.example.cmpt276a2.Models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RectangleRepository extends JpaRepository<Rectangle, Integer> {
    List<Rectangle> findById(int id);
    List<Rectangle> findByOrderByIdAsc();
}
