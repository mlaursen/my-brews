/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.beer;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.beer.Beer;

/**
 * 
 * @author mlaursen
 *
 */
@Stateless
@Path("/beer")
public class BeerResource extends GenericCRUDResource<Beer> {
  
  public BeerResource() {
    super(Beer.class);
  }
}
