// Austin Trinh, Arjun Rao, Geethan Sundaram, Rayyan Alam
// Phoenix Hackathon 2022 Project
// 12.3.2022

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class Arjun extends JPanel{
    // Fields:
    public int titleX, titleY, gui, angle, tick, constantX, constantY;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    private JLabel name;
    private JPanel north, south, east, west, menu, santaMenu, insert;
    private JPanel north2, east2, west2, south2;
    private JButton testButton;
    private JTextField insertName, insertWish;
    private ImageIcon santaTitle, santaLogo;
    private Timer timer;
    // private etc.

    // Panel Object
    public Arjun() {

        // Base Panel
        setLayout(new BorderLayout());
        setOpaque(false);

        // Instantiating Variables
        gui = 0;
        angle = 0;
        tick = 0;

        // Instantiating title
        santaTitle = new ImageIcon("Title.png");
        santaLogo = new ImageIcon("SecretSantaLogo.png");


        // Instantiating Timer
        timer = new Timer(1, new TimerListener());
        timer.start();

        // Menu Panel
        menu = new JPanel();
        menu.setLayout(new BorderLayout());
        menu.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        menu.setOpaque(false);
        add(menu);
            // North Panel
            north = new JPanel();
            north.setLayout(new BorderLayout());
            north.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
            north.setOpaque(false);
            menu.add(north, BorderLayout.PAGE_START);

            testButton = new JButton("Let's Begin!");
            testButton.setFont(new Font("Roboto", Font.BOLD, 30));
            testButton.setBackground(Color.RED); // Button Background
            testButton.setForeground(Color.WHITE); // Font color
            testButton.addActionListener(new Test());
            testButton.setPreferredSize(new Dimension(WIDTH/4, 0));
            testButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0,0,0,0, Color.BLACK),
                BorderFactory.createMatteBorder(3,3,3,3, Color.BLACK)),
            BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2,2,2,2, Color.WHITE),
                BorderFactory.createMatteBorder(6,3,6,3, new Color(136,65,62)))));
            menu.add(testButton, BorderLayout.CENTER);

            // Filler code
            west = new JPanel();
            west.setPreferredSize(new Dimension(WIDTH/4, 0));
            west.setOpaque(false);
            menu.add(west, BorderLayout.WEST);

            east = new JPanel();
            east.setPreferredSize(new Dimension(WIDTH/4, 0));
            east.setOpaque(false);
            menu.add(east, BorderLayout.EAST);

            south = new JPanel();
            south.setPreferredSize(new Dimension(WIDTH, HEIGHT/4));
            south.setOpaque(false);
            menu.add(south, BorderLayout.SOUTH);

        // Santa Menu
        santaMenu = new JPanel();
        santaMenu.setLayout(new BorderLayout());
        santaMenu.setOpaque(false);

            // Prompt
            insert = new JPanel();
            insert.setPreferredSize(new Dimension(WIDTH/4, 0));
            insert.setLayout(new BorderLayout());
            insert.setBackground(Color.RED);
            insert.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0,0,0,0, Color.BLACK),
                BorderFactory.createMatteBorder(3,3,3,3, Color.BLACK)),
            BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2,2,2,2, Color.WHITE),
                BorderFactory.createMatteBorder(6,3,6,3, new Color(136,65,62)))));
                santaMenu.add(insert, BorderLayout.CENTER);

                // Insert Fillers
                JPanel insertFiller = new JPanel();
                    insertFiller.setOpaque(false);
                    insertFiller.setPreferredSize(new Dimension(WIDTH/32, 0));
                        insert.add(insertFiller, BorderLayout.WEST);
                JPanel insertFiller2 = new JPanel();
                    insertFiller2.setOpaque(false);
                    insertFiller2.setPreferredSize(new Dimension(WIDTH/32, 0));
                        insert.add(insertFiller2, BorderLayout.EAST);

                JPanel insertFiller3 = new JPanel();
                    insertFiller3.setOpaque(false);
                    insertFiller3.setPreferredSize(new Dimension(0, HEIGHT/32));
                        insert.add(insertFiller3, BorderLayout.NORTH);
                
                JPanel insertFiller4 = new JPanel();
                    insertFiller4.setOpaque(false);
                    insertFiller4.setPreferredSize(new Dimension(0, HEIGHT/32));
                        insert.add(insertFiller4, BorderLayout.SOUTH);

                // Panel for Insert Name and Name TextField
                JPanel insert2 = new JPanel(new BorderLayout());
                insert2.setOpaque(false);
                    insert.add(insert2, BorderLayout.CENTER);

                    // Insert JLabel
                    name = new JLabel("Insert Name");
                    name.setFont(new Font("Roboto", Font.BOLD, 30));
                    //name.setHorizontalAlignment(JLabel.CENTER);
                    name.setForeground(Color.WHITE);
                    insert2.add(name, BorderLayout.NORTH);

                    // Insert TextField
                    insertName = new JTextField();
                    insertName.setFont(new Font("Roboto", Font.PLAIN, 20));
                    insertName.setPreferredSize(new Dimension(0, HEIGHT/32));
                    insert2.add(insertName, BorderLayout.CENTER);

                    // JPanel insert2filler = new JPanel();
                    //insert2filler.setOpaque(false);
                    //insert2filler.setPreferredSize(new Dimension(0, HEIGHT/32));
                    // insert2.add(insert2filler, BorderLayout.SOUTH);

                JPanel wish = new JPanel();
                wish.setLayout(new BorderLayout());
                wish.setOpaque(false);
                wish.setPreferredSize(new Dimension(0, 220));
                insert2.add(wish, BorderLayout.SOUTH);

                    JPanel fill1 = new JPanel();
                    fill1.setPreferredSize(new Dimension(0, HEIGHT/32));
                    fill1.setOpaque(false);
                        wish.add(fill1, BorderLayout.NORTH);

                    JPanel wish2 = new JPanel(new GridLayout(2,0));
                    wish2.setOpaque(false);
                        wish.add(wish2, BorderLayout.CENTER);

                        JLabel wishLabel = new JLabel("Insert Wish Item");
                        wishLabel.setFont(new Font("Roboto", Font.BOLD, 30));
                        wishLabel.setVerticalAlignment(JLabel.TOP);
                        wishLabel.setForeground(Color.WHITE);
                            wish2.add(wishLabel);

                        JTextField insertWish = new JTextField();
                        insertWish.setPreferredSize(new Dimension(0, HEIGHT/32));
                        insertWish.setFont(new Font("Roboto", Font.PLAIN, 20));
                            wish2.add(insertWish);

                    JPanel buttons = new JPanel(new BorderLayout());
                        //buttons.setOpaque(false);
                        buttons.setPreferredSize(new Dimension(0, HEIGHT/9));
                        wish.add(buttons, BorderLayout.SOUTH);

                        JPanel fill2 = new JPanel();
                        fill2.setPreferredSize(new Dimension(0, HEIGHT/32));
                        fill2.setBackground(Color.BLACK);
                            buttons.add(fill2, BorderLayout.NORTH);
                

            
            // Fillers
            north2 = new JPanel();
                north2.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
                north2.setOpaque(false);
                santaMenu.add(north2, BorderLayout.NORTH);
            east2 = new JPanel();
                east2.setPreferredSize(new Dimension(WIDTH/4, 0));
                east2.setOpaque(false);
                santaMenu.add(east2, BorderLayout.EAST);
            west2 = new JPanel();
                west2.setPreferredSize(new Dimension(WIDTH/4, 0));
                west2.setOpaque(false);
                santaMenu.add(west2, BorderLayout.WEST);
            south2 = new JPanel();
                south2.setPreferredSize(new Dimension(WIDTH, HEIGHT/4));
                south2.setOpaque(false);
                santaMenu.add(south2, BorderLayout.SOUTH);



        constantX = WIDTH/2 - (int)((675*0.8)/2);
        // titleY = north.getHeight()/2 + (int)((288*0.8)/2);
        constantY = (WIDTH/3)/2 - (int)((288*0.8)/2);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        GradientPaint blueToOrange = new GradientPaint(0, 0, new Color(60, 0, 16), 0, HEIGHT, new Color(255,0,35));
        g2D.setPaint(blueToOrange);
        g2D.fillRect(0, 0, WIDTH, HEIGHT);

        // Secret Santa Logo
        drawTitle(g);
        //drawLogo(g);
        if(gui == 1) {
            //drawTitle(g);
        }
        // 675, 288
    }

    public void drawTitle(Graphics g) {
        g.drawImage(santaTitle.getImage(), titleX, titleY, (int)(675*0.8), (int)(288*0.8), null);
    }

    public void drawLogo(Graphics g) {
        g.drawImage(santaLogo.getImage(), 500, 300, 100, 100, null);
    }

    // Button Actions
    private class Test implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            remove(menu);
            add(santaMenu);
            gui = 1;
            repaint();
            revalidate();
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
            tick++;
            angle+=2;
            // if(tick %10 == 0) {
            //     angle++;
            // }

            titleX = constantX;
            titleY = (int)(constantY + 20*Math.sin(Math.toRadians(angle)));
        }
    }

    // Panel Driver
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arjun: Secret Santa");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Arjun());
        frame.setVisible(true);
    }
}

/*
 * public static void gradientBackground(Graphics g) {
        // convert g into a graphics2d object
        Graphics2D g2D = (Graphics2D) g;

        //create gradient paint object
        //experiment with the parameters to see how changing them affects the gradient
        GradientPaint blueToOrange = new GradientPaint(0, 0, new Color(117, 0, 16), 0, HEIGHT, new Color(255,0,35));
        
        //draw a rectangle filling the frame (background)
        //that uses the gradient we just created
        g2D.setPaint(blueToOrange);
        g2D.fillRect(0, 0, WIDTH, HEIGHT);
    }
 */