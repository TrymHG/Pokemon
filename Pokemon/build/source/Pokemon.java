import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Pokemon extends PApplet {

int listValueNum = 0;
int activeButtons = 0;
int totalTime;
int microTime;

Start startButton; 
Start test;
TrymButton tb;
Player trym;
Background b;

PImage tsd;

public void setup() {
  
  startButton = new Start("Start Game", 200, 200);
  tb = new TrymButton("Trym", 200, 200);
  tsd = loadImage("TSD.png");
  trym = new Player();
  b = new Background();
}

public void draw() {
  background(0);
  listValueNumRestrictions();
  startButton.display();
  listValueNumRestrictions();
  tb.display();
  timingDevice();
  if (startButton.gameStarted) {
    b.movement();
    trym.display();
  }
}

public void timingDevice() {
  totalTime = ((60*60*hour()) + (60*minute()) + second());
  microTime++;
}

public void listValueNumRestrictions() {
  if (listValueNum < 0) {
    listValueNum++;
  }
  else if (listValueNum >= activeButtons) {
    listValueNum--;
  }
}
public class Background {
  int grassX = trym.x-20;
  int grassY = trym.y-20;

  PImage ground;
  PImage tree;
  PImage trees;

  Background() {
    ground = loadImage("grassB.PNG");
    tree = loadImage("tree.png");
    trees = loadImage("trees.PNG");
  }

  public void movement() {
    image(ground, trym.x, trym.y);
    grass();
    pond();
    trees();
  }

  public void grass() {
  }

  public void pond() {

  }

  public void trees() {
    for (int i = 0; i<4; i++) {
       image(trees, trym.x + i*252, trym.y);
    }
    if (trym.y+230 > 250) {
         trym.y-=2;
    }
    for (int i = 0; i<4; i++) {
      image(trees, trym.x, trym.y + 200*i);
    }
    if (trym.x+252 > 250) {
      trym.x-=2;
    }
    for (int i = 0; i<4; i++) {
      image(trees, trym.x+756, trym.y + 200*i);
    }
    if (trym.x+725 < 250) {
      trym.x+=2;
    }
    for (int i = 0; i<4; i++) {
       image(trees, trym.x + i*252, trym.y+800);
    }
    if (trym.y+760 < 250) {
      trym.y+=2;
    }
  }
}


// if (grassX == 250) {}
// System.out.println(grassX);
public abstract class Button {
  boolean isSelected;
  boolean clicked;
  boolean menuIsOpen;
  int listValue = 0;
  int x;
  int y;
  String name;
  int lag = 0;
  boolean isActive = false;
  Button() {

  }
  public void display() {
    if (menuIsOpen) {
      this.ifClicked();
      fill(150);
      textSize(12);
      text(name, x, y+5);
      if (isSelected) {
        if (microTime > lag+50) {
          triangle(x-7, y, x-17, y+5, x-17, y-5);
          lag = microTime;
        }
        else {
          triangle(x-10, y, x-20, y+5, x-20, y-5);
        }
      }
    }
    this.listChange();
    this.countActiveButtons();
  }

  public abstract void ifClicked();

  public void listChange() {
    if (menuIsOpen) {
      if (keyPressed && microTime-lag > 5) {
        lag = microTime;
        if (keyCode == UP) {
          listValueNum--;
        }
        else if (keyCode == DOWN) {
          listValueNum++;
        }
      }
      if (listValueNum == listValue) {
        isSelected = true;
      }
      else {
        isSelected = false;
      }
    }
    else {
      this.listValue = activeButtons-1;
    }
  }

  public void countActiveButtons() {
    if(menuIsOpen && !isActive) {
      activeButtons++;
      isActive = true;
    }
    else if (!menuIsOpen && isActive) {
      activeButtons--;
      isActive = false;
    }
  }
}
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
public class Player {
  PImage tsl;
  PImage tsr;
  PImage tsu;
  PImage twd1;
  PImage twl1;
  PImage twr1;
  PImage twu1;
  PImage twd2;
  PImage twl2;
  PImage twr2;
  PImage twu2;

  boolean upKey = false;
  boolean downKey = false;
  boolean rightKey = false;
  boolean leftKey = false;
  boolean ivii = false;
  int x = 0;
  int y = 0;

  Player() {
    tsl = loadImage("TSL.png");
    tsr = loadImage("TSR.png");
    tsu = loadImage("TSU.png");
    twd1 = loadImage("TWD1.png");
    twl1 = loadImage("TWL1.png");
    twr1 = loadImage("TWR1.png");
    twu1 = loadImage("TWU1.png");
    twd2 = loadImage("TWD2.png");
    twl2 = loadImage("TWL2.png");
    twr2 = loadImage("TWR2.png");
    twu2 = loadImage("TWU2.png");
  }

  public void display() {
    if (upKey == true) {
      if (keyPressed == true) {
        if (keyCode == UP) {
        y+=2;
        if (y % 15 == 0 && !ivii) {
          ivii = true;
        } else if (y % 15 == 0 && ivii) {
          ivii = false;
        }
        if (ivii) {
          image(twu1, 250, 250, 375, 250);
        } else {
          image(twu2, 250, 250, 375, 250);
        }
        }
        else {
        image(tsu, 250, 250, 375, 250);
      }
      } else {
        image(tsu, 250, 250, 375, 250);
      }
    } else if (downKey == true) {
      if (keyPressed == true) {
        if (keyCode == DOWN) {
          y-=2;
          if (y % 15 == 0 && !ivii) {
            ivii = true;
          } else if (y % 15 == 0 && ivii) {
            ivii = false;
          }
          if (ivii) {
            image(twd1, 250, 250, 375, 250);
          } else {
            image(twd2, 250, 250, 375, 250);
          }
        } else {
          image(tsd, 250, 250, 375, 250);
        }
      } else {
        image(tsd, 250, 250, 375, 250);
      }
    } else if (leftKey == true) {
      if (keyPressed == true) {
        if (keyCode == LEFT) {
          x+=2;
          if (x % 15 == 0 && !ivii) {
            ivii = true;
          } else if (x % 15 == 0 & ivii) {
            ivii = false;
          }
          if (ivii) {
            image(twl1, 250, 250, 375, 250);
          } else {
            image(twl2, 250, 250, 375, 250);
          }
        } else {
          image(tsl, 250, 250, 375, 250);
        }
      } else {
        image(tsl, 250, 250, 375, 250);
      }
    } else {
      if (keyPressed == true) {
        if (keyCode == RIGHT) {
          x-=2;
          if (x % 15 == 0 && !ivii) {
            ivii = true;
          } else if (x % 15 == 0 & ivii) {
            ivii = false;
          }
          if (ivii) {
            image(twr1, 250, 250, 375, 250);
          } else {
            image(twr2, 250, 250, 375, 250);
          }
        } else {
          image(tsr, 250, 250, 375, 250);
        }
      } else {
        image(tsr, 250, 250, 375, 250);
      }
    }
    this.keyCoded();
  }


  public void keyCoded() {
    if (keyCode == UP) {
      upKey = true;
      downKey = false;
      rightKey = false;
      leftKey = false;
    } else if (keyCode == DOWN) {
      upKey = false;
      downKey = true;
      rightKey = false;
      leftKey = false;
    } else if (keyCode == RIGHT) {
      upKey = false;
      downKey = false;
      rightKey = true;
      leftKey = false;
    } else if (keyCode == LEFT) {
      upKey = false;
      downKey = false;
      rightKey = false;
      leftKey = true;
    }
  }
}
public class Start extends Button {
  boolean gameStarted = false;

  Start(String Name, int xx, int xy) {
    menuIsOpen = true;
    x = xx;
    y = xy;
    name = Name;
  }

  public void ifClicked() {
    if (keyPressed) {
      if (isSelected && key == 'a') {
        lag = microTime;
        this.menuIsOpen = false; 
        tb.menuIsOpen = true;
      }
    }
  }
}
public class TrymButton extends Button {
  boolean trymSelected;
  
  TrymButton(String Name, int xx, int xy) {
    x = xx;
    y = xy;
    name = Name;
  }
  
  public void display() {
    super.display();
    if (isSelected && menuIsOpen) {
      image(tsd, 200, 150, 375, 250);
    }
  }
  
  public void ifClicked() {
    if (keyPressed) {
      if (isSelected && key == 'a' && microTime-lag > 5) {
        lag = microTime;
        startButton.gameStarted = true;
        this.menuIsOpen = false; 
      }
    }
  }
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Pokemon" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
