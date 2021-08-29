package cl.uchile.dcc.simplePokemon.Pokemon;

/**
 * Implements all the functionality shared by all the Pokémon classes, which
 * includes the parameters name, species, HP and PP; and the behaviour
 * of the attack system in absence of weaknesses.
 */
public abstract class AbstractPokemon implements IPokemon {
    protected String name;
    protected String species;
    protected int HP;
    protected int PP;

    protected int maxHP;
    protected int maxPP;

    /** Creates a new Pokémon with its respective parameters. */
    public AbstractPokemon(String name, String species, int HP, int PP) {
        this.name = name;
        this.species = species;
        this.HP = HP;
        this.PP = PP;
        this.maxHP = HP;
        this.maxPP = PP;
    }

    /** Returns this Pokémon name. */
    public String getName() {
        return name;
    }

    /** Returns this Pokémon species.*/
    public String getSpecies() {
        return species;
    }

    /** Returns the actual amount of health points of this Pokémon. */
    public int getHP() {
        return HP;
    }

    /** Returns the actual amount of power points of this Pokémon. */
    public int getPP() {
        return PP;
    }

    /** Returns the max possible amount of health points of this Pokémon. */
    public int getMaxHP() {
        return maxHP;
    }

    /** Returns the max possible amount of health points of this Pokémon. */
    public int getMaxPP() {
        return maxPP;
    }

    /** Sets the name of this Pokémon to the variable 'name'. */
    public void setName(String name) {
        this.name = name;
    }

    /** Sets the HP of this Pokémon to 'HP' points. */
    public void setHP(int HP) {
        int temp = Math.min(HP, getMaxHP());
        this.HP = Math.max(temp, 0);
    }

    /** Sets the PP of this Pokémon to 'PP' points. */
    public void setPP(int PP) {
        int temp = Math.min(PP, getMaxPP());
        this.PP = Math.max(temp, 0);
    }

    /**
     * Returns a boolean indicating if a Pokémon is out of combat. A Pokémon
     * is out of combat when its amount of HP is equal to 0.
     */
    public boolean outOfCombat() {
        return HP == 0;
    }

    /** This Pokémon receives a fireAttack. In absence of a weakness, the damage
     * received is equal to 5 HP.
     */
    public void fireAttackReceived(IPokemon Pokemon) {
        setHP(getHP() - 5);
    }

    /** This Pokémon receives a waterAttack. In absence of a weakness, the damage
     * received is equal to 5 HP.
     */
    public void waterAttackReceived(IPokemon Pokemon) {
        setHP(getHP() - 5);
    }

    /** This Pokémon receives a grassAttack. In absence of a weakness, the damage
     * received is equal to 5 HP.
     */
    public void grassAttackReceived(IPokemon Pokemon) {
        setHP(getHP() - 5);
    }

    @Override
    public String toString() {
        return getName();
    }
}
