package org.softwire.training.resources;

import org.hibernate.validator.constraints.NotEmpty;
import org.softwire.training.db.UserDao;
import org.softwire.training.models.User;
import org.softwire.training.views.InvalidUsernameView;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/signupError")
@Produces(MediaType.TEXT_HTML)
public class InvalidUsernameResource{

    @GET
    @Produces(MediaType.TEXT_HTML)
    public InvalidUsernameView get() {
        return new InvalidUsernameView();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response post() {
        return Response.seeOther(URI.create("/signup")).build();
    }
}
