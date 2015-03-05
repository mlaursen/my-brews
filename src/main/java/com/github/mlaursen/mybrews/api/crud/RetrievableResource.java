/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
public interface RetrievableResource<E extends GeneratedIdEntity> {

  /**
   * Attempts to find an entity by the given id.
   * 
   * <p>The url should look as follows:
   * <code><pre>
   *    /api/{entityName}/{entityId}
   * </pre></code>
   * @param id the entity's id
   * @return the entity or null
   */
  @GET
  @Path("/{entityId}")
  Response retrieve(@PathParam("entityId") Long id);
}
