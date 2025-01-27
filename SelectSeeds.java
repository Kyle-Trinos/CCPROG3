package MyFarm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// class for the GUI of choosing which seed to plant
public class SelectSeeds implements ActionListener {
    public static JFrame frame = new JFrame();
    private JButton[] seeds = new JButton[4]; //roots, flowers, trees, cancel
    private Container container;
    //method to select seeds
    public SelectSeeds() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(520, 250);
        frame.setVisible(true);

        container = frame.getContentPane();
        container.setLayout(null);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        for(int j=0; j<4; j++) {
            seeds[j] = new JButton();
            seeds[j].setBounds(50 + (100 * j),50,100,90);
            seeds[j].addActionListener(this);
            seeds[j].setFocusable(false);
            container.add(seeds[j]);
        }
        seeds[0].setText("Root Crops");
        seeds[0].setActionCommand("rc");
        seeds[1].setText("Flowers");
        seeds[1].setActionCommand("fl");
        seeds[2].setText("Fruit Trees");
        seeds[2].setActionCommand("ft");
        seeds[3].setText("Back");
        seeds[3].setActionCommand("b");
    }
    //method for the action
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String src = e.getActionCommand();
        Window w =  javax.swing.FocusManager.getCurrentManager().getActiveWindow();
        if(w.isActive() == true){
            frame.setEnabled(false);
        }

        if(src.equals("rc")){
            RootCrops rc = new RootCrops();
        }
        if(src.equals("fl")){
            Flowers fc = new Flowers();
        }
        if(src.equals("ft")){
            FruitTree fl = new FruitTree();
        }
        if(src.equals("b")){
            frame.setEnabled(true);
            frame.setVisible(false);


            FarmView.frame.setEnabled(true);
            FarmView.frame.toFront();
        }

    }
}