/**
 * 
 */
package com.github.mlaursen.mybrews.api;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.mlaursen.mybrews.util.MyBrewsDB;

/**
 *
 * @author mlaursen
 *
 */
public class DatabaseProducer {
  @Produces
  @PersistenceContext(unitName = "mybrews")
  @MyBrewsDB
  protected EntityManager em;
}
