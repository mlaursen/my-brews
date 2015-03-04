/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class RecipePart extends GeneratedIdEntity {
  @JoinColumn(name = "recipe_id")
  @ManyToOne
  private Recipe recipe;

  @JoinColumn(name = "malt_id")
  @OneToMany(fetch = FetchType.EAGER)
  private List<Malt> malts;

  @JoinColumn(name = "grain_id")
  @OneToMany(fetch = FetchType.EAGER)
  private List<Grain> grains;

  @JoinColumn(name = "hops_id")
  @OneToMany(fetch = FetchType.EAGER)
  private List<Hops> hops;

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
   * @return the malts
   */
  public List<Malt> getMalts() {
    return malts;
  }

  /**
   * @param malts
   *          the malts to set
   */
  public void setMalts(List<Malt> malts) {
    this.malts = malts;
  }

  /**
   * @return the grains
   */
  public List<Grain> getGrains() {
    return grains;
  }

  /**
   * @param grains
   *          the grains to set
   */
  public void setGrains(List<Grain> grains) {
    this.grains = grains;
  }

  /**
   * @return the hops
   */
  public List<Hops> getHops() {
    return hops;
  }

  /**
   * @param hops
   *          the hops to set
   */
  public void setHops(List<Hops> hops) {
    this.hops = hops;
  }
}
