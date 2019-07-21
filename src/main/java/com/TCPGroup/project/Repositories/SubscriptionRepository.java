package com.TCPGroup.project.Repositories;

import com.TCPGroup.project.Models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
 //   Subscription getById(Integer id);
    List<Subscription> findByUserId(Integer id);
    List<Subscription> findByChannelId(Integer id);
}
