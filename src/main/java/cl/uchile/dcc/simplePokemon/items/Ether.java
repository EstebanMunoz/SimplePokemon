package cl.uchile.dcc.simplePokemon.items;

import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;

/** Pokémon game object that restores a fixed amount of HP of a Pokémon. */
public class Ether {
    private final int PP;

    /** Creates an Ether able to restore a max of PP power points. */
    public Ether(int PP) {
        this.PP = PP;
    }

    /** Restores the PP of Pokemon. */
    public void restorePP(IPokemon Pokemon) {
        Pokemon.setPP(Pokemon.getPP() + PP);
    }
}
