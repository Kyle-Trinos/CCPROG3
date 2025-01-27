package MyFarm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//class for the GUI of root crops
public class RootCrops implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton turnip, carrot, potato, cancel;
    private Container container;
    private JLabel pTurnip, pCarrot, pPotato;
    private String[] cost = { "5", "10", "20" };
    private String[] names = { "Turnip", "Carrot", "Potato" };
   // public static Tile tile = new Tile();

  //method for the label  of the seeds under root crops
    private void label() {
        pTurnip = new JLabel( cost[0] + " objectCoins");
        pTurnip.setBounds(23, 10, 150, 55);
        frame.add(pTurnip);

        pCarrot = new JLabel(cost[1] + " objectCoins");
        pCarrot.setBounds(153, 10, 150, 55);
        frame.add(pCarrot);

        pPotato = new JLabel(cost[2] + " objectCoins");
        pPotato.setBounds(283, 10, 150, 55);
        frame.add(pPotato);
    }
    //method to display the labels and create buttons for the seeds
    public RootCrops() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setTitle("Root Crop");
        container = frame.getContentPane();
        container.setLayout(null);

        label();

        turnip = new JButton("Turnip");
        turnip.setBounds(10, 50, 100, 90);
        turnip.setActionCommand("0");
        turnip.addActionListener(this);
        turnip.setFocusable(false);
        frame.add(turnip);

        carrot = new JButton("Carrot");
        carrot.setBounds(138, 50, 110, 90);
        carrot.setActionCommand("1");
        carrot.addActionListener(this);
        carrot.setFocusable(false);
        frame.add(carrot);

        potato = new JButton("Potato");
        potato.setBounds(275, 50, 100, 90);
        potato.setActionCommand("2");
        potato.addActionListener(this);
        potato.setFocusable(false);
        frame.add(potato);

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
        SelectSeeds.frame.setEnabled(true);
        SelectSeeds.frame.dispose();

        FarmView.frame.setEnabled(true);
        FarmView.frame.toFront();
   
        frame.dispose();
    }
    //method to quit the window if a seed is not chosen
    private void quit_B() {

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