/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.constants.WeightUnit;
import com.github.mlaursen.mybrews.entity.lookup.Grain;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class RecipeGrain extends RecipePart {
  
  @OneToOne
  @JoinColumn(name = "grain_id")
  private Grain grain;
  
  public RecipeGrain() {
  }
  
  public RecipeGrain(Grain grain, Double amount) {
    this.grain = grain;
    setAmount(amount);
    setUnit(WeightUnit.LBS);
  }

  /**
   * @return the malt
   */
  public Grain getGrain() {
    return grain;
  }

  /**
   * @param grain the grain to set
   */
  public void setGrain(Grain grain) {
    this.grain = grain;
  }
}
