package User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Label label = new Label("Hello, JavaFX!");
        Scene scene = new Scene(label, 300, 200);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
