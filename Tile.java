/*
	MCO2: MyFarm 
	David, Rain Caitlin Aelis
	Trinos, Marvin Kyle
	S24
*/
package MyFarm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Class for the structure and attributes of a single Tile
public class Tile {
	
	public  Stats stats = new Stats();
	//array list of the crops
	public List<Crop> seedList = new ArrayList<Crop>(Arrays.asList(
			new Crop("Turnip", "Root Crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 500),
			new Crop("Carrot", "Root Crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5),
			new Crop("Potato", "Root Crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5),
			new Crop("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5),
			new Crop("Tulip", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5),
			new Crop("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5),
			new Crop("Mango", "Fruit Tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25),
			new Crop("Apple", "Fruit Tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25)));
	
	private int dayOfPlanting, Yield, harvestTotal;
	private double waterBonus, fertilizerBonus, finalHarvestPrice;
	
	private boolean isWithered = false;
	private boolean isRocky;
	

	private boolean isPlowed = false;
	private Crop plantedCrop = null;
	
	//getters and setters
	public boolean isRocky() {
		return isRocky;
	}

	public void setRocky(boolean isRocky) {
		this.isRocky = isRocky;
	}
	public boolean isWithered() {
		return isWithered;
	}

	public void setWithered(boolean isWithered) {
		this.isWithered = isWithered;
	}
	
	public boolean isPlowed() {
		return isPlowed;
	}

	public void setPlowed(boolean isPlowed) {
		this.isPlowed = isPlowed;
	}

	Crop getPlantedCrop() {
		return plantedCrop;
	}

	public void setPlantedCrop(Crop plantedCrop) {
		this.plantedCrop = plantedCrop;
	}
	
	public int getDayOfPlanting() {
		return dayOfPlanting;
	}

	public void setDayOfPlanting(int dayOfPlanting) {
		this.dayOfPlanting = dayOfPlanting;
	}
	
	public int getYield() {
		return Yield;
	}

	public void setYield(int yield) {
		Yield = yield;
	}
	public int getHarvestTotal() {
		return harvestTotal;
	}

	public void setHarvestTotal(int harvestTotal) {
		this.harvestTotal = harvestTotal;
	}

	public double getWaterBonus() {
		return waterBonus;
	}

	public void setWaterBonus(double waterBonus) {
		this.waterBonus = waterBonus;
	}

	public double getFertilizerBonus() {
		return fertilizerBonus;
	}

	public void setFertilizerBonus(double fertilizerBonus) {
		this.fertilizerBonus = fertilizerBonus;
	}

	public double getFinalHarvestPrice() {
		return finalHarvestPrice;
	}

	public void setFinalHarvestPrice(double finalHarvestPrice) {
		this.finalHarvestPrice = finalHarvestPrice;
	}

}
