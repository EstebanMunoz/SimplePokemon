package cl.uchile.dcc.cc3002.simplePokemon.test;
import cl.uchile.dcc.cc3002.simplePokemon.main.FireTypePokemon;
import cl.uchile.dcc.cc3002.simplePokemon.main.WaterTypePokemon;
import cl.uchile.dcc.cc3002.simplePokemon.main.GrassTypePokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterTypePokemonTest extends AbstractPokemonTest {
    private final String NAME = "Pepito";
    private final String SPECIES = "Squirtle";
    private final int HP = 100;
    private WaterTypePokemon waterPokemon;

    @BeforeEach
    void setUp() {
        waterPokemon = new WaterTypePokemon(NAME, SPECIES, HP);
    }

    @Test
    void constructorTest() {
        WaterTypePokemon expected = new WaterTypePokemon(NAME, SPECIES, HP);
        checkConstructor(expected, waterPokemon);

        WaterTypePokemon differentName = new WaterTypePokemon("Juancho", SPECIES, HP);
        WaterTypePokemon differentSpecies = new WaterTypePokemon(NAME, "Totodile", HP);
        WaterTypePokemon differentHP = new WaterTypePokemon(NAME, SPECIES, 50);

        checkDifferent(differentName, waterPokemon);
        checkDifferent(differentSpecies, waterPokemon);
        checkDifferent(differentHP, waterPokemon);
    }

    @Test
    void getNameTest() {
        checkGetName(NAME, waterPokemon);
    }

    @Test
    void getSpeciesTest() {
        checkGetSpecies(SPECIES, waterPokemon);
    }

    @Test
    void getHPTest() {
        checkGetHP(HP, waterPokemon);
    }

    @Test
    void setNameTest() {
        checkSetName("Juancho", waterPokemon);
    }

    @Test
    void setHPTest() {
        checkSetHP(50, waterPokemon);
    }

    @Test
    void outOfCombatTest() {
        checkOutOfCombat(waterPokemon);
    }

    @Test
    void testFireAttack() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP);
        waterPokemon.fireAttackReceived(fireOpponent);
        assertEquals(HP - 5, waterPokemon.getHP());
    }

    @Test
    void testWaterAttack() {
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP);
        waterPokemon.waterAttackReceived(waterOpponent);
        assertEquals(HP - 5, waterPokemon.getHP());
    }

    @Test
    void testGrassAttack() {
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP);
        waterPokemon.grassAttackReceived(grassOpponent);
        assertEquals(HP - 10, waterPokemon.getHP());
    }

    @Test
    void testAttack() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP);
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP);
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP);

        waterPokemon.attack(fireOpponent);
        waterPokemon.attack(waterOpponent);
        waterPokemon.attack(grassOpponent);

        assertEquals(HP - 10, fireOpponent.getHP());
        assertEquals(HP - 5, waterOpponent.getHP());
        assertEquals(HP - 5, grassOpponent.getHP());
    }
}
