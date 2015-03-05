/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.BeerStyle;

/**
 *
 * @author mlaursen
 *
 */
@Path("/beerstyle")
public class BeerStyleResource extends GenericCRUDResource<BeerStyle> {

  public BeerStyleResource() {
    super(BeerStyle.class);
  }

}
