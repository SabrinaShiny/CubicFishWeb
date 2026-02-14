package classes;

public class Ground {
//Global Variables
	private double liter = 0;
	private double height = 4;
	private String type = "Kies";

//Methods
	public void groundCalc(Aquarium aquarium) {
		//calculation for liter
		liter =(aquarium.getAWidth()*aquarium.getADepth()*height)/1000;
	}

//get and set
	public double getLiter() {
		return liter;
	}

	public double getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}
}
