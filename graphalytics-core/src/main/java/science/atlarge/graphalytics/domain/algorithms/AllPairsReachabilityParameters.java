package science.atlarge.graphalytics.domain.algorithms;

import org.apache.commons.configuration.Configuration;
import science.atlarge.graphalytics.configuration.ConfigurationUtil;
import science.atlarge.graphalytics.configuration.InvalidConfigurationException;
import science.atlarge.graphalytics.domain.graph.Property;
import science.atlarge.graphalytics.domain.graph.PropertyList;
import science.atlarge.graphalytics.domain.graph.PropertyType;

/**
 * Parameters for the execution of the all pairs context-free-language reachability algorithm.
 *
 * @author Vladimir Kutuev
 */
public final class AllPairsReachabilityParameters extends AlgorithmParameters {

	private static final String LABEL_PROPERTY_PROPERTY = "label-property";
	private static final String GRAMMAR_PATH_PROPERTY = "grammar-path";
	private static final String START_SYMBOL_PROPERTY = "start-symbol";

	private final String labelPropertyName;
	private final String grammarPath;
	private final String startSymbol;

	/**
	 * @param labelPropertyName name of the edge property that represents edge label
	 * @param grammarPath       path to file with context-free grammar
	 * @param startSymbol       start non-terminal symbol
	 */
	public AllPairsReachabilityParameters(String labelPropertyName, String grammarPath, String startSymbol) {
		this.labelPropertyName = labelPropertyName;
		this.grammarPath = grammarPath;
		this.startSymbol = startSymbol;
	}

	/**
	 * @return name of the edge property that represents edge label
	 */
	public String getLabelPropertyName() {
		return labelPropertyName;
	}

	/**
	 * @return path to file with context-free grammar
	 */
	public String getGrammarPath() {
		return grammarPath;
	}

	@Override
	public PropertyList getRequiredEdgeProperties() {
		return new PropertyList(new Property(labelPropertyName, PropertyType.STRING));
	}

	public static final class AllPairsParametersParametersFactory implements
			ParameterFactory<AllPairsReachabilityParameters> {

		@Override
		public AllPairsReachabilityParameters fromConfiguration(Configuration configuration)
				throws InvalidConfigurationException {
			return new AllPairsReachabilityParameters(ConfigurationUtil.getString(configuration, LABEL_PROPERTY_PROPERTY),
					ConfigurationUtil.getString(configuration, GRAMMAR_PATH_PROPERTY),
					ConfigurationUtil.getString(configuration, START_SYMBOL_PROPERTY));
		}
	}

	@Override
	public String toString() { return String.format("APR[%s]", getDescription()); }

	@Override
	public String getDescription() { return String.format("prop=%s, grammar=%s, start-symbol=%s", labelPropertyName, grammarPath, startSymbol); }
}
