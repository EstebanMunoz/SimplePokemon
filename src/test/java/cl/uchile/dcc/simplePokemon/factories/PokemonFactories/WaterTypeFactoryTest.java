package cl.uchile.dcc.simplePokemon.factories.PokemonFactories;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.WaterTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.AbstractPokemonFactoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaterTypeFactoryTest extends AbstractPokemonFactoryTest {
    WaterTypeFactory waterFactory = new WaterTypeFactory();
    WaterTypePokemon Squirtle;

    @BeforeEach
    void setUp() {
        name = "Oogway";
        species = "Squirtle";
        HP = 100;
        PP = 20;
    }

    @Test
    void settersTest() {
        checkSetters(waterFactory);
    }

    @Test
    void createPokemonTest() {
        waterFactory.setName(name);
        waterFactory.setSpecies(species);
        waterFactory.setHP(HP);
        waterFactory.setPP(PP);

        Squirtle = new WaterTypePokemon(name, species, HP, PP);
        assertEquals(Squirtle, waterFactory.createPokemon());
    }
}
