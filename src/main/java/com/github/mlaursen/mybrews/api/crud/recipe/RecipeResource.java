/**
 * 
 */
package com.github.mlaursen.mybrews.api.crud.recipe;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.recipe.Recipe;

/**
 *
 * @author mlaursen
 *
 */
@Stateless
@Path("/recipes")
public class RecipeResource extends GenericCRUDResource<Recipe> {
  
  public RecipeResource() {
    super(Recipe.class);
  }
  
}
