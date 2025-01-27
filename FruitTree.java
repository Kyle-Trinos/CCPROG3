package MyFarm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//class for the GUI of fruit trees
public class FruitTree implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton mango, apple, cancel;
    private Container container;
    private JLabel pMango, pApple;
    private String[] cost = { "100", "200" };
    private String[] names = { "Mango", "Apple" };
    
    //method for the label  of the seeds under fruit trees
    private void label() {
        pMango = new JLabel();
        pMango.setText(cost[0] + " objectCoins");
        pMango.setBounds(55, 10, 150, 55);
        frame.add(pMango);

        pApple = new JLabel();
        pApple.setText(cost[1] + " objectCoins");
        pApple.setBounds(245, 10, 150, 55);
        frame.add(pApple);
    }
    //method to display the labels and create buttons for the seeds
    public FruitTree() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setTitle("Fruit Crop");
        container = frame.getContentPane();
        container.setLayout(null);

        label();

        mango = new JButton("Mango");
        mango.setBounds(50, 50, 100, 90);
        mango.setActionCommand("0");
        mango.addActionListener(this);
        mango.setFocusable(false);
        frame.add(mango);

        apple = new JButton("Apple");
        apple.setBounds(240, 50, 100, 90);
        apple.setActionCommand("1");
        apple.addActionListener(this);
        apple.setFocusable(false);
        frame.add(apple);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 150, 90, 50);
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        cancel.setFocusable(false);
        frame.add(cancel);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

        frame.setLocation(x, y);
        frame.setVisible(true);

    }
    //method to quit the window after picking a seed
    private void quit() {
        FarmView.frame.setEnabled(true);
        FarmView.frame.toFront();
        FarmView.frame.repaint();
        FarmView.frame.validate();
     

        SelectSeeds.frame.setEnabled(true);
        SelectSeeds.frame.dispose();
        frame.dispose();
    }
    //method to quit the window if a seed is not chosen
    private void quit_B() {
        SelectSeeds.frame.toFront();
        SelectSeeds.frame.repaint();
        SelectSeeds.frame.validate();

        SelectSeeds.frame.setEnabled(true);
        SelectSeeds.frame.toFront();
        SelectSeeds.frame.repaint();
        SelectSeeds.frame.validate();
        frame.dispose();
    }
    //method for the action
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        
        try {
        	var right = FarmView.tile[FarmView.tileNumber + 1].getText();
    		var left = FarmView.tile[FarmView.tileNumber - 1].getText();
    		var topRight = FarmView.tile[FarmView.tileNumber - 9].getText();
    		var topLeft =FarmView.tile[FarmView.tileNumber - 11].getText();
    		var up = FarmView.tile[FarmView.tileNumber - 10].getText();
    		var down = FarmView.tile[FarmView.tileNumber + 10].getText();;
    		var bottomLeft = FarmView.tile[FarmView.tileNumber + 9].getText();
    		var bottomRight = FarmView.tile[FarmView.tileNumber + 11].getText();
            int num = Integer.parseInt(src);
            int val = Integer.parseInt(cost[num]);
            if (FarmView.player.getObjectCoins() < val) {
                JOptionPane.showMessageDialog(frame, "Insufficient Balance.");
            } 
            else {
            	if(FarmView.tileNumber > 0 && FarmView.tileNumber < 9) {
					if( left == "Unplowed" && right == "Unplowed" &&  down == "Unplowed" &&  bottomRight == "Unplowed" && bottomLeft == "Unplowed") {
					
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
				}
				else if (FarmView.tileNumber > 40 && FarmView.tileNumber <49) {
					if(left == "Unplowed" && right == "Unplowed" && up == "Unplowed" && topLeft == "Unplowed" && topRight == "Unplowed") {
								
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
					
				}
				else if (FarmView.tileNumber == 10 || FarmView.tileNumber == 20 || FarmView.tileNumber == 30) {
					if(right == "Unplowed" &&  up == "Unplowed" && down== "Unplowed" && topRight == "Unplowed" && 
						bottomRight == "Unplowed") {
										
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
							
				}
				else if (FarmView.tileNumber == 19 || FarmView.tileNumber== 29 || FarmView.tileNumber == 39) {
					if(left == "Unplowed" && up == "Unplowed" &&  down == "Unplowed" && topLeft == "Unplowed" && bottomLeft== "Unplowed") {
												
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
				}
				else if (FarmView.tileNumber == 0) {
					if(right == "Unplowed" && down== "Unplowed" && bottomRight == "Unplowed") {
						
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
				}
				else if (FarmView.tileNumber == 9) {
					if(left == "Unplowed" && down == "Unplowed" &&  bottomLeft == "Unplowed") {	
						
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
				}
				else if (FarmView.tileNumber== 40) {
					if(right== "Unplowed" && up == "Unplowed" && topRight == "Unplowed") {				
						
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
				}
            	
				else if (FarmView.tileNumber == 49) {
					if(left == "Unplowed" && up== "Unplowed" && topLeft  == "Unplowed") {				
						
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
				}
            	
				else {
					if(up == "Unplowed" && down == "Unplowed"&& right == "Unplowed" && left == "Unplowed" && 
						topLeft == "Unplowed" && topRight== "Unplowed" && bottomLeft == "Unplowed" && bottomRight== "Unplowed" ) {
												
						FarmView.player.setObjectCoins(-val);
		                FarmView.tile[FarmView.tileNumber].setText(names[num]);
		                FarmView.updateInfo();
		                quit();
					}
					else {
						JOptionPane.showMessageDialog(frame, "You can't plant a tree here!");
					}
				}
                
            }

        } catch (Exception c) {
            quit_B();
        }

    }

}