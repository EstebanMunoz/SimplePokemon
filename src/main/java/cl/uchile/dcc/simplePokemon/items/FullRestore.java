package cl.uchile.dcc.simplePokemon.items;

import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;

/** Pokémon game object that restores all the HP and PP of a Pokémon. */
public class FullRestore {
    public FullRestore() {
    }

    /** Sets the HP and PP of Pokemon to its max value. */
    public void restorePokemon(IPokemon Pokemon) {
        Pokemon.setHP(Pokemon.getMaxHP());
        Pokemon.setPP(Pokemon.getMaxPP());
    }
}
