package classes;

public class Heater {
//Global Variables
	private double watt = 0;
	private String type = "Heizstab";
	private double reduction = 0.5;
//Methoden
	//0.5-1 watt per Liter
	public void wattCalc(Aquarium aquarium) {
		watt= aquarium.getLiter()*reduction;
	}

//get and set
	public double getWatt() {
		return watt;
	}

	public String getType() {
		return type;
	}
}
