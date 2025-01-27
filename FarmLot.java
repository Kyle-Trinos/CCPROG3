///*
//	MCO2: MyFarm 
//	David, Rain Caitlin Aelis
//	Trinos, Marvin Kyle
//	S24
//*/
//package MyFarm;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class FarmLot {
//	
//	public static final Scanner input = new Scanner(System.in);
//	public static  Player Pstats = new Player();
//	// Global state
//	public static boolean isRunning = true;
//	
//	public static Tile[] Lot = new Tile[50];
//	
//	public static void InitializeTile() {
//		Boolean[] Rocks = new Boolean[50];
//		int i, RockIndex =0, sum = 0;
//		String line, file;
//		var isWrong = true;
//		
//		while(isWrong) {
//			System.out.println("Please input the filename of the farmlot you want to initialize!\n");
//			file = input.next();
//			try {
//				BufferedReader reader = Files.newBufferedReader(Path.of(file+".txt"));
//				while((line = reader.readLine())!= null) {
//					//System.out.println(line);
//					
//					if(Integer.parseInt(line) == 1)
//						Rocks[RockIndex]=true;
//					else
//						Rocks[RockIndex]=false;
//					sum = Integer.parseInt(line)+sum;	
//					RockIndex++;
//				}
//				//System.out.println(sum);
//			} 
//			catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//			if(sum >= 10 && sum <= 30) {
//				for (i =0; i < 50; i++) {
//					Lot[i]= new Tile();
//					//System.out.println(Rocks[i]);
//					Lot[i].setRocky(Rocks[i]);
//					isWrong=false;
//				}
//			}
//			else {
//				System.out.println("\nFile contains insufficient number of rocks!");
//			}
//		}
//	}
//	
//	public static void setToZero(int LotNumber) {
//		Lot[LotNumber].getPlantedCrop().setCropAge(0);
//		Lot[LotNumber].getPlantedCrop().setCurrWater(0);
//		Lot[LotNumber].getPlantedCrop().setCurrFertilizer(0);
//		Lot[LotNumber].setHarvestTotal(0);
//		Lot[LotNumber].setWaterBonus(0);
//		Lot[LotNumber].setFertilizerBonus(0);
//		Lot[LotNumber].setFinalHarvestPrice(0);
//		Lot[LotNumber].setDayOfPlanting(0);	
//		Lot[LotNumber].setPlantedCrop(null);
//		Lot[LotNumber].setPlowed(false);	
//
//		Lot[LotNumber].stats.setTimesWatered(0);
//		Lot[LotNumber].stats.setTimesFertilized(0);
//	}
//	
//	public static final List<Tools> toolsList = new ArrayList<Tools>(Arrays.asList(
//		new Tools("Plow", 0, 0.5),
//		new Tools("Watering Can", 0, 0.5),
//		new Tools("Fertilizer", 10, 4),
//		new Tools("Pickaxe", 50, 15),
//		new Tools("Shovel", 7, 2)));
//			
//	public static final List<FarmerType> farmerList = new ArrayList<FarmerType>(Arrays.asList(
//			new FarmerType("Default Farmer", 0, 0, 0, 0, 0, 0),
//			new FarmerType("Registered Farmer", 5, 1, 1, 0 , 0, 200 ),
//			new FarmerType("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
//			new FarmerType("Legendary Farmer", 15, 4, 3, 2, 1, 400)));
//	
//	public static void main(String[] args){
//		var day = 1;
//		var success = false; 
//		int LotNumber, index, farmerIndex = 1;
//		String cmd, TSelection;
//		Crop seed = null;
//		FarmerType farmer = farmerList.get(0);
//		
//		
//		InitializeTile();
//		
//		while (isRunning){
//			
//			var BackToFarm = true;
//			
//			System.out.println("DAY "+ day);
//			Pstats.setType(farmer.getType());
//			System.out.println(Pstats);	
//			
//			System.out.println("\nCOMMANDS: \n[F] Farm\n[R] Register\n[Q] Quit\n\nDecision: "); 
//			cmd = input.next();	
//			switch(cmd)	{
//				case "R":
//				case "r":
//					if(farmerIndex < 4) {
//						if(Pstats.getFarmerLevel()>=farmerList.get(farmerIndex).getLevelReq()) {
//							if(Pstats.getObjectCoins()>farmerList.get(farmerIndex).getRegistrationFee()) { 
//								System.out.println("Would you like to become a " + farmerList.get(farmerIndex).getType() + "? [Y/N]");
//								var ans = input.next();
//								switch(ans) {
//									case "Y":
//									case "y":
//										farmer = farmerList.get(farmerIndex);
//										System.out.println("\nYou are now a " + farmer.getType() + "!");
//										Pstats.setType(farmer.getType());
//										Pstats.setObjectCoins(-farmer.getRegistrationFee());
//										farmerIndex++;
//										break;
//									case "N":
//									case "n":
//										System.out.println("We recommend to upgrade into a " + farmerList.get(farmerIndex).getType() + " to get bonus perks!");
//										break;
//									default:
//										System.out.println("Unknown command: " + cmd); 
//								
//								}
//							}
//							else {
//								System.out.println("\nYou don't have enough object coins to register as a " + farmerList.get(farmerIndex).getType());
//							}
//						}
//						else {
//							System.out.println("\nYour level is insufficient!");
//						}
//					}
//					else {
//						System.out.println("You have already reached the peak farmer upgrade!");
//					}
//					break;
//			
//				case "F":
//				case "f":
//					System.out.println("\nPick a Lot Number [1-50]");
//					LotNumber = input.nextInt()-1;
//					Tile tile = Lot[LotNumber];
//					System.out.println(tile.isRocky());
//					while (BackToFarm) {
//						
//						if (tile.getPlantedCrop() != null) {
//						System.out.println("\n\nPlanted Crop: " + tile.getPlantedCrop().getName() + 
//			                    "\n[Age: " + tile.getPlantedCrop().getCropAge() + '/' + tile.getPlantedCrop().getHarvestTime() + ']' +
//			                    "\n[Water: " + tile.getPlantedCrop().getCurrWater() + '/' + tile.getPlantedCrop().getMinWater() + ']' + 
//			                    "\n[Fertilizer: " + tile.getPlantedCrop().getCurrFertilizer() + '/' + tile.getPlantedCrop().getMinFertilizer() + ']');
//						}
//						
//						System.out.println("\nCOMMANDS: \n[S] Plant seed\n[T] Tool Selection\n[A] Advance a day\n[H] Harvest\n[R] Return\n\nDecision: "); 
//						cmd = input.next();			
//						
//						switch(cmd) {
//							case "s": // Planting seed
//							case "S": 
//								if (tile.isRocky()==true) {
//									System.out.println("\nYou can't do anything to this tile because it is filled with rocks!");
//								}
//								else {
//									if (tile.getPlantedCrop() == null) {
//										System.out.println("\nWhich crop do you want to plant?"); 	// Ask which crop
//										System.out.println("\nAVAILABLE SEEDS\n ");// Display crop options from seedList
//										for(int i = 0; i < tile.seedList.size(); i++) {
//											switch(i) {
//											case 0:
//												System.out.println("\nROOT CROPS");
//												break;
//												
//											case 3:
//												System.out.println("\nFLOWERS");
//												break;
//												
//											case 6:
//												System.out.println("\nFRUIT TREES");
//												break;
//											}	
//											System.out.println("\n["+ (i+1) + "] " + tile.seedList.get(i).getName() + "\nCost: $" + 
//															  (tile.seedList.get(i).getSeedCost()-farmer.getSeedCostReduction()));
//										}
//									
//									System.out.println("\n\nDecision: ");
//									index = input.nextInt()-1;
//									seed = tile.seedList.get(index);
//									}
//										
//										
//									if (tile.isPlowed() == true) {//check if plown
//											
//										if(tile.getPlantedCrop() == null) {
//												
//											if((seed.getSeedCost()-farmer.getSeedCostReduction())>Pstats.getObjectCoins()) {
//												System.out.println("You don't have enough Object Coins!\n");
//											}
//												
//											else {
//												
//												if(seed.getType() == "Fruit Tree") {
//													var right = Lot[LotNumber + 1].getPlantedCrop();
//													var left = Lot[LotNumber - 1].getPlantedCrop();
//													var topRight = Lot[LotNumber - 9].getPlantedCrop();
//													var topLeft =Lot[LotNumber - 11].getPlantedCrop();
//													var up = Lot[LotNumber - 10].getPlantedCrop();
//													var down = Lot[LotNumber + 10].getPlantedCrop();
//													var bottomLeft = Lot[LotNumber + 9].getPlantedCrop();
//													var bottomRight = Lot[LotNumber + 11].getPlantedCrop();
//													if(LotNumber > 0 && LotNumber < 9) {
//														if( left == null && right == null &&  down == null &&  bottomRight == null && bottomLeft == null) {
//														
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//													}
//													else if (LotNumber > 40 && LotNumber <49) {
//														if(left == null && right == null && up == null && topLeft == null && topRight == null) {
//																	
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//														
//													}
//													else if (LotNumber == 10 || LotNumber == 20 || LotNumber == 30) {
//														if(right == null &&  up == null && down== null && topRight == null && 
//															bottomRight == null) {
//																			
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//																
//													}
//													else if (LotNumber == 19 || LotNumber == 29 || LotNumber == 39) {
//														if(left == null && up == null &&  down == null && topLeft == null && bottomLeft== null) {
//																					
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//													}
//													else if (LotNumber == 0) {
//														if(right == null && down== null && bottomRight == null) {
//															
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//													}
//													else if (LotNumber == 9) {
//														if(left == null && down == null &&  bottomLeft == null) {	
//															
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//													}
//													else if (LotNumber == 40) {
//														if(right== null && up == null && topRight == null) {				
//															
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//													}
//													else if (LotNumber == 49) {
//														if(left == null && up== null && topLeft  == null) {				
//															
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//													}
//													else {
//														if(up == null && down == null && right == null && left == null && 
//															topLeft == null && topRight== null && bottomLeft == null && bottomRight== null ) {
//																					
//															tile.setPlantedCrop(seed); // Plant seed to tile
//															tile.setDayOfPlanting(day);
//															Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//															System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//															success = true;
//														}
//														else {
//															System.out.println("\nYou can't plant a fruit tree here because surrounding tiles have a planted crop!");
//															seed = null;
//															BackToFarm = false;
//														}
//													}
//													
//												}
//												else {
//													
//													tile.setPlantedCrop(seed); // Plant seed to tile
//													tile.setDayOfPlanting(day);
//													Pstats.setObjectCoins(-(tile.getPlantedCrop().getSeedCost()-farmer.getSeedCostReduction()));
//													System.out.println("You planted " + tile.getPlantedCrop().getName() + " to this tile!\n");
//													success = true;
//												}
//											}	
//										}
//											
//										else {
//											System.out.println("The tile is already occupied!\n");
//										}
//									}
//										
//									else {
//										System.out.println("\nTile is not yet plown!\n");
//									}
//										
//									if (success == true) // Update planting stats
//										tile.stats.addTimesPlanted();
//								}
//								success = false;
//								break;
//								
//							case "T":	// Plow tile
//							case "t":
//								
//								System.out.println("\nTools: \n[P] Plow\n[W] Watering Can\n[F] Fertilizer\n[A] Pickaxe\n[S] Shovel\n[R] Return\n\nDecision: "); 
//								TSelection = input.next();	
//									
//								switch(TSelection) {
//									
//									case "P":
//									case "p":
//										if (tile.isRocky()==true) {
//											System.out.println("\nYou can't do anything to this tile because it is filled with rocks!");
//										}
//										else {
//											if(tile.isPlowed()==false) {
//												System.out.println("You plowed the tile!\n");
//												tile.setPlowed(true);
//												Pstats.setFarmerExp(toolsList.get(0).getExpGain());
//												success = true;
//											}
//											else if(tile.getPlantedCrop()!=null){
//												System.out.println("Tile is already occupied!");
//											}
//											else {
//												System.out.println("Tile is already plown!");
//											}
//												
//											if (success == true) // Update plowing stats 
//												tile.stats.addTimesPlowed();
//											success = false;
//										}
//										
//										break;
//									
//									case "W":
//									case "w":
//										if (tile.isRocky()==true) {
//											System.out.println("\nYou can't do anything to this tile because it is filled with rocks!");
//										}
//										else {
//											if(tile.getPlantedCrop()!=null) {
//												System.out.println("Your " + tile.getPlantedCrop().getName() + " has been watered!");
//												tile.getPlantedCrop().setCurrWater(tile.getPlantedCrop().getCurrWater() + 1);
//												Pstats.setFarmerExp(toolsList.get(1).getExpGain());
//												success = true;
//											}
//												
//											else {
//												System.out.println("Plant a crop first!");
//											}
//												// Update watering stats 
//											if (success == true)
//												tile.stats.addTimesWatered();
//											success = false;
//										}
//										
//										break;
//											
//									case "F":
//									case "f":
//										if (tile.isRocky()==true) {
//											System.out.println("\nYou can't do anything to this tile because it is filled with rocks!");
//										}
//										else {
//											if(tile.getPlantedCrop()!=null) {
//												
//												if(toolsList.get(2).getCostOfUsage()>Pstats.getObjectCoins()) {
//													System.out.println("You don't have enough Object Coins!\n");
//												}
//												else {
//													System.out.println("Your " + tile.getPlantedCrop().getName() + " has been fertilized!");
//													tile.getPlantedCrop().setCurrFertilizer(tile.getPlantedCrop().getCurrFertilizer() + 1);
//													Pstats.setFarmerExp(toolsList.get(2).getExpGain());
//													Pstats.setObjectCoins(-toolsList.get(2).getCostOfUsage());
//													success = true;
//												}
//											}
//											else {
//												System.out.println("Plant a crop first!");
//											}
//												// Update watering stats 
//											if (success == true)
//												tile.stats.addTimesFertilized();
//											success = false;
//										}
//										
//										break;
//											
//									case "A":
//									case "a":
//										if(tile.isRocky()==true) {
//											System.out.println("\nRocks from tile " + (LotNumber+1) + " has been removed!");
//											tile.setRocky(false);
//											Pstats.setFarmerExp(toolsList.get(3).getExpGain());
//											Pstats.setObjectCoins(-toolsList.get(3).getCostOfUsage());
//				
//										}
//										else {
//											System.out.println("\nThere are no rocks to clear!");
//										}
//										break;
//											
//									case "S":
//									case "s":
//										if (tile.isRocky()==true) {
//											System.out.println("\nYou can't do anything to this tile because it is filled with rocks!");
//										}
//										else {
//											if(tile.isWithered()==true) {
//												if(toolsList.get(4).getCostOfUsage()>Pstats.getObjectCoins()) {
//													System.out.println("You don't have enough Object Coins!\n");
//												}
//												else {
//													System.out.println("You used a shovel!\n");
//													Pstats.setObjectCoins(-toolsList.get(4).getCostOfUsage());
//													Pstats.setFarmerExp(toolsList.get(4).getExpGain());
//													setToZero(LotNumber);
//													seed = null;
//													tile.setWithered(false);												
//													success = true;
//												}
//											}
//											
//											else if(tile.isWithered()==false){
//												
//												if(toolsList.get(4).getCostOfUsage()>Pstats.getObjectCoins()) {
//													System.out.println("You don't have enough Object Coins!\n");
//												}
//												else {
//													System.out.println("You used a shovel!\n");
//													Pstats.setObjectCoins(-toolsList.get(4).getCostOfUsage());
//													Pstats.setFarmerExp(toolsList.get(4).getExpGain());
//													if(tile.getPlantedCrop()!=null) {
//														setToZero(LotNumber);
//														seed = null;
//													}
//													else
//														System.out.println("You used the shovel on an empty tile!");
//													success = true;
//												}
//											}
//											
//											BackToFarm = false;	
//											success = false;
//										}
//								
//										break;
//										
//									case "R":
//									case "r":
//										
//										break;
//									default:
//										System.out.println("Unknown command: " + cmd); 
//								}
//								
//								break;
//									
//							case "A":
//							case "a":
//									
//								System.out.println("you advanced a day!");
//								day++;
//								System.out.println("Current day is now " + day);
//								for(int i = 0; i <50; i++) {
//									if(Lot[i].getPlantedCrop()!=null) {
//										Lot[i].getPlantedCrop().setCropAge(Lot[i].getPlantedCrop().getCropAge() + 1);
//									}
//								}
//								break;
//									
//							case "H":
//							case "h":
//							
//								if(day >= ( tile.getDayOfPlanting()+ tile.getPlantedCrop().getHarvestTime())){
//																						
//										if (tile.getPlantedCrop().getCurrWater() < tile.getPlantedCrop().getMinWater() ||
//											tile.getPlantedCrop().getCurrFertilizer() < tile.getPlantedCrop().getMinFertilizer() ||  
//											day > ( tile.getDayOfPlanting()+ tile.getPlantedCrop().getHarvestTime())) {
//											
//											if(tile.getPlantedCrop().getCurrWater() < tile.getPlantedCrop().getMinWater()) {
//												System.out.println("\nYour " + tile.getPlantedCrop().getName() + " withered because it does not have enough water!" );
//												tile.setWithered(true);
//											}
//											if(tile.getPlantedCrop().getCurrFertilizer() < tile.getPlantedCrop().getMinFertilizer()) {
//												System.out.println("\nYour " + tile.getPlantedCrop().getName() + " withered because it does not have enough fertilizer!" );
//												tile.setWithered(true);
//											}
//											if(day > (tile.getDayOfPlanting()+ tile.getPlantedCrop().getHarvestTime())) {
//												System.out.println("\nYour " + tile.getPlantedCrop().getName() + " withered due to late harvesting!" );
//												tile.setWithered(true);
//											}
//										}
//																			
//										else {
//											success = true;
//											System.out.println("You harvested your crop!");
//												
//										}
//												
//										if(tile.isWithered() == false) {
//											tile.setYield((int)Math.floor(Math.random()*(tile.getPlantedCrop().getMaxYield()-tile.getPlantedCrop().getMinYield()+1)+
//																						 tile.getPlantedCrop().getMinYield()));
//											
//											System.out.println("\nYour " + tile.getPlantedCrop().getName() + " yielded " + tile.getYield() + "!\n");
//													
//											tile.setHarvestTotal(tile.getYield() * (tile.getPlantedCrop().getBasePrice()+farmer.getBonusEarnings()));
//											
//											if(tile.stats.getTimesWatered()>=(tile.getPlantedCrop().getMaxWater()+farmer.getWaterBonusIncrease())) {
//											
//												tile.setWaterBonus(tile.getHarvestTotal()* 0.2 * (tile.getPlantedCrop().getMaxWater()-1));
//											
//											}
//											
//											else {
//											
//												tile.setWaterBonus(tile.getHarvestTotal()* 0.2 * (tile.stats.getTimesWatered()-1));
//										
//											}
//											
//											if(tile.stats.getTimesFertilized()>=(tile.getPlantedCrop().getMaxFertilizer()+farmer.getFertilizerBonusIncrease())){
//												
//									
//												tile.setFertilizerBonus(tile.getHarvestTotal() * 0.5 * tile.getPlantedCrop().getMaxFertilizer());
//									
//											}
//											else {
//											
//												tile.setFertilizerBonus(tile.getHarvestTotal() * 0.5 * tile.stats.getTimesFertilized());
//											
//											}
//											
//											tile.setFinalHarvestPrice(tile.getHarvestTotal()+tile.getWaterBonus()+tile.getFertilizerBonus());
//										
//											Pstats.setFarmerExp(tile.getPlantedCrop().getExp());
//											
//											if(tile.getPlantedCrop().getType()=="Flower") {
//												System.out.println("Flowers are a premium crop! Your final harvest price will be multiplied by 1.1!");
//												tile.setFinalHarvestPrice(tile.getFinalHarvestPrice()*1.1);
//											}
//													
//											Pstats.setObjectCoins(tile.getFinalHarvestPrice());
//											System.out.println("\nYou earned $" + tile.getFinalHarvestPrice() +"!\n");
//											setToZero(LotNumber);
//											seed = null;
//										}
//										
//											
//										BackToFarm = false;		
//											// Update harvest stats 
//										if (success == true) {
//											tile.stats.addTimesHarvestedSuccessfully();
//										}
//													
//										success = false;
//												
//								}	
//								else {
//									System.out.println("Your crop is not yet harvestable!");
//								}
//									
//								break;	
//									
//						
//							case "R":	
//							case "r":
//								BackToFarm = false;
//								System.out.println("Returning to Farm");
//								break;
//									
//							default:
//								System.out.println("Unknown command: " + cmd); 
//						}
//					Pstats.setFarmerLevel((int)Pstats.getFarmerExp()/100);	
//					System.out.println(Pstats);		
//					System.out.println(tile.stats);
//					
//					}
//					break;
//				case "Q":
//				case "q":
//					System.out.println("\nThank you for playing farmer!");
//					isRunning = false;
//					break;
//				default:
//					System.out.println("Unknown command: " + cmd); 
//			}
//		}
//		input.close();
//	}
//}