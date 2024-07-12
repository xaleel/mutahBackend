package app.mutah.repository.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import app.mutah.enums.UserRole;
import app.mutah.model.UserModel;
import app.mutah.model.row_mappers.UserRowMapper;

@Repository
public class UserRepository {

    @Autowired
    private JdbcClient jdbcClient;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRowMapper userRowMapper;

    public UserRepository() {
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public void create(UserModel user) {
        int updated = jdbcClient.sql(
                "INSERT INTO user_account (name, surname, phone, email, password, role, created_at, updated_at, country, banned) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                .params(user.getName(), user.getSurname(), user.getPhone(), user.getEmail(),
                        passwordEncoder.encode(user.getPassword().toString()), user.getRole().toString(),
                        user.getCreatedAt().toString(), user.getUpdatedAt().toString(), user.getCountry().toString(),
                        user.getBanned())
                .update();
        if (updated != 1) {
            throw new RuntimeException("Failed to create user.");
        }
    }

    public void update(UserModel user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UserModel> findAll(Integer page, Integer pageSize, String search) {
        String searchString = String.format("%%%s%%", Objects.toString(search, ""));
        List<UserModel> users = jdbcClient.sql(
                "SELECT id, name, surname, phone, image, email, password, role, created_at, updated_at, country, banned, push_token, verified FROM user_account WHERE name ILIKE ? OR surname ILIKE ? OR email ILIKE ? LIMIT ? OFFSET ?")
                .params(searchString, searchString, searchString, pageSize, Math.min(0, page - 1))
                .query(userRowMapper).list();
        return users;
    }

    public Optional<UserModel> findById(Long id) {
        Optional<UserModel> user = jdbcClient.sql(
                "SELECT id,name,surname,phone,image,email,password,role,created_at,updated_at,country,banned,push_token,verified FROM user_account WHERE id=?")
                .params(id)
                .query(userRowMapper).optional();
        return user;
    }

    public List<UserModel> findByRole(UserRole role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
