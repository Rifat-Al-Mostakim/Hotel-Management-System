import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener {

    private ImageIcon icon, icon2;
    // A container provides a space where a component can be located
    private Container c;
    private JLabel welcome, bgpic;
    private JButton checkin, customer, checkout, admin;
    private JScrollBar scroll;
    private Font f1, f2;
    private Cursor cur;

    Start() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 680);
        this.setLocationRelativeTo(null);
        this.setTitle("HOTEL TRANSYLVANIA");
        initComponents();// method
    }

    public void initComponents() {
        // this part changes the bg color
        c = this.getContentPane();
        c.setLayout(null);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("IMG/icon1.png"));
        this.setIconImage(icon.getImage());

        // fontstyle for welcome message
        f1 = new Font("modern", Font.BOLD, 30);

        // fontstyle for button
        f2 = new Font("Arial", Font.BOLD, 16);
        // welcome message

        welcome = new JLabel("Welcome to the Hotel Transylvania");
        welcome.setBounds(310, 150, 650, 35);
        welcome.setFont(f1);
        c.add(welcome);
        welcome.setForeground(Color.RED);

        // cursor for button
        cur = new Cursor(Cursor.HAND_CURSOR);
        // newCustomer button

        checkin = new JButton("Check-in(receptionist login)");
        checkin.setBounds(310, 200, 500, 50);
        checkin.setFont(f2);
        checkin.setCursor(cur);
        c.add(checkin);
        checkin.addActionListener(this);

        // Customer button
        customer = new JButton("Customer");
        customer.setBounds(310, 260, 500, 50);
        customer.setFont(f2);
        customer.setCursor(cur);
        c.add(customer);
        customer.addActionListener(this);

        // checkout button
        checkout = new JButton("Employee");
        checkout.setBounds(310, 320, 500, 50);
        checkout.setFont(f2);
        checkout.setCursor(cur);
        c.add(checkout);
        checkout.addActionListener(this);
        
        // add background picture...JLabel er maddhome ekta pic add korbo then seta frame er size onujai dibo
        icon2 = new ImageIcon("IMG/abc1.png");// pic->ImageIcon->JLabel
        bgpic = new JLabel("", icon2, JLabel.CENTER);
        bgpic.setBounds(0, 0, 1000, 680);
        c.add(bgpic);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(checkin)) {
            dispose();
            AdminLogin admin = new AdminLogin();
            admin.setVisible(true);
        } else if (e.getSource().equals(customer)) {
            dispose();
            MemberLogin2 member = new MemberLogin2();
            member.setVisible(true);
        } else {

            dispose();
            EmployeeLogin employee = new EmployeeLogin();
            employee.setVisible(true);
        }

    }

    public static void main(String[] args) {
        Start frame = new Start();
        frame.setVisible(true);
    }

}