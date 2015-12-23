/**
 * This class contains all menus for the game. It has a start, options, and
 * a quit option.
 */
package cs1180project06eberhart;

import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Aaron Eberhart
 * Lab Section 06		
 * Daniel Kingseed
 * Rick Volkers
 */
public class StartMenuEtc {
    
    public final static int SCENE_WIDTH = 800;
    public final static int SCENE_HEIGHT = 600;
    boolean instructionsShown = false;
    public final static int SELECTED_MUSIC = 2;
    public static double volMus = .15;
    public static double volTot = .31;
    public static double volFX = .04;   
    
    Media strauss = new Media("http://hwcdn.libsyn.com/p/7/2/8/728eb8e84e52aa82/strauss_fledermaus.mp3?c_id=1788409&expiration=1449370070&hwt=11aeaf53d6554a2c68fff5532a88511f");
    Media grieg = new Media("http://hwcdn.libsyn.com/p/0/7/7/077e8f28ceba44af/grieg_holbergsuite_afarcry.mp3?c_id=7087278&expiration=1449371401&hwt=27664563a78f6d155a72cb616cf1ef58");
    Media ligeti = new Media("http://hanysz.net/audio/Ligeti_autumn-in-warsaw_hanysz.mp3");
    Media schoenberg = new Media("http://hwcdn.libsyn.com/p/a/9/3/a93ccf590b3648f8/schoenberg_op4_afarcry.mp3?c_id=7891914&expiration=1449372843&hwt=2a92da75197d191608fa30b28a056489");
    Media hindemith = new Media("http://ec.libsyn.com/p/7/0/8/708c38f39ff2fe92/Hindemith_op11no4_GutermanPorat.mp3?d13a76d516d9dec20c3d276ce028ed5089ab1ce3dae902ea1d06cc8e34d6cb5c97fb&c_id=5337233");
    Media win = new Media("http://static1.grsites.com/archive/sounds/cartoon/cartoon010.mp3");
    Media lose = new Media("http://www.allmusiclibrary.com/free_sound_effects/victory_fanfare.mp3");   
    
    /**
     * This method is the starting screen for the game.
     * 
     * Pre-conditions:  The program needs to show the start screen.
     * Post-conditions: The start screen is displayed.
     * 
     * @param primaryStage Stage
     * @return startScene Scene
     */
    public Scene startScene(Stage primaryStage){
        
        Pane pane = new Pane();
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        pane.setStyle("-fx-background-color: black;");
        Save save = new Save();
        
        //set up music
        ArrayList<MediaPlayer> music = new ArrayList<>();
        music.add(new MediaPlayer(schoenberg));
        music.add(new MediaPlayer(grieg));
        music.add(new MediaPlayer(ligeti));
        music.add(new MediaPlayer(strauss));
        music.add(new MediaPlayer(hindemith));
        music.add(new MediaPlayer(win));
        music.add(new MediaPlayer(lose));
        music.get(0).setVolume(volMus * volTot);
        music.get(1).setVolume(volMus * volTot);
        music.get(2).setVolume(volMus * volTot);
        music.get(3).setVolume(volMus * volTot);
        music.get(4).setVolume(volMus * volTot);
        music.get(0).setCycleCount(6);
        music.get(1).setCycleCount(6);
        music.get(2).setCycleCount(6);
        music.get(3).setCycleCount(6);
        music.get(4).setCycleCount(6);
        music.get(5).setVolume(volFX * volTot);
        music.get(6).setVolume(volFX * volTot);
        music.get(SELECTED_MUSIC).play();
        MediaView node = new MediaView(music.get(0));       
        
        pane.getChildren().add(node);
        
        //background
        Image pic = new Image("Rescources/phobos2.png");
        ImageView bkgd = new ImageView(pic);
        bkgd.setFitHeight(SCENE_HEIGHT);
        bkgd.setFitWidth(SCENE_WIDTH);
        pane.getChildren().add(bkgd);
        
        //title
        Image title = new Image("Rescources/title.png");
        ImageView t = new ImageView(title);
        t.setX(200);
        t.setY(200);
        pane.getChildren().add(t);
        
        //text
        Text text = new Text("Click to Start");
        text.setX(325);
        text.setY(500);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Verdana", 25));
        pane.getChildren().add(text);
        
        Difficulty difficulty = new Difficulty(0);
        
        scene.setOnMouseClicked(e -> {
            primaryStage.setScene(menuScene(primaryStage, save, music, difficulty));
        });
        
        return scene;
    }    
    
    /**
     * This method is the main menu for the game. It has options to start, open
     * the game menu, or exit.
     * 
     * Pre-conditions:  The program needs to show the main screen.
     * Post-conditions: The main screen is displayed.
     * 
     * @param primaryStage Stage
     * @param save Save
     * @param difficulty Difficulty
     * @param music ArrayList MediaPlayer
     * @return menuScene Scene
     */
    public Scene menuScene(Stage primaryStage, Save save, ArrayList<MediaPlayer> music, Difficulty difficulty) {
        
        music.get(5).stop();
        music.get(6).stop();
        
        Pane pane = new Pane();
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        pane.setStyle("-fx-background-color: black;");
        
        //background
        Image pic = new Image("Rescources/phobos3.png");
        ImageView bkgd = new ImageView(pic);
        bkgd.setFitHeight(SCENE_HEIGHT);
        bkgd.setFitWidth(SCENE_WIDTH);
        pane.getChildren().add(bkgd);
        
        Image pic2 = new Image("Rescources/main.png");
        ImageView bkgd2 = new ImageView(pic2);
        bkgd2.setFitHeight(SCENE_HEIGHT);
        bkgd2.setFitWidth(SCENE_WIDTH);
        pane.getChildren().add(bkgd2);
        
        //start button
        Button startButton = new Button();
        startButton.setLayoutX(100);
        startButton.setLayoutY(500);
        startButton.setText("Start");
        startButton.setFont(Font.font("Verdana", 25));
        startButton.setOnAction(e -> { 
            
            if(!instructionsShown) {
                primaryStage.setScene(instructions(primaryStage, save, music, false, difficulty));
            }
            else {
                Game game = new Game();
                primaryStage.setScene(game.gameScene(primaryStage, save, music, difficulty));
            }
            
        });
        pane.getChildren().add(startButton);
        
        //options button
        Button optionsButton = new Button();
        optionsButton.setLayoutX(335);
        optionsButton.setLayoutY(500);
        optionsButton.setText("Options");
        optionsButton.setFont(Font.font("Verdana", 25));
        optionsButton.setOnAction(e -> {
            primaryStage.setScene(optionsScene(primaryStage, save, music, difficulty));
        });
        pane.getChildren().add(optionsButton);
        
        //quit button
        Button quitButton = new Button();
        quitButton.setLayoutX(600);
        quitButton.setLayoutY(500);
        quitButton.setText("Quit");
        quitButton.setFont(Font.font("Verdana", 25));
        quitButton.setOnAction(e -> {
            System.exit(0);
        });
        pane.getChildren().add(quitButton);
                
        return scene;
    }
    
    /**
     * This method displays the options screen. There are controls for
     * difficulty, volume, and background music.
     * 
     * Pre-conditions:  The program needs to show the options screen.
     * Post-conditions: The options screen is displayed.
     * 
     * @param primaryStage Stage
     * @param save Save
     * @param difficulty Difficulty
     * @param music ArrayList MediaPlayer
     * @return optionsScene Scene
     */
    public Scene optionsScene(Stage primaryStage, Save save, ArrayList<MediaPlayer> music, Difficulty difficulty){
        
        Pane pane = new Pane();
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        pane.setStyle("-fx-background-color: black;");
        
        //background
        Image pic = new Image("Rescources/phobos4.png");
        ImageView bkgd = new ImageView(pic);
        bkgd.setFitHeight(SCENE_HEIGHT);
        bkgd.setFitWidth(SCENE_WIDTH);
        pane.getChildren().add(bkgd);
        
        //back button
        Button back = new Button();
        back.setText("Back");
        back.setLayoutX(600);
        back.setLayoutY(500);
        back.setFont(Font.font("Verdana", 25));
        back.setOnAction(e -> {
            primaryStage.setScene(menuScene(primaryStage, save, music, difficulty));
        });
        pane.getChildren().add(back);
        
        //instructions button
        Button instructions = new Button();
        instructions.setText("Instructions");
        instructions.setLayoutX(100);
        instructions.setLayoutY(500);
        instructions.setFont(Font.font("Verdana", 25));
        instructions.setOnAction(e -> {
            primaryStage.setScene(instructions(primaryStage, save, music, true, difficulty));
        });
        pane.getChildren().add(instructions);
        
        //music picker
        ToggleGroup tg = new ToggleGroup();
        RadioButton straussb = new RadioButton();
        RadioButton griegb = new RadioButton();
        RadioButton schoenbergb = new RadioButton();
        RadioButton ligetib = new RadioButton();
        RadioButton hindemithb = new RadioButton();
        
        straussb.setToggleGroup(tg);
        griegb.setToggleGroup(tg);
        schoenbergb.setToggleGroup(tg);
        ligetib.setToggleGroup(tg);
        hindemithb.setToggleGroup(tg);
        
        //set active toggle
        if(music.get(0).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
            tg.selectToggle(schoenbergb);
        else if(music.get(1).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
            tg.selectToggle(griegb);
        else if(music.get(2).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
            tg.selectToggle(ligetib);
        else if(music.get(3).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
            tg.selectToggle(straussb);
        else if(music.get(4).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
            tg.selectToggle(hindemithb);
        
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        
        //toggle handler
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle1, Toggle toggle2) {
            
                if(tg.getSelectedToggle().equals(schoenbergb)) {
                    for(int i = 0; i < 5; i++)
                        if(music.get(i).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
                            music.get(i).stop();
                    music.get(0).play();
                }
                else if(tg.getSelectedToggle().equals(griegb)) {
                    for(int i = 0; i < 5; i++)
                        if(music.get(i).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
                            music.get(i).stop();
                    music.get(1).play();
                }
                else if(tg.getSelectedToggle().equals(ligetib)) {
                    for(int i = 0; i < 5; i++)
                        if(music.get(i).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
                            music.get(i).stop();
                    music.get(2).play();
                }
                else if(tg.getSelectedToggle().equals(straussb)) {
                    for(int i = 0; i < 5; i++)
                        if(music.get(i).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
                            music.get(i).stop();
                    music.get(3).play();
                }
                else if(tg.getSelectedToggle().equals(hindemithb)) {
                    for(int i = 0; i < 5; i++)
                        if(music.get(i).getStatus().compareTo(MediaPlayer.Status.PLAYING) == 0)
                            music.get(i).stop();
                    music.get(4).play();
                }
            }
        });
        
        schoenbergb.setLayoutX(675);
        schoenbergb.setLayoutY(100);
        griegb.setLayoutX(675);
        griegb.setLayoutY(150);
        ligetib.setLayoutX(675);
        ligetib.setLayoutY(200);
        straussb.setLayoutX(675);
        straussb.setLayoutY(250);
        hindemithb.setLayoutX(675);
        hindemithb.setLayoutY(300);
        
        pane.getChildren().add(schoenbergb);
        pane.getChildren().add(griegb);
        pane.getChildren().add(ligetib);
        pane.getChildren().add(straussb);
        pane.getChildren().add(hindemithb);
        
        //radio text
        Text text = new Text("Music Selector");
        text.setX(570);
        text.setY(65);
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);
        text.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text);
        
        Text text1 = new Text("Scoenberg");
        text1.setX(550);
        text1.setY(115);
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text1);
        
        Text text2 = new Text("Grieg");
        text2.setX(550);
        text2.setY(165);
        text2.setFill(Color.WHITE);
        text2.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text2);
        
        Text text3 = new Text("Ligeti");
        text3.setX(550);
        text3.setY(215);
        text3.setFill(Color.WHITE);
        text3.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text3);
        
        Text text4 = new Text("Strauss");
        text4.setX(550);
        text4.setY(265);
        text4.setFill(Color.WHITE);
        text4.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text4);
        
        Text text5 = new Text("Hindemith");
        text5.setX(550);
        text5.setY(315);
        text5.setFill(Color.WHITE);
        text5.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text5);
        
        
        
        //total volume slider
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(1);
        slider.setValue(volTot);
        slider.setTranslateX(50);
        slider.setTranslateY(100);        
        
        //music volume slider
        Slider sliderMus = new Slider();
        sliderMus.setMin(0);
        sliderMus.setMax(1);
        sliderMus.setValue(volMus);
        sliderMus.setTranslateX(50);
        sliderMus.setTranslateY(150);       
        
        //effects volume slider
        Slider sliderFX = new Slider();
        sliderFX.setMin(0);
        sliderFX.setMax(1);
        sliderFX.setValue(volFX);
        sliderFX.setTranslateX(50);
        sliderFX.setTranslateY(200);       
        
        //define slider behavior
        slider.valueProperty().addListener((ObservableValue<? extends Number> o, Number oldNum, Number newNum) -> {
            volTot = slider.getValue();
            for(int i = 0; i < 5; i++) {                
                music.get(i).setVolume(volTot * sliderMus.getValue());
            }
            for(int i = 5; i < music.size(); i++) {
                music.get(i).setVolume(volTot * sliderFX.getValue());
            }
        });
        
        sliderFX.valueProperty().addListener((ObservableValue<? extends Number> o, Number oldNum, Number newNum) -> {
            volFX = sliderFX.getValue();
            for(int i = 5; i < music.size(); i++) {                
                music.get(i).setVolume(volFX * volTot);
            }
        });
        
        sliderMus.valueProperty().addListener((ObservableValue<? extends Number> o, Number oldNum, Number newNum) -> {
            volMus = sliderMus.getValue();
            for(int i = 0; i < 5; i++) {
                music.get(i).setVolume(volMus * volTot);
            }
        });
        
        pane.getChildren().add(slider);
        pane.getChildren().add(sliderMus);
        pane.getChildren().add(sliderFX);
        
        //slider text
        Text text6 = new Text("Total Volume");
        text6.setX(200);
        text6.setY(110);
        text6.setFill(Color.WHITE);
        text6.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text6);
        
        Text text7 = new Text("Music Volume");
        text7.setX(200);
        text7.setY(160);
        text7.setFill(Color.WHITE);
        text7.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text7);
        
        Text text8 = new Text("Effects Volume");
        text8.setX(200);
        text8.setY(210);
        text8.setFill(Color.WHITE);
        text8.setFont(Font.font("Verdana", 20));
        pane.getChildren().add(text8);
        
        
        
        //difficulty text
        Text text9 = new Text("Difficulty");
        text9.setX(200);
        text9.setY(310);
        text9.setFill(Color.WHITE);
        text9.setStroke(Color.BLACK);
        text9.setFont(Font.font("Verdana", 30));
        pane.getChildren().add(text9);
        
        //easy button
        Button easy = new Button();
        easy.setText(" Easy ");
        easy.setLayoutX(75);
        easy.setLayoutY(350);
        easy.setFont(Font.font("Verdana", 25));
        easy.setOnAction(e -> {
            difficulty.setDifficulty(0);
        });
        pane.getChildren().add(easy);
        
        //easy button
        Button medium = new Button();
        medium.setText("Medium");
        medium.setLayoutX(200);
        medium.setLayoutY(350);
        medium.setFont(Font.font("Verdana", 25));
        medium.setOnAction(e -> {
            difficulty.setDifficulty(1);
        });
        pane.getChildren().add(medium);
        
        //easy button
        Button hard = new Button();
        hard.setText(" Hard ");
        hard.setLayoutX(350);
        hard.setLayoutY(350);
        hard.setFont(Font.font("Verdana", 25));
        hard.setOnAction(e -> {
            difficulty.setDifficulty(2);
        });
        pane.getChildren().add(hard);
        
        return scene;
    }
    
    /**
     * This method displays a scene with the instructions.
     * 
     * Pre-conditions:  The program needs to show the instructions screen.
     * Post-conditions: The instructions screen is displayed.
     * 
     * @param primaryStage Stage
     * @param save Save
     * @param difficulty Difficulty
     * @param fromOptions boolean
     * @param music ArrayList MediaPlayer
     * @return instructions Scene
     */
    public Scene instructions(Stage primaryStage, Save save, ArrayList<MediaPlayer> music, boolean fromOptions, Difficulty difficulty) {
        
        Pane pane = new Pane();
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        pane.setStyle("-fx-background-color: black;");
        
        //background
        Image pic = new Image("Rescources/instructions.png");
        ImageView bkgd = new ImageView(pic);
        bkgd.setFitHeight(SCENE_HEIGHT);
        bkgd.setFitWidth(SCENE_WIDTH);
        pane.getChildren().add(bkgd);
        
        //background
        Image pic2 = new Image("Rescources/controls.png");
        ImageView bkgd2 = new ImageView(pic2);
        bkgd2.setFitHeight(SCENE_HEIGHT);
        bkgd2.setFitWidth(SCENE_WIDTH);
        pane.getChildren().add(bkgd2);
        
        //text
        Text text = new Text("Click to Continue");
        text.setX(300);
        text.setY(75);
        text.setFill(Color.LIME);
        text.setFont(Font.font("Verdana", 25));
        pane.getChildren().add(text);
        
        instructionsShown = true;
        
        
        scene.setOnMouseClicked(e -> {
            if(!fromOptions) {
                Game game = new Game();
                primaryStage.setScene(game.gameScene(primaryStage, save, music, difficulty));
            }else{
                primaryStage.setScene(optionsScene(primaryStage, save, music, difficulty));
            }
        });
        
        
        return scene;
    }
    
    
}
