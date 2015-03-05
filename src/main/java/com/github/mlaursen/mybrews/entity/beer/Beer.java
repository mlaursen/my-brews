/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.GeneratedIdNamedEntity;
import com.github.mlaursen.mybrews.entity.lookup.BeerColor;
import com.github.mlaursen.mybrews.entity.lookup.BeerStyle;
import com.github.mlaursen.mybrews.entity.lookup.RegionalStyle;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class Beer extends GeneratedIdNamedEntity {

  @OneToOne
  @JoinColumn(name = "beer_style_id")
  private BeerStyle beerStyle;
  @OneToOne
  @JoinColumn(name = "regional_style_id")
  private RegionalStyle regionalStyle;
  @OneToOne
  @JoinColumn(name = "beer_color_id")
  private BeerColor beerColor;
  private String description;

  /**
   * @return the beerStyle
   */
  public BeerStyle getBeerStyle() {
    return beerStyle;
  }

  /**
   * @param beerStyle
   *          the beerStyle to set
   */
  public void setBeerStyle(BeerStyle beerStyle) {
    this.beerStyle = beerStyle;
  }

  /**
   * @return the regionalStyle
   */
  public RegionalStyle getRegionalStyle() {
    return regionalStyle;
  }

  /**
   * @param regionalStyle
   *          the regionalStyle to set
   */
  public void setRegionalStyle(RegionalStyle regionalStyle) {
    this.regionalStyle = regionalStyle;
  }

  /**
   * @return the beerColor
   */
  public BeerColor getBeerColor() {
    return beerColor;
  }

  /**
   * @param beerColor
   *          the beerColor to set
   */
  public void setBeerColor(BeerColor beerColor) {
    this.beerColor = beerColor;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description
   *          the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }
}
