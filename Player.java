package alex.andrew.monoplyproject;

public class Player {
	
	public String name;
	
	public String piece;
	
	public int money;
	
	public int location;
	
	public alex.andrew.monoplyproject.Owner owner;
	
	public enum player {
		P1, P2, P3, P4, P5, P6, P7, P8
	}
	
	public player player;
	
	public enum Owner {
		P1, P2, P3, P4, P5, P6, P7, P8
	}
	
}