package cl.uchile.dcc.simplePokemon.factories.PokemonFactories;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.GrassTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.AbstractPokemonFactory;

/** A factory that handles the creation of GrassTypePokemon. */
public class GrassTypeFactory extends AbstractPokemonFactory {
    public GrassTypeFactory() {
        super();
    }

    /**
     * Creates a GrassTypePokemon with parameters given by the setter methods,
     * or default values in case those parameters weren't given and are not
     * mandatory. In this case, species is a mandatory parameter.
     */
    public GrassTypePokemon createPokemon() {
        return new GrassTypePokemon(name, species, HP, PP);
    }
}
