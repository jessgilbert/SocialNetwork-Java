package org.softwire.training.db;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.models.User;

import java.util.List;

public class UserDao {

    private final Jdbi jdbi;

    public UserDao(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void addUser(User user) {
        try (Handle handle = jdbi.open()) {
            handle.createUpdate("INSERT INTO users (username, fullname, password) VALUES (:username, :fullname, :password)")
                    .bind( "username", user.getUsername())
                    .bind("fullname", user.getFullname())
                    .bind("password", user.getPassword())
                    .execute();
        }
    }
}