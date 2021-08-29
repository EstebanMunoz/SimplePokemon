package cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes;

import cl.uchile.dcc.simplePokemon.Pokemon.AbstractPokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;

import java.util.Objects;

/** It holds all the information of a given fire type Pokémon. */
public class FireTypePokemon extends AbstractPokemon implements IPokemon {

    /** Creates a new fire type Pokémon with its respective parameters. */
    public FireTypePokemon(String name, String species, int HP, int PP) {
        super(name, species, HP, PP);
    }

    /** Creates a fire type Pokémon without a name. In this case
     * the name field is filled with the species field.
     */
    public FireTypePokemon(String species, int HP, int PP) {
        this(species, species, HP, PP);
    }

    /** This performs a fire attack against 'Pokémon'. */
    public void attack(IPokemon Pokemon) {
        Pokemon.fireAttackReceived(this);
    }

    /**
     * This Pokémon receives a waterAttack. Due to a weakness against
     * waterTypePokemon, this Pokémon receives 10 points of damage.
     */
    public void waterAttackReceived(IPokemon IPokemon) {
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
        if (obj instanceof FireTypePokemon) {
            FireTypePokemon fireType = (FireTypePokemon) obj;
            return (fireType.getName().equals(this.getName()) &&
                    fireType.getSpecies().equals(this.getSpecies()) &&
                    fireType.getHP() == this.getHP()) &&
                    fireType.getPP() == this.getPP();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(FireTypePokemon.class);
    }

    @Override
    public String toString() {
        return getName();
    }
}
