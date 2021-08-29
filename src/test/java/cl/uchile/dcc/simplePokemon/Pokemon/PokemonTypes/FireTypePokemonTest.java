package cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes;

import cl.uchile.dcc.simplePokemon.Pokemon.AbstractPokemonTest;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.GrassTypePokemon;
import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.WaterTypePokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireTypePokemonTest extends AbstractPokemonTest {
    private final String NAME = "Pepito";
    private final String SPECIES = "Charmander";
    private final int HP = 100;
    private final int PP = 20;
    private FireTypePokemon firePokemon;

    @BeforeEach
    void setUp() {
        firePokemon = new FireTypePokemon(NAME, SPECIES, HP, PP);
    }

    @Test
    void constructorTest() {
        FireTypePokemon expected = new FireTypePokemon(NAME, SPECIES, HP, PP);
        checkConstructor(expected, firePokemon);

        FireTypePokemon differentName = new FireTypePokemon("Juancho", SPECIES, HP, PP);
        FireTypePokemon differentSpecies = new FireTypePokemon(NAME, "Cyndaquil", HP, PP);
        FireTypePokemon differentHP = new FireTypePokemon(NAME, SPECIES, 50, PP);
        FireTypePokemon differentPP = new FireTypePokemon(NAME, SPECIES, HP, 15);

        checkDifferent(differentName, firePokemon);
        checkDifferent(differentSpecies, firePokemon);
        checkDifferent(differentHP, firePokemon);
        checkDifferent(differentPP, firePokemon);
    }

    @Test
    void getNameTest() {
        checkGetName(NAME, firePokemon);
    }

    @Test
    void getSpeciesTest() {
        checkGetSpecies(SPECIES, firePokemon);
    }

    @Test
    void getHPTest() {
        checkGetHP(HP, firePokemon);
    }

    @Test
    void setNameTest() {
        checkSetName("Juancho", firePokemon);
    }

    @Test
    void setHPTest() {
        checkSetHP(50, firePokemon);
    }

    @Test
    void outOfCombatTest() {
        checkOutOfCombat(firePokemon);
    }

    @Test
    void fireAttackTest() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP, PP);
        firePokemon.fireAttackReceived(fireOpponent);
        assertEquals(HP - 5, firePokemon.getHP());
    }

    @Test
    void waterAttackTest() {
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP, PP);
        firePokemon.waterAttackReceived(waterOpponent);
        assertEquals(HP - 10, firePokemon.getHP());
    }

    @Test
    void grassAttackTest() {
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP, PP);
        firePokemon.grassAttackReceived(grassOpponent);
        assertEquals(HP - 5, firePokemon.getHP());
    }

    @Test
    void attackTest() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP, PP);
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP, PP);
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP, PP);

        firePokemon.attack(fireOpponent);
        firePokemon.attack(waterOpponent);
        firePokemon.attack(grassOpponent);

        assertEquals(HP - 5, fireOpponent.getHP());
        assertEquals(HP - 5, waterOpponent.getHP());
        assertEquals(HP - 10, grassOpponent.getHP());
    }
}
