package cl.uchile.dcc.simplePokemon.factories;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractPokemonFactoryTest {
    protected String name;
    protected String species;
    protected int HP;
    protected int PP;

    protected void checkSetters(PokemonFactory factory) {
        factory.setName(name);
        assertEquals(name, factory.getName());

        factory.setSpecies(species);
        assertEquals(species, factory.getSpecies());

        factory.setNameAndSpecies(species);
        assertEquals(species, factory.getName());
        assertEquals(species, factory.getSpecies());

        factory.setHP(HP);
        assertEquals(HP, factory.getHP());

        factory.setPP(PP);
        assertEquals(PP, factory.getPP());
    }
}
