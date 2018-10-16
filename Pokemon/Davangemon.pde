public abstract class Davangemon {
  private int xP;
  private int aTTK;
  private int speed;
  private int def;
  private int SPA;
  private int SPD;
  private int HP;
  private int MHP;
  private int level;
  private int evasion;
  private int evolLevel;
  private String name;


  public abstract void display();

  public abstract void levelUP();

  public abstract void moves();

  public abstract void moveLearn();

  public abstract void evolution();

  public int getxP() {
    return xP;
  }

  public abstract int setxP();

  public int getaTTK() {
    return aTTK;
  }

  public void setaTTK(int attackValue){
    aTTK = attackValue;
  }

  public int getspeed() {
    return speed;
  }

  public void setspeed(int speedValue){
    speed = speedValue;
  }

  public int getdef() {
    return def;
  }

  public void setdef(int defValue){
    def = defValue;
  }

  public int getSPA() {
    return SPA;
  }

  public void setSPA(int SPAValue){
    SPA = SPAValue;
  }

  public int getSPD() {
    return SPD;
  }

  public void setSPD(int SPDValue){
    SPD = SPDValue;
  }

  public int getMHP() {
    return MHP;
  }

  public void setMHP(int MHPValue){
    MHP = MHPValue;
  }

  public int getlevel() {
    return level;
  }

  public void setlevel(int levelValue){
    level = levelValue;
  }

  public int getevasion() {
    return evasion;
  }

  public void setevasion(int evasionValue){
    evasion = evasionValue;
  }

  public int getHP() {
    return HP;
  }

  public void setHP(int HPValue){
    HP = HPValue;
  }

  public int getevolLevel() {
    return evolLevel;
  }

  public void setevolLevel(int evolLevelValue){
    evolLevel = evolLevelValue;
  }

  public void pokeName(String pokeName) {
    name = pokeName;
  }

  public String getName() {
    return name;
  }
}
