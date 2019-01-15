void setup() {
  size(640, 360, P3D);
  lights();
}


void carre(){
  beginShape();
  vertex(50,50,50);
  vertex(50,50,-50);
  vertex(-50,50,-50);
  vertex(-50,50,50);
  endShape(CLOSE);
}
void draw() {
  background(0);
  translate(width/2, height/2, 0);
  rotateX(radians(60 + frameCount));
  rotateY(radians(60 + frameCount));
  stroke(255);
  
  fill(128,0,0,128);
  carre();
  for (int i=0;i<4;i++){
    rotateX(radians(90));
    carre();
  }
  rotateZ(radians(90));
  carre();
  rotateZ(radians(180));
  carre();
}
