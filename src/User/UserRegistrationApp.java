package User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 interface DBoperations{
    boolean registerUser(String name, String email, String password);
     boolean signInUser(String email, String password);

}

public class UserRegistrationApp extends Application implements DBoperations {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("City Guide(For Paris)");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 20, 10));

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button registerButton = new Button("Register");
        Button signInButton = new Button("Sign In");
        Button reviewButton = new Button("Write a Review"); 
        nameField.setManaged(false);
        nameField.setVisible(false);

        registerButton.setOnAction(e -> {
            if (nameField.isVisible()) {
                // Registration
                String name = nameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();

                boolean registrationSuccessful = registerUser(name, email, password);

                if (registrationSuccessful) {
                    showModuleSelection();
                }
            } else {
                
                nameField.setManaged(true);
                nameField.setVisible(true);
            }

            nameField.clear();
            emailField.clear();
            passwordField.clear();
        });

        signInButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            boolean signInSuccessful = signInUser(email, password);

            if (signInSuccessful) {
                showModuleSelection();
            } else {
                System.out.println("Sign-in failed. Please check your email and password.");
            }

            nameField.clear();
            emailField.clear();
            passwordField.clear();
        });

        

        // Handle the review button click
        reviewButton.setOnAction(e -> openReviewDialog());

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(registerButton, 1, 3);
        grid.add(signInButton, 0, 3);
        grid.add(reviewButton, 2, 3); 

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     public  boolean registerUser(String name, String email, String password) {
        // Registration logic 
        // Insert the user into the database
        String insertUserQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public  boolean signInUser(String email, String password) {
        // Sign-in logic (check email and password in the database)
        
        String selectUserQuery = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection connection = DataBaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectUserQuery)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Sign-in is successful if a matching user is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showModuleSelection() {
        ModuleSelectionWindow moduleSelectionWindow = new ModuleSelectionWindow(primaryStage);
        moduleSelectionWindow.start(new Stage());
    }

    

    private void openReviewDialog() {
        ReviewDialog<String> reviewDialog = new ReviewDialog<>(primaryStage);
        reviewDialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
