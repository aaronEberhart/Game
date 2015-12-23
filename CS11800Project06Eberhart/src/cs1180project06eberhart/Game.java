/**
 * This class contains all methods needed for running the game.
 */
package cs1180project06eberhart;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public class Game { 
    
    public static int animationTime = 0;
    public static double tempVY, tempVX;
    
    /**
     * This method sets up and starts the game.
     * 
     * Pre-conditions:  The program needs to show the game screen.
     * Post-conditions: The game screen is displayed.
     * 
     * @param primaryStage Stage
     * @param save Save
     * @param difficulty Difficulty
     * @param music ArrayList MediaPlayer
     * @return gameScene Scene
     */
    public Scene gameScene(Stage primaryStage, Save save, ArrayList<MediaPlayer> music, Difficulty difficulty) {
        
        double diff = difficulty.getDifficulty();
        
        Group group = new Group();
        Pane player = new Pane();
        Pane rocks = new Pane();
        Pane rescue = new Pane();
        Pane pane = new Pane();
        HBox healthBar = new HBox();
                
        Image man = new Image("Rescources/guy.png");
        Image left = new Image("Rescources/guy_left.png");
        Image right = new Image("Rescources/guy_right.png");
        Image back = new Image("Rescources/phobos.png");
        Image little = new Image("Rescources/little_rock.png");
        Image regular = new Image("Rescources/rock.png");
        Image big = new Image("Rescources/big_rock.png");
        Image huge = new Image("Rescources/huge_rock.png");
        Image health = new Image("Rescources/health_node.png");
        Image damage = new Image("Rescources/empty_health_node.png");
        Image ship = new Image("Rescources/ship.png");
         
        //health bar
        healthBar.setLayoutY(550);
        healthBar.setLayoutX(150);
        Text hText = new Text("Health: ");
        hText.setStyle("-fx-fill: white;");
        hText.setFont(Font.font("Arial", 30));
        healthBar.getChildren().add(hText);
        
        ImageView[] bar = new ImageView[10];
        for(int i = 0; i < bar.length; i++)
        {
            bar[i] = new ImageView(health);
            healthBar.getChildren().add(bar[i]);
        }
        
        //background
        ImageView bkgd = new ImageView(back);
        pane.getChildren().add(bkgd);
        
        Text time = new Text();
        time.setLayoutX(600);
        time.setLayoutY(550);
        time.setFont(Font.font("Arial", 30)); 
        time.setFill(Color.RED);
        time.setStroke(Color.WHITE);
        pane.getChildren().add(time);
        
        group.getChildren().add(pane);
        group.getChildren().add(player);
        group.getChildren().add(rocks);
        group.getChildren().add(healthBar);
        group.getChildren().add(rescue);
        
        Scene scene = new Scene(group, 800, 600);
        
        Controller input = new Controller(scene);        
        
        //rocks
        ArrayList<Rock> rockList = new ArrayList<>();      
        
        rockList.add(new Rock(rocks, little, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2))); 
        rockList.add(new Rock(rocks, regular, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2))); 
        rockList.add(new Rock(rocks, regular, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2))); 
        rockList.add(new Rock(rocks, big, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
        rockList.add(new Rock(rocks, big, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
        rockList.add(new Rock(rocks, huge, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
        rockList.add(new Rock(rocks, huge, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
        
        if(diff > 0) {
            rockList.add(new Rock(rocks, regular, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2))); 
            rockList.add(new Rock(rocks, big, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
            rockList.add(new Rock(rocks, big, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
            rockList.add(new Rock(rocks, little, (Math.random() * 800), (Math.random() * 600),((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
            rockList.add(new Rock(rocks, huge, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
            if(diff > 1) {
                rockList.add(new Rock(rocks, regular, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2),((Math.random()- 0.5) / 2))); 
                rockList.add(new Rock(rocks, big, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
                rockList.add(new Rock(rocks, big, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
                rockList.add(new Rock(rocks, little, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
                rockList.add(new Rock(rocks, huge, (Math.random() * 800), (Math.random() * 600), ((Math.random()- 0.5) / 2), ((Math.random()- 0.5) / 2)));
            }
        }
            
        
        Rock plane = new Rock(rescue, ship, 850, 400, 0, 0);
        
        Character guy;
        if(save.hasSaved) {                
                guy = new Character(player, man, left, right, 
                        save.positionX, save.positionY, save.velocityX, save.velocityY, input, save.health);
        }else{            
            guy = new Character(player, man, left, right, 400, 300, 0, 0, input); 
        }
        
        input.addListener();        
        
        
        
        
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(1), (ActionEvent e) -> {    
            
            //increase time milliseconds by one
            animationTime += 1;
            
            //if animation has reached the time set by difficulty, show and move rescue ship
            if(animationTime >= (60000 + (diff * 30000))) {
                plane.velocityX = -.05;
                plane.move();
                plane.redraw();
            }
            
            //if player reaches rescue ship, show victory screen
            if(plane.testCollisiion(guy)) {
                animation.stop();
                input.removeListener();
                StartMenuEtc menu = new StartMenuEtc();
                animationTime = 0;
                primaryStage.setScene(winScene(primaryStage, music, save, difficulty));
                menu.instructionsShown = true;
            }                
            
            //update timer display
            time.setText(String.format("Time:%7ds", animationTime / 1000));
            
            //if menu button is pressed, stop game, save character, and load menu
            if(input.menuPressed()) {                
                animation.stop();
                input.removeListener();
                StartMenuEtc menu = new StartMenuEtc();
                Save temp = new Save(guy);
                primaryStage.setScene(menu.menuScene(primaryStage, temp, music, difficulty));
                menu.instructionsShown = true;
            }
            
            //if exit is pressed, close program
            if(input.escPressed()) {
                System.exit(0);
            }
            
            //process player input
            guy.processInput();
            
            //move character based on input
            guy.move();
            
            //move all of the rocks
            rockList.forEach(x -> x.move());
            
            //test player hits
            for(Rock x : rockList) {
                if(guy.testCollisiion(x)) {
                    
                    //lose a health if hit
                    guy.health -= 1;
                    
                    //if 0 health, display game over screen
                    if(guy.health <= 0) {
                        animationTime = 0;
                        primaryStage.setScene(loseScene(primaryStage, save, music, difficulty));
                        animation.stop();
                        input.removeListener();
                    }            
                    
                    guy.velocityX = -guy.velocityX;
                    guy.velocityY = -guy.velocityY;
                    
                    x.velocityX = -x.velocityX + (-guy.velocityX / 2); 
                    x.velocityY = -x.velocityY + (-guy.velocityY / 2);
                    
                    if(x.positionX == guy.positionX)
                        x.positionX += .01;
                    if(x.positionY == guy.positionY)
                        x.positionY -= .01;
                }                
            }           
            
            //test rock hits
            for(int i = 0; i < rockList.size(); i++) {
                for(int j = i; j < rockList.size(); j++) {
                    if(rockList.get(i).testCollisiion(rockList.get(j)) && i != j) {
                        
                        tempVY = rockList.get(j).velocityY;
                        tempVX = rockList.get(j).velocityX;
                        
                        rockList.get(j).velocityX = -rockList.get(i).velocityY;
                        rockList.get(j).velocityY = -rockList.get(i).velocityX;
                        
                        rockList.get(i).velocityX = tempVX;
                        rockList.get(i).velocityY = tempVY;
                        
                    }
                }
            }
            
            //update health bar
            for(int i = 0; i < bar.length; i++)
            {
                if(i >= guy.health)
                    bar[i].setImage(damage);
            }
            
            //redraw all the rocks and the character
            rockList.forEach(x -> x.redraw());
            
            guy.redraw();            

        }));      
        
        //start animation
        animation.play();
        
        return scene;
    }
    
    /**
     * This method displays the lose screen.
     * 
     * Pre-conditions:  The program needs to show the lose screen.
     * Post-conditions: The lose screen is displayed.
     * 
     * @param primaryStage Stage
     * @param save Save
     * @param difficulty Difficulty
     * @param music ArrayList MediaPlayer
     * @return loseScene Scene
     */
    public Scene loseScene(Stage primaryStage, Save save, ArrayList<MediaPlayer> music, Difficulty difficulty) {
        
        Pane pane = new Pane();
        
        music.get(5).play();
        
        //background
        Image pic = new Image("Rescources/end.png");
        ImageView bkgd = new ImageView(pic);
        bkgd.setFitHeight(600);
        bkgd.setFitWidth(800);
        pane.getChildren().add(bkgd);
        
        //title
        Image title = new Image("Rescources/game_over.png");
        ImageView t = new ImageView(title);
        t.setX(100);
        t.setY(200);
        pane.getChildren().add(t);
        
        //restart button
        Button back = new Button();
        back.setText("Start Over");
        back.setLayoutX(100);
        back.setLayoutY(500);
        back.setFont(Font.font("Verdana", 25));
        back.setOnAction(e -> {
            StartMenuEtc menu = new StartMenuEtc();
            save.hasSaved = false;
            primaryStage.setScene(menu.menuScene(primaryStage, save, music, difficulty));
            menu.instructionsShown = true;
        });
        pane.getChildren().add(back);
        
        //quit button
        Button quitButton = new Button();
        quitButton.setLayoutX(600);
        quitButton.setLayoutY(500);
        quitButton.setText("Exit");
        quitButton.setFont(Font.font("Verdana", 25));
        quitButton.setOnAction(e -> { 
            System.exit(0);
        });
        pane.getChildren().add(quitButton);        
        
        Scene scene = new Scene(pane, 800, 600);
        
        return scene;
    }
    
    /**
     * This method displays the win screen.
     * 
     * Pre-conditions:  The program needs to show the win screen.
     * Post-conditions: The win screen is displayed.
     * 
     * @param primaryStage Stage
     * @param save Save
     * @param difficulty Difficulty
     * @param music ArrayList MediaPlayer
     * @return winScene Scene
     */
    public Scene winScene(Stage primaryStage, ArrayList<MediaPlayer> music, Save save, Difficulty difficulty) {
        
        Pane pane = new Pane();
        
        music.get(6).play();
                
        //background
        Image pic = new Image("Rescources/end.png");
        ImageView bkgd = new ImageView(pic);
        bkgd.setFitHeight(600);
        bkgd.setFitWidth(800);
        pane.getChildren().add(bkgd);
        
        //title
        Image title = new Image("Rescources/win.png");
        ImageView t = new ImageView(title);
        t.setX(100);
        t.setY(200);
        pane.getChildren().add(t);
        
        //restart button
        Button back = new Button();
        back.setText("Start Over");
        back.setLayoutX(100);
        back.setLayoutY(500);
        back.setFont(Font.font("Verdana", 25));
        back.setOnAction(e -> {
            StartMenuEtc menu = new StartMenuEtc();
            save.hasSaved = false;
            primaryStage.setScene(menu.menuScene(primaryStage, save, music, difficulty));
            menu.instructionsShown = true;
        });
        pane.getChildren().add(back);
        
        //quit button
        Button quitButton = new Button();
        quitButton.setLayoutX(600);
        quitButton.setLayoutY(500);
        quitButton.setText("Exit");
        quitButton.setFont(Font.font("Verdana", 25));
        quitButton.setOnAction(e -> { 
            System.exit(0);
        });
        pane.getChildren().add(quitButton);        
        
        Scene scene = new Scene(pane, 800, 600);
        
        return scene;
    }
    
}
