//package atm;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.io.File;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.geom.RoundRectangle2D;
import java.util.concurrent.*;




public class atm {

    atm() {
        double acc1=230003906;
        int pin1=1234;
        JFrame fr = new JFrame("ATM");
        JFrame fr2=new JFrame("frame2");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(null);
        fr2.setLayout(null);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        JLabel acc = new JLabel("Card Number:");
        JLabel pass = new JLabel("PIN             :");
        JTextField tf1 = new JTextField();
        JPasswordField tf2 = new JPasswordField();
        JButton deposit = new JButton("Deposit");
        JButton withdraw = new JButton("withdraw");
        JButton balenquiry = new JButton("Balance Enquiry");
        JButton balstate = new JButton("Balance Statement");
        JButton passchange = new JButton("Change Password");
        JButton saving = new JButton("Savings Account");

        JButton amount1=new JButton("amount1");
        JTextArea ta1=new JTextArea(3,4);
        //Dimension dim = new Dimension(500,500);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        ImageIcon entericon=new ImageIcon("C:\\Users\\gopi sai\\Desktop\\javaatm\\ATM\\src\\login1.png");
        // JLabel image= new JLable(ImageIcon("log-in(1).png"))
        panel3.setBorder(border);
       // panel1.setBorder(border);
        panel6.setBorder(border);
        JButton enter = new JButton("ENTER") {
            @Override
            protected void paintComponent(Graphics g) {
                // Check if the button is pressed and change color accordingl
                // y
                if (getModel().isPressed()) {
                    g.setColor(new Color(81, 255, 13)); // Pressed color
                } else {
                    g.setColor(new Color(0, 0, 255)); // Default color
                }

                // Fill the button with a rounded rectangle
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                // Set the text color to white
                g.setColor(Color.WHITE);

                // Draw the button text centered in the middle
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent()) / 2;
                g.drawString(getText(), x, y);  // Draw the text
            }

            @Override
            public boolean contains(int x, int y) {
                // Ensure the clickable area matches the rounded corners
                return new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 30, 30).contains(x, y);
            }
        };//etLayout(null);  // No layout manager
       // enter.setBounds(100, 100, 200, 60);  // Position and size of the button
       // fr.add(button);

        // Add ActionListener to the button

        JButton register = new JButton("REGISTER") {
            @Override
            protected void paintComponent(Graphics g) {
                // Check if the button is pressed and change color accordingly
                if (getModel().isPressed()) {
                    g.setColor(new Color(81, 255, 13)); // Pressed color
                } else {
                    g.setColor(new Color(0, 0, 255)); // Default color
                }

                // Fill the button with a rounded rectangle
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                // Set the text color to white
                g.setColor(Color.WHITE);

                // Draw the button text centered in the middle
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent()) / 2;
                g.drawString(getText(), x, y);  // Draw the text
            }

            @Override
            public boolean contains(int x, int y) {
                // Ensure the clickable area matches the rounded corners
                return new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 30, 30).contains(x, y);
            }
        };
                panel1.setLayout(null);
                panel1.setOpaque(false);

        acc.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
        acc.setForeground(Color.CYAN);
        pass.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
        pass.setForeground(Color.CYAN);


        tf1.setOpaque(false);
        tf1.setForeground(Color.WHITE);
        tf1.setFont(new Font("Arial",Font.PLAIN,20));
        tf1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tf1.setUI(new javax.swing.plaf.basic.BasicTextFieldUI() {
            @Override
            public void paintSafely(Graphics g) {
                super.paintSafely(g);
                // Get the Graphics2D object for advanced drawing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.CYAN);  // Underline color
                int y = tf1.getHeight() - 2;  // Position of the underline
                g2d.drawLine(0, y, tf1.getWidth(), y);  // Draw underline across width of text field
            }
        });
        //VideoPanel video=new VideoPanel(" ");
        tf2.setOpaque(false);
        tf2.setForeground(Color.WHITE);
        tf2.setFont(new Font("Arial",Font.PLAIN,20));
        tf2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tf2.setUI(new javax.swing.plaf.basic.BasicTextFieldUI() {
            @Override
            public void paintSafely(Graphics g) {
                super.paintSafely(g);
                // Get the Graphics2D object for advanced drawing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.CYAN);  // Underline color
                int y = tf2.getHeight() - 2;  // Position of the underline
                g2d.drawLine(0, y, tf1.getWidth(), y);  // Draw underline across width of text field
            }
        });

        //enetr button shape
               enter.setOpaque(false);
                enter.setFocusPainted(false);
               enter.setBorder(null);

        //enter.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 255), 2));
        //enter.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
          enter.setBorderPainted(false);
              //  enter.setContentAreaFilled(false);
                register.setOpaque(false);

               register.setBorderPainted(false);
               // register.setForeground(Color.YELLOW);
        register.setBackground(Color.GREEN);
                //register.setContentAreaFilled(false);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);
        panel5.setLayout(null);
        panel6.setLayout(null);
        // fr.setLocationRelativeTo(null);
        fr.setResizable(true);
        //fr2.setLocationRelativeTo(null);
        fr2.setResizable(true);




        // panel1.setSize(500, 500);
        panel2.setSize(400,400);
        panel3.setSize(400,400);
        // panel4.setSize(400,400);


        acc.setBounds(20, 20, 150, 20);
        tf1.setBounds(150, 10, 150, 40);
        pass.setBounds(20, 80, 150, 20);
        tf2.setBounds(150, 80, 150, 40);
        enter.setBounds(120, 150, 130, 50);
        register.setBounds(120,230,130,50);
        panel1.setBounds(300, 180, 400, 300);
        deposit.setBounds(40, 80, 170, 40);
        saving.setBounds(40, 160, 170, 40);
        passchange.setBounds(40, 240, 170, 40);
        withdraw.setBounds(20, 80, 170, 40);
        balenquiry.setBounds(20, 160, 170, 40);
        balstate.setBounds(20, 240, 170, 40);

        panel2.setBounds(50, 100, 300, 300);
        panel3.setBounds(355,100,300,300);
        panel4.setBounds(700,100,300,300);
        panel5.setBounds(410,400,300,300);
        panel6.setBounds(355,100,300,300);
        panel1.add(acc);
        panel1.add(pass);
        panel1.add(tf1);

        panel1.add(tf2);
        panel1.add(enter);
        panel1.add(register);
        fr2.add(panel2);
        fr2.add(panel3);
        fr2.add(panel4);

        panel2.add(saving);
        panel2.add(passchange);
        panel4.add(withdraw);
        panel4.add(balenquiry);
        panel4.add(balstate);
        panel2.add(deposit);

        //CREATING NUMBERS
        JButton withdraw_b1=new JButton("1");
        JButton withdraw_b2=new JButton("2");
        JButton withdraw_b3=new JButton("3");
        JButton withdraw_b4=new JButton("4");
        JButton withdraw_b5=new JButton("5");
        JButton withdraw_b6=new JButton("6");
        JButton withdraw_b7=new JButton("7");
        JButton withdraw_b8=new JButton("8");
        JButton withdraw_b9=new JButton("9");
        JButton withdraw_b0=new JButton("0");
        JButton withdraw_bclear=new JButton("<");
        JButton withdraw_benter=new JButton("->");

        withdraw_b1.setBounds(10,10,50,50);
        withdraw_b2.setBounds(70,10,50,50);
        withdraw_b3.setBounds(130,10,50,50);
        withdraw_b4.setBounds(10,70,50,50);
        withdraw_b5.setBounds(70,70,50,50);
        withdraw_b6.setBounds(130,70,50,50);
        withdraw_b7.setBounds(10,130,50,50);
        withdraw_b8.setBounds(70,130,50,50);
        withdraw_b9.setBounds(130,130,50,50);
        withdraw_b0.setBounds(70,190,50,50);
        withdraw_bclear.setBounds(10,190,50,50);
        withdraw_benter.setBounds(130,190,50,50);



        panel5.add(withdraw_b1);
        panel5.add(withdraw_b2);
        panel5.add(withdraw_b3);
        panel5.add(withdraw_b4);
        panel5.add(withdraw_b5);
        panel5.add(withdraw_b6);
        panel5.add(withdraw_b7);
        panel5.add(withdraw_b8);
        panel5.add(withdraw_b9);
        panel5.add(withdraw_b0);
        panel5.add(withdraw_bclear);
        panel5.add(withdraw_benter);
        fr2.add(panel5);


       //
        //
        //fr.setSize(1000, 1000);
        fr2.setSize(1000,1000);
        fr.add(panel1);

        //panel3 field

        JLabel w=new JLabel("W");
        JLabel e=new JLabel("E");
        JLabel l=new JLabel("L");
        JLabel c=new JLabel("C");
        JLabel o=new JLabel("O");
        JLabel m=new JLabel("M");
        JLabel e2=new JLabel("E");
        JLabel t=new JLabel("T");
        JLabel o2=new JLabel("O");
        JLabel a=new JLabel("A");
        JLabel t2=new JLabel("T");
        JLabel m1=new JLabel("M");
        JLabel text=new JLabel("Insert Card Here-->");
        w.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        e.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        l.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        c.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        o.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        m.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        e2.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        t.setFont(new java.awt.Font("Arial", Font.BOLD, 30));
        o2.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        a.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        t2.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        m1.setFont(new java.awt.Font("Arial", Font.BOLD, 40));
        text.setFont(new java.awt.Font("Arial", Font.BOLD, 20));

        w.setBounds(60,50,150,60);
        e.setBounds(89,50,150,60);
        l.setBounds(113,50,150,60);
        c.setBounds(140,50,150,60);
        o.setBounds(166,50,150,60);
        m.setBounds(190,50,150,60);
        e2.setBounds(214,50,150,60);
        t.setBounds(120,95,200,60);
        o2.setBounds(145,95,200,60);
        a.setBounds(85,155,200,60);
        t2.setBounds(109,155,200,60);
        m1.setBounds(138,155,200,60);
        text.setBounds(138,235,200,60);


        w.setForeground(Color.ORANGE);
        e.setForeground(Color.decode("#ff7733"));
        l.setForeground(Color.decode("#f1c40f"));
        c.setForeground(Color.GREEN);
        o.setForeground(Color.decode("#87CEEB"));
        m.setForeground(Color.BLUE);
        e2.setForeground(Color.decode("#800080"));
        t.setForeground(Color.BLUE);
        o.setForeground(Color.PINK);
        a.setForeground(Color.GRAY);
        t2.setForeground(Color.BLUE);
        m1.setForeground(Color.GREEN);
        text.setForeground(Color.RED);



        panel3.add(w);
        panel3.add(e);
        panel3.add(l);
        panel3.add(c);
        panel3.add(o);
        panel3.add(m);
        panel3.add(e2);
        panel3.add(t2);
        panel3.add(o2);
        panel3.add(a);
        panel3.add(m1);
        panel3.add(text);
      //  panel3.add(t2);
        panel3.add(t);
        //withdraw field
        JLabel labelwithdraw=new JLabel("Enter Amount :");
        JTextField amountwithdraw=new JTextField();
        labelwithdraw.setBounds(10,108,100,30);
        amountwithdraw.setBounds(120,108,150,30);
        // JButton withdraw_ok=new JButton("ok");
        // withdraw_ok.setBounds(110,150,100,30);
        // panel6.add(withdraw_ok);
        ImageIcon withdraw_img=new ImageIcon(getClass().getResource("atm (1).png"));
        JLabel img_withdraw=new JLabel(withdraw_img);
        img_withdraw.setBounds(90,190,100,100);
        panel6.add(amountwithdraw);
        panel6.add(labelwithdraw);
        panel6.add(img_withdraw);

        //deposit field

        JLabel labeldeposit=new JLabel("Enter Amount:");
        JTextField amountdeposit=new JTextField();
        labeldeposit.setBounds(10,100,100,30);
        amountdeposit.setBounds(120,100,150,30);
        ImageIcon deposit_img=new ImageIcon(getClass().getResource("deposit.png"));
        JLabel img_deposit=new JLabel(deposit_img);
        img_deposit.setBounds(90,180,100,100);
        //JButton deposit_ok=new JButton("ok");
        // deposit_ok.setBounds(110,150,100,30);
        JPanel depositpanel=new JPanel();
        depositpanel.add(labeldeposit);
        depositpanel.add(amountdeposit);

        depositpanel.setLayout(null);
        depositpanel.setBorder(border);
        depositpanel.setBounds(355,100,300,300);
        //depositpanel.add(deposit_ok);
        JPanel deposit_button=new JPanel();
        deposit_button.setLayout(null);
        deposit_button.setBounds(410,400,300,300);
        JButton deposit_b1=new JButton("1");
        JButton deposit_b2=new JButton("2");
        JButton deposit_b3=new JButton("3");
        JButton deposit_b4=new JButton("4");
        JButton deposit_b5=new JButton("5");
        JButton deposit_b6=new JButton("6");
        JButton deposit_b7=new JButton("7");
        JButton deposit_b8=new JButton("8");
        JButton deposit_b9=new JButton("9");
        JButton deposit_b0=new JButton("0");
        JButton deposit_bclear=new JButton("<");
        JButton deposit_benter=new JButton("->");

        deposit_b1.setBounds(10,10,50,50);
        deposit_b2.setBounds(70,10,50,50);
        deposit_b3.setBounds(130,10,50,50);
        deposit_b4.setBounds(10,70,50,50);
        deposit_b5.setBounds(70,70,50,50);
        deposit_b6.setBounds(130,70,50,50);
        deposit_b7.setBounds(10,130,50,50);
        deposit_b8.setBounds(70,130,50,50);
        deposit_b9.setBounds(130,130,50,50);
        deposit_b0.setBounds(70,190,50,50);
        deposit_bclear.setBounds(10,190,50,50);
        deposit_benter.setBounds(130,190,50,50);



        deposit_button.add(deposit_b1);
        deposit_button.add(deposit_b2);
        deposit_button.add(deposit_b3);
        deposit_button.add(deposit_b4);
        deposit_button.add(deposit_b5);
        deposit_button.add(deposit_b6);
        deposit_button.add(deposit_b7);
        deposit_button.add(deposit_b8);
        deposit_button.add(deposit_b9);
        deposit_button.add(deposit_b0);
        deposit_button.add(deposit_bclear);
        deposit_button.add(deposit_benter);
        depositpanel.add(img_deposit);
        fr2.add(deposit_button);
        //balance enqiuiry
        JPanel balenqpanel=new JPanel();
        JLabel labelbalance=new JLabel(" Account balance is:");
        labelbalance.setBounds(10,100,100,30);
        JTextArea balanceta=new JTextArea();
        balenqpanel.setBounds(355,100,300,300);
        balenqpanel.setLayout(null);
        balenqpanel.setBorder(border);
        balanceta.setBounds(120,100,150,60);
        balenqpanel.add(labelbalance);
        balenqpanel.add(balanceta);

        // Password change field
        JPanel passchangepanel=new JPanel();
        passchangepanel.setBounds(355,100,300,300);
        passchangepanel.setLayout(null);
        passchangepanel.setBorder(border);
        JLabel labelpassword1=new JLabel("Enter current pin:");
        JLabel labelpassword2=new JLabel ("Enter new pin:");
        JLabel labelpassword3=new JLabel ("Renter new pin:");
        labelpassword1.setBounds(10,100,120,30);
        labelpassword2.setBounds(10,150,120,30);
        labelpassword3.setBounds(10,200,120,30);
        JPasswordField pass1=new JPasswordField();
        JPasswordField pass2=new JPasswordField();
        JPasswordField pass3=new JPasswordField();

        ImageIcon pass_img=new ImageIcon(getClass().getResource("key.png"));
        JLabel img_pass=new JLabel(pass_img);
        img_pass.setBounds(10,10,100,100);
        JButton password_enter=new JButton("OK");
        pass1.setBounds(150,100,120,30);
        pass2.setBounds(150,150,120,30);
        pass3.setBounds(150,200,120,30);
        password_enter.setBounds(180,240,60,40);
        passchangepanel.add(labelpassword1);
        passchangepanel.add(labelpassword2);
        passchangepanel.add(labelpassword3);
        passchangepanel.add(pass1);
        passchangepanel.add(pass2);
        passchangepanel.add(pass3);
        passchangepanel.add(password_enter);
        passchangepanel.add(img_pass);
        JPanel password_button=new JPanel();
        JButton password_b1=new JButton("1");
        JButton password_b2=new JButton("2");
        JButton password_b3=new JButton("3");
        JButton password_b4=new JButton("4");
        JButton password_b5=new JButton("5");
        JButton password_b6=new JButton("6");
        JButton password_b7=new JButton("7");
        JButton password_b8=new JButton("8");
        JButton password_b9=new JButton("9");
        JButton password_b0=new JButton("0");
        JButton password_bclear=new JButton("<");
        JButton password_benter=new JButton("->");

        password_b1.setBounds(10,10,50,50);
        password_b2.setBounds(70,10,50,50);
        password_b3.setBounds(130,10,50,50);
        password_b4.setBounds(10,70,50,50);
        password_b5.setBounds(70,70,50,50);
        password_b6.setBounds(130,70,50,50);
        password_b7.setBounds(10,130,50,50);
        password_b8.setBounds(70,130,50,50);
        password_b9.setBounds(130,130,50,50);
        password_b0.setBounds(70,190,50,50);
        password_bclear.setBounds(10,190,50,50);
        password_benter.setBounds(130,190,50,50);



        password_button.add(password_b1);
        password_button.add(password_b2);
        password_button.add(password_b3);
        password_button.add(password_b4);
        password_button.add(password_b5);
        password_button.add(password_b6);
        password_button.add(password_b7);
        password_button.add(password_b8);
        password_button.add(password_b9);
        password_button.add(password_b0);
        password_button.add(password_bclear);
        password_button.add(password_benter);

        fr2.add(password_button);

        //balance statement field
        JPanel balstatepanel=new JPanel();
        balstatepanel.setBounds(355,100,300,300);
        JLabel  labelbalstate=new JLabel("Balance History:");
        labelbalstate.setBounds(10,100,100,30);
        JTextArea  balstate_ta=new JTextArea();
        balstate_ta.setBounds(120,100,100,90);
        balstatepanel.setLayout(null);
        balstatepanel.setBorder(border);
        balstatepanel.add(labelbalstate);
        balstatepanel.add(balstate_ta);

        //savings account field
        JPanel savepanel=new JPanel();
        savepanel.setLayout(null);
        savepanel.setBounds(355,100,300,300);
        savepanel.setBorder(border);
        JLabel labelsave=new JLabel("savings account details:");
        JTextArea  save_ta=new JTextArea();
        labelsave.setBounds(10,80,100,100);
        save_ta.setBounds(100,80,100,100);
        savepanel.add(labelsave);
        savepanel.add(save_ta);

        //frame background image
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        fr.setSize(screenSize);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
ImageIcon frbg=new ImageIcon(this.getClass().getResource("bank.jpg"));
        Image img = frbg.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);

        JLabel fr_bg = new JLabel(new ImageIcon(img));

        fr_bg.setSize(screenSize);

fr.setLocationRelativeTo(null);
fr.add(fr_bg);
        ImageIcon panel3_bg=new ImageIcon(this.getClass().getResource("insert1.jpg"));
        Image img1 = panel3_bg.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        JLabel panel3_label = new JLabel(new ImageIcon(img1));
        panel3_label.setSize(400,400);
     //   panel3.add(panel3_label);


        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = tf1.getText();
                String password = new String(tf2.getPassword());

                String url = "jdbc:mysql://localhost:3306/atm"; // Database URL
                String dbUser = "gopi";  // Database username
                String dbPassword = "gsai";  // Database password

                Connection connection = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    // Establish connection to the database
                    connection = DriverManager.getConnection(url, dbUser, dbPassword);
                    System.out.println("Connection successful!");

                    // Prepare SQL query to check if card number and PIN exist
                    String sql = "SELECT * FROM customers WHERE card_no=? AND pin=?";
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, user);
                    ps.setString(2, password);

                    // Execute query
                    rs = ps.executeQuery();

                    // Check if login is successful
                    if (rs.next()) {
                        // Login successful, open Deposit Panel
                        fr2.setVisible(true);
                        fr.setVisible(false);
                    } else {
                        // Invalid login, show error message
                        JOptionPane.showMessageDialog(fr, "Invalid Card Number or PIN.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(fr, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        // Close resources safely
                        if (rs != null) rs.close();
                        if (ps != null) ps.close();
                        if (connection != null) connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Hover effect for the Enter button
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                enter.setBackground(new Color(0, 150, 0));  // Change background color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                enter.setBackground(new Color(0, 255, 255));  // Reset color when mouse exits
            }
        });

        //REGISTRATION FIELD
        JFrame fr3=new JFrame("REGISTER");
        JPanel panel_register=new JPanel();
        JLabel user_name=new JLabel("USER NAME   :");
        JLabel pass_wd=new JLabel("PASSWORD    :");
        JLabel card_number=new JLabel("CARD NO    :");
        JLabel balance_reg=new JLabel("BALANCE     :");


        JLabel pinn=new JLabel("ENTER PIN   :");
        JLabel mob_no=new JLabel("MOBILE NO   :");
        JTextField user_name_tf=new JTextField();
        JTextField pass_wd_tf=new JTextField();
        JTextField card_number_tf=new JTextField();
        JTextField pinn_tf=new JTextField();
        JTextField mob_no_tf=new JTextField();
        JTextField bal_reg=new JTextField();

        JButton register_ok=new JButton("OK");
        JButton register_back=new JButton("BACK");
        panel_register.setBounds(330,90,400,500);
        user_name.setBounds(30,40,150,30);
        pass_wd.setBounds(30,80,150,30);
        card_number.setBounds(30,120,180,30);
        pinn.setBounds(30,160,150,30);
        mob_no.setBounds(30,200,150,30);
        balance_reg.setBounds(30,240,150,30);

        user_name_tf.setBounds(230,40,150,30);
        pass_wd_tf.setBounds(230,80,150,30);
        card_number_tf.setBounds(230,120,150,30);
        pinn_tf.setBounds(230,160,150,30);
        mob_no_tf.setBounds(230,200,150,30);
        bal_reg.setBounds(230,240,150,30);


        register_ok.setBounds(100,250,100,30);
        register_back.setBounds(240,250,100,30);

        user_name_tf.setOpaque(false);
        user_name_tf.setFont(new Font("Arial",Font.BOLD,20));
        //user_name_tf.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        //user_name_tf.setForeground(Color.decode("#964B00"));
        pass_wd_tf.setOpaque(false);
        pass_wd_tf.setFont(new Font("Arial",Font.BOLD,20));
     //   pass_wd_tf.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        card_number_tf.setOpaque(false);
        card_number_tf.setFont(new Font("Arial",Font.BOLD,20));
        //card_number_tf.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        pinn_tf.setOpaque(false);
       pinn_tf.setFont(new Font("Arial",Font.BOLD,20));
       // pinn_tf.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        mob_no_tf.setOpaque(false);
        mob_no_tf.setFont(new Font("Arial",Font.BOLD,20));
       //mob_no_tf.setBorder(BorderFactory.createLineBorder(Color.RED,3));


        panel_register.setOpaque(false);



        panel_register.add(user_name);
        panel_register.add(pass_wd);
        panel_register.add(card_number);
        panel_register.add(pinn);
        panel_register.add(mob_no);
        panel_register.add(user_name_tf);
        panel_register.add(pass_wd_tf);
        panel_register.add(card_number_tf);
        panel_register.add(pinn_tf);
        panel_register.add(mob_no_tf);
        panel_register.add(register_ok);
        panel_register.add(register_back);
        panel_register.setLayout(null);
        fr3.setResizable(true);
        fr3.setLayout(null);
        fr3.setSize(1000,1000);
        fr3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr3.add(panel_register);
        //fr3.setResizable(false);

       fr3.setSize(screenSize);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon frbg_reg=new ImageIcon(this.getClass().getResource("reg6.jpg"));
        Image img_reg = frbg_reg.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);

        JLabel fr_bg_reg = new JLabel(new ImageIcon(img_reg));

        fr_bg_reg.setSize(screenSize);
        fr3.add(fr_bg_reg);
        user_name.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        user_name.setForeground(Color.BLUE);
        pass_wd.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        pass_wd.setForeground(Color.BLUE);
        card_number.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        card_number.setForeground(Color.BLUE);
        pinn.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        pinn.setForeground(Color.BLUE);
        mob_no.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        mob_no.setForeground(Color.BLUE);
        mob_no.setFont(new java.awt.Font("Arial", Font.CENTER_BASELINE, 20));
        mob_no.setForeground(Color.BLUE);






//register actionlister

        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fr.setVisible(false);
                fr3.setVisible(true);

            }
        });


//register_ok actionlister



        register_ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/atm"; // Database URL
                String userr = "gopi"; // MySQL username
                String passwordd = "gsai"; // MySQL password

                // Use try-with-resources to manage resources
                try (Connection connection = DriverManager.getConnection(url, userr, passwordd)) {
                    System.out.println("Connection successful!");

                    // Retrieve user input
                    String user_n = user_name_tf.getText();
                    String passw = pass_wd_tf.getText();
                    long cardno = Long.parseLong(card_number_tf.getText());
                    int pinnn = Integer.parseInt(pinn_tf.getText());
                    long mob = Long.parseLong(mob_no_tf.getText());

                    // Prepare SQL insert statement
                    String sql = "INSERT INTO customers(user_name, password, card_no, pin, mobile_number,balance) VALUES (?, ?, ?, ?,?,0)";
                    //String sql1="INSERT INTO ACCOUNTS(CARD_NO,BALANCE) VALUES(?,?)";

                    try (PreparedStatement ps = connection.prepareStatement(sql)) {
                        ps.setString(1, user_n);
                        ps.setString(2, passw);
                        ps.setLong(3, cardno);
                        ps.setInt(4, pinnn);
                        ps.setLong(5, mob);

                        // Execute update and check if it was successful
                        int rowsAffected = ps.executeUpdate(); // Use executeUpdate for INSERT
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(fr3, "DATA INSERTED SUCCESSFULLY");
                        } else {
                            JOptionPane.showMessageDialog(fr3, "INVALID DATA");
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("SQL Error: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    System.out.println("Number Format Error: " + ex.getMessage());
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });

        register_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fr.setVisible(true);
                fr3.setVisible(false);

            }
        });
       // frame 2 back field
        JButton fr2_back=new JButton("BACK");
        fr2_back.setBounds(10,10,80,40);
        fr2.add(fr2_back);

        fr2_back.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           fr.setVisible(true);
                                           fr2.setVisible(false);
                                       }
                                   });
        //withdraw action listener
        withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel3.setVisible(false);
                depositpanel.setVisible(false);
                balenqpanel.setVisible(false);
                passchangepanel.setVisible(false);
                balenqpanel.setVisible(false);
                savepanel.setVisible(false);
                deposit_button.setVisible(false);
                panel5.setVisible(true);
                fr2.add(panel6);
                panel6.setVisible(true);


            }
        });


        //deposit add actionlistener

        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel3.setVisible(false);
                panel6.setVisible(false);
                balenqpanel.setVisible(false);
                passchangepanel.setVisible(false);
                balenqpanel.setVisible(false);
                savepanel.setVisible(false);
                //fr2.add(deposit_button);
                panel5.setVisible(false);
                fr2.add(depositpanel);
                deposit_button.setVisible(true);
                depositpanel.setVisible(true);


            }
        });
        deposit_benter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount;
                try {
                    // Parse the deposit amount
                    amount = Double.parseDouble(amountdeposit.getText());
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(fr2, "Amount must be greater than zero!");
                        return; // Exit if amount is invalid
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fr2, "Invalid amount entered!");
                    return; // Exit if input is invalid
                }

                String url = "jdbc:mysql://localhost:3306/atm"; // Database URL
                String user = "gopi"; // Database username
                String password = "gsai"; // Database password

                Connection connection = null;

                try {
                    // Establish connection to the database
                    connection = DriverManager.getConnection(url, user, password);
                    connection.setAutoCommit(false); // Start transaction
                    System.out.println("Connection successful!");

                    String userCard = tf1.getText();
                    String userPassword = new String(tf2.getPassword());

                    // Query to verify user credentials
                    String sql1 = "SELECT customer_id FROM customers WHERE card_no=? AND pin=?";
                    try (PreparedStatement ps1 = connection.prepareStatement(sql1)) {
                        ps1.setString(1, userCard);
                        ps1.setString(2, userPassword);
                        ResultSet rs1 = ps1.executeQuery();

                        if (rs1.next()) {
                            int customerId = rs1.getInt("customer_id");

                            // Fetch customer's current balance
                            String balanceSql = "SELECT balance FROM customers WHERE customer_id = ?"; // Assuming you have an accounts table
                            try (PreparedStatement ps = connection.prepareStatement(balanceSql)) {
                                ps.setInt(1, customerId);
                                ResultSet rs = ps.executeQuery();

                                // Check if balance exists for the customer
                                if (rs.next()) {
                                    double balance = rs.getDouble("balance");

                                    // Calculate the new balance
                                    double newBalance = balance + amount;
                                    int transId = generateUniqueTransactionId(); // Generate unique transaction ID

                                    // Insert the transaction record
                                    String insertSql = "INSERT INTO transactions (transaction_id, customer_id, transaction_type, amount) VALUES (?, ?, ?, ?)";
                                    try (PreparedStatement pstmt = connection.prepareStatement(insertSql)) {
                                        pstmt.setInt(1, transId);
                                        pstmt.setInt(2, customerId);
                                        pstmt.setString(3, "DEPOSIT");
                                        pstmt.setDouble(4, amount);
                                       // pstmt.setDouble(5, newBalance);

                                        pstmt.executeUpdate(); // Insert transaction record
                                    }

                                    // Update the balance in the accounts table (not transactions table)
                                    String updateBalanceSql = "UPDATE customers SET balance = ?";
                                    try (PreparedStatement updateStmt = connection.prepareStatement(updateBalanceSql)) {
                                        updateStmt.setDouble(1, newBalance);
                                        //updateStmt.setInt(2, customerId);
                                        //updateStmt.setInt(2,transId);
                                        updateStmt.executeUpdate(); // Update the balance
                                    }

                                    // Commit transaction after successful operations
                                    connection.commit();
                                    JOptionPane.showMessageDialog(fr2, "Deposit Successful! New Balance: " + newBalance);

                                } else {
                                    // If no balance is found, handle the error gracefully
                                    JOptionPane.showMessageDialog(fr2, "Could not retrieve balance!");
                                    connection.rollback(); // Rollback transaction in case of failure
                                }

                            } catch (SQLException ex) {
                                // Handle SQL exceptions related to balance retrieval
                                connection.rollback(); // Rollback on error
                                JOptionPane.showMessageDialog(fr2, "Error retrieving balance: " + ex.getMessage());
                                ex.printStackTrace();
                            }

                        } else {
                            // Invalid card number or PIN
                            JOptionPane.showMessageDialog(fr2, "Invalid card number or PIN!");
                        }
                    }

                } catch (SQLException ex) {
                    // Handle database connection and SQL exceptions
                    try {
                        if (connection != null) {
                            connection.rollback(); // Rollback on any SQL exception
                        }
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace(); // Log rollback error
                    }
                    JOptionPane.showMessageDialog(fr2, "Database error: " + ex.getMessage());
                    ex.printStackTrace();
                } catch (Exception ex) {
                    // Handle other unexpected exceptions
                    JOptionPane.showMessageDialog(fr2, "An unexpected error occurred: " + ex.getMessage());
                    ex.printStackTrace();
                } finally {
                    // Ensure connection is closed
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace(); // Log connection close error
                    }
                }
            }

            private int generateUniqueTransactionId() {
                // Simple random generator for testing purposes, replace with more robust method in production
                return new Random().nextInt(10000); // You might want to use a UUID or auto-increment ID from DB
            }
        });






    //balance enquiry actionlistener

        balstate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel3.setVisible(false);
                panel6.setVisible(false);
                depositpanel.setVisible(false);
                passchangepanel.setVisible(false);
                balstatepanel.setVisible(false);
                savepanel.setVisible(false);

                fr.setVisible(false); // Hide the main frame
                balenqpanel.setVisible(true); // Show the balance inquiry panel

                String url = "jdbc:mysql://localhost:3306/atm"; // Database URL
                String user = "gopi"; // Database username
                String password = "gsai"; // Database password
                String sql1 = "SELECT customer_id FROM customers WHERE card_no=? AND pin=?";

                JFrame frame = new JFrame("BALANCE :");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);

                DefaultListModel<String> listModel = new DefaultListModel<>();
                JList<String> list = new JList<>(listModel);
                JScrollPane scrollPane = new JScrollPane(list);
                frame.add(scrollPane);
                frame.setVisible(true);

                String userCard = tf1.getText();
                String userPassword = new String(tf2.getPassword());

                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement ps1 = connection.prepareStatement(sql1)) {

                    ps1.setString(1, userCard);
                    ps1.setString(2, userPassword);
                    ResultSet rs1 = ps1.executeQuery();

                    if (rs1.next()) { // Check if a record was found
                        int customerId = rs1.getInt("customer_id");

                        String query = "SELECT * FROM transactions WHERE customer_id=?";
                        try (PreparedStatement st = connection.prepareStatement(query)) {
                            st.setInt(1, customerId);
                            ResultSet resultSet = st.executeQuery();

                            while (resultSet.next()) {
                                StringBuilder record = new StringBuilder();
                                int columnCount = resultSet.getMetaData().getColumnCount();
                                for (int i = 1; i <= columnCount; i++) {
                                    String columnName = resultSet.getMetaData().getColumnName(i);
                                    String value = resultSet.getString(i);
                                    record.append(columnName).append(": ").append(value).append("\n");
                                    if (i < columnCount) record.append(",  "); // Comma between fields
                                }
                                listModel.addElement(record.toString());
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid card number or PIN!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // password change action listener

        passchange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel3.setVisible(false);
                panel6.setVisible(false);
                depositpanel.setVisible(false);
                balenqpanel.setVisible(false);
                balstatepanel.setVisible(false);
                savepanel.setVisible(false);
                fr2.add(passchangepanel);
                passchangepanel.setVisible(true);


            }

        });
        password_enter.addActionListener(new ActionListener() {
            String url = "jdbc:mysql://localhost:3306/atm";
            String userr = "gopi";
            String passwordd = "gsai";

            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null; // Declare connection variable here
                try {
                    connection = DriverManager.getConnection(url, userr, passwordd);
                    connection.setAutoCommit(false);
                    System.out.println("Connection successful!");

                    String sql = "SELECT * FROM customers WHERE card_no=? AND pin=?";
                    String user = tf1.getText();
                    String password = new String(tf2.getPassword());

                    try (PreparedStatement ps = connection.prepareStatement(sql)) {
                        ps.setString(1, user);
                        ps.setString(2, password);
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            int customer_id = rs.getInt("customer_id");
                            String pin = rs.getString("pin");

                            String passwd = pass1.getText();
                            String passwd2 = pass2.getText();
                            String passwd3 = pass3.getText();

                            if (passwd.equals(pin)) {
                                if (passwd2.equals(passwd3)) {
                                    String sql2 = "UPDATE customers SET pin=? WHERE customer_id=?";
                                    try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
                                        ps2.setString(1, passwd3);
                                        ps2.setInt(2, customer_id);
                                        int rowsUpdated = ps2.executeUpdate();

                                        if (rowsUpdated > 0) {
                                            connection.commit();
                                            JOptionPane.showMessageDialog(fr2, "UPDATED SUCCESSFULLY");
                                        } else {
                                            JOptionPane.showMessageDialog(fr2, "UPDATE FAILED, PIN may be unchanged.");
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(fr2, "TWO PASSWORDS NOT MATCHED");
                                }
                            } else {
                                JOptionPane.showMessageDialog(fr2, "INVALID CURRENT PASSWORD");
                            }
                        } else {
                            JOptionPane.showMessageDialog(fr2, "No matching records found.");
                        }
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(fr2, "Database error: " + ex.getMessage());
                    if (connection != null) {
                        try {
                            connection.rollback();
                        } catch (SQLException rollbackEx) {
                            rollbackEx.printStackTrace();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(fr2, "An error occurred: " + ex.getMessage());
                } finally {
                    if (connection != null) {
                        try {
                            connection.close(); // Ensure the connection is closed
                        } catch (SQLException closeEx) {
                            closeEx.printStackTrace();
                        }
                    }
                }
            }
        });

        //balance statement actionlistener
        balenquiry.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           panel3.setVisible(false);
                                           panel6.setVisible(false);
                                           depositpanel.setVisible(false);
                                           balenqpanel.setVisible(false);
                                           // fr2.add(balstatepanel);
                                           passchangepanel.setVisible(false);
                                           savepanel.setVisible(false);
                                           balstatepanel.setVisible(true);

                                           String url = "jdbc:mysql://localhost:3306/atm";
                                           String userr = "gopi";
                                           String passwordd = "gsai";

                                           String userCard = tf1.getText();
                                           String userPassword = new String(tf2.getPassword());
                                           String sql1 = "SELECT customer_id FROM customers WHERE card_no=? AND pin=?";

                                           try{
                                                                                                                                                                Connection connection = DriverManager.getConnection(url, userr, passwordd);
                                                PreparedStatement ps1 = connection.prepareStatement(sql1);


                                               ps1.setString(1, userCard);
                                               ps1.setString(2, userPassword);
                                               ResultSet rs = ps1.executeQuery();
                                              try {
                                                  if (rs.next()) {
                                                      int customer_id = rs.getInt("customer_id");
                                                      String sql = "select balance from customers where customer_id=?";
                                                      PreparedStatement ps = connection.prepareStatement(sql);
                                                      ps.setInt(1, customer_id);
                                                      ResultSet rs1 = ps.executeQuery();
                                                      if(rs1.next()) {
                                                          int balance = rs1.getInt("balance");
                                                          JOptionPane.showMessageDialog(fr2, "YOUR CURRENT BALANCE IS :" + balance);

                                                      }

                                                  } else {
                                                      JOptionPane.showMessageDialog(fr2, "credentials are invalid");
                                                  }
                                              }catch(Exception exx){
                                                  exx.printStackTrace();
                                                  JOptionPane.showMessageDialog(fr2, "Database error: " + exx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                                              }
                                           }catch(Exception ex){

                                               ex.printStackTrace();
                                               JOptionPane.showMessageDialog(fr2, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                           }
                                       }
                                   });


        //savings action listener
        saving.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel3.setVisible(false);
                panel6.setVisible(false);
                depositpanel.setVisible(false);
                balenqpanel.setVisible(false);
               // fr2.add(savepanel);
                passchangepanel.setVisible(false);
                balstatepanel.setVisible(false);
                savepanel.setVisible(true);



                        String url = "jdbc:mysql://localhost:3306/atm"; // Database URL
                        String user = "gopi"; // Database username
                        String password = "gsai"; // Database password
                        String sql1 = "SELECT customer_id FROM customers WHERE card_no=? AND pin=?";

                        JFrame frame = new JFrame("BALANCE :");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(400, 300);

                        DefaultListModel<String> listModel = new DefaultListModel<>();
                        JList<String> list = new JList<>(listModel);
                        JScrollPane scrollPane = new JScrollPane(list);
                        frame.add(scrollPane);
                        frame.setVisible(true);

                        String userCard = tf1.getText();
                        String userPassword = new String(tf2.getPassword());

                        try (Connection connection = DriverManager.getConnection(url, user, password);
                             PreparedStatement ps1 = connection.prepareStatement(sql1)) {

                            ps1.setString(1, userCard);
                            ps1.setString(2, userPassword);
                            ResultSet rs1 = ps1.executeQuery();

                            if (rs1.next()) { // Check if a record was found
                                int customerId = rs1.getInt("customer_id");

                                String query = "SELECT * FROM customers WHERE customer_id=?";
                                try (PreparedStatement st = connection.prepareStatement(query)) {
                                    st.setInt(1, customerId);
                                    ResultSet resultSet = st.executeQuery();

                                    while (resultSet.next()) {
                                        StringBuilder record = new StringBuilder();
                                        int columnCount = resultSet.getMetaData().getColumnCount();
                                        for (int i = 1; i <= columnCount; i++) {
                                            String columnName = resultSet.getMetaData().getColumnName(i);
                                            String value = resultSet.getString(i);
                                            record.append(columnName).append(": ").append(value).append("\n");
                                           // record.append(resultSet.getString(i));
                                            if (i < columnCount) record.append(", "); // Comma between fields
                                        }
                                        listModel.addElement(record.toString());
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid card number or PIN!", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });







        withdraw_b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"1");
            }
        });
        withdraw_b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"2");
            }
        });
        withdraw_b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"3");
            }
        });
        withdraw_b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"4");
            }
        });
        withdraw_b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"5");
            }
        });
        withdraw_b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"6");
            }
        });
        withdraw_b7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"7");
            }
        });
        withdraw_b8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"8");
            }
        });
        withdraw_b9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"9");
            }
        });
        withdraw_b0.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountwithdraw.setText(amountwithdraw.getText()+"0");
            }
        });
        withdraw_bclear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                String currentText=amountwithdraw.getText();
                if (currentText.length() > 0) {
                    String newText = currentText.substring(0, currentText.length() - 1);
                    amountwithdraw.setText(newText);
                }
            }
        });



        withdraw_benter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount;
                try {
                    amount = Double.parseDouble(amountwithdraw.getText());
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(fr2, "Invalid amount entered!");
                        return; // Exit if amount is invalid
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fr2, "Invalid amount entered!");
                    return; // Exit if input is invalid
                }

                String url = "jdbc:mysql://localhost:3306/atm"; // Database URL
                String user = "gopi"; // Database username
                String password = "gsai"; // Database password

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    connection.setAutoCommit(false); // Start transaction
                    System.out.println("Connection successful!");

                    String userCard = tf1.getText();
                    String userPassword = new String(tf2.getPassword());

                    String sql1 = "SELECT customer_id FROM customers WHERE card_no=? AND pin=?";
                    try (PreparedStatement ps1 = connection.prepareStatement(sql1)) {
                        ps1.setString(1, userCard);
                        ps1.setString(2, userPassword);
                        ResultSet rs1 = ps1.executeQuery();

                        if (rs1.next()) {
                            int customerId = rs1.getInt("customer_id");

                            // Fetch customer balance
                            String sql = "SELECT balance FROM customers WHERE customer_id = ?";
                            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                                ps.setInt(1, customerId);
                                ResultSet rs = ps.executeQuery();

                                if (rs.next()) {
                                    double balance = rs.getDouble("balance");
                                    if (balance < amount) {
                                        JOptionPane.showMessageDialog(fr2, "INSUFFICIENT BALANCE");
                                        return; // Exit if insufficient balance
                                    }

                                    // Calculate new balance
                                    double newBalance = balance - amount;

                                    // Insert transaction record
                                    String query = "INSERT INTO transactions (transaction_id, customer_id, transaction_type, amount) VALUES (?, ?, ?, ?)";
                                    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                                        int transId = generateUniqueTransactionId(); // Use a method to generate unique IDs
                                        pstmt.setInt(1, transId);
                                        pstmt.setInt(2, customerId);
                                        pstmt.setString(3, "WITHDRAW");
                                        pstmt.setDouble(4, amount);
                                       // pstmt.setDouble(5, newBalance);
                                        pstmt.executeUpdate(); // Use executeUpdate for INSERT
                                    }

                                    // Update the balance in the transactions table
                                    String updateBalanceSQL = "UPDATE customers SET balance = ? WHERE customer_id = ?";
                                    try (PreparedStatement updateStmt = connection.prepareStatement(updateBalanceSQL)) {
                                        updateStmt.setDouble(1, newBalance);
                                        updateStmt.setInt(2, customerId);
                                        updateStmt.executeUpdate(); // Update the balance
                                    }

                                    connection.commit(); // Commit transaction
                                    JOptionPane.showMessageDialog(fr2, "WITHDRAW Successful! New Balance: " + newBalance);
                                } else {
                                    JOptionPane.showMessageDialog(fr2, "Could not retrieve balance!");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(fr2, "Invalid card number or PIN!");
                        }
                    }
                    try {
                        connection.rollback(); // Rollback transaction on error
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace(); // Log rollback error
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Log the error details in production
                    JOptionPane.showMessageDialog(fr2, "Database error: " + ex.getMessage());

                } catch (Exception ex) {
                    ex.printStackTrace(); // Handle any other exceptions
                    JOptionPane.showMessageDialog(fr2, "An error occurred: " + ex.getMessage());
                }
            }

            private int generateUniqueTransactionId() {
                // Implement a method to generate a unique transaction ID, e.g., from the database or using UUID.
                return new Random().nextInt(10000); // Change this to a more robust ID generation
            }
        });


        deposit_b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"1");
            }
        });
        deposit_b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"2");
            }
        });
        deposit_b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"3");
            }
        });
        deposit_b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"4");
            }
        });
        deposit_b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"5");
            }
        });
        deposit_b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"6");
            }
        });
        deposit_b7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"7");
            }
        });
        deposit_b8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"8");
            }
        });
        deposit_b9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"9");
            }
        });
        deposit_b0.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                amountdeposit.setText(amountdeposit.getText()+"0");
            }
        });
        deposit_bclear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                String currentText=amountdeposit.getText();
                if (currentText.length() > 0) {
                    String newText = currentText.substring(0, currentText.length() - 1);
                    amountdeposit.setText(newText);
                }
            }
        });



        fr.setVisible(true);
    }

    public static void main(String[] args) {
        atm ob = new atm();
    }
}