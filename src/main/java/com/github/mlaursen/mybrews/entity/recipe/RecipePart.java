/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.github.mlaursen.mybrews.constants.WeightUnit;
import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
@MappedSuperclass
public abstract class RecipePart extends GeneratedIdEntity {

  @OneToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  private Double amount;
  @Enumerated(EnumType.STRING)
  private WeightUnit unit;

  /**
   * @return the recipe
   */
  public Recipe getRecipe() {
    return recipe;
  }

  /**
   * @param recipe
   *          the recipe to set
   */
  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  /**
   * @return the amount
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * @param amount
   *          the amount to set
   */
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  /**
   * @return the unit
   */
  public WeightUnit getUnit() {
    return unit;
  }

  /**
   * @param unit
   *          the unit to set
   */
  public void setUnit(WeightUnit unit) {
    this.unit = unit;
  }
}
