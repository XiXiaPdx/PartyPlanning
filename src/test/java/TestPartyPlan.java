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
  public void add10People_10(){
    PartyPlan testEvent = new PartyPlan (100,"","","",0);
    int expectedOut = 100;
    assertEquals(expectedOut, testEvent.getPeople());
  }
  @Test
  public void addOpenBar_OpenBar(){
    PartyPlan testEvent = new PartyPlan (0,"Open Bar","","",0);
    String expectedOut = "Open Bar";
    assertEquals(expectedOut, testEvent.getAlcohol());
  }
  @Test
  public void addMusic_LiveBand(){
    PartyPlan testEvent = new PartyPlan (0,"","Live Band","",0);
    String expectedOut = "Live Band";
    assertEquals(expectedOut, testEvent.getMusic());
  }
  @Test
  public void addFood_Catered(){
    PartyPlan testEvent = new PartyPlan (0,"","","Catered 5-Course Dinner",0);
    String expectedOut = "Catered 5-Course Dinner";
    assertEquals(expectedOut, testEvent.getFood());
  }
  @Test
  public void getCost(){
    PartyPlan testEvent = new PartyPlan (0,"","","",1000);
    float expectedOut = 1000;
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void calculateCost10People_2000(){
    PartyPlan testEvent = new PartyPlan (100,"0","0","0",0);
    float expectedOut = 2000;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void calculateCost10PeopleAddOpenBar_700(){
    PartyPlan testEvent = new PartyPlan (10,"1","0","0",0);
    float expectedOut = 700;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void calculateCost10PeopleAddServiceBar_400(){
    PartyPlan testEvent = new PartyPlan (10,"2","0","0",0);
    float expectedOut = 400;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void getAlcoholCostFrom10PeopleAddServiceBar_200(){
    PartyPlan testEvent = new PartyPlan (10,"2","0","0",0);
    float expectedOut = 200;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getAlcoholCost(), .001);
  }
  @Test
  public void openBarLiveBand10people_2200(){
    PartyPlan testEvent = new PartyPlan (10,"1","1","0",0);
    float expectedOut = 2200;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void openBarLiveBandCatered10people_2700(){
    PartyPlan testEvent = new PartyPlan (10,"1","1","1",0);
    float expectedOut = 2700;
    testEvent.calculateCost();
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }
  @Test
  public void discountCodeChecker_halfOffmusic(){
    PartyPlan testEvent = new PartyPlan (10,"1","1","1",0);
    float expectedOut = 750;
    testEvent.calculateCost();
    testEvent.discountCode("BigBang");
    assertEquals(expectedOut, testEvent.getMusicCost(), .001);
  }
  @Test
  public void discountCodeChecker_25percentoffBigParty(){
    PartyPlan testEvent = new PartyPlan (200,"1","1","1",0);
    float expectedOut = 19125 ;
    testEvent.calculateCost();
    testEvent.discountCode("Iamspecial");
    assertEquals(expectedOut, testEvent.getCost(), .001);
  }


}
