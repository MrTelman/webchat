package com.example.webchat.repositories;

import com.example.webchat.models.ChatRoomModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ChatRoomRepository extends PagingAndSortingRepository<ChatRoomModel, Long> {
    /**
     * This query returns chats that user already subscribed
     * @param userId
     * @return
     */
    @Query("from ChatRoomModel ch left join ChatModel chm on ch.id = chm.chatRoomId where chm.userId = :userId")
    Iterable<ChatRoomModel> findMyChats(@Param("userId") Long userId);
}
