/*
	MCO2: MyFarm 
	David, Rain Caitlin Aelis
	Trinos, Marvin Kyle
	S24
*/
package MyFarm;
//Class for the stats of the player
public class Player {
    private String type;
    private double objectCoins = 500;
    private int farmerLevel = 0, noOfDays = 1;
    private double farmerExp = 0;

    //updates the farmer level
    public int addFarmerLevel() {
        return ++farmerLevel;
    }

    //gets the no of days
    public int getNoOfDays() {
        return noOfDays;
    }
    
    //updates the number of days
    public int advanceDay() {
        return noOfDays++;
    }

    //getters and setters
    public double computeCoins(int i) {
        this.objectCoins = objectCoins - i;
        return objectCoins;
    }
    
    public double getObjectCoins() {
        return objectCoins;
    }
    public void setObjectCoins(double objectCoins) {
        this.objectCoins = this.objectCoins + objectCoins;
    }
    public int getFarmerLevel() {
        return farmerLevel;
    }
    public void setFarmerLevel(int farmerLevel) {
        this.farmerLevel = farmerLevel;
    }
    public double getFarmerExp() {
        return farmerExp;
    }
    public void setFarmerExp(double farmerExp) {
        this.farmerExp = this.farmerExp + farmerExp;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "\n\n[" + type + ": Exp =" + farmerExp + ", Farmer Level =" + farmerLevel + ", Object Coins=" + objectCoins + "]\n\n";
    }

}