package com.writer.bll;

import com.writer.bo.User;
import com.writer.dal.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO dao;

    public List<User> listAllUsers() {
        return dao.findAll();
    }

    public User addUser(User user) {
        return dao.save(user);
    }
    public void deleteUser(User user) {
        dao.delete(user);
    }
}
