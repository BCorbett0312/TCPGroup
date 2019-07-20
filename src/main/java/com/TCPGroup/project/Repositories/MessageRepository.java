package com.TCPGroup.project.Repositories;

import com.TCPGroup.project.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> getMessagesByChannel(Integer toChannelId);

}
