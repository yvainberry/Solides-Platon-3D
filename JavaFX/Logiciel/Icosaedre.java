
package de3d;

import java.util.ArrayList;

public class Icosaedre extends Solide{

	public Icosaedre(ArrayList<Face> t) {
		super(t);
	}


	public static Solide icosaedre (){
		float lg = 40;
		float or = (float) ((1 + Math.sqrt(5))/2);
		// Définisont les Point du caré centrale
		Point d = new Point(lg/2, (lg*or)/2, 0);
		Point c = new Point((lg*or)/2, 0, lg/2);
		Point h = new Point(0, lg/2, (lg*or)/2);
		
		Point j = new Point(-lg/2, (lg*or)/2, 0);
		Point i = new Point((lg*or)/2, 0, -lg/2);
		Point b = new Point(0, -lg/2, (lg*or)/2);

		Point a = new Point(lg/2, (-lg*or)/2, 0);
		Point f = new Point((-lg*or)/2, 0, lg/2);
		Point k = new Point(0, lg/2, (-lg*or)/2);

		Point g = new Point(-lg/2, (-lg*or)/2, 0);
		Point l = new Point((-lg*or)/2, 0, -lg/2);
		Point e = new Point(0, -lg/2, (-lg*or)/2);

		// On définie les diférentes face du octaêdre
		ArrayList<Point> po = new ArrayList<Point>();
		ArrayList<Arete> ar = new ArrayList<Arete>();

		ArrayList<Face> lf = new ArrayList<Face>();
		
		Point[][] pts = new Point[][] {
			{a, c, b},  
			{a, i, c},  
			{a, e, i},  
			{a, g, e},  
			{a, b, g},   
			{h, b, c},   
			{d, c, i},  
			{k, i, e},  
			{l, e, g},  
			{f, g, b},   
			{d, j, h},  
			{h, j, f},  
			{f, j, l},   
			{l, j, k},  
			{k, j, d},  
			{d, h, c},  
 			{h, f, b},  
			{f, l, g},
			{l, k, e},
			{k, d, i} 
		};

		for (int ii = 0; ii < 20; ii++) {
			Face z = new Face(ar);
			for (int jj = 0; jj < 3; jj++) {
				po.add(pts[ii][jj]);
			}
			z.face(po);
			po.clear();
			lf.add(z);
		}

		Solide t = new Solide(lf);
		return t;
	}

}