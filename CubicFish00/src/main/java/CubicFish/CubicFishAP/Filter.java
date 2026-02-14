package classes;

public class Filter {
//Global Variables
	//Liter per h
	private double output = 0;
	private String type = "Innenfilter";
	private double reduction = 0.2;

//Methods
	//output reduction (l/h) thanks to filter medium and other things: 20-50%
	//1-3 times of aquarium volume per hour depending on residents
	//for the prototype we use 2 l/h and 20% reduction
	public void filterCalc(Aquarium aquarium) {
		output = 2 * aquarium.getLiter();
		output = output + (output * reduction);
	}

//get and set
	public double getOutput() {
		return output;
	}

	public String getType() {
		return type;
	}

	public double getReduction() {
		return reduction;
	}
}
