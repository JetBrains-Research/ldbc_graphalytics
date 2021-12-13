package science.atlarge.graphalytics.domain.algorithms;

import org.apache.commons.configuration.Configuration;
import science.atlarge.graphalytics.configuration.ConfigurationUtil;
import science.atlarge.graphalytics.configuration.InvalidConfigurationException;
import science.atlarge.graphalytics.domain.graph.Property;
import science.atlarge.graphalytics.domain.graph.PropertyList;
import science.atlarge.graphalytics.domain.graph.PropertyType;

/**
 * Parameters for the execution of the context-free-language reachability algorithm.
 *
 * @author Vladimir Kutuev
 */
public final class CflReachabilityParameters extends AlgorithmParameters {

	private static final String LABEL_PROPERTY_PROPERTY = "label-property";
	private static final String GRAMMAR_PATH_PROPERTY = "grammar-path";

	private final String labelPropertyName;
	private final String grammarPath;

	/**
	 * @param labelPropertyName name of the edge property that represents edge label
	 * @param grammarPath       path to file with context-free grammar
	 */
	public CflReachabilityParameters(String labelPropertyName, String grammarPath) {
		this.labelPropertyName = labelPropertyName;
		this.grammarPath = grammarPath;
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

	public static final class CflReachabilityParametersParametersFactory implements
			ParameterFactory<CflReachabilityParameters> {

		@Override
		public CflReachabilityParameters fromConfiguration(Configuration configuration)
				throws InvalidConfigurationException {
			return new CflReachabilityParameters(ConfigurationUtil.getString(configuration, LABEL_PROPERTY_PROPERTY),
					ConfigurationUtil.getString(configuration, GRAMMAR_PATH_PROPERTY));
		}
	}

	@Override
	public String toString() { return String.format("CFLR[%s]", getDescription()); }

	@Override
	public String getDescription() { return String.format("prop=%s, grammar=%s", labelPropertyName, grammarPath); }
}
