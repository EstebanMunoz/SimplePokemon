package cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes;

import cl.uchile.dcc.simplePokemon.Pokemon.AbstractPokemonTest;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.GrassTypePokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.WaterTypePokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassTypePokemonTest extends AbstractPokemonTest {
    private final String NAME = "Pepito";
    private final String SPECIES = "Squirtle";
    private final int HP = 100;
    private final int PP = 20;
    private GrassTypePokemon grassPokemon;

    @BeforeEach
    void setUp() {
        grassPokemon = new GrassTypePokemon(NAME, SPECIES, HP, PP);
    }

    @Test
    void constructorTest() {
        GrassTypePokemon expected = new GrassTypePokemon(NAME, SPECIES, HP, PP);
        checkConstructor(expected, grassPokemon);

        GrassTypePokemon differentName = new GrassTypePokemon("Juancho", SPECIES, HP, PP);
        GrassTypePokemon differentSpecies = new GrassTypePokemon(NAME, "Chikorita", HP, PP);
        GrassTypePokemon differentHP = new GrassTypePokemon(NAME, SPECIES, 50, PP);

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
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP, PP);
        grassPokemon.fireAttackReceived(fireOpponent);
        assertEquals(HP - 10, grassPokemon.getHP());
    }

    @Test
    void testWaterAttack() {
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP, PP);
        grassPokemon.waterAttackReceived(waterOpponent);
        assertEquals(HP - 5, grassPokemon.getHP());
    }

    @Test
    void testGrassAttack() {
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP, PP);
        grassPokemon.grassAttackReceived(grassOpponent);
        assertEquals(HP - 5, grassPokemon.getHP());
    }

    @Test
    void testAttack() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP, PP);
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP, PP);
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP, PP);

        grassPokemon.attack(fireOpponent);
        grassPokemon.attack(waterOpponent);
        grassPokemon.attack(grassOpponent);

        assertEquals(HP - 5, grassOpponent.getHP());
        assertEquals(HP - 10, waterOpponent.getHP());
        assertEquals(HP - 5, grassOpponent.getHP());
    }
}
