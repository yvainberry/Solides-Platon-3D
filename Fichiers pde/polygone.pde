
void setup () {
  size(900, 800, P3D);
}

void draw() {
  translate(width/2, height/2);
 
  polygone(3);
}

void polygone(int n) { // crée un polygone à n côtés
   float p1, p2;

  for (int i=2; i<2+n; i=i+1) {
    p1 = (i-1)*(TWO_PI/n);
    p2 = i*(TWO_PI/n);

    line(cos(p1)*300, sin(p1)*300, cos(p2)*300, sin(p2)*300);
   
  }
}
