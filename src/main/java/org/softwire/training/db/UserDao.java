package org.softwire.training.db;

import io.dropwizard.auth.basic.BasicCredentials;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.models.User;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

public class UserDao {

    private final Jdbi jdbi;

    public UserDao(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void addUser(User user) throws  Exception{

        try (Handle handle = jdbi.open()) {
            handle.createUpdate("INSERT INTO users (username, fullname, password) VALUES (:username, :fullname, :password)")
                    .bind( "username", user.getUsername())
                    .bind("fullname", user.getFullname())
                    .bind("password", user.getPassword())
                    .execute();
        }
    }

    public boolean areUsernameAndPasswordInDb(BasicCredentials credentials){

        try (Handle handle = jdbi.open()) {
            List<User> result = handle.createQuery("SELECT * FROM users WHERE username= :username AND password = :password")
                    .bind("username", credentials.getUsername())
                    .bind("password", credentials.getPassword())
                    .mapToBean(User.class)
                    .list();

            return result != null;
        }
    }
}