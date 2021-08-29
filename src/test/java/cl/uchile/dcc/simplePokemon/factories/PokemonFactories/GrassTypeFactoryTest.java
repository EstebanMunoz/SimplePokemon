package cl.uchile.dcc.simplePokemon.factories.PokemonFactories;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.GrassTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.AbstractPokemonFactoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassTypeFactoryTest extends AbstractPokemonFactoryTest {
    GrassTypeFactory grassFactory = new GrassTypeFactory();
    GrassTypePokemon Bulbasaur;

    @BeforeEach
    void setUp() {
        name = "Solar Panel";
        species = "Bulbasaur";
        HP = 100;
        PP = 20;
    }

    @Test
    void settersTest() {
        checkSetters(grassFactory);
    }

    @Test
    void createPokemonTest() {
        grassFactory.setName(name);
        grassFactory.setSpecies(species);
        grassFactory.setHP(HP);
        grassFactory.setPP(PP);

        Bulbasaur = new GrassTypePokemon(name, species, HP, PP);
        assertEquals(Bulbasaur, grassFactory.createPokemon());
    }
}
