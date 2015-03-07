package com.github.mlaursen.mybrews.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseResource {
  
  @PersistenceContext(unitName = "mybrews")
  protected EntityManager em;
}
