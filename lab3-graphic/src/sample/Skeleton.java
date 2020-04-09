package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Skeleton extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 600);

        drawPicture(root);

        Path movement = new Path(
                new MoveTo(120, 120),
                new CubicCurveTo(270, 10, 470, 500, 880, 480)
        );

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(5000));
        pathTransition.setPath(movement);
        pathTransition.setNode(root);
        pathTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(2500), root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(3);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(5000), root);
        scaleTransition.setToX(0.4);
        scaleTransition.setToY(0.4);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                rotateTransition,
                scaleTransition,
                pathTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.setAutoReverse(true);
        parallelTransition.play();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawPicture(Group group) {
        Color bodyColor = Color.rgb(125, 191, 182);
        Color eyesColor = Color.rgb(255, 245, 31);
        Color shirtColor = Color.rgb(201, 70, 77);

        //body
        Path leftHand = new Path(
                new MoveTo(122, 192),
                new CubicCurveTo(133, 210, 132, 222, 125, 228),
                new QuadCurveTo(123, 226, 127, 220),
                new CubicCurveTo(125, 222, 121, 221, 127, 215),
                new LineTo(120, 205)
        );
        leftHand.setFill(bodyColor);
        leftHand.setStroke(Color.BLACK);
        group.getChildren().add(leftHand);

        Path rightHand = new Path(
                new MoveTo(78, 192),
                new CubicCurveTo(67, 210, 68, 222, 75, 228),
                new QuadCurveTo(77, 226, 73, 220),
                new CubicCurveTo(75, 222, 79, 221, 73, 215),
                new LineTo(80, 205)
        );
        rightHand.setFill(bodyColor);
        rightHand.setStroke(Color.BLACK);
        group.getChildren().add(rightHand);

        Path lowerBody = new Path(
                new MoveTo(120, 217),
                new QuadCurveTo(119, 230, 112, 247),
                new QuadCurveTo(130, 260, 105, 250),
                new QuadCurveTo(107, 242, 105, 234),
                new QuadCurveTo(100, 236, 95, 234),

                new QuadCurveTo(93, 242, 95, 250),
                new QuadCurveTo(70, 260, 88, 247),
                new QuadCurveTo(81, 230, 80, 217)
        );
        lowerBody.setFill(bodyColor);
        lowerBody.setStroke(Color.BLACK);
        group.getChildren().add(lowerBody);

        // shirt
        Path shirtBody = new Path(
                new MoveTo(118, 185),
                new QuadCurveTo(123, 206, 120, 217),
                new QuadCurveTo(100, 225, 80, 217),
                new QuadCurveTo(77, 206, 82, 185)
        );
        shirtBody.setFill(shirtColor);
        shirtBody.setStroke(Color.BLACK);
        group.getChildren().add(shirtBody);

        Polyline rightSleeve = new Polyline(82, 184, 74, 194, 79, 196);
        rightSleeve.setFill(shirtColor);
        rightSleeve.setStroke(Color.BLACK);
        group.getChildren().add(rightSleeve);

        Path collar = new Path(
                new MoveTo(118, 178),
                new LineTo(118, 184),
                new QuadCurveTo(100, 191, 82, 184),
                new LineTo(82,178)
        );
        collar.setFill(shirtColor);
        collar.setStroke(Color.BLACK);
        group.getChildren().add(collar);

        Polyline leftSleeve = new Polyline(118, 184, 126, 194, 121, 196);
        leftSleeve.setFill(shirtColor);
        leftSleeve.setStroke(Color.BLACK);
        group.getChildren().add(leftSleeve);



        //head
        Path head = new Path(
                new MoveTo(100, 100),
                new CubicCurveTo(115, 93, 128, 100, 142, 144),
                new CubicCurveTo(147, 150, 140, 162, 118, 178),
                new QuadCurveTo(100, 187, 82, 178),
                new CubicCurveTo(60, 162, 53, 150, 58, 144),
                new CubicCurveTo(78, 100, 85, 93, 100, 100)

        );
        head.setFill(bodyColor);
        head.setStroke(Color.BLACK);
        group.getChildren().add(head);

        Path mouth = new Path(
                new MoveTo(120, 165),
                new QuadCurveTo(100, 190, 80, 165)
        );
        mouth.setFill(Color.rgb(76, 18, 26));
        mouth.setStroke(Color.BLACK);
        group.getChildren().add(mouth);

        Path tongue = new Path(
                new MoveTo(108, 175),
                new QuadCurveTo(105, 170, 102, 172),
                new QuadCurveTo(100, 174, 98, 172),
                new QuadCurveTo(95, 170, 92, 175),
                new QuadCurveTo(100, 178, 108, 175)
        );
        tongue.setFill(Color.rgb(192, 148, 137));
        tongue.setStroke(Color.BLACK);
        group.getChildren().add(tongue);

        Path smile = new Path(
                new MoveTo(140, 152),
                new CubicCurveTo(136, 152, 132, 154, 120, 165),
                new QuadCurveTo(100, 176, 80, 165),
                new CubicCurveTo(68, 154, 64, 152, 60, 152)
        );
        smile.setFill(bodyColor);
        smile.setStroke(Color.BLACK);
        group.getChildren().add(smile);

        Path eyes = new Path(
                new MoveTo(100, 100),
                new CubicCurveTo(115, 93, 128, 100, 134, 130),
                new CubicCurveTo(136, 148, 130, 155, 100, 160),
                new CubicCurveTo(70, 155, 64, 148, 66, 130),
                new CubicCurveTo(78, 100, 85, 93, 100, 100)
        );
        eyes.setFill(eyesColor);
        eyes.setStroke(Color.BLACK);
        group.getChildren().add(eyes);

        Ellipse nose = new Ellipse(100, 158, 10, 8);
        nose.setFill(Color.BLACK);
        nose.setStroke(Color.BLACK);
        group.getChildren().add(nose);

        Ellipse noseBlink = new Ellipse(100, 156, 4, 2);
        noseBlink.setFill(Color.WHITE);
        noseBlink.setStroke(Color.BLACK);
        group.getChildren().add(noseBlink);

        Ellipse pupil1 = new Ellipse(108, 147, 2, 3);
        pupil1.setFill(Color.BLACK);
        pupil1.setStroke(Color.BLACK);
        group.getChildren().add(pupil1);

        Ellipse pupil2 = new Ellipse(92, 147, 2, 3);
        pupil2.setFill(Color.BLACK);
        pupil2.setStroke(Color.BLACK);
        group.getChildren().add(pupil2);





        QuadCurve whisker1 = new QuadCurve(115, 97, 116, 87, 118, 82);
        whisker1.setFill(Color.TRANSPARENT);
        whisker1.setStroke(Color.BLACK);
        group.getChildren().add(whisker1);

        QuadCurve whisker2 = new QuadCurve(120, 99, 121, 89, 128, 83);
        whisker2.setFill(Color.TRANSPARENT);
        whisker2.setStroke(Color.BLACK);
        group.getChildren().add(whisker2);

        QuadCurve whisker3 = new QuadCurve(85, 97, 84, 87, 82, 82);
        whisker3.setFill(Color.TRANSPARENT);
        whisker3.setStroke(Color.BLACK);
        group.getChildren().add(whisker3);

        QuadCurve whisker4 = new QuadCurve(80, 99, 79, 89, 72, 83);
        whisker4.setFill(Color.TRANSPARENT);
        whisker4.setStroke(Color.BLACK);
        group.getChildren().add(whisker4);
    }

}