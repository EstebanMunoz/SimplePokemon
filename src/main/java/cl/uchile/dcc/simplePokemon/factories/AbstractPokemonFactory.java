package cl.uchile.dcc.simplePokemon.factories;

/**
 * Implements all the functionality shared by all the Pokémon factories, which
 * includes the setters of the Pokemon parameters.
 */
public abstract class AbstractPokemonFactory implements PokemonFactory {
    protected String name;
    protected String species;
    protected int HP = 100;
    protected int PP = 20;

    /** Empty constructor with the purpose of instantiate the subclasses. */
    public AbstractPokemonFactory(){
    }

    /** Returns the Pokémon name. */
    public String getName() {
        return name;
    }

    /** Returns the Pokémon species.*/
    public String getSpecies() {
        return species;
    }

    /** Returns the actual amount of health points of the Pokémon. */
    public int getHP() {
        return HP;
    }

    /** Returns the actual amount of power points of the Pokémon. */
    public int getPP() {
        return PP;
    }

    /** Sets the name of the Pokémon to the variable "name". */
    public void setName(String name) {
        this.name = name;
    }

    /** Sets the species of the Pokémon to the variable "species". */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets the name and species of the Pokémon to the variable
     * "species" in case a name is unwanted.
     */
    public void setNameAndSpecies(String species) {
        this.name = species;
        this.species = species;
    }

    /** Sets the HP of the Pokémon to "HP" points. */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /** Sets the PP of the Pokémon to "PP" points. */
    public void setPP(int PP) {
        this.PP = PP;
    }
}
