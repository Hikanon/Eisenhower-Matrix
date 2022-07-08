package eisenhowermatrix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 900);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icon.png")));
        stage.setResizable(false);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}