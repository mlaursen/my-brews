/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;
import com.github.mlaursen.mybrews.entity.lookup.EventType;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class Event extends GeneratedIdEntity {
  
  @OneToOne
  @JoinColumn(name = "brewed_beer_id")
  private BrewedBeer brewedBeer;
  
  @OneToOne
  @JoinColumn(name = "event_type_id")
  private EventType eventType;
  
  @Temporal(TemporalType.DATE)
  private Date eventDate;

  /**
   * @return the brewedBeer
   */
  public BrewedBeer getBrewedBeer() {
    return brewedBeer;
  }

  /**
   * @param brewedBeer the brewedBeer to set
   */
  public void setBrewedBeer(BrewedBeer brewedBeer) {
    this.brewedBeer = brewedBeer;
  }

  /**
   * @return the eventType
   */
  public EventType getEventType() {
    return eventType;
  }

  /**
   * @param eventType the eventType to set
   */
  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  /**
   * @return the eventDate
   */
  public Date getEventDate() {
    return eventDate;
  }

  /**
   * @param eventDate the eventDate to set
   */
  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }
}
