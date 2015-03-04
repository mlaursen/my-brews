/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.beer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.AllRetrievableResource;
import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.beer.Beer;

/**
 *
 * @author mlaursen
 *
 */
@Path("/beer")
@Stateless
public class BeerResource extends GenericCRUDResource<Beer> implements AllRetrievableResource<Beer> {
  
  public BeerResource() {
    super(Beer.class);
  }

  @Override
  public List<Beer> retrieveAll() {
    TypedQuery<Beer> q = em.createNamedQuery(Beer.Q_retrieveAll, Beer.class);
    return q.getResultList();
  }
}
