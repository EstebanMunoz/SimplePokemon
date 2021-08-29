package cl.uchile.dcc.simplePokemon;

import cl.uchile.dcc.simplePokemon.Pokemon.IPokemon;

import java.util.Random;

/**
 * A class that holds a Pokémon battle. A Pokémon battle currently consists in 2
 * Pokémon randomly attacking each other until one of them runs out of HP.
 */
public class PokemonBattle {

    /** Given 2 Pokémon, they start to attack each other until one of the gets out of combat. */
    public PokemonBattle(IPokemon myIPokemon, IPokemon opponent) {
        System.out.println("Ha aparecido un " + opponent + " salvaje.\n");
        IPokemon[] IPokemon = {myIPokemon, opponent};

        System.out.println(IPokemon[0].getName() + " comienza con " + IPokemon[0].getHP() + "HP");
        System.out.println(IPokemon[1].getName() + " comienza con " + IPokemon[1].getHP() + "HP\n");

        while (true) {
            int attacker = new Random().nextInt(2);
            int defender = (attacker + 1) % 2;
            IPokemon[attacker].attack(IPokemon[defender]);
            System.out.println(IPokemon[attacker] + " ha atacado a " + IPokemon[defender]);
            System.out.println("A " + IPokemon[defender] + " le quedan " + IPokemon[defender].getHP() + "HP.\n");
            if (IPokemon[defender].outOfCombat()) {
                System.out.println(IPokemon[defender] + " ha quedado fuera de combate.");
                break;
            }
        }
    }
}
