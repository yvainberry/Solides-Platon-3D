package de3d;

import java.util.ArrayList;

public class Dodecaedre extends Solide{

	public Dodecaedre(ArrayList<Face> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
	public static Solide dodecaedre (){
		ArrayList<Point> po = new ArrayList<Point>();
		ArrayList<Arete> ar = new ArrayList<Arete>();
		ArrayList<Face> lf = new ArrayList<Face>();
		ArrayList<Face> facesPoint = new ArrayList<Face>();
		Solide ico = Icosaedre.icosaedre();
		Solide dode = getDual(ico);
//		
//		int cpt = 0;
//		int cptface = 0; 
//		for (Face face : dode.getFaces()) {
//			System.out.println("FACE " + cptface);
//			for (Point point : face.getPoint()) {
//				System.out.println("Point " + cpt + " : " + point.getAbscisse() + ", " + point.getOrdonnee() + ", " + point.getProfondeur());
//				cpt++;
//			}
//			cptface++;
//		}
//		
		Point a = new Point((float)-17.45356, (float)-17.45356, (float)17.45356);
		Point b = new Point((float)-17.45356,(float) -17.45356, (float)-17.45356);
		Point c = new Point((float)-17.45356,(float) 17.45356,(float) 17.45356);
		Point d = new Point((float)-17.45356,(float) 17.45356, (float)-17.45356);
		Point e = new Point((float)17.45356, (float)-17.45356, (float)17.45356);
		Point f = new Point((float)17.45356, (float)17.45356, (float)17.45356);		
		Point g = new Point((float)17.45356, (float)17.45356, (float)-17.45356);
		Point h = new Point((float)17.45356, (float)-17.45356, (float)-17.45356);
		
		Point i = new Point((float)0.0, (float)-28.240454, (float)-10.786893);
		Point j = new Point((float)0.0, (float)-28.240454, (float)10.786893);
		Point k = new Point((float)0.0,(float) 28.240454, (float)-10.786893);
		Point l = new Point((float)0.0,(float) 28.240454,(float) 10.786893);
	
		Point m = new Point((float)28.240454, (float)10.786893, (float)0.0);
		Point n = new Point((float)-28.240454, (float)-10.786893, (float)0.0);
		Point o = new Point((float)-28.240454, (float)10.786893, (float)0.0);
		Point p = new Point((float)28.240454, (float)-10.786893, (float)0.0);
			
		Point q = new Point((float)-10.786893, (float)0.0, (float)28.240454);
		Point r = new Point((float)10.786893, (float)0.0, (float)28.240454);			
		Point s = new Point((float)-10.786893, (float)0.0, (float)-28.240454);
		Point t = new Point((float)10.786893, (float)0.0, (float)-28.240454);		
		Point[][] pts = new Point[][] {
			{j, i, b, n, a}, // 0  ok
			
			{r, f, m, p, e}, // 1 ok
			{a, q, r, e, j}, // 2  caca
			{f, l, k, g, m}, // 3		 // {m, g, f, p, l} 
			
			{o, n, b, s, d}, // 4 	// {b, s, n, d, p} 
			{q, a, n, o, c}, // 5 // 
			{e, p, h, i, j}, // 6 
			{k, l, c, o, d}, // 7 
			
			{p, m, g, t, h}, // 8  
			{r, q, c, l, f}, // 9 
			{i, h, t, s, b}, // 10 
			{k, d, s, t, g} // 
		};
		
		// ArrayList<Face> face_triangle = new ArrayList<Face>();
		
		for (int ii = 0; ii < 12; ii++) {
			Face fa = new Face(ar);
			for (int jj = 0; jj < 5; jj++) {
				po.add(pts[ii][jj]);
			}
			
			fa.face(po);
		//	face_triangle.addAll(fa.triangle());				
			po.clear();
			lf.add(fa);
		//	face_triangle.clear();
		}

		Solide sol= new Solide(lf);
		return sol;
	}
}
