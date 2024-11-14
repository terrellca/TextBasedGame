
package package1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import package1.Game.ChoiceHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


/*
 * handles windows/swing elements
 */
public class UI
{
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonpanel, playerPanel;
    JLabel titleNameLabel,hpTagLabel,hpNumLabel,weaponLabel,weaponNameLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;

    Font titleFont = new Font("Bell MT", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    
    public void createUI(ChoiceHandler cHandler)
    {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
       

        // Title
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400,200,100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);

        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");


        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);



        //Game Screen
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);



        mainTextArea = new JTextArea("Main area");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);


        //Button area.

        choiceButtonpanel = new JPanel();
        choiceButtonpanel.setBounds(250,350,300,150);
        choiceButtonpanel.setBackground(Color.black);
        choiceButtonpanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonpanel);

        choice1 = new JButton("choice1");
        choice1.setBackground(Color.white);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);

        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");

        choiceButtonpanel.add(choice1);

        choice2 = new JButton("choice1");
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);

        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");

        choiceButtonpanel.add(choice2);

        choice3 = new JButton("choice1");
        choice3.setBackground(Color.white);
        choice3.setForeground(Color.black);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);

        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");

        choiceButtonpanel.add(choice3);

        choice4 = new JButton("choice1");
        choice4.setBackground(Color.white);
        choice4.setForeground(Color.black);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);

        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");

        choiceButtonpanel.add(choice4);


        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);


        hpTagLabel = new JLabel("HP:");
        hpTagLabel.setFont(normalFont);
        hpTagLabel.setForeground(Color.white);
        playerPanel.add(hpTagLabel);
        hpNumLabel = new JLabel();
        hpNumLabel.setForeground(Color.white);
        hpNumLabel.setFont(normalFont);
        playerPanel.add(hpNumLabel);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel .setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);
        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(normalFont);
        weaponNameLabel.setForeground(Color.white);
        playerPanel.add(weaponNameLabel);




        window.setVisible(true);

    }
}