package MyFarm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//class for the GUI of flowers
public class Flowers implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton rose, turnips, sunflower, cancel;
    private Container container;
    private JLabel pRose, pTulips, pSunFlower;
    private String[] cost = { "5", "10", "20" };
    private String[] names = { "Rose", "Turnips", "Sunflower" };
    
    //method for the label  of the seeds under flowers
    private void label() {
        pRose = new JLabel();
        pRose.setText(cost[0] + " objectCoins");
        pRose.setBounds(23, 10, 150, 55);
        frame.add(pRose);

        pTulips = new JLabel();
        pTulips.setText(cost[1] + " objectCoins");
        pTulips.setBounds(153, 10, 150, 55);
        frame.add(pTulips);

        pSunFlower = new JLabel();
        pSunFlower.setText(cost[2] + " objectCoins");
        pSunFlower.setBounds(283, 10, 150, 55);
        frame.add(pSunFlower);
    }
    //method to display the labels and create buttons for the seeds
    public Flowers() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setTitle("Flower Crop");
        container = frame.getContentPane();
        container.setLayout(null);

        label();

        rose = new JButton("Rose");
        rose.setBounds(10, 50, 100, 90);
        rose.setActionCommand("0");
        rose.addActionListener(this);
        rose.setFocusable(false);
        frame.add(rose);

        turnips = new JButton("Turnips");
        turnips.setBounds(138, 50, 110, 90);
        turnips.setActionCommand("1");
        turnips.addActionListener(this);
        turnips.setFocusable(false);
        frame.add(turnips);

        sunflower = new JButton("Sunflower");
        sunflower.setBounds(275, 50, 100, 90);
        sunflower.setActionCommand("2");
        sunflower.addActionListener(this);
        sunflower.setFocusable(false);
        frame.add(sunflower);

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
        FarmView.frame.toFront();
        FarmView.frame.repaint();
        FarmView.frame.validate();

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
            int num = Integer.parseInt(src);
            int val = Integer.parseInt(cost[num]);
            if (FarmView.player.getObjectCoins() < val) {
                JOptionPane.showMessageDialog(frame, "Insufficient Balance.");
            } else {
                FarmView.player.setObjectCoins(-val);
                FarmView.tile[FarmView.tileNumber].setText(names[num]);
                FarmView.updateInfo();
                quit();
            }

        } catch (Exception c) {
            quit_B();
        }

    }

}
