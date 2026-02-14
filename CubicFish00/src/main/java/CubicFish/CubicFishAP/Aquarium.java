package classes;
import java.util.ArrayList;

public class Aquarium {
//Global Variables
	//aquarium size (a=aquarium)
	private double liter = 0;
	private double aWidth = 0;
	private double aHeight = 0;
	private double aDepth = 0;

	//water data (c=celsius)
	private double cMin = 0;
	private double cMax = 0;
	private double ghMin = 0;
	private double ghMax = 0;
	private double khMin = 0;
	private double khMax = 0;
	private double phMin = 0;
	private double phMax = 0;

	//variable to keep track of dummy data
	private boolean dummys = true;

	//lists, blackList lists incompatible residents
	//such as too small (will get eaten) or other exceptions
	private ArrayList<Resident> residents = new ArrayList<>();
	private ArrayList<Integer> blackList = new ArrayList<>();

	//components
	private Filter filter = new Filter();
	private Ground ground = new Ground();
	private Heater heater = new Heater();


//Methods
	public void aquariumCalc() {
		//reset data
		this.aDepth = 0;
		this.liter = 0;
		this.aWidth = 0;
		this.aHeight = 0;
		this.cMin = 0;
		this.cMax = 0;
		this.ghMin = 0;
		this.ghMax = 0;
		this.khMin = 0;
		this.khMax = 0;
		this.phMin = 0;
		this.phMax = 0;
		dummys = true;

		//add data of first resident
		if (residents.size() > 0) {
			this.liter = residents.get(0).getLiter();
			this.aWidth = residents.get(0).getAWidth();
			this.aHeight = residents.get(0).getAHeight();
			this.cMin = residents.get(0).getCMin();
			this.cMax = residents.get(0).getCMax();
			this.ghMin = residents.get(0).getGhMin();
			this.ghMax = residents.get(0).getGhMax();
			this.khMin = residents.get(0).getKhMin();
			this.khMax = residents.get(0).getKhMax();
			this.phMin = residents.get(0).getPhMin();
			this.phMax = residents.get(0).getPhMax();
			dummys = false;
		}

		//add data of all other residents
		for (Resident residents2 : residents) {
		//aquarium size
			if (residents2.getLiter()>this.liter) {
				this.liter = residents2.getLiter();
			}

			if (residents2.getAWidth()>this.aWidth) {
				this.aWidth = residents2.getAWidth();
			}

			if (residents2.getAHeight()>this.aHeight) {
				this.aHeight = residents2.getAHeight();
			}

		//water data
			//celcius
			if (residents2.getCMin()>this.cMin) {
				this.cMin= residents2.getCMin();
			}

			if (residents2.getCMax()<this.cMax) {
				this.cMax= residents2.getCMax();
			}

			if (this.cMax==0) {
				this.cMax= residents2.getCMax();
			}

			//gh
			if (residents2.getGhMin()>this.ghMin) {
				this.ghMin= residents2.getGhMin();
			}

			if (residents2.getGhMax()<this.ghMax) {
				this.ghMax= residents2.getGhMax();
			}

			if (this.ghMax==0) {
				this.ghMax= residents2.getGhMax();
			}

			//kh
			if (residents2.getKhMin()>this.khMin) {
				this.khMin= residents2.getKhMin();
			}

			if (residents2.getKhMax()<this.khMax) {
				this.khMax= residents2.getKhMax();
			}

			if (this.khMax==0) {
				this.khMax= residents2.getKhMax();
			}

			//ph
			if (residents2.getPhMin()>this.phMin) {
				this.phMin= residents2.getPhMin();
			}

			if (residents2.getPhMax()<this.phMax) {
				this.phMax= residents2.getPhMax();
			}

			if (this.phMax==0) {
				this.phMax= residents2.getPhMax();
			}
		}

	//using cubic root to calculate default data
		//our default aquarium is a cube
		if (this.aWidth == 0) {
			this.aWidth= Math.cbrt(this.liter*1000);

		}

		if (this.aHeight == 0) {
			this.aHeight= Math.cbrt(this.liter*1000);
		}

		//calculating depth
		aDepth= (this.liter*1000)/(aHeight*aWidth);

		if (this.aHeight == 0 && this.aWidth == 0) {
			aDepth= 0;
		}

		//use component calculators
		filter.filterCalc(this);
		ground.groundCalc(this);
		heater.wattCalc(this);
	}

//Get and set
		public boolean isDummys() {
			return dummys;
		}

		public ArrayList<Resident> getResident() {
			return residents;
		}

		public double getLiter() {
			return liter;
		}

		public void setLiter(double liter) {
			this.liter = liter;
		}

		public double getAWidth() {
			return aWidth;
		}

		public void setAWidth(double aWidth) {
			this.aWidth = aWidth;
		}

		public double getAHeight() {
			return aHeight;
		}

		public void setAHeight(double aHeight) {
			this.aHeight = aHeight;
		}

		public double getADepth() {
			return aDepth;
		}

		public double getCMin() {
			return cMin;
		}

		public void setCMin(double cMin) {
			this.cMin = cMin;
		}

		public double getCMax() {
			return cMax;
		}

		public void setCMax(double cMax) {
			this.cMax = cMax;
		}

		public double getGhMin() {
			return ghMin;
		}

		public void setGhMin(double ghMin) {
			this.ghMin = ghMin;
		}

		public double getGhMax() {
			return ghMax;
		}

		public void setGhMax(double ghMax) {
			this.ghMax = ghMax;
		}

		public double getKhMin() {
			return khMin;
		}

		public void setKhMin(double khMin) {
			this.khMin = khMin;
		}

		public double getKhMax() {
			return khMax;
		}

		public void setKhMax(double khMax) {
			this.khMax = khMax;
		}

		public double getPhMin() {
			return phMin;
		}

		public void setPhMin(double phMin) {
			this.phMin = phMin;
		}

		public double getPhMax() {
			return phMax;
		}

		public void setPhMax(double phMax) {
			this.phMax = phMax;
		}

		public Filter getFilter() {
			return filter;
		}

		public Ground getGround() {
			return ground;
		}

		public Heater getHeater() {
			return heater;
		}

		public void addResident(Resident resident) {
			for (Resident resident2 : this.residents) {
				if (resident2.id == resident.getId()) {
					return;
				}
			}
			this.residents.add(resident);

			//update aquarium and blackList
			buildBlackList();
			aquariumCalc();
		}

		public void removeResident(Resident resident) {
			ArrayList<Resident> remove = new ArrayList<>();
			for (Resident resident2 : this.residents) {
			   if (resident2.getId() == resident.getId()) {
				   remove.add(resident2);
			   }
			}

			this.residents.removeAll(remove);

			//update aquarium and blackList
			buildBlackList();
			aquariumCalc();
		}

		public void buildBlackList() {
			//check if the number already exists and add if not
			getBlackList().clear();
			for (Resident resident2 : residents) {
				for (int id : resident2.getBlackList()) {
					if (!getBlackList().contains(id)) {
						this.getBlackList().add(id);
					}
				}
			}
		}

		public ArrayList<Integer> getBlackList() {
			return blackList;
		}
}
