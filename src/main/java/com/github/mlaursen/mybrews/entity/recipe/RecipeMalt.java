/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.lookup.Malt;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class RecipeMalt extends RecipePart {
  
  @OneToOne
  @JoinColumn(name = "malt_id")
  private Malt malt;

  /**
   * @return the malt
   */
  public Malt getMalt() {
    return malt;
  }

  /**
   * @param malt the malt to set
   */
  public void setMalt(Malt malt) {
    this.malt = malt;
  }

  /**
   * @return the recipe
   */
  public Recipe getRecipe() {
    return recipe;
  }

  /**
   * @param recipe the recipe to set
   */
  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }
}
