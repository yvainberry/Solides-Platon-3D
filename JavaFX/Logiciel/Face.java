package de3d;
import java.util.ArrayList;


public class Face{

	ArrayList<Arete> lA;

	public Face(ArrayList<Arete> f){
		lA = f;
	}
	
	public ArrayList<Arete> getAretes() {
		return lA;
	}

	public void face(ArrayList<Point> lP){
		ArrayList<Arete> face = new ArrayList<Arete>();
		for(int i = 0; i < lP.size(); i++) {
			Arete a= new Arete(lP.get(i),lP.get((i+1)%lP.size()));
			face.add(a);
		}
		lA = face;
	}
	
	public boolean contient(Point p) {
		for (Point pf : getPoint()) {
			if (p.equals(pf)) return true;
		}
		return false;
	}
	
	public ArrayList<Point> getPoint() {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = lA.size() - 1; i >= 0; i--){
            points.add(lA.get(i).getPointB());            
        }
        return points;        
    }

	public boolean estAdjacente(Face f) {
		for (Arete a : lA) {
			for (Arete b : f.getAretes()) {
				if (a.equals(b)) return true;
			}
		}
		
		 return false;
	}

	public Point barycentre() {
		
		float[] bary={0,0,0};// Initialisation des coordonnées du barycentre
		
		// On veut faire la moyenne des coordonnées de tous les sommets de la face
		
		// On additionne d'abord les coordonnées des sommets
		// lA correspond à la liste d'arêtes de la face (this). 
		for (int i = 0; i < lA.size(); i++){
			bary[0] += lA.get(i).getPointA().getAbscisse();   // Somme des X de chaque points
			bary[1] += lA.get(i).getPointA().getOrdonnee();	  // Somme des Y
			bary[2] += lA.get(i).getPointA().getProfondeur(); // Somme des Z
		}
		
		// On divise les sommes par le nombre de sommets de la face
		for (int i = 0; i < 3; i++){
			bary[i] = bary[i] / lA.size();
		}
		
		// On peut construire le point et le renvoyer
		Point barycentre = new Point(bary[0], bary[1],bary[2]);
		return barycentre; 
	}
	
	public ArrayList<Face> triangle(){
		ArrayList<Point> lP= new ArrayList<Point>();
		ArrayList<Arete> aR = new ArrayList<Arete>();
		ArrayList<Face> lF = new ArrayList<Face>();
		
		if (lA.size() <= 3) {
			
			lF.add(this);
			System.out.println(lF);
			return lF;
		}
//		else if (lA.size()==3){
//			Face d=new Face(aR);
//			Point a=new Point(lA.get(0).getPointA().getAbscisse(), lA.get(0).getPointA().getOrdonnee(), lA.get(0).getPointA().getProfondeur());
//			Point b=new Point(lA.get(1).getPointA().getAbscisse(), lA.get(1).getPointA().getOrdonnee(), lA.get(1).getPointA().getProfondeur());
//			Point c=new Point(lA.get(2).getPointA().getAbscisse(), lA.get(2).getPointA().getOrdonnee(), lA.get(2).getPointA().getProfondeur());
//			lP.add(a);
//			lP.add(b);
//			lP.add(c);
//			d.face(lP);
//			lF.add(d);
//			return lF;
//						
//		}
		else{
			
			Point barycentre = barycentre();	
			for(int i=0; i<lA.size(); i++){
				Face d=new Face(aR);

			//	Point a=new Point(barycentre.getAbscisse(),barycentre.getOrdonnee(), barycentre.getProfondeur());
//				Point b=new Point(lA.get(i).getPointA().getAbscisse(), lA.get(i).getPointA().getOrdonnee(), lA.get(i).getPointA().getProfondeur());
//				Point c=new Point(lA.get(i).getPointB().getAbscisse(), lA.get(i).getPointB().getOrdonnee(), lA.get(i).getPointB().getProfondeur());
				lP.add(barycentre);
				lP.add(lA.get(i).getPointA());
				lP.add(lA.get(i).getPointB());
				d.face(lP);
				lF.add(d);
				lP.clear();	
				}
			return lF;
			}

	}

//	public void dessin(){
//	for(int i = 0;i<lA.size()-1;i++){
//		trace(lA.get(i),lA.get(i+1));
//	}
//	trace(lA.get(0),lA.get(lA.size()-1));
//		
//	if (lA.size()==3){
//	}
//	else{
//			Point barycentre=barycentre();
//			
//			for(int i=0; i<lA.size(); i++){
//
//				trace(barycentre, lA.get(i).getPointA());
//				
//			}
//		}
//
//	}
//	
//	public void dessin2(){
//	if (lA.size()==3){
//		beginShape();
//		vertex(lA.get(0).getPointA().getAbscisse(), lA.get(0).getPointA().getOrdonnee(), lA.get(0).getPointA().getProfondeur());
//		vertex(lA.get(1).getPointA().getAbscisse(), lA.get(1).getPointA().getOrdonnee(), lA.get(1).getPointA().getProfondeur());
//		vertex(lA.get(2).getPointA().getAbscisse(), lA.get(2).getPointA().getOrdonnee(), lA.get(2).getPointA().getProfondeur());
//		endShape(CLOSE);
//	}
//	else{
//		Point barycentre=barycentre();	
//		for(int i=0; i<lA.size(); i++){
//			beginShape();
//			vertex(barycentre.getAbscisse(),barycentre.getOrdonnee(), barycentre.getProfondeur());
//			vertex(lA.get(i).getPointA().getAbscisse(), lA.get(i).getPointA().getOrdonnee(), lA.get(i).getPointA().getProfondeur());
//			vertex(lA.get(i).getPointB().getAbscisse(), lA.get(i).getPointB().getOrdonnee(), lA.get(i).getPointB().getProfondeur());
//			endShape(CLOSE);	
//			}
//		}
//
//	}
}