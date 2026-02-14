package classes;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		//add constructors to factory
		ObjectFactory[] factory = new ObjectFactory[1];
		FreshWaterConstructor freshWaterConstructor = new FreshWaterConstructor();
		factory[0]=freshWaterConstructor;

		//call all builders and put residents to one list
		ArrayList<Resident> residentList = new ArrayList<>();
		for (ObjectFactory construktor : factory) {
			for (Resident resident2 : construktor.builder()) {
				residentList.add(resident2);
			}
		}

		//convert ArrayList to Array
		Resident[] resident= new Resident[residentList.size()];
		residentList.toArray(resident);

		Gui fensterAufrufGui = new Gui(resident);
	}
}
