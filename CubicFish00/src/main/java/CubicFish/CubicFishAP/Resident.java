package classes;

import java.util.ArrayList;

public abstract class Resident {

//Global Variables
	//resident data (s=scientific, a=aquarium)
	protected boolean compatible = true;
	protected int id = 0;
	protected String name = "";
	protected String sName = "";
	protected String origin = "";
	protected String age = "";
	protected String info = "";
	protected String group = "";

	//needed aquarium size (aWidth and aHeight in cm)
	protected double liter = 0;
	protected double aWidth = 0;
	protected double aHeight = 0;

	//water data (c = Celsius)
	protected double cMin = 0;
	protected double cMax = 0;
	protected double ghMin = 0;
	protected double ghMax = 0;
	protected double khMin = 0;
	protected double khMax = 0;
	protected double phMin = 0;
	protected double phMax = 0;

	//compatibility data
	public enum region {bottom, middle, top, allOver}

	protected double sizeMin = 0;
	protected double sizeMax = 0;
	protected region aRegion = null;
	protected ArrayList<Integer> blackList= new ArrayList<>();

//Methods
	public abstract boolean check(Aquarium aquarium);

//Get and set
	public boolean isCompatible() {
		return compatible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public ArrayList<Integer> getBlackList() {
		return blackList;
	}

	public void setBlackList(ArrayList<Integer> blackList) {
		this.blackList = blackList;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		if (info != null) {
			this.info = info;
		}
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public double getSizeMin() {
		return sizeMin;
	}

	public void setSizeMin(double sizeMin) {
		this.sizeMin = sizeMin;
	}

	public double getSizeMax() {
		return sizeMax;
	}

	public void setSizeMax(double sizeMax) {
		this.sizeMax = sizeMax;
	}

	public region getARegion() {
		return aRegion;
	}

	public void setARegion(String aRegion) {
		if (aRegion != null) {
			if (aRegion.equals("Oben")) {
				this.aRegion = region.top;
			}
			if (aRegion.equals("Mitte")) {
				this.aRegion = region.middle;
			}
			if (aRegion.equals("Unten")) {
				this.aRegion = region.bottom;
			}
			if (aRegion.equals("�berall")) {
				this.aRegion = region.allOver;
			}
		}
	}
}
