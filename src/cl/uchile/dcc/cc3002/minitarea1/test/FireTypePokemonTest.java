package cl.uchile.dcc.cc3002.minitarea1.test;
import cl.uchile.dcc.cc3002.minitarea1.main.FireTypePokemon;
import cl.uchile.dcc.cc3002.minitarea1.main.WaterTypePokemon;
import cl.uchile.dcc.cc3002.minitarea1.main.GrassTypePokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireTypePokemonTest extends AbstractPokemonTest {
    private final String NAME = "Pepito";
    private final String SPECIES = "Charmander";
    private final int HP = 100;
    private FireTypePokemon firePokemon;

    @BeforeEach
    void setUp() {
        firePokemon = new FireTypePokemon(NAME, SPECIES, HP);
    }

    @Test
    void constructorTest() {
        FireTypePokemon expected = new FireTypePokemon(NAME, SPECIES, HP);
        checkConstructor(expected, firePokemon);

        FireTypePokemon differentName = new FireTypePokemon("Juancho", SPECIES, HP);
        FireTypePokemon differentSpecies = new FireTypePokemon(NAME, "Cyndaquil", HP);
        FireTypePokemon differentHP = new FireTypePokemon(NAME, SPECIES, 50);

        checkDifferent(differentName, firePokemon);
        checkDifferent(differentSpecies, firePokemon);
        checkDifferent(differentHP, firePokemon);
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
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP);
        firePokemon.fireAttackReceived(fireOpponent);
        assertEquals(HP - 5, firePokemon.getHP());
    }

    @Test
    void waterAttackTest() {
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP);
        firePokemon.waterAttackReceived(waterOpponent);
        assertEquals(HP - 10, firePokemon.getHP());
    }

    @Test
    void grassAttackTest() {
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP);
        firePokemon.grassAttackReceived(grassOpponent);
        assertEquals(HP - 5, firePokemon.getHP());
    }

    @Test
    void attackTest() {
        FireTypePokemon fireOpponent = new FireTypePokemon(NAME, SPECIES, HP);
        WaterTypePokemon waterOpponent = new WaterTypePokemon(NAME, SPECIES, HP);
        GrassTypePokemon grassOpponent = new GrassTypePokemon(NAME, SPECIES, HP);

        firePokemon.attack(fireOpponent);
        firePokemon.attack(waterOpponent);
        firePokemon.attack(grassOpponent);

        assertEquals(HP - 5, fireOpponent.getHP());
        assertEquals(HP - 5, waterOpponent.getHP());
        assertEquals(HP - 10, grassOpponent.getHP());
    }
}
