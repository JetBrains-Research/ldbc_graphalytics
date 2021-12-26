/*
 * Copyright 2015 - 2017 Atlarge Research Team,
 * operating at Technische Universiteit Delft
 * and Vrije Universiteit Amsterdam, the Netherlands.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
