/*
	MCO2: MyFarm 
	David, Rain Caitlin Aelis
	Trinos, Marvin Kyle
	S24
*/
package MyFarm;
//Class for the structure and attributes of a crop
public class Crop {
	
	private String name, type;
	
	private int minWater, maxWater, currWater; 
	private int minFertilizer, maxFertilizer, currFertilizer;
	
	private int cropAge, harvestTime, minYield, maxYield, seedCost, basePrice; 

	private double exp;
	
	/**
	 * @param name
	 * @param type
	 * @param harvestTime
	 * @param minWater
	 * @param maxWater
	 * @param minFertilizer
	 * @param maxFertilizer
	 * @param minYield
	 * @param maxYield
	 * @param seedCost
	 * @param basePrice
	 * @param exp
	 * 
	 * Constructor for the crop class
	 */
	public Crop(String name, String type, int harvestTime, int minWater, int maxWater, int minFertilizer,
			int maxFertilizer, int minYield, int maxYield, int seedCost, int basePrice, double exp) {
		
		this.name = name; 
		this.type = type;
		this.harvestTime = harvestTime;
		
		this.minWater = minWater;
		this.maxWater = maxWater;
		this.currWater = 0;
		
		this.minFertilizer = minFertilizer;
		this.maxFertilizer = maxFertilizer;
		this.currFertilizer = 0;
				
		this.minYield = minYield; 
		this.maxYield = maxYield; 
		
		this.seedCost = seedCost;
		this.basePrice = basePrice;
		this.exp = exp;
	}
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMinWater() {
		return minWater;
	}

	public void setMinWater(int minWater) {
		this.minWater = minWater;
	}

	public int getMaxWater() {
		return maxWater;
	}

	public void setMaxWater(int maxWater) {
		this.maxWater = maxWater;
	}

	public int getCurrWater() {
		return currWater;
	}

	public void setCurrWater(int currWater) {
		this.currWater = currWater;
	}

	public int getMinFertilizer() {
		return minFertilizer;
	}

	public void setMinFertilizer(int minFertilizer) {
		this.minFertilizer = minFertilizer;
	}

	public int getMaxFertilizer() {
		return maxFertilizer;
	}

	public void setMaxFertilizer(int maxFertilizer) {
		this.maxFertilizer = maxFertilizer;
	}

	public int getCurrFertilizer() {
		return currFertilizer;
	}

	public void setCurrFertilizer(int currFertilizer) {
		this.currFertilizer = currFertilizer;
	}

	public int getHarvestTime() {
		return harvestTime;
	}

	public void setHarvestTime(int harvestTime) {
		this.harvestTime = harvestTime;
	}

	public int getMinYield() {
		return minYield;
	}

	public void setMinYield(int minYield) {
		this.minYield = minYield;
	}

	public int getMaxYield() {
		return maxYield;
	}

	public void setMaxYield(int maxYield) {
		this.maxYield = maxYield;
	}
	public int getCropAge() {
		return cropAge;
	}

	public void setCropAge(int cropAge) {
		this.cropAge = cropAge;
	}
	public int getSeedCost() {
		return seedCost;
	}

	public void setSeedCost(int seedCost) {
		this.seedCost = seedCost;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}
}
