/**
 * 
 */
package com.github.mlaursen.mybrews.util;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
public class ResponseBuilder {
  private ResponseBuilder() {}
  
  public static <E extends GeneratedIdEntity> Response buildResponse(Status satus, E entity, MediaType type) {
    return Response.status(satus).type(type).entity(entity).build();
  }
  
  public static <E extends GeneratedIdEntity> Response buildResponse(Status status, E entity) {
    return buildResponse(status, entity, MediaType.APPLICATION_JSON_TYPE);
  }
  
  public static <E extends GeneratedIdEntity> Response buildResponse(Status satus, List<E> entity, MediaType type) {
    return Response.status(satus).type(type).entity(entity).build();
  }
  
  public static <E extends GeneratedIdEntity> Response buildResponse(Status status, List<E> entity) {
    return buildResponse(status, entity, MediaType.APPLICATION_JSON_TYPE);
  }
}
