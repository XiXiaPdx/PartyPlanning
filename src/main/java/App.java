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
        PartyPlan newPlan = new PartyPlan(0,"3","3","3",0);
        System.out.println("\n"+"Great! Which of the following would you like to plan? Please start with people first to your bill update as you add services. ");
        boolean planningDetails = true;
        while (planningDetails) {
          System.out.println("\n"+"1 - Number of people attending"+"\n"+"2 - Alcohol Services"+"\n"+"3 - Music Services"+"\n"+"4 - Catering Services"+"\n"+"5 - Start this Plan Over"+"\n"+"6 - Enter Discount Code"+"\n"+"7 - Confirm Your Plan");
          String whatToPlan = myConsole.readLine();
          if (whatToPlan.equals("1")){
            boolean planningPeople = true;
            while (planningPeople){
              System.out.println("\n"+"How many people are attending?");
              String userNumberAttending = myConsole.readLine();
              if (userNumberAttending.matches("[0-9]+")){
                newPlan.setPeople(Integer.parseInt(userNumberAttending));
                newPlan.calculateCost();
                planningPeople = false;
                displayCurrentCost(newPlan);
              } else {
                System.out.println("\n"+"Sorry, I didn't quite get that...");
              }
            }
          } else if (whatToPlan.equals("2")){
            boolean planningAlcohol = true;
            while (planningAlcohol){
              System.out.println("\n"+"1--Open Bar"+"\n"+"2--Service Bar"+"\n"+"3--None");
              String userAlcoholService = myConsole.readLine();
              if (userAlcoholService.matches("[1-3]+")){
                newPlan.setAlcohol(userAlcoholService);
                newPlan.calculateCost();
                planningAlcohol= false;
                displayCurrentCost(newPlan);
              } else {
                System.out.println("\n"+"Sorry, I didn't quite get that...");
              }
            }
          } else if (whatToPlan.equals("3")){
            boolean planningMusic = true;
            while (planningMusic){
              System.out.println("\n"+"1--Live Band"+"\n"+"2--DJ"+"\n"+"3--None");
              String userMusicService = myConsole.readLine();
              if (userMusicService.matches("[1-3]+")){
                newPlan.setMusic(userMusicService);
                newPlan.calculateCost();
                planningMusic= false;
                displayCurrentCost(newPlan);
              } else {
                System.out.println("\n"+"Sorry, I didn't quite get that...");
              }
            }
          } else if (whatToPlan.equals("4")){
            boolean planningFood = true;
            while (planningFood){
              System.out.println("\n"+"1--Catered 5 Course Dinner"+"\n"+"2--Appetizers"+"\n"+"3--None");
              String userFoodService = myConsole.readLine();
              if (userFoodService.matches("[1-3]+")){
                newPlan.setFood(userFoodService);
                newPlan.calculateCost();
                planningFood= false;
                displayCurrentCost(newPlan);
              } else {
                System.out.println("\n"+"Sorry, I didn't quite get that...");
              }
            }
          } else if (whatToPlan.equals("5")){
             newPlan.setFood("3");
             newPlan.setPeople(0);
             newPlan.setMusic("3");
             newPlan.setAlcohol("3");
             newPlan.calculateCost();
             displayCurrentCost(newPlan);
          } else if (whatToPlan.equals("6")){
              System.out.println("\n"+"Enter either 'BigBang' or 'Iamspecial'. Note, you need at least 200 attendees, open bar, and catered dinner  for the 'Iamspecial' code to apply ");
              String code = myConsole.readLine();
              if(code.equals("BigBang")){
                newPlan.discountCode(code);
                newPlan.setCost();
                displayCurrentCost(newPlan);
              }else if (code.equals("Iamspecial")){
                newPlan.discountCode(code);
                displayCurrentCost(newPlan);
              }else {
                System.out.println("\n"+"Sorry, that's not a code");
              }
          }else if (whatToPlan.equals("7")){
            String alcoholSelected ="";
            if (newPlan.getAlcohol().equals("1")){
              alcoholSelected = "Open Bar";
            } else if (newPlan.getAlcohol().equals("2")){
              alcoholSelected = "Service Bar";
            } else {
              alcoholSelected = "none";
            }
            String foodSelected="";
            if (newPlan.getFood().equals("1")){
              foodSelected = "Open Bar";
            } else if (newPlan.getFood().equals("2")){
              foodSelected = "Service Bar";
            } else {
              foodSelected = "none";
            }
            String musicSelected="";
            if (newPlan.getMusic().equals("1")){
              musicSelected = "Open Bar";
            } else if (newPlan.getMusic().equals("2")){
              musicSelected = "Service Bar";
            } else {
              musicSelected = "none";
            }
            System.out.println("Confirmed! You selected the following services for your event."+"\n"+"Alcohol Services: "+ alcoholSelected+"\n"+"Music Services: "+ musicSelected+"\n"+"Catering Services: "+ foodSelected+"\n");
            displayCurrentCost(newPlan);
            planningDetails=false;
            planOrExit=false;
          } else {
            System.out.println("\n"+"Sorry, I didn't quite get that...");
          }
        }
      }
    }
  }
  public static void displayCurrentCost(PartyPlan plan){
    System.out.println("Your Invoice:"+"\n"+"--------------------"+"\n"+" people--$"+ plan.getPeopleCost()+"\n"+" Alcohol Services--$"+plan.getAlcoholCost()+"\n"+" Music Services--$"+plan.getMusicCost()+"\n"+" Catering Services--$"+plan.getFoodCost()+"\n"+"--------------------"+"\n"+"Total Bill--$"+plan.getCost());
  }
}
