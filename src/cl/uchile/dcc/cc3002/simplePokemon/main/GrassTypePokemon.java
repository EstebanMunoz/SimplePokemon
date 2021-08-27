package cl.uchile.dcc.cc3002.simplePokemon.main;

import java.lang.Math;
import java.util.Objects;

/**
 * It holds all the information of a given grass type Pokémon, including the parameters
 * name, species and HP; and the behaviour of the attack system.
 */
public class GrassTypePokemon extends AbstractPokemon {

    /** Creates a new grass type Pokémon with its respective parameters. */
    public GrassTypePokemon(String name, String species, int HP) {
        super(name, species, HP);
    }

    /** Creates a grass type Pokémon without a name. In this case
     * the name field is filled with the species field.
     */
    public GrassTypePokemon(String species, int HP) {
        this(species, species, HP);
    }

    /** This performs a grass attack against 'Pokémon'. */
    public void attack(IPokemon Pokemon) {
        Pokemon.grassAttackReceived(this);
    }

    /** This Pokémon receives a fireAttack. When a grass type Pokémon receives
     * a fire attack it looses 10 HP.
     */
    public void fireAttackReceived(IPokemon Pokemon) {
        setHP(Math.max(getHP() - 10, 0));
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GrassTypePokemon) {
            GrassTypePokemon grassType = (GrassTypePokemon) obj;
            return (grassType.getName().equals(this.getName()) &&
                    grassType.getSpecies().equals(this.getSpecies()) &&
                    grassType.getHP() == this.getHP());
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
