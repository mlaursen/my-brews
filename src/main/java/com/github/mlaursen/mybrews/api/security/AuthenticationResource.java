package com.github.mlaursen.mybrews.api.security;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.mlaursen.mybrews.api.BaseResource;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource extends BaseResource {
  
  @Inject
  private AuthenticationService auth;
  
  @POST
  @Path("/login")
  @PermitAll
  public AuthenticationAccessElement login(@Context HttpServletRequest request, AuthenticationLoginElement loginElement) {
    AuthenticationAccessElement access = auth.login(loginElement);
    if(access != null) {
      request.getSession().setAttribute(AuthenticationAccessElement.AUTH_ID, access.getAuthId());
      request.getSession().setAttribute(AuthenticationAccessElement.AUTH_TOKEN, access.getAuthToken());
    }
    
    return access;
  }
}
