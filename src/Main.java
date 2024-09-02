import defense_system.controller.Observer;
import defense_system.model.Observable;
import defense_system.view.MainController;
import defense_system.view.defenses.Helicopter;
import defense_system.view.defenses.Submarine;
import defense_system.view.defenses.WarTank;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`, then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Observer observer = new Observer();
//
//        MainController controller = new MainController(observer);
//
//        observer.add(new Helicopter(mainController, 1));
//        observer.add(new WarTank(mainController, 2));
//        observer.add(new Submarine(mainController, 3));
//
//        observer.sendStrength(0);

        Observable observable = Observable.getInstance();

        MainController mainController = new MainController();
        Helicopter helicopter = new Helicopter();
        WarTank tank = new WarTank();
        Submarine submarine = new Submarine();

        mainController.setVisible(true);
        helicopter.setVisible(true);
        tank.setVisible(true);
        submarine.setVisible(true);

        observable.addComponent(mainController);
        observable.addComponent(helicopter);
        observable.addComponent(tank);
        observable.addComponent(submarine);

        // Press Alt+Enter with your caret at the highlighted text to see how IntelliJ IDEA suggests fixing it.

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

        // Press Shift+F9 to start debugging your code. We have set one breakpoint for you, but you can always add more by pressing Ctrl+F8.
    }
}