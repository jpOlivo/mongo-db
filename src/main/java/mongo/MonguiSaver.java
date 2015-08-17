package mongo;

public class MonguiSaver extends Mongui {

	private MonguiDocument actualDocument;
	
	MonguiSaver(MonguiDocument actualDocument) {
		super();
		this.actualDocument = actualDocument;
	}
	
	@Override
	public Object execute() {
		actualCollection.saveDocument(actualDocument);
		return null;
	}

}