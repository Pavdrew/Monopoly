package alex.andrew.monoplyproject;

public class Square {
	
	public Player[] occupiedBy;
		
	@Override
	public String toString() {
		if(occupiedBy == null) {
			return "              ";
		} 
		return occupiedBy.toString();
}
}
