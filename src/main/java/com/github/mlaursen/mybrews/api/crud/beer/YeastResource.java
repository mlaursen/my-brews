/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.beer;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.beer.Yeast;

/**
 *
 * @author mlaursen
 *
 */
@Path("/yeast")
@Stateless
public class YeastResource extends GenericCRUDResource<Yeast> {

  public YeastResource() {
    super(Yeast.class);
  }

}
