package Gui.Panel.Events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class StatesButton{
    private boolean statePlaying = false;
    private int amountCircles;
    private PropertyChangeSupport pcsListener;

    public StatesButton(){
      pcsListener = new PropertyChangeSupport(this);
    }

    public void setPlayingStatus(boolean status){
      boolean oldValue = this.statePlaying;
      this.statePlaying = status;
      String property = "Playing";
      if(status == false) property = "notPlaying";
      pcsListener.firePropertyChange(property, oldValue, status);
    }
    
    public void setAmountCircles(int amount){
      int oldValue = this.amountCircles;
      this.amountCircles = amount;
      String property = "Circles";
      pcsListener.firePropertyChange(property, oldValue, amount);
    }

    public int getAmountCircles(){
      return this.amountCircles;
    }

    public boolean isPlaying(){
      return statePlaying;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
      pcsListener.addPropertyChangeListener(listener);
    }
}
