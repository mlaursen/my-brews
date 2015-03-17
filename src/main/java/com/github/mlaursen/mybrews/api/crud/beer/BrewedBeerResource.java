/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.beer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

  
  @Path("/beer/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<BrewedBeer> retrieveBeerBrews(@PathParam("id") Long beerId) {
    Map<String, Object> parameters = new HashMap<>(1);
    parameters.put("beerId", beerId);
    return findResultList(BrewedBeer.Q_findByBeerId, parameters);
  }
}
