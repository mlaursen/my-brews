/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.beer;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.beer.BrewedBeer;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/brewedbeers")
public class BrewedBeerResource extends GenericCRUDResource<BrewedBeer> {
  
  public BrewedBeerResource() {
    super(BrewedBeer.class);
  }
}
