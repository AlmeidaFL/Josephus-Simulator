package Gui;

import javax.swing.JFrame;
<<<<<<< Updated upstream
import javax.swing.*;
=======

import Gui.Panel.*;
import Gui.Panel.Events.MenuEvent;
>>>>>>> Stashed changes
import java.awt.*;
import Gui.GuiUtils;

public class Window extends JFrame{
  
  private PanelTitle pnlTitle;
  private PanelMenu pnlMenu;
  private PanelCircle pnlCircle;
  private MenuEvent events;

  public Window(){
    initialize();
    setEvents();
  }
  /** Configure the main window elements
   */
  private void initialize(){
    setLayout(new BorderLayout());

    add(getPnlTitle(), BorderLayout.PAGE_START);
    add(getPnlMenu(), BorderLayout.PAGE_END);
    
    getPnlMenu().getHeight();
    getPnlTitle().getHeight();
    
    PanelCircle aux = getPnlCircle();
    aux.setCirclePlaces();
    add(aux);
    
    setVisible(true);
    setResizable(false);
    getContentPane().setBackground(GuiUtils.BACKGROUND);
    getContentPane().setForeground(GuiUtils.FOREGROUND);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 600);

  }

  private void setEvents(){
    if(this.pnlMenu != null){
      this.events = new MenuEvent(this.pnlMenu);
    }
  }

  public MenuEvent getMenuEvent(){
    return this.events;
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


  private PanelCircle getPnlCircle(){
    if(pnlCircle == null){
      pnlCircle = new PanelCircle();
    }
    return pnlCircle;
  }
}
