package com.example.webchat.repositories;

import com.example.webchat.models.UserModel;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {
    Optional<UserModel> findByLogin(String login);

    @Query("from UserModel u WHERE u.active = true ")
    Iterable<UserModel> findActiveUsers();

    @Modifying
    @Transactional
    @Query("UPDATE UserModel u SET u.active = TRUE WHERE u.login = :login")
    void markAsActive(@Param("login") String login);
}
