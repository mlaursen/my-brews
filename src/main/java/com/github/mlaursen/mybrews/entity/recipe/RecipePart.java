/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlTransient;

import com.github.mlaursen.mybrews.constants.WeightUnit;
import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 * Abstract class for any class that is considered a Recipe part. This class defines the mapping
 * between the Recipe and the part and includes the amount and unit for the part.
 * 
 * 
 * @author mlaursen
 * @see GeneratedIdEntity
 * @see Recipe
 */
@MappedSuperclass
public abstract class RecipePart extends GeneratedIdEntity {

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  @XmlTransient
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
