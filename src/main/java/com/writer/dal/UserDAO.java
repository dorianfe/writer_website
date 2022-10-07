package com.writer.dal;

import com.writer.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

}
