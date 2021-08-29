package cl.uchile.dcc.simplePokemon.Pokemon;

/**
 * Represents a Pokémon class of any type. Currently, there are 3 Pokémon
 * classes: FireTypePokemon, WaterTypePokemon and GrassTypePokemon.
 * A Pokémon class contains 4 parameters: name, species, HP (health points)
 * and PP (power points).
 */
public interface IPokemon {

    /** Returns this Pokémon name. */
    String getName();

    /** Returns this Pokémon species.*/
    String getSpecies();

    /** Returns the actual amount of health points of this Pokémon. */
    int getHP();

    /** Returns the actual amount of health points of this Pokémon. */
    int getPP();

    /** Returns the max possible amount of health points of this Pokémon. */
    int getMaxHP();

    /** Returns the max possible amount of health points of this Pokémon. */
    int getMaxPP();

    /** Sets the name of this Pokémon to the variable 'name'. */
    void setName(String name);

    /** Sets the HP of this Pokémon to 'HP' points. */
    void setHP(int HP);

    /** Sets the PP of this Pokémon to 'PP' points. */
    void setPP(int PP);

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

    /** This is attacked by a fire type Pokémon. */
    void fireAttackReceived(IPokemon Pokemon);

    /** This is attacked by a water type Pokémon. */
    void waterAttackReceived(IPokemon Pokemon);

    /** This is attacked by a grass type Pokémon. */
    void grassAttackReceived(IPokemon Pokemon);
}
