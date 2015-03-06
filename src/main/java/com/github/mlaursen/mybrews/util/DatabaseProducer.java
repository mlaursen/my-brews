/**
 * 
 */
package com.github.mlaursen.mybrews.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Should produce the entity manager from the persistence context.
 * @author mlaursen
 *
 */
public class DatabaseProducer {
  @Produces
  @PersistenceContext(unitName = "mybrews")
  @MyBrewsDB
  protected EntityManager em;
}
