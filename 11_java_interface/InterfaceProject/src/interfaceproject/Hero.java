/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceproject;
import java.util.Scanner;

/**
 *
 * @author Alexander_Potashnik
 */
public class Hero implements CharacterInterface{
    
    
    String name;
    int health = 30;
    int attackPower = 3;
    
    
    
    void grabName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Tell me your name traveler: ");
        name = input.nextLine();
        System.out.println("Welcome to a journey of a lifetime! Try your best, " + name);
        System.out.println(" ");
        
    };

    @Override
    public String gotHit() {
        System.out.println("Ouch, " + name + " doesn't like that");
        //To change body of generated methods, choose Tools | Templates.
        return null;
    };

    @Override
    public int takeDamage(int currentHealth, int damageDealt) {
        int newHealth = currentHealth - damageDealt;
        if (newHealth>0){
            return newHealth;
        }
        else{
            return 0;
        }

    }

    @Override
    public int dealDamage(int opponentHealth, int damageDealt) {
       int oppNewHealth = opponentHealth - damageDealt;
        if(oppNewHealth > 0){
            return oppNewHealth;
        }
        else{
            return 0;
        
        }
    }

    @Override
    public String displayCurrentStats() {
        String stats = "Name: "+ name + ", Health: " + health + ", Attack Power: " + attackPower;
        return stats;
    }
    
}
