package cl.uchile.dcc.simplePokemon.items;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.PokemonFactories.FireTypeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PotionTest {
    private final FireTypeFactory fireFactory = new FireTypeFactory();
    private FireTypePokemon Charmander;
    private Potion potion;

    private int pokemonMaxHP;
    private int potionHP;

    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        fireFactory.setNameAndSpecies("Charmander");
        fireFactory.setPP(20);

        seed = new Random().nextInt();
        rng = new Random(seed);

        pokemonMaxHP = rng.nextInt(50) + 50;
        potionHP = rng.nextInt(30) + 10;

        fireFactory.setHP(pokemonMaxHP);
        Charmander = fireFactory.createPokemon();

        potion = new Potion(potionHP);
    }

    @RepeatedTest(20)
    void restoreHPTest() {
        potion.restoreHP(Charmander);

        assertEquals(pokemonMaxHP, Charmander.getHP());

        Charmander.setHP(10);
        potion.restoreHP(Charmander);

        assertEquals(potionHP + 10, Charmander.getHP());
    }
}
