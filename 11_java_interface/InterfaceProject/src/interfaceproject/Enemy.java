/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceproject;

/**
 *
 * @author Alexander_Potashnik
 */
public class Enemy implements CharacterInterface{

    String name = "Java Goblin";
    int health = 10;
    int attackPower = 2;

    @Override
    public String gotHit() {
        return "Ouch that hurt! " + name + " doesn't like that!";
    }

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
        
    };

    @Override
    public String displayCurrentStats() {
        String stats = "Name: "+ name + ", Health: " + health + ", Attack Power: " + attackPower;
        return stats;
    };

    
}
