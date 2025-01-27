package MyFarm;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Gui for the view
public class FarmView implements ActionListener{
	
	public  Stats stats = new Stats();
    public static Player player = new Player();
    public static JButton[] tile = new JButton[50];
    public static int tileNumber;
    public int num, farmerIndex=1;
    public static JFrame frame = new JFrame();
    private JPanel FarmLot = new JPanel();
    private JPanel StatsPanel = new JPanel();
    private JPanel CmdPanel = new JPanel();
    private JButton[] tools = new JButton[5];

    private JButton[] cmd = new JButton[4];
    private JButton farmerBtn = new JButton();
    private JTextPane txt = new JTextPane();
    private SelectSeeds selectSeeds;
    public static JLabel title, cmdLb, toolLb, farmerLb, days, exp, level, coins;
    public static Tile tileInfo[] = new Tile[50];
    private int noOfDays;

    private Crop empty = new Crop("No Crop", "Null", 0,0,0,
            0, 0,0,0,0,0,0);

    public List<Crop> seedList = new ArrayList<Crop>(Arrays.asList(
            new Crop("Turnip", "Root Crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5),
            new Crop("Carrot", "Root Crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5),
            new Crop("Potato", "Root Crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5),
            new Crop("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5),
            new Crop("Tulip", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5),
            new Crop("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5),
            new Crop("Mango", "Fruit Tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25),
            new Crop("Apple", "Fruit Tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25)));

    public static final List<Tools> toolsList = new ArrayList<Tools>(Arrays.asList(
            new Tools("Plow", 0, 0.5),
            new Tools("Watering Can", 0, 0.5),
            new Tools("Fertilizer", 10, 4),
            new Tools("Pickaxe", 50, 15),
            new Tools("Shovel", 7, 2)));
    private static int[] toolCost = {0, 0, 10, 50, 7};

    public static final List<FarmerType> farmerList = new ArrayList<FarmerType>(Arrays.asList(
            new FarmerType("Default Farmer", 0, 0, 0, 0, 0, 0),
            new FarmerType("Registered Farmer", 5, 1, 1, 0 , 0, 200 ),
            new FarmerType("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
            new FarmerType("Legendary Farmer", 15, 4, 3, 2, 1, 400)));
//setting every variable to 0 or null
    public static void setToZero(int LotNumber, Crop x) {
        tileInfo[LotNumber].getPlantedCrop().setCropAge(0);
        tileInfo[LotNumber].getPlantedCrop().setCurrWater(0);
        tileInfo[LotNumber].getPlantedCrop().setCurrFertilizer(0);
        tileInfo[LotNumber].setHarvestTotal(0);
        tileInfo[LotNumber].setWaterBonus(0);
        tileInfo[LotNumber].setFertilizerBonus(0);
        tileInfo[LotNumber].setFinalHarvestPrice(0);
        tileInfo[LotNumber].setDayOfPlanting(0);
        tileInfo[LotNumber].setPlantedCrop(x);
        tileInfo[LotNumber].setPlowed(false);

        tileInfo[LotNumber].stats.setTimesWatered(0);
        tileInfo[LotNumber].stats.setTimesFertilized(0);
    }


//initializes the farm
    public FarmView() {
        for(int i=0; i<50; i++) {
            tileInfo[i] = new Tile();
        }
        display();
    }
//gui for the farm lot
    public void display() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 650);
        frame.getContentPane().setBackground(new Color(96,93,81));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        FarmLot.setLayout(new GridLayout(5,10));
        FarmLot.setBounds(15,100, 1000,500);
        FarmLot.setBackground(new Color(50,62,13));

        StatsPanel.setLayout(new GridLayout(5,10));
        StatsPanel.setBounds(100,1000, 400,250);
        StatsPanel.setBackground(new Color(255,248,220));

        CmdPanel.setLayout(new GridLayout(5,1));
        CmdPanel.setBounds(1000,0, 250,350);
        CmdPanel.setBackground(new Color(255,248,220));

        initializeFarm();
        tiles();
        cmdButtons();
        toolButtons();
        farmerButton();
        farmInfo();

        frame.add(FarmLot);
        frame.add(StatsPanel);
        frame.add(CmdPanel);
    }
//gui for the tiles
    public void tiles() {
        for(int i=0; i<50; i++) {
            String s = Integer.toString(i);
            tile[i] = new JButton();
            tile[i].setText("Unplowed");
            tile[i].setSize(100,100);
            FarmLot.add(tile[i]);
            tile[i].setFocusable(false);
            tile[i].setActionCommand(s);
            tile[i].addActionListener(this);
        }
    }
//buttons for the commands
    public void cmdButtons() {
        cmdLb = new JLabel();
        cmdLb.setText("Commands:");
        cmdLb.setBounds(1120,40, 150,55);
        frame.add(cmdLb);

;        for(int j=0; j<4; j++) {
            String s = Integer.toString(j+50);
            cmd[j] = new JButton();
            cmd[j].setBounds(1075,100 + (j *40),160,30);
            frame.add(cmd[j]);
            cmd[j].setActionCommand(s);
            cmd[j].setFocusable(false);
            cmd[j].addActionListener(this);
        }

        cmd[0].setText("Plant Seed");
        cmd[1].setText("Advance A Day");
        cmd[2].setText("Harvest");
        cmd[3].setText("Exit");
    }
//buttons for the tools
    public void toolButtons() {
        toolLb = new JLabel();
        toolLb.setText("Tools:");
        toolLb.setBounds(1130,250, 150,55);
        frame.add(toolLb);

        for(int j=0; j<5; j++) {
            String s = Integer.toString(j+54);
            tools[j] = new JButton();
            tools[j].setText(toolsList.get(j).getName());
            tools[j].setBounds(1075,300 + (j *40),160,30);
            frame.add(tools[j]);
            tools[j].setActionCommand(s);
            tools[j].setFocusable(false);
            tools[j].addActionListener(this);
        }
    }
 //buttons for the farmers
    public void farmerButton() {
        farmerLb = new JLabel();
        farmerLb.setText("Register Farmer:");
        farmerLb.setBounds(1110,495, 150,55);
        frame.add(farmerLb);

        farmerBtn = new JButton();
        farmerBtn.setText("Upgrade Farmer");
        farmerBtn.setBounds(1075,550,160,30);
        frame.add(farmerBtn);
        farmerBtn.setActionCommand("59");
        farmerBtn.setFocusable(false);
        farmerBtn.addActionListener(this);
    }
 //information about the farm
    public static void farmInfo() {
        title = new JLabel();
        title.setText("Farm Information:");
        title.setBounds(100, 40, 150, 55);
        frame.add(title);

        days = new JLabel();
        days.setText("Day: " + player.getNoOfDays());
        days.setBounds(300, 40, 150, 55);
        frame.add(days);

        coins = new JLabel();
        coins.setText("Coins: " + player.getObjectCoins());
        coins.setBounds(500, 40, 150, 55);
        frame.add(coins);

        level = new JLabel();
        level.setText("Level: " + player.getFarmerLevel());
        level.setBounds(700, 40, 150, 55);
        frame.add(level);

        exp = new JLabel();
        exp.setText("Exp: " + player.getFarmerExp());
        exp.setBounds(900, 40, 150, 55);
        frame.add(exp);

    }
    //initialize the farm
    public void initializeFarm(){
        for(int i=0; i<50; i++) {
            tileInfo[i].setPlantedCrop(empty);
        }
    }
//update the info
    public static void updateInfo() {
    	player.setFarmerLevel((int)player.getFarmerExp()/100);
        days.setText("Day: " + player.getNoOfDays());
        coins.setText("Coins: " + player.getObjectCoins());
        level.setText("Level: " + player.getFarmerLevel());
        exp.setText("Exp: " + player.getFarmerExp());
    }

    private void pause() {
        Window w = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
        if (w.isActive() == true) {
            frame.setEnabled(false);
        }
    }

    private void reset() {
        for (int i = 0; i < tools.length; i++) {
            tools[i].setEnabled(true);
        }
    }
    //upgrades the farmer
    private void upgradeFarmer(){
        FarmerType farmer = farmerList.get(0);
        player.setType(farmer.getType());
        if(farmerIndex < 4) {
            if(FarmView.player.getFarmerLevel()>=FarmView.farmerList.get(farmerIndex).getLevelReq()) {
                if(FarmView.player.getObjectCoins()>FarmView.farmerList.get(farmerIndex).getRegistrationFee()) {
                    if (JOptionPane.showConfirmDialog(frame, "Would you like to become a " + FarmView.farmerList.get(farmerIndex).getType() + "?", "Upgrade Farmer",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        farmer = FarmView.farmerList.get(farmerIndex);
                        JOptionPane.showMessageDialog(frame, "You are now a " + FarmView.farmerList.get(farmerIndex).getType() + "!");
                        FarmView.player.setType(farmer.getType());
                        FarmView.player.setObjectCoins(-farmer.getRegistrationFee());
                        updateInfo();
                        farmerIndex++;
                    } else if (JOptionPane.showConfirmDialog(frame, "Would you like to become a " + FarmView.farmerList.get(farmerIndex).getType() + "?", "Upgrade Farmer",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(frame, "We recommend to upgrade into a " + FarmView.farmerList.get(farmerIndex).getType() + " to get bonus perks!");
                    }

                } else {
                    JOptionPane.showMessageDialog(frame, "\nYou don't have enough object coins to register as a " + FarmView.farmerList.get(farmerIndex).getType());
                }
            } else {
                JOptionPane.showMessageDialog(frame, "\nYour level is insufficient!");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "You have already reached the peak farmer upgrade!");
        }
    }
    //advancing a day
    private void advanceADay(){
        player.advanceDay();
        JOptionPane.showMessageDialog(frame, "You advanced a day.\n Current day is now " + player.getNoOfDays());
        for(int i = 0; i <50; i++) {
            if(tileInfo[i].getPlantedCrop().getName()!=null) {
                tileInfo[i].getPlantedCrop().setCropAge(tileInfo[i].getPlantedCrop().getCropAge() + 1);
            }
        }
        days.setText("Day: " + player.getNoOfDays());
       // cmd[1].setEnabled(true);
        updateCropInfo();
    }
//harvesting
    private void harvest() {
        int day = player.getNoOfDays();
        if (day >= (tileInfo[tileNumber].getDayOfPlanting() + tileInfo[tileNumber].getPlantedCrop().getHarvestTime())) {

            if (tileInfo[tileNumber].getPlantedCrop().getCurrWater() < tileInfo[tileNumber].getPlantedCrop().getMinWater() || tileInfo[tileNumber].getPlantedCrop().getCurrFertilizer() < tileInfo[tileNumber].getPlantedCrop().getMinFertilizer() || day > (tileInfo[tileNumber].getDayOfPlanting() + tileInfo[tileNumber].getPlantedCrop().getHarvestTime())) {
                if (tileInfo[tileNumber].getPlantedCrop().getCurrWater() < tileInfo[tileNumber].getPlantedCrop().getMinWater()) {
                    JOptionPane.showMessageDialog(frame, "Your " + tileInfo[tileNumber].getPlantedCrop().getName() + " withered because it does not have enough water!");
                    tileInfo[tileNumber].setWithered(true);
                    tile[tileNumber].setText("Withered");
                }
                if (tileInfo[tileNumber].getPlantedCrop().getCurrFertilizer() < tileInfo[tileNumber].getPlantedCrop().getMinFertilizer()) {
                    JOptionPane.showMessageDialog(frame, "\nYour " + tileInfo[tileNumber].getPlantedCrop().getName() + " withered because it does not have enough fertilizer!");
                    tileInfo[tileNumber].setWithered(true);
                    tile[tileNumber].setText("Withered");
                }
                if (day > (tileInfo[tileNumber].getDayOfPlanting() + tileInfo[tileNumber].getPlantedCrop().getHarvestTime())) {
                    JOptionPane.showMessageDialog(frame, "\nYour " + tileInfo[tileNumber].getPlantedCrop().getName() + " withered due to late harvesting!");
                    tileInfo[tileNumber].setWithered(true);
                    tile[tileNumber].setText("Withered");
                }
         
            }
        } 
        else if (tileInfo[tileNumber].getPlantedCrop().getCropAge() < tileInfo[tileNumber].getPlantedCrop().getCropAge()) {
            JOptionPane.showMessageDialog(frame, "Your crop is not yet ripe!");
        }
        else {
            JOptionPane.showMessageDialog(frame, "You harvested your crop!");
            tile[tileNumber].setText("Unplowed");
                if(tile[tileNumber].getText() != "Withered") {
                    tileInfo[tileNumber].setYield((int)Math.floor(Math.random()*(tileInfo[tileNumber].getPlantedCrop().getMaxYield()-tileInfo[tileNumber].getPlantedCrop().getMinYield()+1)+tileInfo[tileNumber].getPlantedCrop().getMinYield()));

                    JOptionPane.showMessageDialog(frame, "\nYour " + tileInfo[tileNumber].getPlantedCrop().getName() + " yielded " + tileInfo[tileNumber].getYield() + "!\n");

                    tileInfo[tileNumber].setHarvestTotal(tileInfo[tileNumber].getYield() * tileInfo[tileNumber].getPlantedCrop().getBasePrice());
                    tileInfo[tileNumber].setWaterBonus(tileInfo[tileNumber].getHarvestTotal()* 0.2 * tileInfo[tileNumber].stats.getTimesWatered());
                    tileInfo[tileNumber].setFertilizerBonus(tileInfo[tileNumber].getHarvestTotal() * 0.5 * tileInfo[tileNumber].stats.getTimesFertilized());
                    tileInfo[tileNumber].setFinalHarvestPrice(tileInfo[tileNumber].getHarvestTotal()+tileInfo[tileNumber].getWaterBonus()+tileInfo[tileNumber].getFertilizerBonus());
                    player.setFarmerExp(tileInfo[tileNumber].getPlantedCrop().getExp());

                    if(tileInfo[tileNumber].getPlantedCrop().getType()=="Flower") {
                        JOptionPane.showMessageDialog(frame, "Flowers are a premium crop! Your final harvest price will be multiplied by 1.1!");
                        tileInfo[tileNumber].setFinalHarvestPrice(tileInfo[tileNumber].getFinalHarvestPrice()*1.1);
                    }
                    player.setObjectCoins(tileInfo[tileNumber].getFinalHarvestPrice());
                    JOptionPane.showMessageDialog(frame, "\nYou earned $" + tileInfo[tileNumber].getFinalHarvestPrice() +"!\n");
                    updateInfo();
                    setToZero(tileNumber, empty);
                }
                setToZero(tileNumber, empty);
            }
    }
    
    private void emptyTile() {
        if ( tile[tileNumber].getText() == "Unplowed" || tile[tileNumber].getText() == "Plowed") { // empty tile, implement rocks
            if (tools[0].isEnabled() == false && tile[tileNumber].getText() == "Unplowed") { //Plowing the unplowed tile
                tile[tileNumber].setText("Plowed");
                player.setObjectCoins(-toolCost[0]);
                player.setFarmerExp(toolsList.get(0).getExpGain());
                //     tools[0].setEnabled(true);
            } else if (tools[0].isEnabled() == false && tile[tileNumber].getText() == "Plowed") { // plowing a plowed tile
                JOptionPane.showMessageDialog(frame, "Tile is already plowed.");
            } else if ((tools[1].isEnabled() == false || tools[2].isEnabled() == false || tools[3].isEnabled() == false || tools[3].isEnabled() == false)
                    && (tile[tileNumber].getText() == "Unplowed" || tile[tileNumber].getText() == "Plowed")) { //there is no crop yet
                JOptionPane.showMessageDialog(frame, "There is no crop on the tile.");
                tools[1].setEnabled(true);
            } else if (((cmd[0].isEnabled() == false) && tools[1].isEnabled() == true && tools[2].isEnabled() == true && tools[3].isEnabled() == true && tools[2].isEnabled() == true &&
                    tools[3].isEnabled() == true) && (tile[tileNumber].getText() == "Plowed") && (tileInfo[tileNumber].getPlantedCrop() == empty)) {
            //    tile[tileNumber].setEnabled(false);
                selectSeeds = new SelectSeeds();
                pause();
                cmd[0].setEnabled(true);
            }
        }
    }
//updating the crop info
    private void updateCropInfo() {
        txt.setText("[Age: " + tileInfo[tileNumber].getPlantedCrop().getCropAge() + '/' + tileInfo[tileNumber].getPlantedCrop().getHarvestTime() + "]\n"
                + "[Water: " + tileInfo[tileNumber].getPlantedCrop().getCurrWater() + "/"
                + tileInfo[tileNumber].getPlantedCrop().getMinWater() + "("
                + tileInfo[tileNumber].getPlantedCrop().getMaxWater() + ")]\n"
                + "[Fertilizer: " + tileInfo[tileNumber].getPlantedCrop().getCurrFertilizer() + "/"
                + tileInfo[tileNumber].getPlantedCrop().getMinFertilizer() + "("
                + tileInfo[tileNumber].getPlantedCrop().getMaxFertilizer() + ")]\n"
                + "[Selling price: " + tileInfo[tileNumber].getPlantedCrop().getBasePrice() + " objectCoins]\n");
    }
//planting the seed
    private void cropTile(){
        for (int j = 0; j < seedList.size(); j++) {
            if (seedList.get(j).getName() == tile[tileNumber].getText()) {
                tileInfo[tileNumber].setPlantedCrop(tileInfo[tileNumber].seedList.get(j));
                tileInfo[tileNumber].setDayOfPlanting(player.getNoOfDays());
            }
        }

        //  print crop info
        txt.setText("[Age: " + tileInfo[tileNumber].getPlantedCrop().getCropAge() + '/' + tileInfo[tileNumber].getPlantedCrop().getHarvestTime() + "]\n"
                + "[Water: " + tileInfo[tileNumber].getPlantedCrop().getCurrWater() + "/"
                + tileInfo[tileNumber].getPlantedCrop().getMinWater() + "("
                + tileInfo[tileNumber].getPlantedCrop().getMaxWater() + ")]\n"
                + "[Fertilizer: " + tileInfo[tileNumber].getPlantedCrop().getCurrFertilizer() + "/"
                + tileInfo[tileNumber].getPlantedCrop().getMinFertilizer() + "("
                + tileInfo[tileNumber].getPlantedCrop().getMaxFertilizer() + ")]\n"
                + "[Selling price: " + tileInfo[tileNumber].getPlantedCrop().getBasePrice() + " objectCoins]\n");
        if (!(tile[tileNumber].getText() == "Unplowed" //view crop information
                || tile[tileNumber].getText() == "Plowed") && (cmd[0].isEnabled() == true && cmd[1].isEnabled() == true && cmd[2].isEnabled() == true &&
                tools[0].isEnabled() == true && tools[1].isEnabled() == true && tools[2].isEnabled() == true && tools[3].isEnabled() == true && tools[4].isEnabled() == true)) {
            JOptionPane.showMessageDialog(txt, txt.getText(), tileInfo[tileNumber].getPlantedCrop().getName() + " Information", JOptionPane.INFORMATION_MESSAGE);
        } else if ((tools[3].isEnabled() == false || tools[0].isEnabled() == false) // pickaxe on tile with crop
                && !(tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Unplowed"
                || tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Plowed")) {
            JOptionPane.showMessageDialog(frame, "You can't do that! A crop is planted here.");
        } else if ((tools[4].isEnabled() == false)
                && !(tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Unplowed"
                || tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Plowed")) {
            if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to dig up the crop?", "Warning!",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { // if yes
                player.setObjectCoins(-toolCost[4]);
                player.setFarmerExp(toolsList.get(4).getExpGain());
                tile[tileNumber].setText("Unplowed");
                setToZero(tileNumber, empty);
            } else { // if no

            }
        } else if ((tools[1].isEnabled() == false) && !(tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Unplowed"
                || tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Plowed")) { //water crop
            tileInfo[tileNumber].getPlantedCrop().setCurrWater(stats.addTimesWatered());
            player.setFarmerExp(toolsList.get(1).getExpGain());
            tools[1].setEnabled(true);
        } else if ((tools[2].isEnabled() == false) && !(tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Unplowed"
                || tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Plowed")) { // fertilize crop
            tileInfo[tileNumber].getPlantedCrop().setCurrFertilizer(stats.addTimesFertilized());
            player.setFarmerExp(toolsList.get(2).getExpGain());
            player.setObjectCoins(-toolCost[2]);
            tools[2].setEnabled(true);
        } else if ((cmd[2].isEnabled() == false) && !(tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Unplowed"
                || tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Plowed") && (tileInfo[tileNumber].getPlantedCrop() != empty)) { // harvest crop
           // harvest();
        } else {

        }
    }
//run the program
    private void run(){
        if ((tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Unplowed"
                || tile[tileNumber].getText() == "Rocks" || tile[tileNumber].getText() == "Plowed")) {
            emptyTile();
        } else {
        	
            cropTile();
            
        }
      
        updateInfo();
        reset();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        num = Integer.parseInt(src);
        
        if (num < 50) {
            tileNumber = num;
            run();

        } else if (num > 49) { // value of command
            reset();
            if ((num - 54) < 5 && (num - 54) >= 0) { //for using tools
                if (player.getObjectCoins() < toolCost[num - 54]) {
                    JOptionPane.showMessageDialog(frame, "Insufficient Balance.");
                    reset();
                } else {
                    tools[num - 54].setEnabled(false);
                }
            } else if (src.equals("50")) { //Plant Seed
                cmd[0].setEnabled(false);
                //  tile[tileNumber].setEnabled(false);
            } else if (src.equals("51")) { //Advance a Day
                advanceADay();
               
                cmd[1].setEnabled(true);

            } else if (src.equals("52")) { //Harvest
                harvest();
                cmd[2].setEnabled(true);

            } else if (src.equals("53")) { // Exit
                System.exit(0);

            }else if (src.equals("59")) { // level up farmer
                upgradeFarmer();
                farmerBtn.setEnabled(true);
            }
        }
     //   reset();
    }
}