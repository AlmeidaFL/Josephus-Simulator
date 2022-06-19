package Application;

import javax.swing.JFrame;

import Gui.GuiUtils;
import Gui.Panel.*;
import Application.Events.*;
import Data.ILinkedList;

import java.awt.*;

public class Window extends JFrame{
  
  private PanelTitle pnlTitle;
  private PanelMenu pnlMenu;
  private PanelCircle pnlCircle;
  private JosephusSimulation simulation;
  private ILinkedList list;

  public Window(){
    initialize();
  }
  /** Configure the main window elements
   */
  private void initialize(){

    setMinimumSize(new Dimension(1000, 700));
    setLayout(new BorderLayout());
    add(getPnlTitle(), BorderLayout.PAGE_START);   
    add(getPnlMenu(), BorderLayout.PAGE_END);
    setVisible(true);

    add(getPnlCircle(), BorderLayout.CENTER);
    setVisible(true);
    setResizable(false);
    getContentPane().setBackground(GuiUtils.BACKGROUND);
    getContentPane().setForeground(GuiUtils.FOREGROUND);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }

    public void setSimulation(JosephusSimulation simulation){
      if(simulation != null){  
        this.simulation = simulation;
      }
    }
    
    public void setLinkedList(ILinkedList list){
      if(list != null){
        this.list = list;
        MenuEvent.setEvent(pnlMenu, getPnlCircle(), simulation, list);
      }
    }

  private PanelTitle getPnlTitle(){

    if(pnlTitle == null){
      pnlTitle = new PanelTitle();
    }
    return pnlTitle;
  }

  private PanelMenu getPnlMenu(){
    if(pnlMenu == null){
      pnlMenu = new PanelMenu();
    }

    return pnlMenu;
  }


  public PanelCircle getPnlCircle(){
    if(pnlCircle == null){
      pnlCircle = new PanelCircle(getSizeComponents());
    }
    return pnlCircle;
  }

  private Dimension getSizeComponents(){
    Dimension aux = null;
    Dimension pnlTitleDimension = pnlTitle.getSize();
    Dimension pnlMenuDimension = pnlMenu.getSize();
    Dimension pnlFrame = this.getMinimumSize();
    double height =  pnlFrame.getHeight() - (pnlTitleDimension.getHeight() + pnlMenuDimension.getHeight());
    aux = new Dimension((int) pnlFrame.getWidth(), (int) height);
    return aux;
  }
}