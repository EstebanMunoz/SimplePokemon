package cl.uchile.dcc.simplePokemon.factories;

import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;

/**
 * Factory pattern.
 *
 * A factory that manages the creation of multiple Pokemon instances.
 */
public interface PokemonFactory {

    /** Generate a Pokémon with the given parameters by the setter methods. */
    IPokemon createPokemon();

    /** Returns the Pokémon name. */
    public String getName();

    /** Returns the Pokémon species.*/
    public String getSpecies();

    /** Returns the actual amount of health points of the Pokémon. */
    public int getHP();

    /** Returns the actual amount of power points of the Pokémon. */
    public int getPP();

    /** Sets the name of the Pokémon to the variable 'name'. */
    void setName(String name);

    /** Sets the species of the Pokémon to the variable 'species'. */
    void setSpecies(String species);

    void setNameAndSpecies(String species);

    /** Sets the HP of the Pokémon to 'HP' points. */
    void setHP(int HP);

    /** Sets the PP of the Pokémon to 'PP' points. */
    void setPP(int PP);
}
