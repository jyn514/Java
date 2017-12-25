import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class HelloWorld extends Application {

	@Override
	public void start(Stage stage) {
		Text hello = new Text(10, 40, "Hello, world!");
		hello.setFont(new Font(40));

		stage.setTitle("Welcome to JavaFX");
		stage.setScene(new Scene(new Group(hello)));
		stage.sizeToScene();
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
