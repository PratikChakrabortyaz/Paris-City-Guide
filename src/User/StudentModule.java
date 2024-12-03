package User;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentModule extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Module");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 10, 10, 10));

        Menu studentMenu = new Menu("Student Module");
        MenuItem schoolsItem = new MenuItem("Schools");
        MenuItem collegesItem = new MenuItem("Colleges");
        MenuItem universitiesItem = new MenuItem("Universities");
        MenuItem coursesItem = new MenuItem("Courses");
        MenuItem scholarshipsItem = new MenuItem("Scholarships");
        MenuItem studentOrgsItem = new MenuItem("Student Organizations");

        studentMenu.getItems().addAll(
            schoolsItem,
            collegesItem,
            universitiesItem,
            coursesItem,
            scholarshipsItem,
            studentOrgsItem
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(studentMenu);

        final TextArea infoTextArea = new TextArea();
        infoTextArea.setWrapText(true);

        vbox.getChildren().addAll(menuBar, infoTextArea);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Handle menu item actions
        schoolsItem.setOnAction(e -> displaySchoolsInfo(infoTextArea));
        collegesItem.setOnAction(e -> displayCollegesInfo(infoTextArea));
        universitiesItem.setOnAction(e -> displayUniversitiesInfo(infoTextArea));
        coursesItem.setOnAction(e -> displayCoursesInfo(infoTextArea));
        scholarshipsItem.setOnAction(e -> displayScholarshipsInfo(infoTextArea));
        studentOrgsItem.setOnAction(e -> displayStudentOrgsInfo(infoTextArea));
    }

    private void displaySchoolsInfo(TextArea infoTextArea) {
        // Implement code to fetch and display information about schools
        infoTextArea.setText("Schools Info:\n\n- Lycée Louis-le-Grand\n- American School of Paris 2\n- Lycée Henri-IV");
    }

    private void displayCollegesInfo(TextArea infoTextArea) {
        // Implement code to fetch and display information about colleges
        infoTextArea.setText("Colleges Info:\n\n- Sciences Po Paris\n- Collège de France\n- Institut Catholique de Paris");
    }

    private void displayUniversitiesInfo(TextArea infoTextArea) {
        // Implement code to fetch and display information about universities
        infoTextArea.setText("Universities Info:\n\n- Sorbonne University\n- University of Paris\n- École Normale Supérieure ");
    }

    private void displayCoursesInfo(TextArea infoTextArea) {
        // Implement code to fetch and display information about courses
        infoTextArea.setText("Courses Info:\n\n- Master in International Affairs\n- MBA in Luxury Brand Management\n- Bachelor in Economics and Social Sciences ");
    }

    private void displayScholarshipsInfo(TextArea infoTextArea) {
        // Implement code to fetch and display information about scholarships
        infoTextArea.setText("Scholarships Info:\n\n- Eiffel Excellence Scholarship Program\n- Charpak Exchange Program\n-  ENS ");
    }

    private void displayStudentOrgsInfo(TextArea infoTextArea) {
        // Implement code to fetch and display information about student organizations
        infoTextArea.setText("Student Organizations Info:\n\n-  ESN \n- AIESEC Paris\n- mnesty International Student Group - Paris");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
