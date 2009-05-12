package fitlibrary;

import fitlibrary.traverse.workflow.BddDoTraverse;

public class BddDoFixture extends DoFixture {
	public BddDoFixture() {
		setTraverse(new BddDoTraverse(this));
	}
}
