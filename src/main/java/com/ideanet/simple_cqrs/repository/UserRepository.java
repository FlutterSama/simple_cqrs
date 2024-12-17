package com.ideanet.simple_cqrs.repository;

import com.ideanet.simple_cqrs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
