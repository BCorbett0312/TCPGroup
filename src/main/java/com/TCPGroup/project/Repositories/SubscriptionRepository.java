package com.TCPGroup.project.Repositories;

import com.TCPGroup.project.Models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
 //   Subscription getById(Integer id);
    List<Subscription> findByUserId(Integer id);
    List<Subscription> findByChannelId(Integer id);

    @Query(value="SELECT * FROM subscription WHERE user_id = :userId1 AND channel_id IN (SELECT channel_id FROM subscription WHERE user_id = :userId2) AND channel_id IN (SELECT id FROM channel where direct = 1)",nativeQuery = true)
    Subscription findDirectChannelSub(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2);
}
