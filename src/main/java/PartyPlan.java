

public class PartyPlan {
  private int mPeople;
  private String mAlcohol;
  private String mMusic;
  private String mFood;
  private float mCost;
  private float mAlcoholCost;
  private float mMusicCost;
  private float mFoodCost;
  private float mPeopleCost;

  public PartyPlan (int people, String alcohol, String music, String food, int cost){
    mPeople = people;
    mAlcohol = alcohol;
    mMusic = music;
    mFood = food;
    mCost = cost;
    mAlcoholCost=0;
    mFoodCost=0;
    mMusicCost=0;
    mPeopleCost=0;
  }
  public int getPeople(){
    return mPeople;
  }
  public void setPeople(int people){
     mPeople = people;
  }
  public void setPeopleCost(){
     mPeopleCost = mPeople*20;
  }
  public float getPeopleCost(){
     return mPeopleCost;
  }
  public String getAlcohol(){
    return mAlcohol;
  }
  public void setAlcohol(String alcohol){
     mAlcohol = alcohol;
  }
  public float getAlcoholCost(){
    return mAlcoholCost;
  }
  public void setAlcoholCost(float newCost){
    mAlcoholCost = newCost;
  }
  public String getMusic(){
    return mMusic;
  }
  public void setMusic(String music){
     mMusic = music;
  }
  public float getMusicCost(){
    return mMusicCost;
  }
  public void setMusicCost(float newCost){
    mMusicCost = newCost;
  }
  public String getFood(){
    return mFood;
  }
  public void setFood(String food){
     mFood = food;
  }
  public float getFoodCost(){
    return mFoodCost;
  }
  public void setFoodCost(float newCost){
    mFoodCost = newCost;
  }
  public float getCost(){
    return mCost;
  }
  public void setCost(){
    mCost = mPeopleCost+mAlcoholCost+mMusicCost+mFoodCost;
  }
  public void replaceTotalCost(float newCost){
    mCost = newCost;
  }
  public void calculateCost(){
    setPeopleCost();
    int alcoholChoice = Integer.parseInt(getAlcohol());
      int musicChoice = Integer.parseInt(getMusic());
      int foodChoice = Integer.parseInt(getFood());
      if( alcoholChoice == 1){
        setAlcoholCost(getPeople() *50);
      } else if (alcoholChoice == 2) {
        setAlcoholCost(getPeople() *20);
      } else if (alcoholChoice == 3) {
        setAlcoholCost(0);
      }
      if( musicChoice == 1){
        setMusicCost(1500);
      } else if (musicChoice == 2) {
        setMusicCost(750);
      }else if (musicChoice == 3) {
        setMusicCost(0);
      }
      if( foodChoice == 1){
        setFoodCost(getPeople() *50);
      } else if (foodChoice == 2) {
        setFoodCost(getPeople() *20);
      }else if (foodChoice == 3) {
        setFoodCost(0);
      }
    setCost();
  }
  public void discountCode(String code){
    if (code.equals("BigBang")) {
       setMusicCost(getMusicCost()*0.5f);
    } else if (code.equals("Iamspecial")){
      if(getPeople()>=200 && getAlcohol().equals("1") && getFood().equals("1")){
        System.out.println(getCost());
        replaceTotalCost(getCost()*0.75f);
      }
    }
  }
}
