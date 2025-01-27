/*
	MCO2: MyFarm 
	David, Rain Caitlin Aelis
	Trinos, Marvin Kyle
	S24
*/
package MyFarm;

//class for updating of status
public class Stats {
	
	private int timesPlanted = 0; 
	private int timesPlowed = 0; 
	private int timesWatered = 0;
	private int timesFertilized = 0; 
	private int timesHarvested = 0; 
	private int timesHarvestedSuccessfully = 0; 
	
	//adding of stats
	
	public int addTimesPlowed() {
		return ++timesPlowed; 
	}
	public int addTimesWatered() {
		return ++timesWatered; 
	}
	public int addTimesFertilized() { 
		return ++timesFertilized; 
	}
	public int addTimesPlanted() { 
		return ++timesPlanted; 
	}
	public int addTimesHarvested() { 
		return ++timesHarvested;
	}
	public int addTimesHarvestedSuccessfully() { 
		return ++timesHarvestedSuccessfully;
	}
	
	
	//getters and setters
	public int getTimesPlowed() {
		return timesPlowed; 
	}
	public void setTimesPlowed(int timesPlowed) { 
		this.timesPlowed = timesPlowed;
	}
	
	public int getTimesWatered() { 
		return timesWatered; 
	}
	public void setTimesWatered(int timesWatered) { 
		this.timesWatered = timesWatered; 
	}
	
	public int getTimesFertilized() { 
		return timesFertilized; 
	}
	public void setTimesFertilized(int timesFertilized) {
		this.timesFertilized = timesFertilized; 
	}
	
	public int getTimesPlanted() { 
		return timesPlanted; 
	}
	public void setTimesPlanted(int timesPlanted) {
		this.timesPlanted = timesPlanted;
	}
	
	public int getTimesHarvested() { 
		return timesHarvested; 
	}
	public void setTimesHarvested(int timesHarvested) { 
		this.timesHarvested = timesHarvested; 
	}
	
	public int getTimesHarvestedSuccessfully() { 
		return timesHarvestedSuccessfully; 
	}
	public void setTimesHarvestedSuccessfully(int timesHarvestedSuccessfully) { 
		this.timesHarvestedSuccessfully = timesHarvestedSuccessfully;
	}
		@Override
	public String toString() {
		return "\n\n[timesPlanted=" + timesPlanted + ", timesPlowed=" + timesPlowed + ", timesWatered=" + timesWatered
				+ ", timesFertilized=" + timesFertilized + ", timesHarvested=" + timesHarvested
				+ ", timesHarvestedSuccessfully=" + timesHarvestedSuccessfully + "]\n\n";
	}
}
