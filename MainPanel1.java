package MyFarm;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
//gui for the main panel
public class MainPanel1 implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton playButton,exitButton;
    private Container container;
//main panel display
    public MainPanel1(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Farm");
        frame.setSize(700,500);
        frame.setLayout(null);
        frame.setVisible(true);
        container = frame.getContentPane();
        container.setLayout(null);


        JLabel title = new JLabel();
        title.setText("My Farm");
        title.setFont(new Font("Impact", Font.BOLD, 50));
        title.setBounds(265,130,200,100);
        container.add(title);

        playButton = new JButton("Start");
        playButton.setBounds(255,220,200,40);
        playButton.setActionCommand("Start");
        playButton.addActionListener(this);
        playButton.setFocusable(false);
        playButton.setEnabled(true);
        container.add(playButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(255,280,200,40);
        exitButton.setActionCommand("Exit");
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        container.add(exitButton);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    public static void main(String[] args) {
        new MainPanel1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String commandString = e.getActionCommand();

        if(commandString.equals("Start")){
            // opens main view of the farm
            FarmView farm = new FarmView();
            frame.setVisible(false);

        }
        if(commandString.equals("Exit")){
            // exits the program
            System.exit(0);
        }
    }

}