// Austin Trinh, Arjun Rao, Geethan Sundaram, Rayyan Alam
// Phoenix Hackathon 2022 Project
// 12.3.2022

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class Arjun extends JPanel{
    // Fields:
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    private JLabel test;
    private JButton testButton;
    // private etc.

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
    }

    // Panel Object
    public Arjun() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));

        // test
        test = new JLabel("test");
        test.setPreferredSize(new Dimension(100, 200));
        add(test, BorderLayout.PAGE_START);

        testButton = new JButton("Test");
        testButton.setFont(new Font("Roboto", Font.BOLD, 30));
        testButton.setBackground(Color.RED); // Button Background
        testButton.setForeground(Color.WHITE); // Font color
        testButton.addActionListener(new Test());
        testButton.setPreferredSize(new Dimension(100, 200));
        testButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(10,0,0,0, Color.WHITE),
            BorderFactory.createMatteBorder(3,3,3,3, Color.BLACK)),
         BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(2,2,2,2, Color.WHITE),
            BorderFactory.createMatteBorder(6,3,6,3, new Color(136,65,62)))));
        add(testButton, BorderLayout.CENTER);

        // Filler code
        JLabel t1 = new JLabel("WEST");
        t1.setVerticalAlignment(JLabel.CENTER);
        t1.setPreferredSize(new Dimension(50, 200));
        add(t1, BorderLayout.EAST);

        JLabel t2 = new JLabel("EAST");
        t2.setVerticalAlignment(JLabel.CENTER);
        t2.setPreferredSize(new Dimension(50, 200));
        add(t2, BorderLayout.WEST);

        JPanel green = new JPanel();
        green.setLayout(new BorderLayout());
        green.setBackground(Color.GREEN);
        add(green, BorderLayout.SOUTH);

        JLabel t3 = new JLabel("SOUTH");
        t3.setVerticalAlignment(JLabel.CENTER);
        t3.setPreferredSize(new Dimension(WIDTH, 100));
        t3.setOpaque(false);
        green.add(t3, BorderLayout.CENTER);
    }

    // Button Actions
    private class Test implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("WOO");
        }
    }

    // Panel Driver
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arjun: Secret Santa");
        frame.setSize(900, 900);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Arjun());
        frame.setVisible(true);
    }
}