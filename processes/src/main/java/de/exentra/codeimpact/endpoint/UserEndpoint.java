package de.exentra.codeimpact.endpoint;

import de.exentra.codeimpact.model.User;
import de.exentra.codeimpact.repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/user")
public class UserEndpoint {

    @Inject
    UserRepository userRepository;

    @GET
    @Path("/{id}")
    public User findById(@PathParam("id") Long id) {
    return userRepository.findById(id)
    }
}
