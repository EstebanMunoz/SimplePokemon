package cl.uchile.dcc.simplePokemon.factories.PokemonFactories;

import cl.uchile.dcc.simplePokemon.Pokemon.PokemonTypes.FireTypePokemon;
import cl.uchile.dcc.simplePokemon.factories.AbstractPokemonFactory;

/** A factory that handles the creation of FireTypePokemon. */
public class FireTypeFactory extends AbstractPokemonFactory {
    public FireTypeFactory() {
        super();
    }

    /**
     * Creates a FireTypePokemon with parameters given by the setter methods,
     * or default values in case those parameters weren't given and are not
     * mandatory. In this case, species is a mandatory parameter.
     */
    public FireTypePokemon createPokemon() {
        return new FireTypePokemon(name, species, HP, PP);
    }
}
