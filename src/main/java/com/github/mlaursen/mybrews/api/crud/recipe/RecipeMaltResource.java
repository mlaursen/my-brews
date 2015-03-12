package com.github.mlaursen.mybrews.api.crud.recipe;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.mlaursen.mybrews.api.BaseResource;
import com.github.mlaursen.mybrews.api.crud.lookup.MaltResource;
import com.github.mlaursen.mybrews.entity.lookup.Malt;
import com.github.mlaursen.mybrews.entity.recipe.Recipe;
import com.github.mlaursen.mybrews.entity.recipe.RecipeMalt;

@Stateless
@Path("/recipemalts")
public class RecipeMaltResource extends BaseResource {
  @Inject
  private RecipeResource recipeResource;
  @Inject
  private MaltResource maltResource;

  @POST
  @Path("/{recipeId}")
  @Consumes({MediaType.APPLICATION_JSON})
  public Response addMalts(@PathParam("recipeId") Long recipeId, @MatrixParam("maltId") Long maltId, RecipeMalt recipeMalt) {
    Recipe recipe = (Recipe) recipeResource.retrieve(recipeId).getEntity();
    Malt malt = (Malt) maltResource.retrieve(maltId).getEntity();
    
    recipeMalt.setRecipe(recipe);
    recipeMalt.setMalt(malt);
    em.persist(recipeMalt);
    
    return Response.ok(recipeMalt).build();
  }
}
