package cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes;

import cl.uchile.dcc.simplePokemon.Pokemon.AbstractPokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;

import java.util.Objects;

/** It holds all the information of a given water type Pokémon. */
public class WaterTypePokemon extends AbstractPokemon {

    /** Creates a new water type Pokémon with its respective parameters. */
    public WaterTypePokemon(String name, String species, int HP, int PP) {
        super(name, species, HP, PP);
    }

    /** Creates a water type Pokémon without a name. In this case
     * the name field is filled with the species field.
     */
    public WaterTypePokemon(String species, int HP, int PP) {
        this(species, species, HP, PP);
    }

    /** This performs a water attack against 'Pokémon'. */
    public void attack(IPokemon Pokemon) {
        Pokemon.waterAttackReceived(this);
    }

    /**
     * This Pokémon receives a grassAttack. Due to a weakness against
     * grassTypePokemon, this Pokémon receives 10 points of damage.
     */
    public void grassAttackReceived(IPokemon Pokemon) {
        setHP(getHP() - 10);
    }

    /**
     * Checks if 2 Pokemon are the same. Due to the lack of an id, the method
     * equals returns true when their parameters holds the same value, even
     * when 2 different Pokémon could potentially share their parameters and
     * be different.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WaterTypePokemon) {
            WaterTypePokemon waterType = (WaterTypePokemon) obj;
            return (waterType.getName().equals(this.getName()) &&
                    waterType.getSpecies().equals(this.getSpecies()) &&
                    waterType.getHP() == this.getHP()) &&
                    waterType.getPP() == this.getPP();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(WaterTypePokemon.class);
    }

    @Override
    public String toString() {
        return getName();
    }
}
