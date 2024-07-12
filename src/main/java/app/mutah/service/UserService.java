package app.mutah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mutah.model.UserModel;
import app.mutah.repository.impl.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getUsers(Integer page, Integer pageSize, String search) {
        return userRepository.findAll(page, pageSize, search);
    }
}
