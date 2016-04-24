package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main extends Application{

    private ObservableList<Node> children;
    private TranslateTransition transition;


    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("pastuhov.fxml"));
        primaryStage.setScene(new Scene(parent,1500,1000));

//        primaryStage.setTitle("Pastuhov");
//
//        Parent parent = FXMLLoader.load(getClass().getResource("pastuhov.fxml"));
//
//        Group group = new Group();
//
//
//
//        Rectangle rectangle = new Rectangle(10, 10, 100, 100);
//        rectangle.setFill(Paint.valueOf("#f0f"));
//        Rectangle rectangle2 = new Rectangle(10, 10, 100, 100);
//
//
//        Circle circle = new Circle(100,100,5,Paint.valueOf("#f00"));
//
//
//
//
//        transition = new TranslateTransition(new Duration(1000),circle);
//        transition.setFromX(0);
//        transition.setToX(200);
//        transition.setAutoReverse(true);
//        transition.setCycleCount(Timeline.INDEFINITE);
//        transition.play();
//
//
//        children = group.getChildren();
//        children.add(rectangle);
//        children.add(rectangle2);
//        children.add(circle);
//
//        Scene scene = new Scene(group,500,500);
//
//        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//                rectangle.setLayoutX(event.getSceneX());
//                rectangle.setLayoutY(event.getSceneY());
//            }
//        });
//
//        primaryStage.setScene(scene);
//
//
//

        primaryStage.show();
    }






    public static void main(String... args){
         String address = "http://api.icndb.com/jokes/random?firstName=John&amp;lastName=Doe";

//        launch(args);


        try {
            URL url = new URL(address);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            reader.lines().forEach(System.out::println);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}