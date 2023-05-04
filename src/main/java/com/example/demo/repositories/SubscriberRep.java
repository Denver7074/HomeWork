package com.example.demo.repositories;

import com.example.demo.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRep extends JpaRepository<Subscriber,Long> {
}
