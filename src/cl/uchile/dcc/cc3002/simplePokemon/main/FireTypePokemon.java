package cl.uchile.dcc.cc3002.simplePokemon.main;

import java.util.Objects;

/**
 * It holds all the information of a given fire type Pokémon, including the parameters
 * name, species and HP; and the behaviour of the attack system.
 */
public class FireTypePokemon extends AbstractPokemon implements IPokemon {

    /** Creates a new fire type Pokémon with its respective parameters. */
    public FireTypePokemon(String name, String species, int HP) {
        super(name, species, HP);
    }

    /** Creates a fire type Pokémon without a name. In this case
     * the name field is filled with the species field.
     */
    public FireTypePokemon(String species, int HP) {
        this(species, species, HP);
    }

    /** This performs a fire attack against 'Pokémon'. */
    public void attack(IPokemon Pokemon) {
        Pokemon.fireAttackReceived(this);
    }

    /** This Pokémon receives a waterAttack. In absence of a weakness, the damage
     * received is equal to 5 HP.
     */
    public void waterAttackReceived(IPokemon IPokemon) {
        setHP(Math.max(getHP() - 10, 0));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FireTypePokemon) {
            FireTypePokemon fireType = (FireTypePokemon) obj;
            return (fireType.getName().equals(this.getName()) &&
                    fireType.getSpecies().equals(this.getSpecies()) &&
                    fireType.getHP() == this.getHP());
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
