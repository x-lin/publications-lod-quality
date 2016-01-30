package at.ac.tuwien.ifs.semweb.publications.util;

import at.ac.tuwien.ifs.semweb.publications.vocabulary.Vocab;
import org.openrdf.model.URI;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * Constants concerning the Sesame DB.
 *
 * @author xlin
 */
public class SesameConstants {
	/**
	 * The context in the Sesame repository, where the ontology is stored.
	 */
	public static final URI CONTEXT_URI = ValueFactoryImpl.getInstance().createURI(Vocab.NS + Config.ONT_CONTEXT);

	/**
	 * The context in the Sesame repository, where the data is stored.
	 */
	public static final URI DATA_CONTEXT = ValueFactoryImpl.getInstance().createURI(Vocab.NS + Config.DATA_CONTEXT);

}
