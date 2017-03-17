import org.junit.*;
import static org.junit.Assert.*;

public class TestPartyPlan {
  @Test
  public void EventObjectCreated_True(){
    PartyPlan testEvent = new PartyPlan (0,"","","",0);
    boolean expectedOut = true;
    assertEquals(expectedOut, testEvent instanceof PartyPlan);
  }
  @Test
  public void EventObjectCreated_add10People_10(){
    PartyPlan testEvent = new PartyPlan (10,"","","",0);
    int expectedOut = 10;
    assertEquals(expectedOut, testEvent.getPeople());
  }
  @Test
  public void EventObjectCreated_addOpenBar_OpenBar(){
    PartyPlan testEvent = new PartyPlan (0,"Open Bar","","",0);
    String expectedOut = "Open Bar";
    assertEquals(expectedOut, testEvent.getAlcohol());
  }
  @Test
  public void EventObjectCreated_addMusic_LiveBand(){
    PartyPlan testEvent = new PartyPlan (0,"","Live Band","",0);
    String expectedOut = "Live Band";
    assertEquals(expectedOut, testEvent.getMusic());
  }
  @Test
  public void EventObjectCreated_addFood_Catered(){
    PartyPlan testEvent = new PartyPlan (0,"","","Catered 5-Course Dinner",0);
    String expectedOut = "Catered 5-Course Dinner";
    assertEquals(expectedOut, testEvent.getFood());
  }
  @Test
  public void EventObjectCreated_getCost(){
    PartyPlan testEvent = new PartyPlan (0,"","","",1000);
    float expectedOut = 1000;
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void EventObjectCreated_calculateCost10People_200(){
    PartyPlan testEvent = new PartyPlan (10,"0","0","0",0);
    float expectedOut = 200;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void EventObjectCreated_calculateCost10PeopleAddOpenBar_700(){
    PartyPlan testEvent = new PartyPlan (10,"1","0","0",0);
    float expectedOut = 700;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void EventObjectCreated_calculateCost10PeopleAddServiceBar_400(){
    PartyPlan testEvent = new PartyPlan (10,"2","0","0",0);
    float expectedOut = 400;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void EventObjectCreated_getAlcoholCostFrom10PeopleAddServiceBar_200(){
    PartyPlan testEvent = new PartyPlan (10,"2","0","0",0);
    float expectedOut = 200;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getAlcoholCost(), .001);
  }
  @Test
  public void EventObjectCreated_openBarLiveBand10people_2200(){
    PartyPlan testEvent = new PartyPlan (10,"1","1","0",0);
    float expectedOut = 2200;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void EventObjectCreated_openBarLiveBandCatered10people_2700(){
    PartyPlan testEvent = new PartyPlan (10,"1","1","1",0);
    float expectedOut = 2700;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }


}
