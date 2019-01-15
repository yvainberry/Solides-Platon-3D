void setup() {
  size(600,600,P3D);
}

void draw() {
  translate(width/2, height/2);
  rotateY(radians(frameCount/2));
  rotateZ(radians(frameCount/2));
  background(0);
  lights();
  
  beginShape(TRIANGLES);
  fill(0,100,128,200);
  stroke(255);
  
  vertex(0, 0);
  vertex(120, 0);
  vertex(60, (60*sqrt(8))/sqrt(3));
  
  vertex(0, 0);
  vertex(60, (60*sqrt(8))/sqrt(3)/3, (60*sqrt(8))/sqrt(3));
  vertex(60, (60*sqrt(8))/sqrt(3));
  
  
  vertex(0, 0);
  vertex(60, (60*sqrt(8))/sqrt(3)/3, (60*sqrt(8))/sqrt(3));
  vertex(120, 0);
  
  vertex(120, 0);
  vertex(60, (60*sqrt(8))/sqrt(3)/3, (60*sqrt(8))/sqrt(3));
  vertex(60, (60*sqrt(8))/sqrt(3));
  
  endShape();
  
}