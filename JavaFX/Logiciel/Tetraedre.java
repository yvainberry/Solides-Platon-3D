package de3d;

import java.util.ArrayList;

public class Tetraedre extends Solide{

	public Tetraedre(ArrayList<Face> t) {
		super(t);
	}

	public static Solide tetraedre (){
		// Coordonnées des points du tétraèdre
		Point a = new Point(-30, 0,0);
		Point b = new Point(30, 0,0);
		Point c = new Point(0, 0,(float)(Math.sqrt(Math.pow(60,2)-Math.pow(30,2))));
		// La hauteur vaut la racine carré( (coté)^2 - (2/3 de médiane)^2 )
		float hauteur = (float)(Math.sqrt(Math.pow(60,2)-Math.pow((c.getProfondeur()*2)/3,2)));
		Point d = new Point(0, hauteur,c.getProfondeur()/3);


		// On définit les différentes faces du tétraèdre
		ArrayList<Point> po = new ArrayList<Point>();
		ArrayList<Arete> ar = new ArrayList<Arete>();
		ArrayList<Face> lf = new ArrayList<Face>();
		
		Point[][] pts = new Point[][] {
			{a, b, c},
			{a, d, b},
			{a, c, d},
			{d, c, b}
		};
		
		for (int i = 0; i < 4; i++) {
			Face f = new Face(ar);
			for (int j = 0; j < 3; j++) {
				po.add(pts[i][j]);
			}
			f.face(po);
			po.clear();
			lf.add(f);
		}
		
		Solide t = new Solide(lf);
		return t;
	}
}
