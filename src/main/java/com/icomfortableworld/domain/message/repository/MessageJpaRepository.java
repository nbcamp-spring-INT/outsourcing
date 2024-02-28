package com.icomfortableworld.domain.message.repository;

import com.icomfortableworld.domain.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageJpaRepository extends JpaRepository <Message,Long> {

    List<Message> findByToNameAndReadFalse(String username);

}
