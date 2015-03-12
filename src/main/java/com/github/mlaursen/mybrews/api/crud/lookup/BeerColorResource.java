/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.BeerColor;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/beercolors")
public class BeerColorResource extends GenericCRUDResource<BeerColor> {

  public BeerColorResource() {
    super(BeerColor.class);
  }

}
