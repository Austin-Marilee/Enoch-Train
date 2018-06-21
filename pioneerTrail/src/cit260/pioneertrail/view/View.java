/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.pioneertrail.view;

import cit260.pioneertrail.control.GameControl;
import cit260.pioneertrail.model.Player;
import java.util.Scanner;
import pioneertrail.PioneerTrail;

/**
 *
 * @author stephencostigan
 */
        
public abstract class View implements ViewInterfaces {
    
        public View(){  
        }
        
        @Override
        public void display(String type) {  //displayStartProgramView() {
                
        boolean endOfView = false; //    endOfView = false
        
        do { //DO
            String[] inputs = this.getInputs(); //inputs = getInputs()
                        
            if (inputs.length < 1 || inputs[0].toUpperCase() == "Q"){ 
            //IF no inputs were entered OR the first input is Q
                return; //RETURN
            } //ENDIF
 
            endOfView = doAction(inputs, type);
            
            }while (endOfView != true); //WHILE endOfView != true
        }
        
        @Override
        public void displayStart(String inputs){
            boolean endOfView = false;
            
            do{
                inputs = this.getInputString("\nPlease enter your name: ");
                endOfView = doActionName(inputs);
            }while (endOfView == false);
        }
            
        
        
        @Override
        public String[] getInputs() { //One character menu entries
            boolean valid = false;
            String[] inputs = new String[1];

            do {     
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                input = input.trim();
                input = input.toUpperCase();

                //Put input into String
                char y;
                y = input.charAt(0);
                inputs[0] = Character.toString(y);

                if(input.length() < 1){
                    System.out.println("Invalid value entered");
                    System.out.println("You must enter a non-blank value");
                    continue;
                } 

                 valid = true;

            } while (valid == false);
            return inputs;
        }
        
    @Override 
    public String getInputString(String promptMessage) { //More than one character
        
        boolean valid = false;
        String inputs = "";

        do {     
            System.out.println(promptMessage);
            Scanner scanner = new Scanner(System.in);
            inputs = scanner.nextLine();

            if(inputs.length() < 1){
                System.out.println("Invalid value entered, You must enter a non-blank value");
            } else {
            return inputs;
        }  
        
        } while (valid == false);
        
        return inputs;
    }
    
    @Override
    public boolean doAction(String[] inputs, String type) {
        switch (inputs[0]){
      
        case "G": inputs[0] = "G"; //GOAL
            if(type == "game"){
//                displayGoal();
                break;
            }else{
                System.out.println("Invalid value entered");
                displayMenu(type);
            }
        case "M": inputs[0] = "M"; //DISPLAY MOVE
            if(type == "main"){
//              displayMove();
                break;
            }else{
                System.out.println("Invalid value entered");
                displayMenu(type);
            }
        case "E": inputs[0] = "E";//ESTIMATE
            if(type == "game"){
//              displayEstimate();
                break;
            }else{
                System.out.println("Invalid value entered");
                displayMenu(type);
            }
        case "R": inputs[0] = "R";//ESTIMATE
            if(type == "main"){
                StartExistingGameView startExistingGameView = new StartExistingGameView();
                startExistingGameView.displayStartExistingGameView();
                GameControl.createNewGame(PioneerTrail.getPlayer());//Create a new game
                break;
            }else{
                System.out.println("Invalid value entered");
                displayMenu(type);
            }
        case "N": inputs[0] = "N";//New Game
            if(type == "main"){
                GameMenuView gameMenuView = new GameMenuView(); // gameMenuView = create a new GameMenuView object
                gameMenuView.displayGameMenuView();// gameMenuView.displayGameMenuView();   
                break;
            }else{
                System.out.println("Invalid value entered");
                displayMenu(type);
            }
        case "H": inputs[0] = "H";//INPUTS
            if(type == "game"){
//              displayHarvest();
                break;
            }else if(type == "main"){
                HelpMenuView helpMenuView = new HelpMenuView();// helpMenuView = Create a new HelpMenuView
                helpMenuView.displayHelpMenuView();
                break;
            }else{
                System.out.println("Invalid value entered");
                displayMenu(type);
            }
        case "D": inputs[0] = "D";//WAREHOUSE
            if(type == "game"){
//              displayWarehouse();
                break;
            }else{
                System.out.println("Invalid value entered");
                displayMenu(type);
            }
        case "Q": inputs[0] = "Q";
            return true;
            
        default:
            System.out.println("Invalid value entered");
            displayMenu(type);
        }
        
        return false;
    }

    
        @Override
        public boolean doActionName(String inputs) {

            String playerName = null;
            if (playerName == null){
                playerName = inputs;

                Player player = GameControl.savePlayer(playerName);

            } else {
                return false;
            }
            System.out.println(
            "\n============================================== " +
            "\n\t      Welcome aboard " + playerName + "!"   
            );

            displayMenu("main");

            return true;

        }
    
    private void displayMenu(String type){  //Displays main menu
        
        switch (type){
            case "main": type = "main";
                MainMenuView mainMenuView = new MainMenuView(); // gameMenuView = create a new GameMenuView object
                mainMenuView.viewMenu();
                break;
            case "game": type = "game";
                
                break;
            case "help": type = "help";
                
                break;
        }
    }
}

    
    
    

