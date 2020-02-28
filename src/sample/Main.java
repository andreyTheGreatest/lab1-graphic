package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);


        double r1x = 60, r1y = 50, r1w = 70, r1h = 80;
        Rectangle r1 = new Rectangle(r1x, r1y, r1w, r1h);
        r1.setRotate(-10.9);

        Rectangle r2 = new Rectangle(r1x + r1w - 30, r1y + r1h + 5, 75, 60);
        r2.setRotate(45.9);

        Rectangle r3 = new Rectangle(r1x + r1w + 10, r1y + 10, 75, 70);
        r3.setRotate(10.9);

        Line l1 = new Line(r1.getX() + r1.getWidth() / 2, r1.getY() + r1.getHeight() / 2, r2.getX() + r2.getWidth() / 2, r2.getY() + r2.getHeight() / 2);
        l1.setStrokeWidth(5.0);

        Line l2 = new Line(r2.getX() + r2.getWidth() / 2, r2.getY() + r2.getHeight() / 2, r3.getX() + r3.getWidth() / 2, r3.getY() + r3.getHeight() / 2);
        l2.setStrokeWidth(5.0);

        Line l3 = new Line(r1.getX() + r1.getWidth() / 2, r1.getY() + r1.getHeight() / 2, r3.getX() + r3.getWidth() / 2, r3.getY() + r3.getHeight() / 2);
        l3.setStrokeWidth(5.0);

        r1.setFill(Color.rgb(0,255, 0));
        r2.setFill(Color.rgb(0,255, 0));
        r3.setFill(Color.rgb(0,255, 0));

        l1.setStroke(Color.BLUE);
        l2.setStroke(Color.BLUE);
        l3.setStroke(Color.BLUE);

        scene.setFill(Color.RED);

        root.getChildren().addAll(r1, r2, r3, l1, l2, l3);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
