package cl.uchile.dcc.simplePokemon.factories.PokemonFactories;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.WaterTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.AbstractPokemonFactory;

/** A factory that handles the creation of WaterTypePokemon. */
public class WaterTypeFactory extends AbstractPokemonFactory {
    public WaterTypeFactory() {
        super();
    }

    /**
     * Creates a WaterTypePokemon with parameters given by the setter methods,
     * or default values in case those parameters weren't given and are not
     * mandatory. In this case, species is a mandatory parameter.
     */
    public WaterTypePokemon createPokemon() {
        return new WaterTypePokemon(name, species, HP, PP);
    }
}
