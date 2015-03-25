package com.github.mlaursen.mybrews.api.crud.beer;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

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
  private final Beer beer0 = new Beer();
  private final Beer updatedBeer0 = new Beer();
  private final Beer newBeer = new Beer();

  @Override
  public void initializeMocking() throws Exception {
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
    
    updatedBeer0.setId(0l);
    updatedBeer0.setBeerColor(amber);
    updatedBeer0.setBeerStyle(amberAle);
    updatedBeer0.setRegionalStyle(usa);
    updatedBeer0.setName(beer0.getName());
    updatedBeer0.setDescription("I got a new description!");
    
    newBeer.setBeerColor(amber);
    newBeer.setBeerStyle(amberAle);
    newBeer.setRegionalStyle(usa);
    newBeer.setName("New Beer");
    newBeer.setDescription("New Beer description");
    
    Mockito.when(em.find(Beer.class, 0l)).thenReturn(beer0);
    Mockito.when(em.createQuery("SELECT ec FROM Beer ec", Beer.class)).thenReturn(query);
    Mockito.when(query.getResultList()).thenReturn(Arrays.asList(beer0));
    
    Mockito.when(em.merge(beer0)).thenReturn(updatedBeer0);
    
    Mockito.doAnswer(new Answer<Beer>() {
      @Override
      public Beer answer(InvocationOnMock invocation) throws Throwable {
        Beer beer = (Beer) invocation.getArguments()[0];
        beer.setId(100l);
        return null;
      }
    }).when(em).persist(Mockito.any(Beer.class));
  }
  
  @Test
  public void testRetrieveBeer0() throws URISyntaxException {
    MockHttpRequest request = MockHttpRequest.get("/beers/0");
    MockHttpResponse response = new MockHttpResponse();
    
    dispatcher.invoke(request, response);
    
    assertThat(response.getStatus(), is(HttpServletResponse.SC_OK));
    Mockito.verify(em).find(Beer.class, 0l);
    
    assertThat(response.getContentAsString(), is(not(nullValue())));
    assertThat(gson.fromJson(response.getContentAsString(), Beer.class), is(beer0));
  }
  
  @Test
  public void testRetrieveAllBeers() throws URISyntaxException {
    MockHttpRequest request = MockHttpRequest.get("/beers");
    MockHttpResponse response = new MockHttpResponse();
    
    dispatcher.invoke(request, response);
    
    assertThat(response.getStatus(), is(HttpServletResponse.SC_OK));
  }
  
  @Test
  public void testUpdateBeer0() throws URISyntaxException {
    MockHttpRequest request = MockHttpRequest.put("/beers/0");
    MockHttpResponse response = new MockHttpResponse();
    
    request.accept(MediaType.APPLICATION_JSON);
    request.contentType(MediaType.APPLICATION_JSON_TYPE);
    
    Beer beer = new Beer();
    beer.setName("Test Beer");
    request.content(gson.toJson(beer).getBytes());
    
    dispatcher.invoke(request, response);
    
    assertThat(response.getStatus(), is(HttpServletResponse.SC_OK));
  }
  
  @Test
  public void testCreateBeer100() throws URISyntaxException {
    MockHttpRequest request = MockHttpRequest.post("/beers");
    MockHttpResponse response = new MockHttpResponse();

    request.accept(MediaType.APPLICATION_JSON);
    request.contentType(MediaType.APPLICATION_JSON_TYPE);
    request.content(gson.toJson(newBeer).getBytes());
    
    dispatcher.invoke(request, response);
    
    Mockito.verify(em).persist(Mockito.any(Beer.class));
    assertThat(response.getStatus(), is(HttpServletResponse.SC_CREATED));
    
    List<Object> locations = response.getOutputHeaders().get("Location");
    assertThat(locations, is(not(nullValue())));
    assertThat(locations, contains("/api/beers/100"));
  }
}
