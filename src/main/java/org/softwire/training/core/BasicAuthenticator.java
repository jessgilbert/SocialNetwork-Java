package org.softwire.training.core;

import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwire.training.db.UserDao;
import org.softwire.training.models.User;
import org.softwire.training.models.UserPrincipal;

import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicAuthenticator implements Authenticator<BasicCredentials, UserPrincipal> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicAuthenticator.class);
    private final UserDao userDao;

    public BasicAuthenticator(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<UserPrincipal> authenticate(BasicCredentials credentials) {

        // TODO: Implement real authentication!
        if (userDao.areUsernameAndPasswordInDb(credentials)) {
            UserPrincipal user = new UserPrincipal(new User(credentials.getUsername()));
            LOGGER.debug("Successfully authenticated user: {}", user);
            return Optional.of(user);
        } else {
            LOGGER.debug("Failed to authenticate user, incorrect password.  Username: {}", credentials.getUsername());
            System.out.println("Wrong password!");
            return Optional.empty();
        }
    }




}
