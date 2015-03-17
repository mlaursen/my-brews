/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.beer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.beer.Beer;
import com.github.mlaursen.mybrews.entity.beer.BrewedBeer;

/**
 * 
 * @author mlaursen
 *
 */
@Stateless
@Path("/beers")
public class BeerResource extends GenericCRUDResource<Beer> {
  
  public BeerResource() {
    super(Beer.class);
  }
}
