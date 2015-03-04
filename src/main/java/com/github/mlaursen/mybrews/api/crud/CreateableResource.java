/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
public interface CreateableResource<E extends GeneratedIdEntity> {

  /**
   * Attempts to create an entity from JSON. If there was a successful creation,
   * the {@link HttpServletResponse#SC_CREATED} should be returned. Otherwise,
   * {@link HttpServletResponse#SC_BAD_REQUEST} will be returned.
   * 
   * <p>The url should look as follows:
   * <code><pre>
   *    /api/{entityName}/create
   * </pre></code>
   * 
   * @param entity the entity to create
   * @return a HttpServletResponse representing the result of the creation action
   */
  @POST
  @Path("/create")
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  Response create(E entity);
}
