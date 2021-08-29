package cl.uchile.dcc.simplePokemon.factories.PokemonFactories;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.AbstractPokemonFactoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FireTypeFactoryTest extends AbstractPokemonFactoryTest {
    FireTypeFactory fireFactory = new FireTypeFactory();
    FireTypePokemon Charmander;

    @BeforeEach
    void setUp() {
        name = "Mushu";
        species = "Charmander";
        HP = 100;
        PP = 20;
    }

    @Test
    void settersTest() {
        checkSetters(fireFactory);
    }

    @Test
    void createPokemonTest() {
        fireFactory.setName(name);
        fireFactory.setSpecies(species);
        fireFactory.setHP(HP);
        fireFactory.setPP(PP);

        Charmander = new FireTypePokemon(name, species, HP, PP);
        assertEquals(Charmander, fireFactory.createPokemon());
    }
}
