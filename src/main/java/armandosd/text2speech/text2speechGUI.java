package armandosd.text2speech;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class text2speechGUI extends Application {
    private static final int APP_WIDTH = 375;
    private static final int APP_HEIGHT = 475;
    private TextArea textArea;
    private ComboBox<String> voices, rates, volumes;
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = createScene();
        scene.getStylesheets().add(getClass().getResource(
                "style.css"
        ).toExternalForm());
        stage.setTitle("text2speech!");
        stage.setScene(scene);
        stage.show();
    }

    private Scene createScene() {
        VBox box = new VBox();
        box.getStyleClass().add("body");

        Label text2speechLabel = new Label("Text-to-Speech");
        text2speechLabel.getStyleClass().add("text-to-speech-label");
        text2speechLabel.setMaxWidth(Double.MAX_VALUE);
        text2speechLabel.setAlignment(Pos.CENTER);
        box.getChildren().add(text2speechLabel);

        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.getStyleClass().add("text-area");


        StackPane textAreaPane = new StackPane();
        textAreaPane.setPadding(new Insets(0, 15, 0, 15));
        textAreaPane.getChildren().add(textArea);
        box.getChildren().add(textAreaPane);

        GridPane settingsPane = createSettingComponents();
        box.getChildren().add(settingsPane);
        settingsPane.getStyleClass().add("settings-label");

        Button speakButton = createImageButton();
        StackPane speakButtonPane = new StackPane();
        speakButtonPane.setPadding(new Insets(40,20,0,20));
        speakButtonPane.getChildren().add(speakButton);
        box.getChildren().add(speakButtonPane);

        return new Scene(box, APP_WIDTH, APP_HEIGHT);
    }

    private Button createImageButton() {
        Button button = new Button("Speak");
        button.getStyleClass().add("speak-btn");

        button.setMaxWidth(Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(
                new Image(
                        getClass().getResourceAsStream("speak.png")
                )
        );
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        button.setGraphic(imageView);
        return button;
    }

    private GridPane createSettingComponents() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 0, 0, 0));
        gridPane.setAlignment(Pos.CENTER);

        Label voiceLabel = new Label("Voice");
        Label rateLabel = new Label("Rate");
        Label volumeLabel = new Label("Volume");

        gridPane.add(voiceLabel, 0, 0);
        GridPane.setHalignment(voiceLabel, HPos.CENTER);

        gridPane.add(rateLabel, 1, 0);
        GridPane.setHalignment(rateLabel, HPos.CENTER);

        gridPane.add(volumeLabel, 2, 0);
        GridPane.setHalignment(volumeLabel, HPos.CENTER);

        voices = new ComboBox<>();
        gridPane.add(voices, 0, 1);
        voices.getStyleClass().add("settings-combo-box");

        rates = new ComboBox<>();
        gridPane.add(rates, 1,1);
        rates.getStyleClass().add("settings-combo-box");

        volumes = new ComboBox<>();
        gridPane.add(volumes, 2,1);
        volumes.getStyleClass().add("settings-combo-box");

        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}