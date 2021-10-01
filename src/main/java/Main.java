import config.DatabaseConnector;
import controller.MainController;
import util.Console;
import util.View;

public class Main {

    public static void main(String[] args) {
        View view = new Console();
        DatabaseConnector dbConnector = new DatabaseConnector();
        MainController mainController = new MainController(view, dbConnector.getDataSource());
        mainController.read();
    }
}
