package User;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ModuleSelectionWindow extends Application {
    private Stage primaryStage;

    public ModuleSelectionWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Module Selection");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 10, 10, 10));

        Menu moduleMenu = new Menu("Select a Module");
        MenuItem tourismItem = new MenuItem("Tourism Module");
        MenuItem businessItem = new MenuItem("Business Module");
        MenuItem studentItem = new MenuItem("Student Module");
        

        moduleMenu.getItems().addAll(tourismItem, businessItem,studentItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(moduleMenu);

        vbox.getChildren().addAll(menuBar);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Handle menu item actions
        tourismItem.setOnAction(e -> showTourismModule());
        businessItem.setOnAction(e -> showBusinessModule());
        studentItem.setOnAction(e -> showStudentModule());

    }

    private void showTourismModule() {
        // Create the Tourism Module window or navigate to the TourismModule class
        TourismModule tourismModule = new TourismModule();
        tourismModule.start(new Stage());
    }

    private void showBusinessModule() {
        // Create the Business Module window or navigate to the BusinessModule class
        BusinessModule businessModule = new BusinessModule();
        businessModule.start(new Stage());
    }
    private void showStudentModule() {
        // Create the Business Module window or navigate to the BusinessModule class
        StudentModule studentModule = new StudentModule();
        studentModule.start(new Stage());
    }

    public static void main(String[] args) {
        launch(args);
    }
}


