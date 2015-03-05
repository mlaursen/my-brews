/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
public interface AllRetrievableResource<E extends GeneratedIdEntity> {

  /**
   * Gets all of the specified entity.
   * 
   * <p>The url should be as follows:
   * <pre>
   *    /api/{entityName}
   * </pre>
   * 
   * @return a List of the Entity
   */
  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  List<E> retrieveAll();
}
