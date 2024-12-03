package User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Insets;

public class ReviewDialog<T> extends Stage {
    private final TextArea reviewTextArea;

    public ReviewDialog(Stage owner) {
        this.initOwner(owner);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initStyle(StageStyle.UTILITY);
        this.setTitle("Review Application");

        Label reviewLabel = new Label("Write your review:");
        reviewTextArea = new TextArea();
        reviewTextArea.setWrapText(true);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String reviewText = reviewTextArea.getText();
            if (!reviewText.isEmpty()) {
                // Create a new thread to store the review
                Thread reviewThread = new Thread(() -> submitReview(reviewText));
                reviewThread.start();

                this.close();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(reviewLabel, reviewTextArea, submitButton);

        Scene scene = new Scene(layout, 400, 300);
        this.setScene(scene);
    }

    private void submitReview(String reviewText) {
        // Implement the logic for handling the review submission
        
        System.out.println("Review submitted: " + reviewText);
    }
}

