package com.TCPGroup.project.Repositories;

import com.TCPGroup.project.Models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

    Channel getById(Integer id);
}
