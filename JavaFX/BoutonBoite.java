import javafx.animation.RotateTransition; 
import javafx.application.Application; 
import javafx.event.EventHandler; 

import javafx.scene.Group; 
import javafx.scene.PerspectiveCamera; 
import javafx.scene.Scene; 
import javafx.scene.control.TextField; 
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color; 
import javafx.scene.paint.PhongMaterial;
import javafx.scene.control.Button;
 
import javafx.scene.shape.Box; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;  
import javafx.scene.transform.Rotate; 
import javafx.stage.Stage; 
import javafx.util.Duration; 
         
public class BoutonBoite extends Application { 
   
   public void start(Stage stage) {
      //Dessine la boite
      Box box = new Box(); 
      
      //Taille de la boite
      box.setWidth(150.0); 
      box.setHeight(150.0);   
      box.setDepth(100.0); 
       
      //Coordonnées de la boite
      box.setTranslateX(350);  
      box.setTranslateY(150); 
      box.setTranslateZ(50); 
       
      //Le texte
      Text text = new Text("Cliquez sur la boite pour la stopper"); 
      
      //Police du texte
      text.setFont(Font.font(null, FontWeight.BOLD, 15));     
      
      //Couleur du texte
      text.setFill(Color.CRIMSON); 
      
      //Coordonnées du texte
      text.setX(20); 
      text.setY(50); 
       
      //Matériau de la boite
      PhongMaterial material = new PhongMaterial();  
      material.setDiffuseColor(Color.DARKSLATEBLUE);  
      
      //Application du matériau sur la boite
      box.setMaterial(material);       
       
      //Création de l'animation de rotation  
      RotateTransition rotateTransition = new RotateTransition(); 
      
      //Durée de la rotation
      rotateTransition.setDuration(Duration.millis(5000)); 
      
      //Application de la rotation sur la boite
      rotateTransition.setNode(box);       
      
      //Axe de rotation
      rotateTransition.setAxis(Rotate.Y_AXIS); 
      
      //Angle de la rotation
      rotateTransition.setByAngle(360); 
      
      //Nombre de fois que l'animation sera faite
      rotateTransition.setCycleCount(50); 
      
      //L'animation ne se refait pas à l'envers
      rotateTransition.setAutoReverse(false);  
      
      //Création du bouton
      Button bouton = new Button("Tourne !");   
      
      //Coordonnées du bouton
      bouton.setLayoutX(50); 
      bouton.setLayoutY(100); 
       
      //On gère l'événement qu'une touche est pressée
      EventHandler<MouseEvent> eventHandlerButton = new EventHandler<MouseEvent>() { 

         public void handle(MouseEvent event) { 
            //L'animation s'execute
            rotateTransition.play(); 
         }           
      };              
      //On ajoute un événement à la zone de texte
      bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandlerButton); 
       
      //On gère l'événement de clic souris sur la boite
      EventHandler<javafx.scene.input.MouseEvent> eventHandlerBox = 
         new EventHandler<javafx.scene.input.MouseEvent>() { 
         
         public void handle(javafx.scene.input.MouseEvent e) { 
            rotateTransition.stop();  
         } 
      }; 
      //On ajoute l'événement à la boite
      box.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandlerBox);
       
      //Creation du groupe contenant les objets
      Group root = new Group(box, bouton, text); 
         
      //Création de la scene avec notre groupe d'objets
      Scene scene = new Scene(root, 600, 300);      
      
      //Placement de la camera
      PerspectiveCamera camera = new PerspectiveCamera(false); 
      camera.setTranslateX(0); 
      camera.setTranslateY(0); 
      camera.setTranslateZ(0); 
      scene.setCamera(camera);  
      
      //Titre du stage
      stage.setTitle("Exemple"); 
         
      //Ajout de la scene au stage
      stage.setScene(scene); 
         
      //Affichage du stage
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
}