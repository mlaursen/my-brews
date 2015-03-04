/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
   * 
   * @return a List of entities
   */
  @GET
  @Path("/retrieveAll")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  java.util.List<E> retrieveAll();
}
