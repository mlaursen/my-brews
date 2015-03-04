/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
public interface UpdateableResource<E extends GeneratedIdEntity> {

  /**
   * Attempts to update an entity by entity id and JSON data. If the entity 
   * was successfully updated, {@link HttpServletResponse#SC_CREATED} should be
   * returned. Otherwise {@link HttpServletResponse#SC_BAD_REQUEST} will
   * be returned.
   * 
   * <p>The url should look as follows:
   * <code><pre>
   *    /api/{entityName}/update
   * </pre></code>
   * 
   * @param entity the entity to update
   * @param entityId the entity's id
   * @return a HttpServletResponse representing the result of the update action
   */
  @PUT
  @Path("/update")
  Response update(E entity);
}
