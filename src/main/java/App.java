import java.io.Console;

public class App{
  public static void main(String[] arg){
    Console myConsole = System.console();
    boolean planOrExit = true;

    System.out.println("\n"+"Welcome to Hendels Party Planner!"+"\n"+"Please select from the following options."+"\n"+"-------------------");

    while(planOrExit){
      System.out.println("\n"+"1 - Plan a party"+"\n"+"2 - Exit");
      String wantToPlan = myConsole.readLine();
      if (wantToPlan.equals("2")){
        planOrExit = false;
      } else if (wantToPlan.equals("1")) {
        System.out.println("\n"+"Great! Which of the following would you like to plan?");
        PartyPlan newPlan = new PartyPlan(0,"3","3","3",0);
        boolean planningDetails = true;
        while (planningDetails) {
          System.out.println("\n"+"1 - Number of people attending"+"\n"+"2 - Alcohol Services"+"\n"+"3 - Music Services"+"\n"+"4 - Catering Services"+"\n"+"5 - Ditch This Plan"+"\n"+"6 - Confirm and set the date!");
          String whatToPlan = myConsole.readLine();
          if (whatToPlan.equals("1")){
            boolean planningPeople = true;
            while (planningPeople){
              System.out.println("\n"+"How many people are attending?");
              String userNumberAttending = myConsole.readLine();
              if(userNumberAttending.matches("[0-9]+")){
                newPlan.setPeople(Integer.parseInt(userNumberAttending));
                newPlan.setPeopleCost();
                planningPeople = false;
                displayCurrentCost(newPlan);
              } else {
                System.out.println("\n"+"Sorry, I didn't quite get that...");
              }
            }
          }
        }

      } else {
        System.out.println("\n"+"Sorry, I didn't quite get that...");
      }
      }
    }
    public static void displayCurrentCost(PartyPlan plan){
      System.out.println("Your Current Bill:"+"\n"+"--------------------"+"\n"+" people--$"+ plan.getPeopleCost()+"\n"+" Alcohol Services--$"+plan.getAlcoholCost()+"\n"+" Music Services--$"+plan.getMusicCost()+"\n"+" Catering Services--$"+plan.getFoodCost());
    }
  }
