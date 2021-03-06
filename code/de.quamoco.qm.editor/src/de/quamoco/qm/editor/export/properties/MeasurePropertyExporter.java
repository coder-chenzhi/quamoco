/*-------------------------------------------------------------------------+
|                                                                          |
| Copyright 2012 Technische Universitaet Muenchen and                      |
| Fraunhofer-Institut fuer Experimentelles Software Engineering (IESE)     |
|                                                                          |
| Licensed under the Apache License, Version 2.0 (the "License");          |
| you may not use this file except in compliance with the License.         |
| You may obtain a copy of the License at                                  |
|                                                                          |
|    http://www.apache.org/licenses/LICENSE-2.0                            |
|                                                                          |
| Unless required by applicable law or agreed to in writing, software      |
| distributed under the License is distributed on an "AS IS" BASIS,        |
| WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. |
| See the License for the specific language governing permissions and      |
| limitations under the License.                                           |
|                                                                          |
+-------------------------------------------------------------------------*/

package de.quamoco.qm.editor.export.properties;

import java.io.IOException;
import java.io.PrintStream;

import de.quamoco.qm.Measure;
import de.quamoco.qm.QmPackage;
import de.quamoco.qm.editor.export.WebSiteExporter;
import de.quamoco.qm.editor.export.properties.elements.FeatureMultipleOppositeReference;
import de.quamoco.qm.editor.export.properties.elements.PropElement;

public class MeasurePropertyExporter extends PropertyExporter<Measure> {

	/**
	 * Constructor
	 */
	public MeasurePropertyExporter(WebSiteExporter parent, Measure element,
			String dir) {
		super(parent, element, dir);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void printContent(PrintStream out) throws IOException {
		out.print("<h4>Attributes</h4>");

		printTableOfStructuralElements(
				out,
				new PropElement[] {
						cr(QmPackage.eINSTANCE
								.getQualityModelElement_QualifiedName()),
						cr(QmPackage.eINSTANCE.getNamedElement_Name()),
						cr(QmPackage.eINSTANCE
								.getCharacterizingElement_Characterizes()),
						cr(QmPackage.eINSTANCE.getNamedElement_Title()),
						cr(QmPackage.eINSTANCE
								.getDescribedElement_Description()),
						cr(QmPackage.eINSTANCE.getMeasure_Type()),
						cr(QmPackage.eINSTANCE.getMeasure_QualityModel()) });

		out.print("<h4>Hierarchy</h4>");

		printTableOfStructuralElements(
				out,
				new PropElement[] {
						new FeatureMultipleOppositeReference(
								QmPackage.eINSTANCE.getMeasure_RefinesDirect(),
								"Refined by"),
						cr(QmPackage.eINSTANCE.getMeasure_RefinesDirect()) });

		out.print("<h4>References</h4>");

		printTableOfStructuralElements(
				out,
				new PropElement[] {
						new FeatureMultipleOppositeReference(
								QmPackage.eINSTANCE
										.getMeasurementMethod_Determines(),
								"Determined by"),
						cr(QmPackage.eINSTANCE.getMeasure_MeasuresDirect()) });

		printReferences(out);

	}

}
