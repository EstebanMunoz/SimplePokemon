package cl.uchile.dcc.cc3002.simplePokemon.main;

import java.lang.Math;
import java.util.Objects;

/**
 * It holds all the information of a given water type Pokémon, including the parameters
 * name, species and HP; and the behaviour of the attack system.
 */
public class WaterTypePokemon extends AbstractPokemon {

    /** Creates a new water type Pokémon with its respective parameters. */
    public WaterTypePokemon(String name, String species, int HP) {
        super(name, species, HP);
    }

    /** Creates a water type Pokémon without a name. In this case
     * the name field is filled with the species field.
     */
    public WaterTypePokemon(String species, int HP) {
        this(species, species, HP);
    }

    /** This performs a water attack against 'Pokémon'. */
    public void attack(IPokemon Pokemon) {
        Pokemon.waterAttackReceived(this);
    }

    /** This Pokémon receives a grassAttack. When a water type Pokémon receives
     * a grass attack it looses 10 HP.
     */
    public void grassAttackReceived(IPokemon Pokemon) {
        setHP(Math.max(getHP() - 10, 0));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WaterTypePokemon) {
            WaterTypePokemon waterType = (WaterTypePokemon) obj;
            return (waterType.getName().equals(this.getName()) &&
                    waterType.getSpecies().equals(this.getSpecies()) &&
                    waterType.getHP() == this.getHP());
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
