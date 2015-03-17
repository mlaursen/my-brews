/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;
import com.github.mlaursen.mybrews.entity.recipe.Recipe;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
@NamedQueries({
  @NamedQuery(
    name = BrewedBeer.Q_findByBeerId,
    query = "SELECT bb FROM BrewedBeer bb where bb.beer.id = :beerId"
  )
})
public class BrewedBeer extends GeneratedIdEntity {
  public static final String Q_findByBeerId = "BrewedBeer.findByBeerId";

  @OneToOne
  @JoinColumn(name = "beer_id")
  private Beer beer;

  @OneToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  private Double og;
  private Double fg;
  private Integer ibu;
  private Double abv;

  /**
   * @return the beer
   */
  public Beer getBeer() {
    return beer;
  }

  /**
   * @param beer
   *          the beer to set
   */
  public void setBeer(Beer beer) {
    this.beer = beer;
  }

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
   * @return the original gravity
   */
  public Double getOg() {
    return og;
  }

  /**
   * @param og
   *          the original gravity to set
   */
  public void setOg(Double og) {
    this.og = og;
  }

  /**
   * @return the final gravity
   */
  public Double getFg() {
    return fg;
  }

  /**
   * @param fg
   *          the final gravity to set
   */
  public void setFg(Double fg) {
    this.fg = fg;
  }

  /**
   * @return the international bittering units
   */
  public Integer getIbu() {
    return ibu;
  }

  /**
   * @param ibu
   *          the international bittering units to set
   */
  public void setIbu(Integer ibu) {
    this.ibu = ibu;
  }

  /**
   * @return the alcohol by volume
   */
  public Double getAbv() {
    return abv;
  }

  /**
   * @param abv
   *          the alcohol by volume to set
   */
  public void setAbv(Double abv) {
    this.abv = abv;
  }
}
