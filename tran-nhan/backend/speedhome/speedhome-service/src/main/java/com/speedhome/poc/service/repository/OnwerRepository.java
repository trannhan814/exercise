package com.speedhome.poc.service.repository;

import com.speedhome.poc.service.model.OnwerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnwerRepository extends JpaRepository<OnwerEntity, String> {
    boolean existsById(String id);
}
