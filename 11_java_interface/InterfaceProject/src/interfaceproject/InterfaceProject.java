/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceproject;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
/**
 *
 * @author Alexander_Potashnik
 */
public class InterfaceProject {

    static void welcomeMessage(){ 
       System.out.println("WELCOME TO ADVENTURE OF JAVA HERO");
       System.out.println("This game is created by Alexander Potashnik");
       
           
    };
    
    static Hero heroSetup(){
        Hero hero = new Hero();
        System.out.println("");
        hero.grabName();
        return hero;
        
    };
    
    static void establishStoryLine(String heroName) throws InterruptedException{
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Long ago, the world of programming was dominated by C-Sharp and all developers were forced to abide.");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Then one day Java was created and Developers began to have a choice about how they wanted to code.");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("But all was not well, because Java was no easy beast to tame...");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("As developers began to learn they found themselves in more difficult situations.");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("But finally emerged a hero by the name of " + heroName+ " who decided to tame said beast!!!");
    };
    
    static void meetMonster(String enemyName, String heroName) throws InterruptedException{
        System.out.println("With developers lying confused and scratching their head,");
        System.out.println(heroName + " emerged from the flames ready to meet and crush the " + enemyName+"!!!");
        TimeUnit.SECONDS.sleep(3);
        
    };
    
    
    
    static void fight(Enemy enemy, Hero hero, Scanner input) throws InterruptedException{
        enemy.displayCurrentStats();
        TimeUnit.SECONDS.sleep(2);
        hero.displayCurrentStats();
        TimeUnit.SECONDS.sleep(2);
        boolean control = true;
        while (control == true){
            System.out.println("Fight Menu");
            System.out.println("Type 1 and Enter to Attack");
            System.out.println("Type 2 and Enter to Run Away");
            String decision = input.nextLine();
            if(decision.equals("1")){
                int result = enemy.takeDamage(enemy.health, hero.attackPower);
                enemy.health = result;
                System.out.println(hero.name + " has done " + hero.attackPower + " damage to the " + enemy.name+"!");
                TimeUnit.SECONDS.sleep(2);
                control = false;
              
            }
            
            else if (decision.equals("2")){
                System.out.println("There is no running away. Java must be learnt!!");
                fight(enemy,hero,input);
            
            }
            
            else{
                System.out.println("Your Input is inaccurate! Try again, " + hero.name);
                fight(enemy,hero,input);
            }

        }
        
    };
    
    static void enemyAttacks(Hero hero, Enemy enemy) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println(enemy.name + " attacks " + hero.name + " for " + enemy.attackPower + " damage!");
        int result = hero.takeDamage(hero.health, enemy.attackPower);
        hero.health = result;
        TimeUnit.SECONDS.sleep(2);
    };
    
    public static void main(String[] args) throws InterruptedException {
        welcomeMessage();
        Hero hero = heroSetup();
        establishStoryLine(hero.name);
        Enemy enemy = new Enemy();
        Scanner input = new Scanner(System.in);
        meetMonster(enemy.name, hero.name);
        System.out.println("LET THE FIGHT BEGIN!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("YOUR OPPONENT!!");
        String eStats = enemy.displayCurrentStats();
        System.out.println(eStats);
        TimeUnit.SECONDS.sleep(2);
        boolean control = true;
        while(enemy.health > 0 && hero.health > 0 && control == true){
            
            fight(enemy, hero, input);
            if (enemy.health >0){
                enemyAttacks(hero,enemy);
                String hStats = hero.displayCurrentStats();
                System.out.println(hStats);
                eStats = enemy.displayCurrentStats();
                System.out.println(eStats);
             
            }
            else{
               System.out.println("YOU WON");
               control = false;
               
            
            }
            
        }
        
        
    }
    
}
