package classes;

public class FreshWaterResident extends Resident{
//Global Variables
	//(S=size)
	private int groupSMin = 0;
	private int groupSMax = 0;

	//compatibility enums and diet
	public enum diet {herbivor, omnivor, karnivor, limnivor}
	public enum nature {peaceful, aggressive, neutral, sensitive, shy}
	public enum behaviour {aktive, calm, normal}

	private diet rDiet = null;
	private diet rDiet2 = null;
	private nature rNature = null;
	private behaviour rBehaviour = null;

//Methods
	@Override
	public boolean check(Aquarium aquarium) {
	//compare with aquarium and set compatibility
		compatible= true;
		if (!aquarium.isDummys()) {
			//wasserwerte
			if (this.cMax != 0) {
				if (aquarium.getCMax()!=0) {
					if (aquarium.getCMin() > this.cMax || aquarium.getCMax() < this.cMin) {
						compatible =false;
					}
				}
			}

			if (this.ghMax != 0) {
				if (aquarium.getGhMax()!=0) {
					if (aquarium.getGhMin() > this.ghMax || aquarium.getGhMax() < this.ghMin) {
						compatible =false;
					}
				}
			}

			if (this.khMax != 0) {
				if (aquarium.getKhMax()!=0) {
					if (aquarium.getKhMin() > this.khMax || aquarium.getKhMax() < this.khMin) {
						compatible =false;
					}
				}
			}

			if (this.phMax != 0) {
				if (aquarium.getPhMax()!=0) {
					if (aquarium.getPhMin() > this.phMax || aquarium.getPhMax() < this.phMin) {
						compatible =false;
					}
				}
			}

			//blackList
			if (aquarium.getBlackList().contains(id)) {
				compatible =false;
			}

			//nature/behaviour
			FreshWaterResident sb;
			for (Resident bewohner : aquarium.getResident()) {
				sb=(FreshWaterResident)bewohner;

				//sensitive residents could die form stress
				if (this.rNature == nature.sensitive && sb.getBehaviour() == behaviour.aktive ||
					this.rBehaviour == behaviour.aktive && sb.getNature() == nature.sensitive) {
					compatible =false;
				}
			}
		}
		return compatible;
	}

//Getter und setter
	public int getGroupSMin() {
		return groupSMin;
	}

	public void setGroupSMin(int groupSMin) {
		this.groupSMin = groupSMin;
	}

	public int getGroupSMax() {
		return groupSMax;
	}

	public void setGroupSMax(int groupSMax) {
		this.groupSMax = groupSMax;
	}

	public diet getDiet() {
		return rDiet;
	}

	public void setDiet(String rDiet) {
		if (rDiet != null) {
			if (rDiet.contains("Karnivor")) {
				this.rDiet = diet.karnivor;
			}

			if (rDiet.contains("Omnivor")) {
				this.rDiet = diet.omnivor;
			}

			if (rDiet.contains("Limnivor")) {
				this.rDiet = diet.limnivor;
			}
		}
	}

	public diet getDiet2() {
		return rDiet2;
	}

	public void setDiet2(String rDiet) {
		if (rDiet != null) {
			if (rDiet.contains("Karnivor")) {
				this.rDiet2 = diet.karnivor;
			}

			if (rDiet.contains("Omnivor")) {
				this.rDiet2 = diet.omnivor;
			}

			if (rDiet.contains("Limnivor")) {
				this.rDiet2 = diet.limnivor;
			}
		}
	}

	public nature getNature() {
		return rNature;
	}

	public void setNature(String rNature) {
		if (rNature != null) {
			if (rNature.equals("aggressiv")) {
				this.rNature = nature.aggressive;
			}

			if (rNature.equals("empfindlich")) {
				this.rNature = nature.sensitive;
			}

			if (rNature.equals("friedlich")) {
				this.rNature = nature.peaceful;
			}

			if (rNature.equals("neutral")) {
				this.rNature = nature.neutral;
			}

			if (rNature.equals("scheu")) {
				this.rNature = nature.shy;
			}
		}
	}

	public behaviour getBehaviour() {
		return rBehaviour;
	}

	public void setBehaviour(String rBehaviour) {
		if (rBehaviour != null) {
			if (rBehaviour.equals("aktiv")) {
				this.rBehaviour = behaviour.aktive;
			}

			if (rBehaviour.equals("normal")) {
				this.rBehaviour = behaviour.normal;
			}

			if (rBehaviour.equals("ruhig")) {
				this.rBehaviour = behaviour.calm;
			}
		}
	}
}
