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
