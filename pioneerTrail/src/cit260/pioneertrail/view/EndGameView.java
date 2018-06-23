/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.pioneertrail.view;

/**
 *
 * @author hughes
 */
public class EndGameView extends View {
    public EndGameView()
    {

    }
    public void displayEndGameView(){
        System.out.println(
            "========================================= "
            + "\n\t   Game Over "
            + "\n========================================="
            + "\n N - Start new game " 
            + "\n R - Restart an existing game " 
            + "\n Q - Quit game "
            + "\n=========================================\n ");// Display the instructions
    }
     @Override 
    public boolean doAction(String[] inputs, String type){
     
        switch(inputs[0]){
            case "N":
                MainMenuView main = new MainMenuView();
                main.displayMainMenuView();
                break;    
            case"R":
           MainMenuView chuck = new MainMenuView();
                chuck.displayMainMenuView();
                
                break;
            case "Q":
                
                MainMenuView fun = new MainMenuView();
                fun.displayMainMenuView();
                break;
        }
        return true;
     }
 }
