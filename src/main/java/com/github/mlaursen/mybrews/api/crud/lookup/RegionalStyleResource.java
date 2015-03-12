/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.RegionalStyle;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/regionalstyles")
public class RegionalStyleResource extends GenericCRUDResource<RegionalStyle> {
  public RegionalStyleResource() {
    super(RegionalStyle.class);
  }

}
