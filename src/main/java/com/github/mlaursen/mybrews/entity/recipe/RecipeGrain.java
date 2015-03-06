/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

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
