import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.valueOf;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        StackPane display = new StackPane();
        Rectangle background = new Rectangle(250, 100);
        background.setFill(valueOf("grey"));

        Text text = new Text(10, 40, "0");
        text.setFont(new Font(40));

        display.getChildren().addAll(background, text);

        Scene layout = new Scene(new Group(display));
        layout.setOnKeyTyped(event -> {
            System.out.println(event.getCharacter());
            text.setText(Logic.handle(event.getCharacter()));
            stage.sizeToScene();
        });

        stage.setTitle("A simple calculator");
        stage.setScene(layout);
        stage.sizeToScene();
        stage.show();
    }

	/**
	 * @param args ignored
	 */
	public static void main(String[] args) {
        Application.launch(args);
	}

}
