/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 * Defines the standards for an entity that can be updated.
 * 
 * @author mlaursen
 *
 */
public interface UpdateableResource<E extends GeneratedIdEntity> {

  /**
   * Attempts to update an entity by entity id and JSON data. If the entity 
   * was successfully updated, {@link HttpServletResponse#SC_CREATED} should be
   * returned along with the updated entity as json. Otherwise {@link HttpServletResponse#SC_BAD_REQUEST}
   * will be returned.
   * 
   * <p>The url should look as follows:
   * <pre>
   *    /api/{entityName}/update
   * </pre>
   * 
   * @param entity the entity to update
   * @return a Response representing the result of the update action
   */
  @PUT
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  Response update(E entity);
}
