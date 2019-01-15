package de3d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

public class Solide {	
	private ArrayList<Face> faces;

	public Solide(ArrayList<Face> t){
		faces = t;
	}

	public ArrayList<Face> getFaces() {
		return faces;
	}
	
	public ArrayList<Point> getPoint() {
		ArrayList<Point> pts = new ArrayList<Point>();
		
		for (Face f : faces) {
			pts.addAll(f.getPoint());
		}
		
		Set<Point> set = new HashSet<>(pts);
		pts.clear();
		pts.addAll(set);
		return pts;
	}

	public static MeshView solideToMeshView(Solide solide) {
		TriangleMesh triangleMesh = new TriangleMesh();
		MeshView meshView_solide;
		int cpt = -1;  // Notre compteur
		
		// Pour chaque face, on parcourt chaque point que l'on ajoute dans le TriangleMesh
		// Il faut garder une trace temporaire de la position du point dans le TriangleMesh, 
		// c'est pourquoi on utilise un compteur cpt.
		
		for (Face f : solide.getFaces()) {
			ArrayList<Point> points = f.getPoint();
			System.out.println("Size points: " + points.size());
			for (Point p : points) {
				triangleMesh.getPoints().addAll(	// Ajout dans le TriangleMesh d'un point � la fois
					p.getAbscisse(), p.getOrdonnee(), p.getProfondeur()				
				);			
				cpt++;
			}
			
			// Une fois les trois points de la face ajout�s, on les mets dans leur ordre d'ajout
			// dans la liste des faces du TriangleMesh. Le 0 est fixe car il repr�sente les coordonn�es
			// de la texture, que nous n'utilisons pas
			
			triangleMesh.getFaces().addAll(
				cpt-2,0, cpt-1,0, cpt,0
			);
		}

		// On param�tre la texture, m�me si il n'y en a pas.
		triangleMesh.getTexCoords().addAll(0,0);
		
		// On cr�e le MeshView � partir de notre TriangleMesh
		// C'est le MehView qui sera affich� au final
		meshView_solide = new MeshView(triangleMesh);

		// On param�tre le mat�riau utilis� par le MeshView
		PhongMaterial material = new PhongMaterial();
		material.setDiffuseColor(Color.DARKSLATEBLUE); 
		meshView_solide.setDrawMode(DrawMode.FILL);
		meshView_solide.setMaterial(material);

		// On positionne le solide dans la fen�tre
		meshView_solide.setTranslateX(350);  
		meshView_solide.setTranslateY(150); 
		meshView_solide.setTranslateZ(-300); 
		
		Rotate rotate = new Rotate();
		rotate.setAngle(40);
		meshView_solide.getTransforms().addAll(rotate);
		
		return meshView_solide;
	}

	public static Solide getDual(Solide solide) {
		ArrayList<Face> facesDual = new ArrayList<Face>();
		ArrayList<Face> facesSommet = new ArrayList<Face>();
		ArrayList<Point> barycentres = new ArrayList<Point>();
		ArrayList<Face> facesOrdonnees = new ArrayList<Face>();
		
		// Pour chaque point, on cherche toutes les faces le poss�dant et on 
		// les stocke dans l'ArrayList facesSommet
		for (Point p : solide.getPoint()) {		
			for (Face f : solide.faces) {		
				if (f.contient(p)) {
					facesSommet.add(f);
				}
			}
			System.out.println("Size facesSommet: " + facesSommet.size());
			Face enCours = facesSommet.get(0);
			while (facesSommet.size() > 1) {
				
				facesSommet.remove(enCours);
				facesOrdonnees.add(enCours);
				
				for (Face f : facesSommet) {
					if (enCours.estAdjacente(f)) {
						enCours = f;
				
						break;
					}
				}
			}
			
			facesOrdonnees.add(facesSommet.get(0));	
			
			// Pour chaque face poss�dant le sommet en question, on
			// r�cup�re le barycentre que l'on stocke dans barycentres		
			for (Face f : facesOrdonnees) {
				barycentres.add(f.barycentre());
			}
			
			// On construit une face � partir des barycentres	
			
			Face faceDual = new Face(new ArrayList<Arete>());
			faceDual.face(barycentres);
			
			// On ajoute cette face � l'ArrayList contenant les faces finales du dual
			
			facesDual.add(faceDual);			
		
			facesSommet.clear();
			barycentres.clear();
			facesOrdonnees.clear();
		}
		
		// On construit le dual avec la liste des faces
		
		Solide dual = new Solide(facesDual);
		return dual;
	}
	
}
