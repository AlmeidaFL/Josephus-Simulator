package Gui.Panel.Events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Application.JosephusSimulation;

public class StatesListener implements PropertyChangeListener{
    
    JosephusSimulation aux;

    public StatesListener(JosephusSimulation aux){
        this.aux = aux;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event){
        if(event.getPropertyName().equals("notPlaying")){
            this.aux.startSimulation();
            System.out.println("Oi");
        }

        if(event.getPropertyName().equals("notPlaying")){
            this.aux.stopSimulation();
            System.out.println("Txau");
        }
    }
}
