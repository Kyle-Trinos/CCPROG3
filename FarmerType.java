/*
	MCO2: MyFarm 
	David, Rain Caitlin Aelis
	Trinos, Marvin Kyle
	S24
*/
package MyFarm;
//Class for the structure and attributes of a farmer type
public class FarmerType {
	private String type;
	private int LevelReq, BonusEarnings, SeedCostReduction, WaterBonusIncrease, FertilizerBonusIncrease, RegistrationFee;

	
	/**
	 * @param type
	 * @param LevelReq
	 * @param BonusEarnings
	 * @param SeedCostReduction
	 * @param WaterBonusIncrease
	 * @param FertilizerBonusIncrease
	 * @param RegistrationFee
	 * 
	 * Constructor for the FarmerType class
	 */
	public FarmerType(String type,int LevelReq,int BonusEarnings, int SeedCostReduction, int WaterBonusIncrease, int FertilizerBonusIncrease, int RegistrationFee) {
		this.type = type;
		this.LevelReq = LevelReq;
		this.BonusEarnings = BonusEarnings;
		this.SeedCostReduction = SeedCostReduction;
		this.WaterBonusIncrease = WaterBonusIncrease;
		this.FertilizerBonusIncrease = FertilizerBonusIncrease;
		this.RegistrationFee = RegistrationFee;
	}
	//getters and setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLevelReq() {
		return LevelReq;
	}
	public void setLevelReq(int levelReq) {
		LevelReq = levelReq;
	}
	public int getBonusEarnings() {
		return BonusEarnings;
	}

	public void setBonusEarnings(int bonusEarnings) {
		BonusEarnings = bonusEarnings;
	}

	public int getSeedCostReduction() {
		return SeedCostReduction;
	}

	public void setSeedCostReduction(int seedCostReduction) {
		SeedCostReduction = seedCostReduction;
	}

	public int getWaterBonusIncrease() {
		return WaterBonusIncrease;
	}

	public void setWaterBonusIncrease(int waterBonusIncrease) {
		WaterBonusIncrease = waterBonusIncrease;
	}

	public int getFertilizerBonusIncrease() {
		return FertilizerBonusIncrease;
	}

	public void setFertilizerBonusIncrease(int fertilizerBonusIncrease) {
		FertilizerBonusIncrease = fertilizerBonusIncrease;
	}

	public int getRegistrationFee() {
		return RegistrationFee;
	}

	public void setRegistrationFee(int registrationFee) {
		RegistrationFee = registrationFee;
	}
}
