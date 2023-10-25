import controller.Controller;
import service.AnimalServiceImpl;
import view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new AnimalServiceImpl(), new View());
        controller.start();
    }
}
