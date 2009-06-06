package fitlibrary.traverse.workflow;

import fitlibrary.table.Row;
import fitlibrary.utility.TestResults;

public class BddDoTraverse extends DoTraverse {
	private static final String[] BDD_WORDS = new String[] { "given", "when", "then", "and" };

	public BddDoTraverse(Object sut) {
		super(sut);
	}

	@Override
	public Object interpretRow(Row row, TestResults testResults) {
		return super.interpretRow(ignoreBddWords(row, testResults), testResults);
	}

	private Row ignoreBddWords(Row row, TestResults testResults) {
		String firstCellText = row.cell(0).text();

		for (String word : BDD_WORDS) {
			if (word.equalsIgnoreCase(firstCellText)) {
				row.cell(0).ignore(testResults);
				return row.rowFrom(1);
			}
		}

		return row;
	}
}
