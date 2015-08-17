package mongo;

public class MonguiGetter extends Mongui {
	
	MonguiGetter() throws MonguiException {
		super();		
	}
 
	@Override
	public Object execute() {
		return actualCollection.getAll();		
	}
 
}