import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.Random;
import java.util.Scanner;


class Snowman_ extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Pane root = new Pane();

        System.out.printf("Enter the number of circles \n");
        Scanner sc = new Scanner(System.in);
        int countCircle = sc.nextInt();

        root.getChildren().addAll(generateCircles(countCircle));

        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        Pane root1 = new Pane();
        primaryStage.setScene(new Scene(root1));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }


    private Circle[] generateCircles(int count) {
        Random random = new Random();

        System.out.printf("Enter the maximum radius \n");
        Scanner sc2 = new Scanner(System.in);
        int maxRadius = sc2.nextInt();


        System.out.printf("Enter the minimum radius \n");
            Scanner sc1 = new Scanner(System.in);
            int minRadius = sc1.nextInt();

        Circle[] circles = new Circle[count];

        double y1 = 20;

        for (int i = 0; i < circles.length; i++) {
            Color color = Color.color(random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble());


            double radius = minRadius+Math.random()*maxRadius;
            double y = radius + y1;
            y1 = y + radius;



            circles[i] = new Circle(
                    200, y, radius, Paint.valueOf(color.toString()));

            if(i==circles.length-1){
                circles[i] = new Circle(200-(circles[0].getRadius())/2,
                        circles[0].getCenterY()-(circles[0].getRadius())/2,
                        (circles[0].getRadius()*Math.random())/4, Paint.valueOf(color.toString()));
            }

            if(i==circles.length-2){
                circles[i] = new Circle(200+(circles[0].getRadius()*Math.random())/2,
                        circles[0].getCenterY()-(circles[0].getRadius())/2,
                        (circles[0].getRadius()*Math.random())/4, Paint.valueOf(color.toString()));
            }

            if(i==circles.length-3){
                circles[i] = new Circle(200,
                        circles[0].getCenterY()+circles[0].getRadius()*Math.random(),
                        (circles[0].getRadius()*Math.random())/4, Paint.valueOf(color.toString()));
            }

        }
        return circles;
    }
}
