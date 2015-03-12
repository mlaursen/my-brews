/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.Yeast;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/yeasts")
public class YeastResource extends GenericCRUDResource<Yeast> {
  
  public YeastResource() {
    super(Yeast.class);
  }
}
