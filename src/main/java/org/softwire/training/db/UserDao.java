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

    public List<User> addUser(User user) {
        try (Handle handle = jdbi.open()) {
            return handle.createQuery("INSERT INTO socialnetwork.users (username, fullname, password) VALUES (:username, :fullname, :password)")
                    .bind( "username", )
                    .mapToBean(User.class)
                    .list();
        }
    }
}