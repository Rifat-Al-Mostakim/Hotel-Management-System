import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EmployeeLogin extends JFrame implements ActionListener {

    private ImageIcon icon, icon2;
    private Container c;// container to change background color
    private JLabel id, password, bgpic, headTitle;
    private JTextField tf1;
    private JButton login, clear, back;
    private JPasswordField pf;
    private Font f1, f2;
    private Cursor cur;
    public int i;

    EmployeeLogin() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 680);
        this.setLocationRelativeTo(null);
        this.setTitle("Employee Login");
        initComponents();
    }

    private void initComponents() {

        // this part changes the bg color
        c = this.getContentPane();
        c.setLayout(null);

        // font for head title
        f1 = new Font("modern", Font.BOLD, 30);
        // font for,username,password,textfield,paaswordfield
        f2 = new Font("Arial", Font.BOLD, 18);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("IMG/icon1.png"));
        this.setIconImage(icon.getImage());

        // creates head title jlabel

        // this part creates username JLabel
        headTitle = new JLabel();
        headTitle.setText("Employee Login");
        headTitle.setBounds(390, 170, 500, 50);
        headTitle.setFont(f1);
        headTitle.setForeground(Color.WHITE);
        headTitle.setToolTipText("enter your ID");
        c.add(headTitle);

        // this part creates username JLabel
        id = new JLabel();
        id.setText("Enter ID");
        id.setBounds(310, 230, 150, 30);
        id.setFont(f2);
        id.setForeground(Color.WHITE);
        id.setToolTipText("enter your ID");
        c.add(id);

        // text field
        tf1 = new JTextField();
        tf1.setBounds(475, 230, 200, 30);
        tf1.setFont(f2);
        c.add(tf1);

        // this part creates password JLabel

        password = new JLabel("Enter Password");
        password.setBounds(310, 280, 150, 30);
        password.setFont(f2);
        password.setForeground(Color.WHITE);

        password.setToolTipText("Please enter your password carefully");
        c.add(password);

        // password field
        pf = new JPasswordField();
        pf.setBounds(475, 280, 200, 30);
        pf.setFont(f2);
        pf.setEchoChar('*');
        c.add(pf);

        // cursor for button
        cur = new Cursor(Cursor.HAND_CURSOR);

        // Login button
        login = new JButton("Login");
        login.setBounds(380, 340, 100, 30);
        login.setFont(f2);
        login.setCursor(cur);
        c.add(login);
        login.addActionListener(this);

        // clear button
        clear = new JButton("Clear");
        clear.setBounds(505, 340, 100, 30);
        clear.setFont(f2);
        clear.setCursor(cur);
        c.add(clear);
        clear.addActionListener(this);

        // back button
        back = new JButton("Back");
        back.setBounds(442, 380, 100, 30);
        back.setFont(f2);
        clear.setCursor(cur);
        c.add(back);
        back.addActionListener(this);

        // add background picture...JLabel er maddhome ekta pic add korbo then seta frame er size onujai dibo
        icon2 = new ImageIcon("IMG/a5.jpg");// pic->ImageIcon->JLabel
        bgpic = new JLabel("", icon2, JLabel.CENTER);
        bgpic.setBounds(0, 0, 1000, 680);

        c.add(bgpic);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(login)) {
            String id = tf1.getText();
            String password = pf.getText();

            if (id.equals("admin1") && password.equals("admin1")) {
                dispose();

                Employee1 frame = new Employee1();
                frame.setVisible(true);
            } else if (id.equals("admin2") && password.equals("admin2")) {
                dispose();

                Employee2 frame = new Employee2();
                frame.setVisible(true);
            }

            else {
                JOptionPane.showMessageDialog(null, "Incorrect password or phone number");
            }
        } else if (e.getSource().equals(clear)) {
            tf1.setText("");
            pf.setText("");
        }

        // back button
        else {
            this.dispose();
            this.setVisible(false);
            new Start().setVisible(true);
        }

    }
}