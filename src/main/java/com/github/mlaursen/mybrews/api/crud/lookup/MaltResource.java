/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.Malt;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/malt")
public class MaltResource extends GenericCRUDResource<Malt> {
  
  public MaltResource() {
    super(Malt.class);
  }
}
