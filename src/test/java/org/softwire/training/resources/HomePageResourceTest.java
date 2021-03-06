package org.softwire.training.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwire.training.db.WallDao;
import org.softwire.training.models.UserPrincipal;
import org.softwire.training.models.User;
import org.softwire.training.views.HomePageView;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomePageResourceTest {
    private static final User LOGGED_IN_USER = new User("jerry");
    private static final UserPrincipal USER_PRINCIPAL = new UserPrincipal(LOGGED_IN_USER);
    private static final List<User> USERS = Arrays.asList(new User("rick"), new User("morty"));

    private final WallDao wallDao = mock(WallDao.class);
    private final HomePageResource resource = new HomePageResource(wallDao);

    @BeforeEach
    public void beforeAll() {
        when(wallDao.getAllUsers()).thenReturn(USERS);
    }

    @Test
    public void displaysAllKnownUsers() {
        HomePageView homePageView = resource.get(USER_PRINCIPAL);

        assertThat(homePageView.getUsers(), equalTo(USERS));
    }

    @Test
    public void displaysLoggedInUser() {
        HomePageView homePageView = resource.get(USER_PRINCIPAL);

        assertThat(homePageView.getLoggedInUser(), equalTo(LOGGED_IN_USER));
    }
}
