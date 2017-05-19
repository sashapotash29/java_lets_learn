package interfaceproject;

/**
 *
 * @author Alexander_Potashnik
 */
public interface CharacterInterface {
    
    String gotHit();
    int takeDamage(int currentHealth, int damageDealt);
    int dealDamage(int opponentHealth, int damageDealt);
    String displayCurrentStats();
    
    
    
    
}
