package de3d;
import java.util.ArrayList;


public class Arete{

	private ArrayList<Point> ar;

	public Arete(Point a, Point b) {
		this.ar = new ArrayList<Point>();
		ar.add(a);
		ar.add(b);		
	}
	
	public boolean equals(Arete a) {
		if ( (this.ar.get(0).equals(a.getPointA()) || this.ar.get(0).equals(a.getPointB()))
		   && (this.ar.get(1).equals(a.getPointA()) || this.ar.get(1).equals(a.getPointB())))
			   return true;
		   
		else return false;
	}
	
	public Point getPointA(){
		return ar.get(0);
	}
	
	public Point getPointB(){
		return ar.get(1);
	}

	public float[] coordA(){
		return this.getPointA().getCoord();
	}

	public float[] coordB(){
		return this.getPointB().getCoord();
	}

	public double longueur(){ // Renvoie la longueur d'une arète 
	// La longueur entre 2 Point est la racine (de la somme (des carrés (des coordonées de B - celle de A)))
		double x = Math.pow(ar.get(1).getAbscisse() - ar.get(0).getAbscisse(), 2);
		double y = Math.pow(ar.get(1).getOrdonnee() - ar.get(0).getOrdonnee(), 2);
		double z = Math.pow(ar.get(1).getProfondeur() - ar.get(0).getProfondeur(), 2);
		return Math.sqrt(x + y + z);
	}

	public void deplacer(float x, float y, float z) {// Déplace une arète dans le plan par un vecteur donnée en paramètre
		// On ajoute les coordonnées et celle du vecteur de translation
		ar.get(0).setAbscisse(ar.get(0).getAbscisse() + x);
		ar.get(1).setAbscisse(ar.get(1).getAbscisse() + x);
		ar.get(0).setOrdonnee(ar.get(0).getOrdonnee() + y);
		ar.get(1).setOrdonnee(ar.get(1).getOrdonnee() + y);
		ar.get(0).setProfondeur(ar.get(0).getProfondeur() + z);
		ar.get(1).setProfondeur(ar.get(1).getProfondeur() + z);
	}
	
	public Point milieu(){// Renvoie le point du milieu de l'arète 
		float[] cA= this.coordA();// On skoque les coordonées du point A
		float[] cB= this.coordB();// On skoque les coordonées du point B
		float[] cC={0,0,0};// Initialisation des coordonnée du milieu
		// On fait la moyenne des coordonné des deux extrémité de l'arète
		for (int i=0; i<3; i++){
			cC[i]=(cA[i]+cB[i])/2;
		}

		Point c= new Point(cC[0], cC[1], cC[2]);
		return c;
	}
	
	
	
			
}































