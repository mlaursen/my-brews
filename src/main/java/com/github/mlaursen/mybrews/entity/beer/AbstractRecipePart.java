/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import javax.persistence.MappedSuperclass;

import com.github.mlaursen.mybrews.constants.WeightUnit;
import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
@MappedSuperclass
public class AbstractRecipePart extends GeneratedIdEntity {

  private String name;
  private Double amount;
  private WeightUnit unit;
  
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
   * @return the amount
   */
  public Double getAmount() {
    return amount;
  }
  /**
   * @param amount the amount to set
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
   * @param unit the unit to set
   */
  public void setUnit(WeightUnit unit) {
    this.unit = unit;
  }
}
