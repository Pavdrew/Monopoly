package alex.andrew.monoplyproject;

public class Owner {

public Player[] ownedBy;
	
	@Override
	public String toString() {
		if(ownedBy ==null) {
			return "              ";
		}
		return ownedBy.toString();
	}
}
