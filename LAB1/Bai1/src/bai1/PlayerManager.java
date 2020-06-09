/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author ASUS
 */
public class PlayerManager {
    public static void main(String[] args) {
        Menu mn = new Menu();
        mn.add("Add a new player");
        mn.add("Remove a player");
        mn.add("Update a player");
        mn.add("Print all player");
        mn.add("Quit");
        PlayerList list = new PlayerList();
        int userChoice;
        do{
            userChoice = mn.getUserChoice();
            switch (userChoice){
                case 1 : list.addPlayer(); break;
                case 2 : list.removePlayer(); break;
                case 3 : list.updatePlayer(); break;
                case 4 : list.print(); break;
            }
        }
        while (userChoice>=0 && userChoice<5);
    }
}
