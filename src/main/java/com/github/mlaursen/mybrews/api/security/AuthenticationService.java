package com.github.mlaursen.mybrews.api.security;

import java.util.UUID;

import javax.ejb.Stateless;

@Stateless
public class AuthenticationService {
  private static final String TEST = "test";

  public AuthenticationAccessElement login(AuthenticationLoginElement loginElement) {
    String username = loginElement.getUsername();
    String password = loginElement.getPassword();
    
    if(TEST.equals(username) && TEST.equals(password)) {
      return new AuthenticationAccessElement(username, UUID.randomUUID().toString(), "admin");
    }
    
    return null;
  }
}
