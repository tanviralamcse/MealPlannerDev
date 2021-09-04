package com.example.demo12.repository;

import com.example.demo12.models.User;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userrepository extends JpaRepository<User, Long> {

}
