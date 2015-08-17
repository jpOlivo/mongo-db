package mongo;

public abstract class Mongui {

	MonguiDataConnection connection;
	MonguiCollection actualCollection;
	MonguiDataBase actualDataBase;

	Mongui() throws MonguiException {
		try {
			this.connection = new MonguiDataConnection();
		} catch (Exception e) {
			treatError(e);
		}
	}

	private void treatError(Exception e) throws MonguiException {
		throw new MonguiException("Problem creating Connection to Mongo", e);
	}

	public final Mongui inThisCollection(String collectionName) {
		this.actualCollection = new MonguiCollection(actualDataBase,
				collectionName);
		return this;
	}

	public final Mongui onThisDataBase(String dataBaseName) {
		this.actualDataBase = new MonguiDataBase(connection, dataBaseName);
		return this;
	}

	public abstract Object execute();

	public static Mongui saveThis(MonguiDocument myDocument) {
		return new MonguiSaver(myDocument);
	}

	public static Mongui obtainAll() {
		return new MonguiGetter();
	}

}
