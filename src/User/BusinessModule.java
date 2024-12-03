package User;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BusinessModule extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Business Module");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 10, 10, 10));

        Menu businessMenu = new Menu("Business Module");
        MenuItem jobMarketItem = new MenuItem("Job Market Insights");
        MenuItem businessOpportunitiesItem = new MenuItem("Business Opportunities");
        MenuItem economicTrendsItem = new MenuItem("Economic Trends");
        MenuItem networkingEventsItem = new MenuItem("Networking Events");

        businessMenu.getItems().addAll(
                jobMarketItem,
                businessOpportunitiesItem,
                economicTrendsItem,
                networkingEventsItem
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(businessMenu);

        final Label infoLabel = new Label("Select a category from the Business Module menu.");
        final TextArea infoTextArea = new TextArea();
        infoTextArea.setWrapText(true);

        vbox.getChildren().addAll(menuBar, infoLabel, infoTextArea);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Handle menu item actions
        jobMarketItem.setOnAction(e -> displayJobMarketInsights(infoTextArea));
        businessOpportunitiesItem.setOnAction(e -> displayBusinessOpportunities(infoTextArea));
        economicTrendsItem.setOnAction(e -> displayEconomicTrends(infoTextArea));
        networkingEventsItem.setOnAction(e -> displayNetworkingEvents(infoTextArea));
    }

    private void displayJobMarketInsights(TextArea infoTextArea) {
        // Implement code to fetch and display job market insights
        infoTextArea.setText("Job Market Insights:\n\n- Technology and Innovation\n- Green and Sustainable Jobs\n- Hospitality and Tourism");
    }

    private void displayBusinessOpportunities(TextArea infoTextArea) {
        // Implement code to fetch and display business opportunities
        infoTextArea.setText("Business Opportunities:\n\n- Fashion and Luxury Industry\n- Culinary Ventures\n- Creative Arts and Media");
    }

    private void displayEconomicTrends(TextArea infoTextArea) {
        // Implement code to fetch and display economic trends
        infoTextArea.setText("Economic Trends:\n\n- Start-up Ecosystem\n- Sustainable Development\n- Financial Services");
    }

    private void displayNetworkingEvents(TextArea infoTextArea) {
        // Implement code to fetch and display networking events
        infoTextArea.setText("Networking Events:\n\n- Virtual Networking\n- Co-Working Spaces\n- Industry-Specific Groups");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

