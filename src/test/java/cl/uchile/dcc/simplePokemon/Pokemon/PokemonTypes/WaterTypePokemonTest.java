package cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes;
import cl.uchile.dcc.simplePokemon.Pokemon.AbstractPokemonTest;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.GrassTypePokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.WaterTypePokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterTypePokemonTest extends AbstractPokemonTest {
    private final String NAME = "Pepito";
    private final String SPECIES = "Squirtle";
    private final int HP = 100;
    private final int PP = 20;
    private WaterTypePokemon waterPokemon;

    @BeforeEach
    void setUp() {
        waterPokemon = new WaterTypePokemon(NAME, SPECIES, HP, PP);
    }

    @Test
    void constructorTest() {
        WaterTypePokemon expected = new WaterTypePokemon(NAME, SPECIES, HP, PP);
        checkConstructor(expected, waterPokemon);

        WaterTypePokemon differentName = new WaterTypePokemon("Juancho", SPECIES, HP, PP);
        WaterTypePokemon differentSpecies = new WaterTypePokemon(NAME, "Totodile", HP, PP);
        WaterTypePokemon differentHP = new WaterTypePokemon(NAME, SPECIES, 50, PP);

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
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP, PP);
        waterPokemon.fireAttackReceived(fireOpponent);
        assertEquals(HP - 5, waterPokemon.getHP());
    }

    @Test
    void testWaterAttack() {
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP, PP);
        waterPokemon.waterAttackReceived(waterOpponent);
        assertEquals(HP - 5, waterPokemon.getHP());
    }

    @Test
    void testGrassAttack() {
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP, PP);
        waterPokemon.grassAttackReceived(grassOpponent);
        assertEquals(HP - 10, waterPokemon.getHP());
    }

    @Test
    void testAttack() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP, PP);
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP, PP);
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP, PP);

        waterPokemon.attack(fireOpponent);
        waterPokemon.attack(waterOpponent);
        waterPokemon.attack(grassOpponent);

        assertEquals(HP - 10, fireOpponent.getHP());
        assertEquals(HP - 5, waterOpponent.getHP());
        assertEquals(HP - 5, grassOpponent.getHP());
    }
}
