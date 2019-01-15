package de3d;
import java.util.ArrayList;

import javafx.animation.RotateTransition; 
import javafx.application.Application; 
import javafx.event.EventHandler; 

import javafx.event.*;

import javafx.scene.Group; 
import javafx.scene.PerspectiveCamera; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color; 
import javafx.scene.paint.PhongMaterial;
import javafx.scene.control.Button;

import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;  
import javafx.scene.transform.Rotate; 
import javafx.stage.Stage; 
import javafx.util.Duration; 

import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Affichage extends Application { 

	static RotateTransition rotateTransition = new RotateTransition();
	public Solide solideAffiche;

	public void start(Stage stage) {
		
		MenuBar menuBar = new MenuBar();
		Menu menuSolide = new Menu("Solides");
		
		MenuItem tetraItem = new MenuItem("Tétraèdre");
		MenuItem cubeItem = new MenuItem("Cube");
		MenuItem octaItem = new MenuItem("Octaèdre");
		MenuItem icoItem = new MenuItem("Icosaèdre");
		MenuItem dodeItem = new MenuItem("Dodécaèdre");
		
		
		
		//Le texte
		Text text = new Text(); 

//		Button boutonBoite = new Button("Cube !");
//		boutonBoite.setLayoutX(150); 
//		boutonBoite.setLayoutY(100); 

		//Police du texte
		text.setFont(Font.font(null, FontWeight.BOLD, 15));     

		//Couleur du texte
		text.setFill(Color.CRIMSON); 

		//Coordonnées du texte
		text.setX(20); 
		text.setY(50); 

//		//Création du bouton
//		Button boutonTetraedre = new Button("Tetraedre !");   
//
//		//Coordonnées du bouton
//		boutonTetraedre.setLayoutX(50); 
//		boutonTetraedre.setLayoutY(100); 
//
//		Button boutonOctaedre = new Button("Octaedre !");
//		boutonOctaedre.setLayoutX(50); 
//		boutonOctaedre.setLayoutY(200); 
//
//		Button boutonIcosaedre = new Button("Icosaedre !");
//		boutonIcosaedre.setLayoutX(100); 
//		boutonIcosaedre.setLayoutY(150); 
//		
//		Button boutonDodecaedre = new Button("Dodecaedre !");
//		boutonDodecaedre.setLayoutX(150); 
//		boutonDodecaedre.setLayoutY(100); 

		Button boutonDual = new Button("Dual !");
		boutonDual.setLayoutX(150); 
		boutonDual.setLayoutY(200);     

		//  System.out.println("hey : " + (float)(Math.sqrt(Math.pow(60,2)-Math.pow(30,3))));
		// MeshView tetraedre = tetraedre();

		menuSolide.getItems().addAll(tetraItem, cubeItem, octaItem, icoItem, dodeItem);
		menuBar.getMenus().addAll(menuSolide);
		Group mesh = new Group();
		Group root = new Group(menuBar, mesh, boutonDual, text);
	

		//Durée de la rotation
		rotateTransition.setDuration(Duration.millis(5000)); 

		//Axe de rotation
		rotateTransition.setAxis(Rotate.Y_AXIS); 

		//Angle de la rotation
		rotateTransition.setByAngle(360); 

		//Nombre de fois que l'animation sera faite
		rotateTransition.setCycleCount(50); 

		//L'animation ne se refait pas à l'envers
		rotateTransition.setAutoReverse(false);  




		// Création de l'objet qui va réagir en cas d'évènement, c'est à dire
		// ici en cas d'action de la souris (car c'est un MouseEvent).		
		EventHandler<ActionEvent> eventBoutonTetra = new EventHandler<ActionEvent>() { 
			
			// A la création de l'objet, on redéfinit la fonction handle. Celle-ci est propre
			// à cet EventHandler, et est redéfinie pour chaque EventHandler créé. 
			// Quand l'évènement est déclenché, la fonction handle est exécutée.		
			public void handle(ActionEvent event) { 
				
				// Ici, cet EventHandler est en association avec le bouton Tétraèdre.
				// Il a pour but de faire apparaître uniquement le tétraèdre à l'écran.
				
				// Le groupe mesh contient le solide en cours d'affichage. On va donc 
				// commencer par le vider avec la fonction clear().
				mesh.getChildren().clear();

				// On crée notre solide, ici le tétraèdre. On note que c'est encore un objet
				// de classe Solide, il n'est pas affichable en l'état.
				Solide tetra = Tetraedre.tetraedre();
				
				// On convertit notre Solide en MeshView, via une fonction de la classe Solide.
				MeshView tetraedre = Solide.solideToMeshView(tetra);
				
				// On ajoute le MeshView au groupe qui va l'afficher à l'écran.
				mesh.getChildren().add(tetraedre);
				solideAffiche = tetra;
				
				// On gère l'animation pour que le tétraèdre tourne. On la stoppe pour changer
				// d'objet à animer. Une fois que l'on indique que le Node ciblé est le tétraèdre, 
				// on peut démarrer l'animation.
				rotateTransition.stop();
				rotateTransition.setNode(tetraedre);
				rotateTransition.play(); 
			}           
		};   
		//On ajoute pour finir l'évènement au bouton concerné, en précisant qu'il s'agit d'un clic de souris
//		boutonTetraedre.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBoutonTetra); 

		EventHandler<ActionEvent> eventBoutonCube = new EventHandler<ActionEvent>() { 

			public void handle(ActionEvent event) { 
				mesh.getChildren().clear();

				Point m = new Point(0,0,0);
				Solide cb = Cube.cube(m, 50);
				ArrayList<Face> facetri = new ArrayList<Face>();
				
				for (Face f : cb.getFaces()) {
					facetri.addAll(f.triangle());
				}
				
				Solide soli = new Solide(facetri);
				MeshView cube = Solide.solideToMeshView(soli);
				solideAffiche = cb;
				//cube.setCullFace(CullFace.NONE);
				mesh.getChildren().add(cube);
				rotateTransition.stop();
				rotateTransition.setNode(cube);
				rotateTransition.play(); 
			}           
		};  
		EventHandler<ActionEvent> eventBoutonIcosaedre = new EventHandler<ActionEvent>() { 

			public void handle(ActionEvent event) { 
				mesh.getChildren().clear();

				Solide ico = Icosaedre.icosaedre();
				MeshView icosaedre = Solide.solideToMeshView(ico);
				solideAffiche = ico;
				mesh.getChildren().add(icosaedre);
				rotateTransition.stop();
				rotateTransition.setNode(icosaedre);
				rotateTransition.play(); 
			}           
		}; 
		EventHandler<ActionEvent> eventBoutonDodecaedre = new EventHandler<ActionEvent>() { 

			public void handle(ActionEvent event) { 
				mesh.getChildren().clear();

				Solide dode = Dodecaedre.dodecaedre();
				solideAffiche = dode;
				
				ArrayList<Face> facetri = new ArrayList<Face>();
				
				for (Face f : dode.getFaces()) {
					facetri.addAll(f.triangle());
				}
				
				Solide dode_tri = new Solide(facetri);
				
				
				MeshView dodecaedre = Solide.solideToMeshView(dode_tri);
				
			
				mesh.getChildren().add(dodecaedre);
				rotateTransition.stop();
				rotateTransition.setNode(dodecaedre);
				rotateTransition.play(); 
			}           
		}; 
		EventHandler<ActionEvent> eventBoutonOctaedre = new EventHandler<ActionEvent>() { 

			public void handle(ActionEvent event) { 
				mesh.getChildren().clear(); 	 

				Solide octa = Octaedre.octaedre();
				MeshView octaedre = Solide.solideToMeshView(octa);

				mesh.getChildren().add(octaedre);
				octaedre.setTranslateZ(-200);
				solideAffiche = octa;
				rotateTransition.stop();
				rotateTransition.setNode(octaedre);
				rotateTransition.play(); 
			}           
		};  
		EventHandler<MouseEvent> eventBoutonDual = new EventHandler<MouseEvent>() { 

			public void handle(MouseEvent event) { 
				mesh.getChildren().clear();

				Solide dual = Solide.getDual(solideAffiche);
				solideAffiche = dual;			
				
				ArrayList<Face> facetri = new ArrayList<Face>();
				
				for (Face f : dual.getFaces()) {
					facetri.addAll(f.triangle());
				}
				
				Solide dual_tri = new Solide(facetri);

				
				MeshView dualMesh = Solide.solideToMeshView(dual_tri);
				
				dualMesh.setCullFace(CullFace.NONE);
				
				dualMesh.setTranslateX(325);  
				dualMesh.setTranslateY(150); 
				dualMesh.setTranslateZ(-300); 
				
				Rotate rotate = new Rotate();
				rotate.setAngle(40);
				dualMesh.getTransforms().addAll(rotate);
				
				mesh.getChildren().add(dualMesh);
				solideAffiche = dual;
				rotateTransition.stop();
				rotateTransition.setNode(dualMesh);
				rotateTransition.play(); 
			}           
		};  


		
		
//		boutonBoite.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBoutonCube);
//		boutonOctaedre.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBoutonOctaedre);
		boutonDual.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBoutonDual);
		icoItem.setOnAction(eventBoutonIcosaedre);
		dodeItem.setOnAction(eventBoutonDodecaedre);
		tetraItem.setOnAction(eventBoutonTetra);
		octaItem.setOnAction(eventBoutonOctaedre);
		cubeItem.setOnAction(eventBoutonCube);
//		boutonDodecaedre.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBoutonDodecaedre);
//		//Creation du groupe contenant les objets


		root.setOnMouseMoved(new EventHandler<MouseEvent>() {
			public void handle (MouseEvent event) {
				text.setText("x: " + event.getSceneX() + " y :" + event.getSceneY());
			}
		});

		//Création de la scene avec notre groupe d'objets
		Scene scene = new Scene(root, 600, 300);      

		//Placement de la camera
		PerspectiveCamera camera = new PerspectiveCamera(false); 
		camera.setTranslateX(0); 
		camera.setTranslateY(0); 
		camera.setTranslateZ(0); 
		scene.setCamera(camera);  

		//Titre du stage
		stage.setTitle("Solides"); 

		//Ajout de la scene au stage
		stage.setScene(scene); 

		//Affichage du stage
		stage.show(); 
	} 

	//   public static MeshView tetraedre () {
	//	   TriangleMesh mesh = new TriangleMesh();
	//	   MeshView pyramid;
	//	   
	//	   
	//	// Vertex coordinates
	//       float h = 150;                    // Height
	//       float s = 300;                    // Side
	//       
	//       mesh.getPoint().addAll(
	//    	        0,    0,    0,            // Point 0 - Top
	//    	        60,    (float)((60*Math.sqrt(8))/Math.sqrt(3)/3),    (float)((60*Math.sqrt(8))/Math.sqrt(3)),         // Point 1 - Front
	//    	        120, 0,    0,            // Point 2 - Left
	//    	        60, (float)((60*Math.sqrt(8))/Math.sqrt(3)), 0         // Point 3 - Back
	//    	     
	//    	    );
	//       mesh.getFaces().addAll(
	//    	        3,0,  2,0,  0,0,          // Front left face
	//    	        3,0,  0,0,  1,0,          // Front right face
	//    	        2,0,  1,0,  0,0,          // Back right face
	//    	        1,0,  2,0,  3,0,      // Bottom rear face
	//    	        
	//    	        0,0,  2,0,  3,0,          // Front left face
	//    	        1,0,  0,0,  3,0,          // Front right face
	//    	        0,0,  1,0,  2,0,          // Back right face
	//    	        3,0,  2,0,  1,0         // Bottom rear face
	//    	    ); 
	//       mesh.getTexCoords().addAll(0,0);
	//       
	////Création de l'animation de rotation  
	//            
	//       pyramid = new MeshView(mesh);
	//       
	//       PhongMaterial material = new PhongMaterial();
	//       material.setDiffuseColor(Color.DARKSLATEBLUE); 
	//       
	//       pyramid.setDrawMode(DrawMode.FILL);
	//       
	//       pyramid.setMaterial(material);
	//
	// 
	//       pyramid.setTranslateX(350);  
	//       pyramid.setTranslateY(150); 
	//       pyramid.setTranslateZ(50); 
	//    
	//       return pyramid;
	//   }

	public static void main(String args[]){ 
		launch(args); 
	} 
}
