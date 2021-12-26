package science.atlarge.graphalytics.validation.rule;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

/**
 * Validation rule which checks if two sets of vertices are identical.
 *
 * @author Vladimir Kutuev
 */
public class VertexSetValidationRule implements ValidationRule<LongSet> {

	@Override
	public LongSet parse(String val) throws Throwable {
		String[] verticesStr = val.split("\\s+");
		LongSet result = new LongOpenHashSet(verticesStr.length);
		for (String vertex: verticesStr) {
			result.add(Long.parseLong(vertex));
		}
		return result;
	}

	@Override
	public boolean match(LongSet lhs, LongSet rhs) { return lhs != null && rhs != null && lhs.equals(rhs); }
}
