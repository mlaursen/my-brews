/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.beer;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.AllRetrievableResource;
import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.beer.Yeast;

/**
 *
 * @author mlaursen
 *
 */
@Path("/yeast")
@Stateless
public class YeastResource extends GenericCRUDResource<Yeast> implements AllRetrievableResource<Yeast> {

  public YeastResource() {
    super(Yeast.class);
  }
  
  @Override
  public List<Yeast> retrieveAll() {
    return em.createNamedQuery(Yeast.Q_retrieveAll, Yeast.class).getResultList();
  }

}
