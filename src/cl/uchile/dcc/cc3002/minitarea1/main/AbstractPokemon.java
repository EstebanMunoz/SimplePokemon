package cl.uchile.dcc.cc3002.minitarea1.main;

public abstract class AbstractPokemon implements IPokemon {
    protected String name;
    protected String species;
    protected int HP;

    public AbstractPokemon(String name, String species, int HP) {
        this.name = name;
        this.species = species;
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getHP() {
        return HP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int HP) {
        this.HP = HP;
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
    public void fireAttackReceived(IPokemon IPokemon) {
        setHP(Math.max(getHP() - 5, 0));
    }

    /** This Pokémon receives a waterAttack. In absence of a weakness, the damage
     * received is equal to 5 HP.
     */
    public void waterAttackReceived(IPokemon IPokemon) {
        setHP(Math.max(getHP() - 5, 0));
    }

    /** This Pokémon receives a grassAttack. In absence of a weakness, the damage
     * received is equal to 5 HP.
     */
    public void grassAttackReceived(IPokemon IPokemon) {
        setHP(Math.max(getHP() - 5, 0));
    }

    @Override
    public String toString() {
        return getName();
    }
}
