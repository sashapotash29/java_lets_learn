# Java Interface


### What is it?

- an Interface is a way for a set of methods to be shared by multiple objects.
- A simple example would be an RPG game or any game for that matter. You would like an interface that explains a lof of the interactions that a character good or bad can do, like do damage, receive damage, say something when they get hit, etc.
- Benefits:
	- It allows us to organize our coding to allow for many methods to be descibed and then per each object be modified accordingly.
	- Many developers can share an interface but build their own objects, allowing for each object written seperately to contain their own approaches to certain methods.

### Lets make a simple RPG Game!

- As mentioned above in my simple example, an RPG game will be useful to see how interface works as well as the benefits. 


#### Creating an Interface
- To begin, we need to create an interface and be sure to include the package all your objects and interfaces reside in on the top of each file.

```
package interfaceproject;

public interface CharacterInterface {
    
    String gotHit();
    int takeDamage(int currentHealth, int damageDealt);
    int dealDamage(int opponentHealth, int damageDealt);
    String displayCurrentStats();
    
    
    
    
}
```

- This is part of the package interfaceproject and we create an interface like above.
- Inside we define methods that will be shared by all objects that implement this interface.
- For this RPG game, it will be very simply so we just have a few simple methods.

#### Linking your interface to your object

- To link our  interface to our object, we use the code "implements" where we declare the object.
- Below we have two classes that both implement the "CharacterInterface". One is the enemy and the other is the hero. They carry very similar variables but there might be a reason why they differ which is why we did not take advantage of inheritance.

##### Hero.java
```
package interfaceproject;
import java.util.Scanner;

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


```

##### Enemy.java
```
package interfaceproject;

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

```

- As you see, both of the classes have the same methods but how they go about executing them is different. In the future, I can create another monster or hero and use the "implement" *nameOfInterface* to allow for us to develop more efficiently.

#### InterfaceProject.java
- Remember that this file's main() method will be ran when the project is executed. Therefore, our object creation and various interactions must be invoked within.

```
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
```
- Look within the src folder to find the code for any methods that have been created outside the scope of the main() method.
- The idea is to have your code be as simple as possible and explain what is happening in a human readable way. For example, userAttacks(), fightBegins(), monsterDies(). It is logical and each method runs accurately by itself instead of a convoluted logic.
- In addition, most of the methods being called use the methods we declared in the object explaining how the object should interact with itself. (i.e. take some damage, attack something, display your stats).




