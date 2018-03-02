package Star;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class Main extends Application {
    public static final int WIDTH_SCREEN = 800;
    public static final int HEIGHT_SCREEN = 800;
    private Star getStar;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);

        Text xCoordinateText = new Text();
        xCoordinateText.setTranslateX(10);
        xCoordinateText.setTranslateY(15);
        xCoordinateText.setText("X coordinate");
        TextField xCoordinateField = new TextField();
        xCoordinateField.setTranslateX(10);
        xCoordinateField.setTranslateY(20);
        xCoordinateField.setText("400");

        Text yCoordinateText = new Text();
        yCoordinateText.setTranslateX(10);
        yCoordinateText.setTranslateY(65);
        yCoordinateText.setText("Y coordinate");
        TextField yCoordinateField = new TextField();
        yCoordinateField.setTranslateX(10);
        yCoordinateField.setTranslateY(70);
        yCoordinateField.setText("400");

        Text radiusText = new Text();
        radiusText.setTranslateX(10);
        radiusText.setTranslateY(115);
        radiusText.setText("Radius star");
        TextField radiusField = new TextField();
        radiusField.setTranslateX(10);
        radiusField.setTranslateY(120);
        radiusField.setText("200");

        Text angleText = new Text();
        angleText.setTranslateX(10);
        angleText.setTranslateY(165);
        angleText.setText("Count angle");
        TextField angleField = new TextField();
        angleField.setTranslateX(10);
        angleField.setTranslateY(170);
        angleField.setText("5");

        Button button = new Button();
        button.setTranslateX(10);
        button.setTranslateY(200);
        button.setText("Draw star");

        Pane root = new Pane();
        root.getChildren().addAll(xCoordinateText, yCoordinateText, radiusText,
                xCoordinateField, yCoordinateField, radiusField, angleText, angleField, button);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Звезда");
        primaryStage.show();


        button.setOnMouseClicked(event -> {

            int xCoordinate = Integer.parseInt(xCoordinateField.getText());
            int yCoordinate = Integer.parseInt(yCoordinateField.getText());
            int radius = Integer.parseInt(radiusField.getText());
            int countAngle = Integer.parseInt(angleField.getText());
            getStar = new Star(xCoordinate, yCoordinate, radius, countAngle);

            root.getChildren().clear();
            root.getChildren().addAll(getStar.drawStar());

            xCoordinateField.setText(String.valueOf(xCoordinate));
            yCoordinateField.setText(String.valueOf(yCoordinate));
            radiusField.setText(String.valueOf(radius));
            root.getChildren().addAll(xCoordinateText, yCoordinateText, radiusText, xCoordinateField, yCoordinateField, radiusField, angleText, angleField, button);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
