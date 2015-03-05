/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud;

import java.util.List;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;
import com.github.mlaursen.mybrews.util.ResponseBuilder;

/**
 *
 * @author mlaursen
 *
 */
public abstract class GenericCRUDResource<E extends GeneratedIdEntity> implements CreateableResource<E>, RetrievableResource<E>, UpdateableResource<E>, DeleteableResource<E>, AllRetrievableResource<E> {
  private static Logger logger = Logger.getLogger(GenericCRUDResource.class);
  
  @PersistenceContext(unitName = "mybrews")
  protected EntityManager em;
  
  private Class<E> entityClass;
  
  protected GenericCRUDResource(Class<E> entityClass) {
    this.entityClass = entityClass;
  }
  
  protected E findById(Long id) {
    return em.find(entityClass, id);
  }
  
  @Override
  public Response create(E entity) {
    Status status = Status.BAD_REQUEST;
    if(logger.isDebugEnabled()) {
      logger.debug("Starting create call of " + entity);
    }
    
    if(entity == null) {
      logger.error("The given entity is null");
      
      return Response.status(status).build();
    }
    
    if(entity.getId() != null) {
      logger.error("The given entity has an id. Do an update call instead of create.");
      
      return Response.status(status).entity("The given entity has an id. Do an update call instead of create.").build();
    }
    
    try {
      em.persist(entity);
      
      status = Status.CREATED;
    } catch(EJBException e) {
      logger.error(e);
      
      status = Status.INTERNAL_SERVER_ERROR;
    }
    
    return ResponseBuilder.buildResponse(status, entity);
  }
  
  @Override
  public Response retrieve(Long id) {
    Status status = Status.BAD_REQUEST;
    if(logger.isDebugEnabled()) {
      logger.debug("Starting the retrieval call for " + entityClass);
    }
    
    if(id == null) {
      logger.error("There is a null id when attempting to get " + entityClass);
      
      return Response.status(status).entity("There is a null id when attempting to get " + entityClass).build();
    }
    
    E entity = findById(id);
    if(entity == null) {
      status = Status.NOT_FOUND;
    } else {
      status = Status.OK;
    }
    
    return ResponseBuilder.buildResponse(status, entity);
  }
  
  @Override
  public List<E> retrieveAll() {
    return em.createQuery("SELECT ec FROM " + entityClass.getSimpleName() + " ec", entityClass).getResultList();
  }

  
  @Override
  public Response update(E entity) {
    Status status = Status.BAD_REQUEST;
    if(entity == null) {
      logger.error("The entity to update was null for " + entityClass);
      
      return Response.status(status).build();
    }
    
    if(entity.getId() == null) {
      logger.error("The entity's id does not exist. Do a create call instead.");
      
      return Response.status(status).build();
    }
    
    E fromDB = findById(entity.getId());
    if(fromDB == null) {
      status = Status.NOT_FOUND;
      logger.error("The given entity does not exist in the database. " + entity);
      
      return Response.status(status).entity("The given entity does not exist in the database. " + entity).build();
    }
    
    try {
      em.merge(entity);
      
      status = Status.ACCEPTED;
    } catch(EJBException e) {
      logger.error(e);
      
      status = Status.INTERNAL_SERVER_ERROR;
    }
    
    return ResponseBuilder.buildResponse(status, entity);
  }
  
  @Override
  public Response delete(Long id) {
    Status status = Status.BAD_REQUEST;
    if(id == null) {
      logger.error("Attempting to delete a " + entityClass + "with no id.");
      
      return Response.status(status).build();
    }
    
    E fromDB = findById(id);
    if(fromDB == null) {
      status = Status.NOT_FOUND;
      
      return Response.status(status).build();
    }
    
    try {
      em.remove(fromDB);
      
      status = Status.OK;
    } catch (EJBException e) {
      
      status = Status.INTERNAL_SERVER_ERROR;
    }
    
    return Response.status(status).build();
  }
}
