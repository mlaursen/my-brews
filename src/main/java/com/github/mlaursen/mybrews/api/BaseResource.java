package com.github.mlaursen.mybrews.api;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.mlaursen.mybrews.util.MyBrewsDB;

/**
 * A simple class that defines the entity manager to be used in Web Resources.
 * 
 * @author laursenm
 *
 */
public abstract class BaseResource {
  
  @Inject
  @MyBrewsDB
  protected EntityManager em;
}
