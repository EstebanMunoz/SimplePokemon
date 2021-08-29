package cl.uchile.dcc.simplePokemon.items;

import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;

/** Pokémon game object that restores a fixed amount of PP of a Pokémon. */
public class Potion {
    private final int HP;

    /** Creates a Potion able to restore a max of HP health points. */
    public Potion(int HP) {
        this.HP = HP;
    }

    /** Restores the HP of Pokemon. */
    public void restoreHP(IPokemon Pokemon) {
        Pokemon.setHP(Pokemon.getHP() + HP);
    }
}
