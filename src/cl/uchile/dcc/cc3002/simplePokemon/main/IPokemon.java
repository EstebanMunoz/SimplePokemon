package cl.uchile.dcc.cc3002.simplePokemon.main;

/**
 * Represents a Pokémon class of any type. Currently, there are 3 Pokémon
 * classes: FireTypePokemon, WaterTypePokemon and GrassTypePokemon.
 * A Pokémon class contains 3 parameters: name, species and HP (health points).
 * A Pokémon can be controlled by the user or the CPU.
 */
public interface IPokemon {

    /** Returns this Pokémon name. */
    String getName();

    /** Returns this Pokémon species.*/
    String getSpecies();

    /** Returns the actual amount oh health points of this Pokémon. */
    int getHP();

    /** Sets the name of this Pokémon to the variable 'name'. */
    void setName(String name);

    /** Sets the HP of this Pokémon to 'HP' points. */
    void setHP(int HP);

    /**
     * Returns a boolean indicating if a Pokémon is out of combat. A Pokémon
     * is out of combat when its amount of HP is equal to 0.
     */
    boolean outOfCombat();

    /**
     * This attacks 'Pokémon'. As a result, 'Pokémon' gets its HP reduced
     * based in its type and this type.
     */
    void attack(IPokemon Pokemon);

    /** This is attacked by a fire type Pokémon- */
    void fireAttackReceived(IPokemon Pokemon);

    /** This is attacked by a water type Pokémon. */
    void waterAttackReceived(IPokemon Pokemon);

    /** This is attacked by a grass type Pokémon. */
    void grassAttackReceived(IPokemon Pokemon);
}
