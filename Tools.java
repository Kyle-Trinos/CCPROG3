/*
	MCO2: MyFarm 
	David, Rain Caitlin Aelis
	Trinos, Marvin Kyle
	S24
*/
package MyFarm;
//Class for the structure and attributes of a Tool
public class Tools {
	
	private String name;
	
	private int costOfUsage;
	
	private double expGain;

	/**
	 * @param name
	 * @param costOfUsage
	 * @param expGain
	 * 
	 * Constructor for the Tools class
	 */
	public Tools(String name, int costOfUsage, double expGain) {
		this.name =name;
		this.costOfUsage = costOfUsage;
		this.expGain = expGain;
	}
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCostOfUsage() {
		return costOfUsage;
	}

	public void setCostOfUsage(int costOfUsage) {
		this.costOfUsage = costOfUsage;
	}

	public double getExpGain() {
		return expGain;
	}

	public void setExpGain(double expGain) {
		this.expGain = expGain;
	}
}
