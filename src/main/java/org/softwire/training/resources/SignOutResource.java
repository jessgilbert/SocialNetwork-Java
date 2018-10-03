package org.softwire.training.resources;

import org.hibernate.validator.constraints.NotEmpty;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwire.training.db.UserDao;
import org.softwire.training.models.User;
import org.softwire.training.views.NewUserView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


@Path("/signOut")
public class SignOutResource {
}
