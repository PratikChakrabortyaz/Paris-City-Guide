package User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TourismModule extends Application {

    private ListView<HBox> optionsListView; // ListView to display options

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tourism Module");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 10, 10, 10));

        Menu tourismMenu = new Menu("Tourism Module");
        MenuItem touristAttractionsItem = new MenuItem("Tourist Attractions");
        MenuItem historicalSitesItem = new MenuItem("Historical Sites");
        MenuItem culturalEventsItem = new MenuItem("Cultural Events");
        MenuItem restaurantsItem = new MenuItem("Restaurants");
        MenuItem accommodationItem = new MenuItem("Accommodation");

        tourismMenu.getItems().addAll(
            touristAttractionsItem,
            historicalSitesItem,
            culturalEventsItem,
            restaurantsItem,
            accommodationItem
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(tourismMenu);

        final Label infoLabel = new Label("Select a category from the Tourism Module menu.");
        final TextArea infoTextArea = new TextArea();
        infoTextArea.setWrapText(true);

        optionsListView = new ListView<>(); // Initialize the ListView

        vbox.getChildren().addAll(menuBar, infoLabel, infoTextArea, optionsListView);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Handle menu item actions
        touristAttractionsItem.setOnAction(e -> displayDataFromDatabaseWithButtons("tourist_attractions"));
        historicalSitesItem.setOnAction(e -> displayDataFromDatabaseWithButtons("historical_sites"));
        culturalEventsItem.setOnAction(e -> displayDataFromDatabaseWithButtons("cultural_events"));
        restaurantsItem.setOnAction(e -> displayDataFromDatabaseWithButtons("restaurants"));
        accommodationItem.setOnAction(e -> displayDataFromDatabaseWithButtons("accommodations"));
    }

    private void displayDataFromDatabaseWithButtons(String category) {
        // Clear the previous options
        optionsListView.getItems().clear();

        try (Connection connection = DataBaseConnector.getConnection()) {
            String sql = "SELECT name, description, location FROM " + category;

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String optionName = resultSet.getString("name");
                    String optionDescription = resultSet.getString("description");
                    String optionLocation = resultSet.getString("location");

                    HBox optionRow = createOptionRow(category, optionName);

                    // Create a label to display the option information
                    Label optionInfo = new Label(optionName + ":\n" +
                            "  Description: " + optionDescription + "\n" +
                            "  Location: " + optionLocation);

                    optionRow.getChildren().add(optionInfo);

                    optionsListView.getItems().add(optionRow);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors
        }
    }

    private HBox createOptionRow(String category, String optionName) {
        HBox optionRow = new HBox(10);
        Button likeButton = new Button("Like");
        Button dislikeButton = new Button("Dislike");

        likeButton.setOnAction(e -> handleLikeButton(category, optionName));
        dislikeButton.setOnAction(e -> handleDislikeButton(category, optionName));

        optionRow.getChildren().addAll(likeButton, dislikeButton);

        return optionRow;
    }

    private void handleLikeButton(String category, String optionName) {
        // Implement code to handle the "Like" button action for the given category and optionName
        System.out.println("Liked: " + optionName + " in category " + category);
        
    }

    private void handleDislikeButton(String category, String optionName) {
        // Implement code to handle the "Dislike" button action for the given category and optionName
        System.out.println("Disliked: " + optionName + " in category " + category);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}




