

public class PartyPlan {
  private int mPeople;
  private String mAlcohol;
  private String mMusic;
  private String mFood;
  private float mCost;
  private float mAlcoholCost;
  private float mMusicCost;
  private float mFoodCost;

  public PartyPlan (int people, String alcohol, String music, String food, int cost){
    mPeople = people;
    mAlcohol = alcohol;
    mMusic = music;
    mFood = food;
    mCost = cost;
    mAlcoholCost=0;
    mFoodCost=0;
    mMusicCost=0;
  }
  public int getPeople(){
    return mPeople;
  }
  public String getAlcohol(){
    return mAlcohol;
  }
  public String getMusic(){
    return mMusic;
  }
  public String getFood(){
    return mFood;
  }
  public float getCost(){
    return mCost;
  }
  public void setCost(float newCost){
    mCost = newCost;
  }
  public float getAlcoholCost(){
    return mAlcoholCost;
  }
  public void setAlcoholCost(float newCost){
    mAlcoholCost = newCost;
  }
  public float getMusicCost(){
    return mMusicCost;
  }
  public void setMusicCost(float newCost){
    mMusicCost = newCost;
  }
  public float getFoodCost(){
    return mMusicCost;
  }
  public void setFoodCost(float newCost){
    mMusicCost = newCost;
  }

  public void calculateCost(){
    float newCost = getPeople() * 20;
    int alcoholChoice = Integer.parseInt(getAlcohol());
      int musicChoice = Integer.parseInt(getMusic());
      int foodChoice = Integer.parseInt(getFood());
      if( alcoholChoice == 1){
        setAlcoholCost(getPeople() *50);
        newCost += getAlcoholCost();
      } else if (alcoholChoice == 2) {
        setAlcoholCost(getPeople() *20);
        newCost += getAlcoholCost();
      }
      if( musicChoice == 1){
        setMusicCost(1500);
        newCost += getMusicCost();
      } else if (musicChoice == 2) {
        setMusicCost(750);
        newCost += getMusicCost();
      }
      if( foodChoice == 1){
        setFoodCost(getPeople() *50);
        newCost += getFoodCost();
      } else if (foodChoice == 2) {
        setFoodCost(getPeople() *20);
        newCost += getFoodCost();
      }
    setCost(newCost);
  }

}
