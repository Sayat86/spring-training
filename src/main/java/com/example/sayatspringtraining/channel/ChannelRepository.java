package com.example.sayatspringtraining.channel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    List<Channel> findByOwnerId(int ownerId);

}
