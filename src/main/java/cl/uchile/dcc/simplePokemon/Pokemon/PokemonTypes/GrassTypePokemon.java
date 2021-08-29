package cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes;

import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.AbstractPokemon;

import java.util.Objects;

/** It holds all the information of a given grass type Pokémon. */
public class GrassTypePokemon extends AbstractPokemon {

    /** Creates a new grass type Pokémon with its respective parameters. */
    public GrassTypePokemon(String name, String species, int HP, int PP) {
        super(name, species, HP, PP);
    }

    /** Creates a grass type Pokémon without a name. In this case
     * the name field is filled with the species field.
     */
    public GrassTypePokemon(String species, int HP, int PP) {
        this(species, species, HP, PP);
    }

    /** This performs a grass attack against 'Pokémon'. */
    public void attack(IPokemon Pokemon) {
        Pokemon.grassAttackReceived(this);
    }

    /**
     * This Pokémon receives a fireAttack. Due to a weakness against
     * fireTypePokemon, this Pokémon receives 10 points of damage.
     */
    public void fireAttackReceived(IPokemon Pokemon) {
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
        if (obj instanceof GrassTypePokemon) {
            GrassTypePokemon grassType = (GrassTypePokemon) obj;
            return (grassType.getName().equals(this.getName()) &&
                    grassType.getSpecies().equals(this.getSpecies()) &&
                    grassType.getHP() == this.getHP()) &&
                    grassType.getPP() == this.getPP();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GrassTypePokemon.class);
    }

    @Override
    public String toString() {
        return getName();
    }
}
