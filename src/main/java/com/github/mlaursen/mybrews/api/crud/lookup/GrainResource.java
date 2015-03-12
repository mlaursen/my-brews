/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.Grain;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/grains")
public class GrainResource extends GenericCRUDResource<Grain> {
  
  public GrainResource() {
    super(Grain.class);
  }
}
