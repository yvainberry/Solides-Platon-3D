
void setup () {
  size(1000, 1000, P3D);

}

void draw() {
  background(0);
  
  
  translate(width/2, height/2);

  //rotateY(radians(90));
  rotateY(radians(-mouseX));
  rotateZ(radians(-mouseY));
  stroke(225, 0, 0);
  line(-500, 0, 0, 500, 0, 0); // x rouge
  stroke(0, 255, 0);
  line(0, -500, 0, 0, 500, 0); // y vert
  stroke(0, 0, 255);
  line(0, 0, -500, 0, 0, 500); // z bleu
  
  stroke(255);
  pyr_pen();
  pushMatrix();
  translate(0, 0, -sqrt(  ( sq((cos(TWO_PI/5)*200) - (cos(0)*200) ) +  ( sq((sin((TWO_PI/5))*200) - (sin(0)*200)) )  ) -1));
  rotateY(radians(180));
  pyr_pen();
  popMatrix();
}

void pyr_pen() { // crée un polygone à n côtés
   float p1, p2;
   int n = 5;
   
  for (int i=2; i<2+n; i=i+1) {
    p1 = (i-1)*(TWO_PI/n);
    p2 = i*(TWO_PI/n);

    line(cos(p1)*200, sin(p1)*200, 0, cos(p2)*200, sin(p2)*200, 0);
   
    line(cos(p1)*200, sin(p1)*200, 0, 0, 0, 
    sqrt(  ( sq((cos(p2)*200) - (cos(p1)*200) ) +  ( sq((sin(p2)*200) - (sin(p1)*200)) )  ) -1));
   
  }
  
 /* void iso() {
    pyr_pen();
  }*/
    
}
