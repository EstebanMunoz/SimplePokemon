package cl.uchile.dcc.cc3002.simplePokemon.test;

import cl.uchile.dcc.cc3002.simplePokemon.main.IPokemon;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractPokemonTest {
    protected void checkConstructor(IPokemon expected, IPokemon actual) {
        assertEquals(expected, actual);
        assertEquals(expected.hashCode(), actual.hashCode());
    }

    protected void checkDifferent(IPokemon unexpected, IPokemon actual) {
        assertNotEquals(unexpected, actual);
    }

    protected void checkGetName(String name, IPokemon Pokemon) {
        assertEquals(name, Pokemon.getName());
    }

    protected void checkGetSpecies(String species, IPokemon Pokemon) {
        assertEquals(species, Pokemon.getSpecies());
    }

    protected void checkGetHP(int HP, IPokemon Pokemon) {
        assertEquals(HP, Pokemon.getHP());
    }

    protected void checkSetName(String name, IPokemon Pokemon) {
        Pokemon.setName(name);
        assertEquals(name, Pokemon.getName());
    }

    protected void checkSetHP(int HP, IPokemon Pokemon) {
        Pokemon.setHP(HP);
        assertEquals(HP, Pokemon.getHP());
    }

    protected void checkOutOfCombat(IPokemon Pokemon) {
        Pokemon.setHP(0);
        assertTrue(Pokemon.outOfCombat());
    }
}
