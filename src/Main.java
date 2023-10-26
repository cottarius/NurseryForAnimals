import controller.Controller;
import model.AnimalTypeCreator;
import service.AnimalServiceImpl;
import service.DataBaseSql;
import view.View;


import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Controller controller = new Controller(new AnimalServiceImpl(),
                new AnimalTypeCreator(),
                new View(),
                new DataBaseSql());
        controller.start();




    }

}
