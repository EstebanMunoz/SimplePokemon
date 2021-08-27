package cl.uchile.dcc.cc3002.simplePokemon.test;

import cl.uchile.dcc.cc3002.simplePokemon.main.FireTypePokemon;
import cl.uchile.dcc.cc3002.simplePokemon.main.GrassTypePokemon;
import cl.uchile.dcc.cc3002.simplePokemon.main.WaterTypePokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassTypePokemonTest extends AbstractPokemonTest {
    private final String NAME = "Pepito";
    private final String SPECIES = "Squirtle";
    private final int HP = 100;
    private GrassTypePokemon grassPokemon;

    @BeforeEach
    void setUp() {
        grassPokemon = new GrassTypePokemon(NAME, SPECIES, HP);
    }

    @Test
    void constructorTest() {
        GrassTypePokemon expected = new GrassTypePokemon(NAME, SPECIES, HP);
        checkConstructor(expected, grassPokemon);

        GrassTypePokemon differentName = new GrassTypePokemon("Juancho", SPECIES, HP);
        GrassTypePokemon differentSpecies = new GrassTypePokemon(NAME, "Chikorita", HP);
        GrassTypePokemon differentHP = new GrassTypePokemon(NAME, SPECIES, 50);

        checkDifferent(differentName, grassPokemon);
        checkDifferent(differentSpecies, grassPokemon);
        checkDifferent(differentHP, grassPokemon);
    }

    @Test
    void getNameTest() {
        checkGetName(NAME, grassPokemon);
    }

    @Test
    void getSpeciesTest() {
        checkGetSpecies(SPECIES, grassPokemon);
    }

    @Test
    void getHPTest() {
        checkGetHP(HP, grassPokemon);
    }

    @Test
    void setNameTest() {
        checkSetName("Juancho", grassPokemon);
    }

    @Test
    void setHPTest() {
        checkSetHP(50, grassPokemon);
    }

    @Test
    void outOfCombatTest() {
        checkOutOfCombat(grassPokemon);
    }

    @Test
    void testFireAttack() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP);
        grassPokemon.fireAttackReceived(fireOpponent);
        assertEquals(HP - 10, grassPokemon.getHP());
    }

    @Test
    void testWaterAttack() {
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP);
        grassPokemon.waterAttackReceived(waterOpponent);
        assertEquals(HP - 5, grassPokemon.getHP());
    }

    @Test
    void testGrassAttack() {
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP);
        grassPokemon.grassAttackReceived(grassOpponent);
        assertEquals(HP - 5, grassPokemon.getHP());
    }

    @Test
    void testAttack() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP);
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP);
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP);

        grassPokemon.attack(fireOpponent);
        grassPokemon.attack(waterOpponent);
        grassPokemon.attack(grassOpponent);

        assertEquals(HP - 5, grassOpponent.getHP());
        assertEquals(HP - 10, waterOpponent.getHP());
        assertEquals(HP - 5, grassOpponent.getHP());
    }
}
