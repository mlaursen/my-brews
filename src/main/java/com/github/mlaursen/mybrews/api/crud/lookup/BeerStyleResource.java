/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.BeerStyle;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/beerstyles")
public class BeerStyleResource extends GenericCRUDResource<BeerStyle> {

  public BeerStyleResource() {
    super(BeerStyle.class);
  }

}
