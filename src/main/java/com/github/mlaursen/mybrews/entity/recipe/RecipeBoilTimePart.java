/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author mlaursen
 *
 */
@MappedSuperclass
public abstract class RecipeBoilTimePart extends RecipePart {

  private Integer boilTime;

  /**
   * @return the boilTime
   */
  public Integer getBoilTime() {
    return boilTime;
  }

  /**
   * @param boilTime the boilTime to set
   */
  public void setBoilTime(Integer boilTime) {
    this.boilTime = boilTime;
  }
}
