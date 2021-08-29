package cl.uchile.dcc.simplePokemon.items;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.PokemonFactories.FireTypeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullRestoreTest {
    private final FireTypeFactory fireFactory = new FireTypeFactory();
    private FireTypePokemon Charmander;
    private FullRestore fullRestore = new FullRestore();

    private int HP = 100;
    private int PP = 20;
    private int newHP;
    private int newPP;

    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        fireFactory.setNameAndSpecies("Charmander");
        fireFactory.setHP(HP);
        fireFactory.setPP(PP);

        Charmander = fireFactory.createPokemon();

        seed = new Random().nextInt();
        rng = new Random(seed);

        newHP = rng.nextInt(80) + 10;
        newPP = rng.nextInt(10) + 5;
    }

    @RepeatedTest(20)
    void restorePPTest() {
        Charmander.setHP(newHP);
        Charmander.setPP(newPP);
        fullRestore.restorePokemon(Charmander);
        assertEquals(HP, Charmander.getHP());
        assertEquals(PP, Charmander.getPP());
    }
}
