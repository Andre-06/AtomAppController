import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.setProperty("javafx.module.path", "C:/Users/andre/OneDrive/Documentos/Java/JavaLibs/javafx-sdk-20.0.1/lib");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AppInterfaceFXML.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Yep");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
}
