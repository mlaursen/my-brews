/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.constants.BeerColor;
import com.github.mlaursen.mybrews.constants.BeerStyle;
import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
@NamedQueries(
  @NamedQuery(
    name = Beer.Q_retrieveAll,
    query = "SELECT b FROM Beer b"
  )
)
public class Beer extends GeneratedIdEntity {
  public static final String Q_retrieveAll = "Beer.retrieveAll";

  private String name;
  private Double originalGravity;
  private Double finalGravity;
  private Double abv;
  @Temporal(TemporalType.DATE)
  private Date dateBrewed;
  @Temporal(TemporalType.DATE)
  private Date primaryEnd;
  @Temporal(TemporalType.DATE)
  private Date secondaryEnd;
  @Temporal(TemporalType.DATE)
  private Date drinkDate;
  @Enumerated(EnumType.STRING)
  private BeerStyle style;
  @Enumerated(EnumType.STRING)
  private BeerColor color;
  
  @JoinColumn(name="recipe_id")
  @ManyToOne
  private Recipe recipe;
  
  private String description;
  
  @Transient
  private List<Integer> ratings;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the originalGravity
   */
  public Double getOriginalGravity() {
    return originalGravity;
  }

  /**
   * @param originalGravity the originalGravity to set
   */
  public void setOriginalGravity(Double originalGravity) {
    this.originalGravity = originalGravity;
  }

  /**
   * @return the finalGravity
   */
  public Double getFinalGravity() {
    return finalGravity;
  }

  /**
   * @param finalGravity the finalGravity to set
   */
  public void setFinalGravity(Double finalGravity) {
    this.finalGravity = finalGravity;
  }

  /**
   * @return the abv
   */
  public Double getAbv() {
    return abv;
  }

  /**
   * @param abv the abv to set
   */
  public void setAbv(Double abv) {
    this.abv = abv;
  }

  /**
   * @return the dateBrewed
   */
  public Date getDateBrewed() {
    return dateBrewed;
  }

  /**
   * @param dateBrewed the dateBrewed to set
   */
  public void setDateBrewed(Date dateBrewed) {
    this.dateBrewed = dateBrewed;
  }

  /**
   * @return the primaryEnd
   */
  public Date getPrimaryEnd() {
    return primaryEnd;
  }

  /**
   * @param primaryEnd the primaryEnd to set
   */
  public void setPrimaryEnd(Date primaryEnd) {
    this.primaryEnd = primaryEnd;
  }

  /**
   * @return the secondaryEnd
   */
  public Date getSecondaryEnd() {
    return secondaryEnd;
  }

  /**
   * @param secondaryEnd the secondaryEnd to set
   */
  public void setSecondaryEnd(Date secondaryEnd) {
    this.secondaryEnd = secondaryEnd;
  }

  /**
   * @return the drinkDate
   */
  public Date getDrinkDate() {
    return drinkDate;
  }

  /**
   * @param drinkDate the drinkDate to set
   */
  public void setDrinkDate(Date drinkDate) {
    this.drinkDate = drinkDate;
  }

  /**
   * @return the style
   */
  public BeerStyle getStyle() {
    return style;
  }

  /**
   * @param style the style to set
   */
  public void setStyle(BeerStyle style) {
    this.style = style;
  }

  /**
   * @return the color
   */
  public BeerColor getColor() {
    return color;
  }

  /**
   * @param color the color to set
   */
  public void setColor(BeerColor color) {
    this.color = color;
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

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }
}
