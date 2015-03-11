package com.github.mlaursen.mybrews.api.security;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthenticationAccessElement implements Serializable {
  private static final long serialVersionUID = 1L;
  public static final String AUTH_ID = "auth-id";
  public static final String AUTH_TOKEN = "auth-token";
  
  private String authId;
  private String authToken;
  private String authPermission;
  
  public AuthenticationAccessElement() {
  }
  
  public AuthenticationAccessElement(String authId, String authToken, String authPermission) {
    this.authId = authId;
    this.authToken = authToken;
    this.authPermission = authPermission;
  }

  public String getAuthId() {
    return authId;
  }

  public void setAuthId(String authId) {
    this.authId = authId;
  }

  public String getAuthToken() {
    return authToken;
  }

  public void setAuthToken(String authToken) {
    this.authToken = authToken;
  }

  public String getAuthPermission() {
    return authPermission;
  }

  public void setAuthPermission(String authPermission) {
    this.authPermission = authPermission;
  }
  
  

}
