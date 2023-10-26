import controller.Controller;
import service.AnimalServiceImpl;
import service.DataBaseSql;
import view.View;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Controller controller = new Controller(new AnimalServiceImpl(), new View(), new DataBaseSql());
        controller.start();




    }

}
