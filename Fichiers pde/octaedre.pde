void setup () {
  size(800,600,P3D);

}

void draw() {
  float a = sqrt(7200) / (60*sqrt(3));
  float ac = acos(a);
  background(0);
  translate(width/2, height/2);
  rotateY(radians(mouseX));
  rotateX(radians(-mouseY));
  lights();
  
  pushMatrix(); 
  rotateX(ac);
  triEqui(0,0,255);   //bleu
  popMatrix();
  
  pushMatrix();
  translate(0,0,120);
  rotateX(ac * -1); 
  triEqui(255,0,0);  //rouge
  popMatrix();
  
  pushMatrix();
  rotateY(radians(270));
  rotateX(ac * -1);
  triEqui(0,255,0);  //vert
  popMatrix();
  
  pushMatrix();
  translate(120,0);
  rotateY(radians(-90));
  rotateX(ac);
  triEqui(128,50,0); //marron
  popMatrix();
  
  pushMatrix();
  rotateX(radians(180));
  rotateX(ac * -1);
  triEqui(50,70,60);   //gris
  popMatrix();
  
  pushMatrix();
  translate(0, 0, 120);
  rotateX(radians(180));
  rotateX(ac);
  triEqui(255,50,0);  //orange
  popMatrix();
  
  pushMatrix();
  rotateY(radians(270));
  rotateX(radians(-180));
  rotateX(ac);
  triEqui(255,255,0);  //jaune
  popMatrix();
  
  pushMatrix();
  translate(120,0);
  rotateY(radians(-90));
  rotateX(radians(180));
  rotateX(ac * -1);
  triEqui(153,0,102); //violet
  popMatrix();
  
  // axe
  fill(255, 0, 0);
  line(-120, 0, 120, 0);
  fill(0, 0, 255);
  line(0, -120, 0, 120);
}

void triEqui(int r, int g, int b) {
  
   beginShape();
   fill(r,g,b,200);
   stroke(255);
   
   vertex(0,0);  
   vertex(120,0);
   vertex(60, 60*sqrt(3));
   
   endShape(CLOSE);
}