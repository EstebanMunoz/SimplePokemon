package cl.uchile.dcc.simplePokemon.items;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.PokemonFactories.FireTypeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtherTest {
    private final FireTypeFactory fireFactory = new FireTypeFactory();
    private FireTypePokemon Charmander;
    private Ether ether;

    private int pokemonMaxPP;
    private int etherPP;

    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        fireFactory.setNameAndSpecies("Charmander");
        fireFactory.setHP(100);

        seed = new Random().nextInt();
        rng = new Random(seed);

        pokemonMaxPP = rng.nextInt(10) + 10;
        etherPP = rng.nextInt(4) + 1;

        fireFactory.setPP(pokemonMaxPP);
        Charmander = fireFactory.createPokemon();

        ether = new Ether(etherPP);
    }

    @RepeatedTest(20)
    void restorePPTest() {
        ether.restorePP(Charmander);
        assertEquals(pokemonMaxPP, Charmander.getPP());

        Charmander.setPP(1);
        ether.restorePP(Charmander);

        assertEquals(etherPP + 1, Charmander.getPP());
    }
}
