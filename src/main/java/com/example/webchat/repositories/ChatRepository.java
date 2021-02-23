package com.example.webchat.repositories;

import com.example.webchat.models.ChatModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends PagingAndSortingRepository<ChatModel, Long> {
}
