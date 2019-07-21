package com.TCPGroup.project.Repositories;

import com.TCPGroup.project.Models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

    Channel getById(Integer id);

    List<Channel> findAllByDirectFalse();

    List<Channel> findAllByIdIn(List<Integer> ids);
}
