package com.github.mlaursen.mybrews.api;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/authen")
public class LoginResource {

  @POST
  @Path("/login")
  @Consumes({MediaType.APPLICATION_JSON})
  public Response login(LoginUser user) {
    if("test".equals(user.username) && "test".equals(user.password)) {
      return Response.ok(new LoginResponse(user), MediaType.APPLICATION_JSON).build();
    }
    
    return Response.status(Status.FORBIDDEN).build();
  }
  
  public static class LoginResponse {
    private String id;
    private User user;
    
    public LoginResponse(LoginUser user) {
      this.id = user.username.hashCode() + "" + user.password.hashCode();
      this.user = new User(user);
    }
    
    public void setId(String id) {
      this.id = id;
    }
    
    public String getId() {
      return id;
    }
    
    public void setUser(User user) {
      this.user = user;
    }
    
    public User getUser() {
      return user;
    }
  }
  
  public static class User {
    private Long id;
    private String username;
    private String role;
    
    public User(LoginUser user) {
      this.id = 1L;
      this.username = user.username;
      this.role = "admin";
    }
    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }
    public String getUsername() {
      return username;
    }
    public void setUsername(String username) {
      this.username = username;
    }
    public String getRole() {
      return role;
    }
    public void setRole(String role) {
      this.role = role;
    }
    
    
  }
  
  public static class LoginUser {
    private String username;
    private String password;
    
    public void setUsername(String username) {
      this.username = username;
    }
    
    public String getUsername() {
      return username;
    }
    
    public void setPassword(String password) {
      this.password = password;
    }
    
    public String getPassword() {
      return password;
    }
  }
}
