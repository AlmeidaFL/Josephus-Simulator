package Application;
import Data.*;
import Gui.Window;
import Gui.Panel.Events.*;

public class StartController {
    public StartController(){
        inicialize();
    }

    public void inicialize(){
        ILinkedList list = new LinkedList();
        Window mainWindow = new Window();
        ViewController.setCirclePlaces(mainWindow.getPnlCircle(), list);
        StatesButton btnStates = mainWindow.getMenuEvent().getStatesButton();
        JosephusSimulation jsGame = new JosephusSimulation(list, 3, btnStates.getAmountCircles());
        StatesListener listener = new StatesListener(jsGame);
        btnStates.addPropertyChangeListener(listener);
    }
}
