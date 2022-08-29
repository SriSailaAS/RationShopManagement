import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class PriceList implements ActionListener {

    Color c = new Color(255, 102, 102);
    JFrame f2 = new JFrame();
    PriceList() {

        f2.getContentPane().setBackground(c);

        f2 = new JFrame("PRICE LIST");
        String data[][] = {
            {
                "001",
                "SUGAR",
                "35"
            },
            {
                "002",
                "RICE",
                "20"
            },
            {
                "003",
                "TEA",
                "30"
            },
            {
                "004",
                "WHEAT",
                "50"
            },
            {
                "005",
                "KEROSENE",
                "25"
            },
            {
                "006",
                "OIL",
                "30"
            },
            {
                "007",
                "PULSES",
                "40"
            },
            {
                "008",
                "SALT",
                "35"
            }
        };
        String column[] = {
            "ID",
            "STOCKS",
            "PRICE"
        };
        JTable jt = new JTable(data, column);
        jt.setBounds(50, 70, 400, 500);
        JScrollPane sp = new JScrollPane(jt);
        f2.add(sp);
        f2.setSize(400, 500);
    }
    public void actionPerformed(ActionEvent e) {}
}
class Registration extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6, tf7;
    JButton btn1, btn2;
    JPasswordField p1, p2;
    Registration() {
        setSize(700, 700);
        setLayout(null);
        setTitle("CUSTOMER DETAILS UPDATION");
        l1 = new JLabel("Updation of the Details of the customer ");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Name: ");
        l2.setFont(new Font("Serif", Font.PLAIN, 16));
        l3 = new JLabel("Email-ID:");
        l3.setFont(new Font("Serif", Font.PLAIN, 16));

        l4 = new JLabel("Create Password:");
        l4.setFont(new Font("Serif", Font.PLAIN, 16));

        l5 = new JLabel("Confirm Password:");
        l5.setFont(new Font("Serif", Font.PLAIN, 16));

        l6 = new JLabel("Country:");
        l6.setFont(new Font("Serif", Font.PLAIN, 16));

        l7 = new JLabel("State:");
        l7.setFont(new Font("Serif", Font.PLAIN, 16));
        l8 = new JLabel("Phone No:");
        l8.setFont(new Font("Serif", Font.PLAIN, 16));

        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        btn1.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(btn1);
        add(btn2);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {

            String s1 = tf1.getText();
            String s2 = tf2.getText();
            char[] s3 = p1.getPassword();
            char[] s4 = p2.getPassword();
            String s8 = new String(s3);
            String s9 = new String(s4);
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();
            if (s8.equals(s9)) {
                try {
                    FileWriter w = new FileWriter("Customerdetails.txt", true);
                    w.write("\nName: " + s1 + "\n");
                    w.write("Email id: " + s2 + "\n");
                    w.write("Password : " + s3 + "\n");
                    w.write("country " + s5 + "\n");
                    w.write("state : " + s6 + "\n");
                    w.write("phone number : " + s7 + "\n");
                    w.close();
                } catch (Exception e3) {
                    System.out.println("Exception during deserialization: " + e3);
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
            }
        } else {
            tf1.setText("");
            tf2.setText("");
            p1.setText("");
            p2.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
        }
    }
}
class CustomerValidation {
    long r, s = 0;
    public int checkid(long num) {
        while (num > 0) {
            r = num % 10;
            num = num / 10;
            s = s + r;
        }
        if (s % 2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
class CustomerIdCheck implements ActionListener {

    Color c = new Color(102, 255, 102);
    JFrame f3 = new JFrame("Customer ID validation");
    CustomerValidation cv = new CustomerValidation();
    Registration r = new Registration();
    String s1;
    long customerid;
    JTextField t = new JTextField();
    CustomerIdCheck() {




        JLabel l2 = new JLabel("Enter the customer ID:");

        l2.setFont(new Font("Algerian", Font.PLAIN, 20));
        JButton jb = new JButton("OK");
        t.setBounds(500, 100, 180, 30);
        l2.setBounds(100, 100, 300, 50);
        jb.setBounds(175, 200, 120, 30);
        f3.add(l2);
        f3.add(t);
        f3.add(jb);
        f3.setLayout(null);
        f3.setSize(800, 600);
        jb.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        s1 = t.getText();
        customerid = Long.parseLong(s1);
        if (cv.checkid(customerid) == 1)
            r.setVisible(true);
        else
            JOptionPane.showMessageDialog(f3, "THE CUSTOMER ID IS INVALID");
    }

}
class UpdateStocks implements ActionListener {

    Color c = new Color(255, 102, 102);
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JFrame f4 = new JFrame();
    Font fo = new Font("Serif", Font.PLAIN, 16);

    UpdateStocks() {
        f4.setTitle("UPDATE STOCKS");
        l1 = new JLabel("SUGAR :");
        l1.setFont(fo);
        l1.setBounds(150, 100, 170, 40);
        tf1 = new JTextField();
        tf1.setBounds(300, 100, 170, 30);
        l2 = new JLabel("RICE:");
        l2.setFont(fo);

        l2.setBounds(150, 150, 170, 40);
        tf2 = new JTextField();
        tf2.setBounds(300, 150, 170, 30);
        l3 = new JLabel("TEA:");
        l3.setBounds(150, 200, 170, 40);
        l3.setFont(fo);

        tf3 = new JTextField();
        tf3.setBounds(300, 200, 170, 30);


        l4 = new JLabel("WHEAT:");
        l4.setBounds(150, 250, 170, 40);
        l4.setFont(fo);

        tf4 = new JTextField();
        tf4.setBounds(300, 250, 170, 30);
        l5 = new JLabel("KEROSENE:");
        l5.setBounds(150, 300, 170, 40);
        l5.setFont(fo);

        tf5 = new JTextField();
        tf5.setBounds(300, 300, 170, 30);
        l6 = new JLabel("OIL:");
        l6.setBounds(150, 350, 170, 40);
        l6.setFont(fo);

        tf6 = new JTextField();
        tf6.setBounds(300, 350, 170, 30);
        l7 = new JLabel("PULSES:");
        l7.setBounds(150, 400, 170, 40);
        l7.setFont(fo);

        tf7 = new JTextField();
        tf7.setBounds(300, 400, 170, 30);
        l8 = new JLabel("SALT:");
        l8.setBounds(150, 450, 170, 40);
        l8.setFont(fo);

        tf8 = new JTextField();
        tf8.setBounds(300, 450, 170, 30);
        l9 = new JLabel("Update The Quantity Of Each Stocks");
        l9.setFont(new Font("Algerian", Font.BOLD, 40));
        l9.setBounds(75, 25, 850, 50);
        b1 = new JButton("Submit");
        b1.setBounds(150, 550, 90, 40);
        b1.addActionListener(this);
        b2 = new JButton("Reset");
        b2.setBounds(350, 550, 90, 40);
        b2.addActionListener(this);
        f4.add(l1);
        f4.add(tf1);
        f4.add(l2);
        f4.add(tf2);
        f4.add(l3);
        f4.add(tf3);
        f4.add(l4);
        f4.add(tf4);
        f4.add(l5);
        f4.add(tf5);
        f4.add(l6);
        f4.add(tf6);
        f4.add(l7);
        f4.add(tf7);
        f4.add(l8);
        f4.add(tf8);
        f4.add(l9);
        f4.add(b1);
        f4.add(b2);
        f4.setSize(1000, 1100);
        f4.setLayout(null);
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str == "Submit") {
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            String s4 = tf4.getText();
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();
            String s8 = tf8.getText();
            try {
                Stocks st = new Stocks(s1, s2, s3, s4, s5, s6, s7, s8);
                FileOutputStream fos = new FileOutputStream("stockdetails.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(st);
                oos.flush();
                oos.close();
            } catch (IOException e1) {
                System.out.println("Exception during serialization: " + e1);
                System.exit(0);
            }
            try {
                Stocks st1;
                FileInputStream fis = new FileInputStream("stockdetails.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                st1 = (Stocks) ois.readObject();
                System.out.println(st1);
                ois.close();
                FileWriter w = new FileWriter("Stocksdetails.txt", true);
                w.write("\nSugar: " + s1 + "\n");
                w.write("Rice: " + s2 + "\n");
                w.write("Tea : " + s3 + "\n");
                w.write("Wheat: " + s4 + "\n");
                w.write("Kerosene " + s5 + "\n");
                w.write("oil : " + s6 + "\n");
                w.write("pulses : " + s7 + "\n");
                w.write("salt : " + s8 + "\n");
                w.close();
            } catch (Exception e2) {
                System.out.println("Exception during deserialization: " + e2);
                System.exit(0);
            }
            tf1.setText(null);
            tf2.setText(null);
            tf3.setText(null);
            tf4.setText(null);
            tf5.setText(null);
            tf6.setText(null);
            tf7.setText(null);
            tf8.setText(null);
        } else {
            tf1.setText(null);
            tf2.setText(null);
            tf3.setText(null);
            tf4.setText(null);
            tf5.setText(null);
            tf6.setText(null);
            tf7.setText(null);
            tf8.setText(null);
        }
    }
}
class Stocks implements Serializable {
    String sugar;
    String rice;
    String tea;
    String wheat;
    String kerosene;
    String oil;
    String pulses;
    String salt;
    Stocks(String sugar, String rice, String tea, String wheat, String kerosene, String oil, String pulses, String salt) {
        this.sugar = sugar;
        this.rice = rice;
        this.tea = tea;
        this.wheat = wheat;
        this.kerosene = kerosene;
        this.oil = oil;
        this.pulses = pulses;
        this.salt = salt;
    }
    public String toString() {
        return "The updated stocks are :\n SUGAR : " + sugar + "\nRICE: " + rice + "\nTEA: " + tea +
            "\nWHEAT: " + wheat + "\nKEROSENE : " + kerosene +
            "\nOIL: " + oil + "\nPULSES: " + pulses + "\nSALT: " + salt;
    }
}
class MainMenu implements ActionListener {
    CustomerIdCheck CID = new CustomerIdCheck();
    PriceList n = new PriceList();
    Color c = new Color(255, 102, 102);
    UpdateStocks us = new UpdateStocks();
    JFrame f = new JFrame("Main Menu");
    JRadioButton rb1, rb2, rb3;
    JButton b;
    MainMenu() {
        f.getContentPane().setBackground(c);
        JLabel l = new JLabel("RATION STOCK MANAGEMENT SYSTEM");
        l.setBounds(200, 200, 1000, 100);
        l.setForeground(Color.black);
        l.setFont(new Font("Algerian", Font.BOLD, 50));
        rb1 = new JRadioButton("PRICE LIST");
        rb1.setBounds(300, 300, 400, 30);
        rb1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        rb1.setForeground(Color.black);
        rb1.setBackground(c);
        rb2 = new JRadioButton("CUSTOMER ID VALIDATION");
        rb2.setBounds(300, 400, 800, 30);
        rb2.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        rb2.setForeground(Color.black);
        rb2.setBackground(c);

        rb3 = new JRadioButton("UPDATE STOCKS");
        rb3.setBounds(300, 500, 300, 30);
        rb3.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        rb3.setForeground(Color.black);
        rb3.setBackground(c);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        b = new JButton("OK");
        b.setBounds(600, 620, 80, 30);
        b.addActionListener(this);
        f.add(rb1);
        f.add(rb2);
        f.add(rb3);
        f.add(b);
        f.add(l);
        f.setSize(1500, 1500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()) {
            n.f2.setVisible(true);
        }
        if (rb2.isSelected()) {

            CID.f3.setVisible(true);
        }
        if (rb3.isSelected()) {
            us.f4.setVisible(true);
        }
    }
    public static void main(String args[]) throws Exception {
        new MainMenu();
    }
}
