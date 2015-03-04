/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.constants.YeastType;
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
    name = Yeast.Q_retrieveAll,
    query = "SELECT y from Yeast y"
  )
)
public class Yeast extends GeneratedIdEntity {
  public static final String Q_retrieveAll = "Yeast.retrieveAll";

  private String name;
  @Enumerated(EnumType.STRING)
  private YeastType type;
  
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
   * @return the type
   */
  public YeastType getType() {
    return type;
  }
  /**
   * @param type the type to set
   */
  public void setType(YeastType type) {
    this.type = type;
  }
  
}
