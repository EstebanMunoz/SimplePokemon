package cl.uchile.dcc.cc3002.simplePokemon.main;

import java.util.Scanner;
import java.util.Random;

/**
 * This class sets the mandatory parameters to initialize a Pokémon Battle.
 * A Pokémon battle needs a Pokémon controlled by the user and an opponent,
 * controlled by the CPU.
 */
public class Driver {

    /** Creates a Driver, whose solely purpose is initialize a Pokémon battle. */
    public Driver() {
        System.out.println("¡Bienvenido al mundo Pokémon!");

        IPokemon myIPokemon = pokemonSelection();
        nameAssignment(myIPokemon);
        IPokemon opponent = randPokemon();

        new PokemonBattle(myIPokemon, opponent);
    }

    /**
     * Asks the user which Pokémon species wants. Cunrrently there are 3
     * Pokémon species: Charmander, Bulbasaur and Squirtle.
     */
    public IPokemon pokemonSelection() {
        System.out.println("Por favor, elige uno de los siguientes Pokémon:");
        System.out.println("Charmander\nBulbasaur\nSquirtle\n");

        Scanner speciesScan = new Scanner(System.in);  // Create a Scanner object
        String species = speciesScan.nextLine();  // Read user input

        return getPokemon(species);

    }

    /**
     * Asks the user if a change in Pokémon name is wanted. If yes, then
     * a new Pokémon name is set.
     */
    public void nameAssignment(IPokemon myIPokemon) {
        System.out.println("¿Te gustaría darle un nuevo nombre a tu " + myIPokemon + "?");
        System.out.println("Responde 'Si' en caso de querer realizar esta acción: ");

        Scanner nameQuestionScan = new Scanner(System.in);  // Create a Scanner object
        String answer = nameQuestionScan.nextLine();  // Read user input

        if ("Si".equals(answer)) {
            System.out.println("Por favor ingresa el nuevo nombre de tu " + myIPokemon);

            Scanner nameScan = new Scanner(System.in);  // Create a Scanner object
            String name = nameScan.nextLine();  // Read user input

            myIPokemon.setName(name);

            System.out.println("¿" + name + "? Creo que le sienta bien a tu " + myIPokemon.getSpecies());
            return;
        }

        System.out.println("¡Bien! Creo que tu " + myIPokemon + " no necesita un nuevo nombre.");
    }

    /** Returns a Pokémon given its species. */
    public IPokemon getPokemon(String species) {
        switch (species) {
            case "Charmander":
                return new FireTypePokemon(species, 100);
            case "Squirtle":
                return new WaterTypePokemon(species, 100);
            case "Bulbasaur":
                return new GrassTypePokemon(species, 100);
            default:
                throw new IllegalStateException("Unexpected value: " + species);
        }
    }

    /** Returns a random Pokémon.*/
    public IPokemon randPokemon() {
        String[] species = {"Charmander", "Bulbasaur", "Squirtle"};

        Random rand = new Random();
        int randint = rand.nextInt(3);

        return getPokemon(species[randint]);
    }
}
