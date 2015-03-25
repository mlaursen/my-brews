package com.github.mlaursen.mybrews.api.crud.beer;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.util.Arrays;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.github.mlaursen.mybrews.api.AbstractGenericCRUDResourceUTest;
import com.github.mlaursen.mybrews.entity.beer.Beer;
import com.github.mlaursen.mybrews.entity.lookup.BeerColor;
import com.github.mlaursen.mybrews.entity.lookup.BeerStyle;
import com.github.mlaursen.mybrews.entity.lookup.RegionalStyle;

public class BeerResourceUTest extends AbstractGenericCRUDResourceUTest<BeerResource> {
  
  public BeerResourceUTest() {
    super(new BeerResource());
  }
  
  @Mock
  private TypedQuery<Beer> query;

  @Override
  public void initializeMocking() throws Exception {
    Beer beer0 = new Beer();
    beer0.setId(0l);
    BeerColor amber = new BeerColor();
    amber.setId(0l);
    amber.setName("Amber");
    beer0.setBeerColor(amber);
    
    BeerStyle amberAle = new BeerStyle();
    amberAle.setId(0l);
    amberAle.setName("Amber Ale");
    beer0.setBeerStyle(amberAle);
    
    RegionalStyle usa = new RegionalStyle();
    usa.setId(0l);
    usa.setName("USA");
    beer0.setRegionalStyle(usa);
    beer0.setDescription("Woot Woot. Beer!");
    beer0.setName("Woot! Woot! Amber Ale");
    
    Beer updatedBeer0 = new Beer();
    updatedBeer0.setId(0l);
    updatedBeer0.setBeerColor(amber);
    updatedBeer0.setBeerStyle(amberAle);
    updatedBeer0.setRegionalStyle(usa);
    updatedBeer0.setName(beer0.getName());
    updatedBeer0.setDescription("I got a new description!");
    
    Mockito.when(em.find(Beer.class, 0l)).thenReturn(beer0);
    Mockito.when(em.createQuery("SELECT ec FROM Beer ec", Beer.class)).thenReturn(query);
    Mockito.when(query.getResultList()).thenReturn(Arrays.asList(beer0));
    
    Mockito.when(em.merge(beer0)).thenReturn(updatedBeer0);
  }
  
  @Test
  public void testRetrieveBeer0() throws URISyntaxException {
    MockHttpRequest request = MockHttpRequest.get("/beers/0");
    MockHttpResponse response = new MockHttpResponse();
    
    dispatcher.invoke(request, response);
    
    assertThat(response.getStatus(), is(HttpServletResponse.SC_OK));
  }
  
  @Test
  public void testRetrieveAllBeers() throws URISyntaxException {
//    MockHttpRequest request = MockHttpRequest.get("/beers");
//    MockHttpResponse response = new MockHttpResponse();
//    
//    dispatcher.invoke(request, response);
//    
//    assertThat(response.getStatus(), is(HttpServletResponse.SC_OK));
  }
  
  @Test
  public void testUpdateBeer0() throws URISyntaxException {
//    MockHttpRequest request = MockHttpRequest.put("/beers/0");
//    MockHttpResponse response = new MockHttpResponse();
//    
//    dispatcher.invoke(request, response);
//    
//    assertThat(response.getStatus(), is(HttpServletResponse.SC_OK));
  }
}
