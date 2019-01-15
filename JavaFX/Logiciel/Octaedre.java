package de3d;

import java.util.ArrayList;

public class Octaedre extends Solide{

	public Octaedre(ArrayList<Face> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
	public static Solide octaedre (){
		// Définisont les Point du caré centrale
		Point a = new Point(-25, 0,-25);
		Point b = new Point(-25, 0,25);
		Point c = new Point(25, 0,-25);
		Point d = new Point(25,0,25);
		// La hauteur d'une des 2 pyramide vaut longueur d'un coté * (1/ racine de 2)
		float hauteur = (float) (50/Math.sqrt(2));
		// on se sert de la hauteur pour donnée les coordonées des sommets manquant
		Point e = new Point(0, hauteur,0);
		Point f = new Point(0,-hauteur,0);


		ArrayList<Point> po = new ArrayList<Point>();
		ArrayList<Arete> ar = new ArrayList<Arete>();
		ArrayList<Face> lf = new ArrayList<Face>();
		
		Point[][] pts = new Point[][] {
			{a, b, e}, 
			{a, f, b}, 
			{a, e, c},
			{a, c, f},  
			{d, c, e}, 
			{d, f, c}, 
			{b, d, e},
			{b, f, d}
		};
		
		for (int i = 0; i < 8; i++) {
			Face h = new Face(ar);
			for (int j = 0; j < 3; j++) {
				po.add(pts[i][j]);
			}
			h.face(po);
			po.clear();
			lf.add(h);
		}

		Solide t= new Solide(lf);
		return t;
	}
}
