/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.Hops;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/hops")
public class HopsResource extends GenericCRUDResource<Hops> {
  
  public HopsResource() {
    super(Hops.class);
  }
}
