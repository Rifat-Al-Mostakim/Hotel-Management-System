import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class memberPanel extends JFrame implements ActionListener {
    private ImageIcon icon, icon2, image;
    private Container c;
    private JTable table;
    private String path;
    private DefaultTableModel model;

    private JLabel titleLabel, fnLabel, lnLabel, phoneLabel, ocpLabel, gndLabel, nidLabel,membShowLabel, checkInTimeLabel, checkInTimeShowLabel, daysLabel, roomsLabel, rtLabel, rnLabel, adLabel, arLabel, rbLabel, rbShowLabel, paidLabel, paidShowLabel, dueLabel, dueShowLabel, passLabel, bgpic, billShowLabel, fishShowLabel, beefShowLabel, muttonShowLabel, duckShowLabel,riceShowLabel, apShowLabel, mkShowLabel, ltShowLabel, ckShowLabel, ccShowLabel, tShowLabel, cShowLabel, ojShowLabel, mjShowLabel, csShowLabel, fishBillShowLabel, beefBillShowLabel, muttonBillShowLabel, duckBillShowLabel, riceBillShowLabel, apBillShowLabel, mkBillShowLabel, ltBillShowLabel, ckBillShowLabel, ccBillShowLabel, tBillShowLabel, cBillShowLabel, ojBillShowLabel,mjBillShowLabel, csBillShowLabel, foodBillShowLabel, foodBill;

    private JButton fishBillButton, beefBillButton, muttonBillButton, duckBillButton,riceBillButton, apBillButton, mkBillButton, ltBillButton, ckBillButton, ccBillButton,  tBillButton, cBillButton, ojBillButton, mjBillButton, csBillButton, fishCancelButton, beefCancelButton, muttonCancelButton, duckCancelButton,riceCancelButton,  apCancelButton, mkCancelButton, ltCancelButton, ckCancelButton, ccCancelButton, tCancelButton, cCancelButton, ojCancelButton, mjCancelButton, csCancelButton, paymentButton, backButton, billButton;

    private JTextField fnTf, lnTf, phoneTf, ocpTf, gndTf, nidTf, membTf, checkInTimeTf, daysTf, roomsTf, rtTf, rnTf, adTf, arTf, rbTf, paidTf, dueTf, passTf;

    private JSpinner fishSpinner, beefSpinner, muttonSpinner, duckSpinner, riceSpinner,apSpinner, mkSpinner, ltSpinner, ckSpinner, ccSpinner, tSpinner, cSpinner, ojSpinner, mjSpinner, csSpinner;
    
    private JCheckBox fishCheckBox, beefCheckBox, muttonCheckBox, duckCheckBox, riceCheckBox, applePieCheckBox, malaiKulfiCheckBox, lemonTartCheckBox, coconutKheerCheckBox, cupCakeCheckBox, tCheckBox, cCheckBox, ojCheckBox, mjCheckBox, csCheckBox;

    private SpinnerNumberModel valueOfFish, valueOfBeef, valueOfMutton, valueOfduck, valueOfRice, valueOfAp, valueOfMk, valueOfLt, valueOfCk, valueOfCc, valueOfT, valueOfC, valueOfOj, valueOfMj, valueOfCs;

    private JScrollBar scroll;
    private Font f1, font, font2;
    private Cursor cur;

    public String[] cols = { "First name", "Last name", "Occupation", "Gender", "NID", "Days", "Room no", "Room bill", "Paid", "Due", "Phone number", "Password" };

    memberPanel(String path) {
        this.path = path;
        initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 680);
        this.setLocationRelativeTo(null);
        this.setTitle("Customer Panel");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("IMG/icon1.png"));
        this.setIconImage(icon.getImage());

        Font font = new Font("Arial", Font.BOLD, 16);

        titleLabel = new JLabel("Customer Profile Panel:");
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(10, 10, 250, 50);
        c.add(titleLabel);

        // table
        table = new JTable();

        TableReader tt5 = new TableReader();
        model = new DefaultTableModel();
        File f = new File(path);
        if (f.length() != 0) {
            model = tt5.createModel(path);
        }
        model.setColumnIdentifiers(cols);
        table.setModel(model);

        // JLabels Start
        fnLabel = new JLabel("First Name");
        fnLabel.setBounds(10, 60, 140, 30);
        fnLabel.setFont(font);
        fnLabel.setForeground(Color.WHITE);
        c.add(fnLabel);

        fnTf = new JTextField();
        fnTf.setBounds(110, 60, 200, 30);
        fnTf.setFont(font);
        c.add(fnTf);

        lnLabel = new JLabel("Last Name ");
        lnLabel.setBounds(10, 110, 140, 30);
        lnLabel.setFont(font);
        lnLabel.setForeground(Color.WHITE);
        c.add(lnLabel);

        lnTf = new JTextField();
        lnTf.setBounds(110, 110, 200, 30);
        lnTf.setFont(font);
        c.add(lnTf);

        // Phone
        phoneLabel = new JLabel("Phone ");
        phoneLabel.setBounds(10, 160, 140, 30);
        phoneLabel.setFont(font);
        phoneLabel.setForeground(Color.WHITE);
        c.add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(110, 160, 200, 30);
        phoneTf.setFont(font);
        c.add(phoneTf);

        // Occupation
        ocpLabel = new JLabel("Occupation");
        ocpLabel.setBounds(10, 210, 140, 30);
        ocpLabel.setFont(font);
        ocpLabel.setForeground(Color.WHITE);
        c.add(ocpLabel);

        ocpTf = new JTextField();
        ocpTf.setBounds(110, 210, 200, 30);
        ocpTf.setFont(font);
        c.add(ocpTf);

        // Gender
        gndLabel = new JLabel("Gender");
        gndLabel.setBounds(10, 260, 140, 30);
        gndLabel.setFont(font);
        gndLabel.setForeground(Color.WHITE);
        c.add(gndLabel);

        gndTf = new JTextField();
        gndTf.setBounds(110, 260, 200, 30);
        gndTf.setFont(font);
        c.add(gndTf);

        // Nid Number
        nidLabel = new JLabel("Nid Number");
        nidLabel.setBounds(10, 310, 140, 30);
        nidLabel.setFont(font);
        nidLabel.setForeground(Color.WHITE);
        c.add(nidLabel);

        nidTf = new JTextField();
        nidTf.setBounds(110, 310, 200, 30);
        nidTf.setFont(font);
        c.add(nidTf);

        daysLabel = new JLabel("Days");
        daysLabel.setBounds(10, 360, 150, 30);
        daysLabel.setFont(font);
        daysLabel.setForeground(Color.WHITE);
        c.add(daysLabel);

        daysTf = new JTextField();
        daysTf.setBounds(110, 360, 200, 30);
        daysTf.setFont(font);
        c.add(daysTf);

        rnLabel = new JLabel("Room No");
        rnLabel.setBounds(10, 410, 150, 30);
        rnLabel.setFont(font);
        rnLabel.setForeground(Color.WHITE);
        c.add(rnLabel);

        rnTf = new JTextField();
        rnTf.setBounds(110, 410, 200, 30);
        rnTf.setFont(font);
        c.add(rnTf);

        rbLabel = new JLabel("Room Bill");
        rbLabel.setBounds(10, 460, 150, 30);
        rbLabel.setFont(font);
        rbLabel.setForeground(Color.WHITE);
        c.add(rbLabel);

        rbTf = new JTextField();
        rbTf.setBounds(110, 460, 200, 30);
        rbTf.setFont(font);
        c.add(rbTf);

        paidLabel = new JLabel("Paid Amount");
        paidLabel.setBounds(10, 510, 150, 30);
        paidLabel.setFont(font);
        paidLabel.setForeground(Color.WHITE);
        c.add(paidLabel);

        paidTf = new JTextField();
        paidTf.setBounds(110, 510, 200, 30);
        paidTf.setFont(font);
        c.add(paidTf);

        dueLabel = new JLabel("Due Amount");
        dueLabel.setBounds(10, 560, 150, 30);
        dueLabel.setFont(font);
        dueLabel.setForeground(Color.WHITE);
        c.add(dueLabel);

        dueTf = new JTextField();
        dueTf.setBounds(110, 560, 200, 30);
        dueTf.setFont(font);
        c.add(dueTf);

        passLabel = new JLabel("Password");
        passLabel.setBounds(10, 610, 150, 30);
        passLabel.setFont(font);
        passLabel.setForeground(Color.WHITE);
        c.add(passLabel);

        passTf = new JTextField();
        passTf.setBounds(110, 610, 200, 30);
        passTf.setFont(font);
        c.add(passTf);

        // JLabels End

        // JTextField Start
        String f_name = model.getValueAt(0, 0).toString();
        String l_name = model.getValueAt(0, 1).toString();

        String ocp = model.getValueAt(0, 2).toString();
        String gnd = model.getValueAt(0, 3).toString();
        String nid = model.getValueAt(0, 4).toString();
        String days = model.getValueAt(0, 5).toString();
        String r_no = model.getValueAt(0, 6).toString();
        String r_bill = model.getValueAt(0, 7).toString();
        String paid = model.getValueAt(0, 8).toString();
        String due = model.getValueAt(0, 9).toString();
        String phone = model.getValueAt(0, 10).toString();
        String pass = model.getValueAt(0, 11).toString();

        fnTf.setText(f_name);
        lnTf.setText(l_name);

        ocpTf.setText(ocp);

        gndTf.setText(gnd);
        nidTf.setText(nid);
        daysTf.setText(days);
        rnTf.setText(r_no);
        rbTf.setText(r_bill);
        paidTf.setText(paid);
        dueTf.setText(due);
        phoneTf.setText(phone);
        passTf.setText(pass);

      
        fnTf.setEditable(false);
        lnTf.setEditable(false);
        ocpTf.setEditable(false);
        gndTf.setEditable(false);
        nidTf.setEditable(false);
        daysTf.setEditable(false);
        rnTf.setEditable(false);
        rbTf.setEditable(false);
        paidTf.setEditable(false);
        dueTf.setEditable(false);
        phoneTf.setEditable(false);
        passTf.setEditable(false);

        fnTf.setBackground(Color.WHITE);
        lnTf.setBackground(Color.WHITE);
        ocpTf.setBackground(Color.WHITE);

        gndTf.setBackground(Color.WHITE);
        nidTf.setBackground(Color.WHITE);
        daysTf.setBackground(Color.WHITE);
        rnTf.setBackground(Color.WHITE);
        rbTf.setBackground(Color.WHITE);
        paidTf.setBackground(Color.WHITE);
        dueTf.setBackground(Color.WHITE);
        phoneTf.setBackground(Color.WHITE);
        passTf.setBackground(Color.WHITE);

        // JTextField End
        Font font5 = new Font("Arial", Font.BOLD, 20);
        JLabel menu = new JLabel("Food Menu");
        menu.setBounds(410, 70, 200, 30);
        menu.setFont(font5);
        menu.setForeground(Color.WHITE);
        c.add(menu);

        // Food========order//
        JLabel meals = new JLabel("Meals");
        meals.setBounds(410, 110, 200, 20);
        meals.setFont(font);
        meals.setForeground(Color.WHITE);
        c.add(meals);

        fishCheckBox = new JCheckBox("Fish(500tk)");
        fishCheckBox.setBounds(410, 130, 200, 20);
        fishCheckBox.setFont(font);
        fishCheckBox.setBackground(Color.WHITE);
        // fishCheckBox.setBackground(Color.BLUE);
        // male.setSelected(true);// run korar por first ei auto male select thkbe
        c.add(fishCheckBox);
        beefCheckBox = new JCheckBox("Beef(700tk)");
        beefCheckBox.setBounds(410, 150, 200, 20);
        beefCheckBox.setFont(font);
        beefCheckBox.setBackground(Color.WHITE);
        // beefCheckBox.setBackground(Color.BLUE);
        // male.setSelected(true);// run korar por first ei auto male select thkbe
        c.add(beefCheckBox);

        muttonCheckBox = new JCheckBox("Mutton(900tk)");
        muttonCheckBox.setBounds(410, 170, 200, 20);
        muttonCheckBox.setFont(font);
        muttonCheckBox.setBackground(Color.WHITE);
        // muttonCheckBox.setBackground(Color.BLUE);
        // male.setSelected(true);// run korar por first ei auto male select thkbe
        c.add(muttonCheckBox);

        duckCheckBox = new JCheckBox("duck(1000tk)");
        duckCheckBox.setBounds(410, 190, 200, 20);
        duckCheckBox.setFont(font);
        duckCheckBox.setBackground(Color.WHITE);
        // muttonCheckBox.setBackground(Color.BLUE);
        // male.setSelected(true);// run korar por first ei auto male select thkbe
        c.add(duckCheckBox);

        riceCheckBox = new JCheckBox("Rice(100tk)");
        riceCheckBox.setBounds(410, 210, 200, 20);
        riceCheckBox.setFont(font);
        riceCheckBox.setBackground(Color.WHITE);

        c.add(riceCheckBox);

        valueOfFish = new SpinnerNumberModel(1, 0, 1000, 1);
        fishSpinner = new JSpinner(valueOfFish);
        fishSpinner.setBounds(643, 130, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(fishSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        fishShowLabel = new JLabel("1");
        fishShowLabel.setBounds(610, 130, 33, 20);
        fishShowLabel.setOpaque(true);
        fishShowLabel.setBackground(Color.WHITE);
        fishShowLabel.setFont(font);
        c.add(fishShowLabel);
        fishSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = fishSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                fishShowLabel.setText("" + intNumber);

            }

        });

        valueOfBeef = new SpinnerNumberModel(1, 1, 1000, 1);
        beefSpinner = new JSpinner(valueOfBeef);
        beefSpinner.setBounds(643, 150, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(beefSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        beefShowLabel = new JLabel("1");
        beefShowLabel.setBounds(610, 150, 33, 20);
        beefShowLabel.setOpaque(true);
        beefShowLabel.setBackground(Color.WHITE);
        beefShowLabel.setFont(font);
        c.add(beefShowLabel);
        beefSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = beefSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                beefShowLabel.setText("" + intNumber);

            }

        });

        valueOfMutton = new SpinnerNumberModel(1, 1, 1000, 1);
        muttonSpinner = new JSpinner(valueOfMutton);
        muttonSpinner.setBounds(643, 170, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(muttonSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        muttonShowLabel = new JLabel("1");
        muttonShowLabel.setBounds(610, 170, 33, 20);
        muttonShowLabel.setOpaque(true);
        muttonShowLabel.setBackground(Color.WHITE);
        muttonShowLabel.setFont(font);
        c.add(muttonShowLabel);
        muttonSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = muttonSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                muttonShowLabel.setText("" + intNumber);

            }

        });

        valueOfduck = new SpinnerNumberModel(1, 1, 1000, 1);
        duckSpinner = new JSpinner(valueOfduck);
        duckSpinner.setBounds(643, 190, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(duckSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        duckShowLabel = new JLabel("1");
        duckShowLabel.setBounds(610, 190, 33, 20);
        duckShowLabel.setOpaque(true);
        duckShowLabel.setBackground(Color.WHITE);
        duckShowLabel.setFont(font);
        c.add(duckShowLabel);
        duckSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = duckSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                duckShowLabel.setText("" + intNumber);

            }

        });

        valueOfRice = new SpinnerNumberModel(1, 1, 1000, 1);
        riceSpinner = new JSpinner(valueOfRice);
        riceSpinner.setBounds(643, 210, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(riceSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        riceShowLabel = new JLabel("1");
        riceShowLabel.setBounds(610, 210, 33, 20);
        riceShowLabel.setOpaque(true);
        riceShowLabel.setBackground(Color.WHITE);
        riceShowLabel.setFont(font);
        c.add(riceShowLabel);
        riceSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = riceSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                riceShowLabel.setText("" + intNumber);

            }

        });

        // Desserts
        JLabel desserts = new JLabel("Desserts");
        desserts.setBounds(410, 260, 200, 20);
        desserts.setFont(font);
        desserts.setForeground(Color.WHITE);
        c.add(desserts);

        applePieCheckBox = new JCheckBox("Apple Pie(200tk)");
        applePieCheckBox.setBounds(410, 280, 200, 20);
        applePieCheckBox.setFont(font);
        applePieCheckBox.setBackground(Color.WHITE);
        c.add(applePieCheckBox);

        malaiKulfiCheckBox = new JCheckBox("Malai Kulfie(200tk)");
        malaiKulfiCheckBox.setBounds(410, 300, 200, 20);
        malaiKulfiCheckBox.setFont(font);
        malaiKulfiCheckBox.setBackground(Color.WHITE);
        c.add(malaiKulfiCheckBox);

        lemonTartCheckBox = new JCheckBox("Lemon Tart(200tk)");
        lemonTartCheckBox.setBounds(410, 320, 200, 20);
        lemonTartCheckBox.setFont(font);
        lemonTartCheckBox.setBackground(Color.WHITE);     
        c.add(lemonTartCheckBox);

        coconutKheerCheckBox = new JCheckBox("Coconut Kheer(250tk)");
        coconutKheerCheckBox.setBounds(410, 340, 200, 20);
        coconutKheerCheckBox.setFont(font);
        coconutKheerCheckBox.setBackground(Color.WHITE);
        c.add(coconutKheerCheckBox);

        cupCakeCheckBox = new JCheckBox("Cup Cake(250tk)");
        cupCakeCheckBox.setBounds(410, 360, 200, 20);
        cupCakeCheckBox.setFont(font);
        cupCakeCheckBox.setBackground(Color.WHITE);
        c.add(cupCakeCheckBox);

        valueOfAp = new SpinnerNumberModel(1, 0, 1000, 1);
        apSpinner = new JSpinner(valueOfAp);
        apSpinner.setBounds(643, 280, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(apSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        apShowLabel = new JLabel("1");
        apShowLabel.setBounds(610, 280, 33, 20);
        apShowLabel.setOpaque(true);
        apShowLabel.setBackground(Color.WHITE);
        apShowLabel.setFont(font);
        c.add(apShowLabel);
        apSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = apSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                apShowLabel.setText("" + intNumber);

            }

        });

        valueOfMk = new SpinnerNumberModel(1, 1, 1000, 1);
        mkSpinner = new JSpinner(valueOfMk);
        mkSpinner.setBounds(643, 300, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(mkSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        mkShowLabel = new JLabel("1");
        mkShowLabel.setBounds(610, 300, 33, 20);
        mkShowLabel.setOpaque(true);
        mkShowLabel.setBackground(Color.WHITE);
        mkShowLabel.setFont(font);
        c.add(mkShowLabel);
        mkSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = mkSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                mkShowLabel.setText("" + intNumber);

            }

        });

        valueOfLt = new SpinnerNumberModel(1, 1, 1000, 1);
        ltSpinner = new JSpinner(valueOfLt);
        ltSpinner.setBounds(643, 320, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(ltSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        ltShowLabel = new JLabel("1");
        ltShowLabel.setBounds(610, 320, 33, 20);
        ltShowLabel.setOpaque(true);
        ltShowLabel.setBackground(Color.WHITE);
        ltShowLabel.setFont(font);
        c.add(ltShowLabel);
        ltSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = ltSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                ltShowLabel.setText("" + intNumber);

            }

        });

        valueOfCk = new SpinnerNumberModel(1, 1, 1000, 1);
        ckSpinner = new JSpinner(valueOfCk);
        ckSpinner.setBounds(643, 340, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(ckSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        ckShowLabel = new JLabel("1");
        ckShowLabel.setBounds(610, 340, 33, 20);
        ckShowLabel.setOpaque(true);
        ckShowLabel.setBackground(Color.WHITE);
        ckShowLabel.setFont(font);
        c.add(ckShowLabel);
        ckSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = ckSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                ckShowLabel.setText("" + intNumber);

            }

        });

        valueOfCc = new SpinnerNumberModel(1, 1, 1000, 1);
        ccSpinner = new JSpinner(valueOfCc);
        ccSpinner.setBounds(643, 360, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(ccSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        ccShowLabel = new JLabel("1");
        ccShowLabel.setBounds(610, 360, 33, 20);
        ccShowLabel.setOpaque(true);
        ccShowLabel.setBackground(Color.WHITE);
        ccShowLabel.setFont(font);
        c.add(ccShowLabel);
        ccSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = ccSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                ccShowLabel.setText("" + intNumber);

            }

        });

        // Drinks

        JLabel drinks = new JLabel("Drinks");
        drinks.setBounds(410, 410, 200, 20);
        drinks.setFont(font);
        drinks.setForeground(Color.WHITE);
        c.add(drinks);

        tCheckBox = new JCheckBox("Tea(100tk)");
        tCheckBox.setBounds(410, 430, 200, 20);
        tCheckBox.setFont(font);
        tCheckBox.setBackground(Color.WHITE);
        c.add(tCheckBox);
        cCheckBox = new JCheckBox("Coffee(150tk)");
        cCheckBox.setBounds(410, 450, 200, 20);
        cCheckBox.setFont(font);
        cCheckBox.setBackground(Color.WHITE);
        c.add(cCheckBox);

        ojCheckBox = new JCheckBox("Orange Juice(300tk)");
        ojCheckBox.setBounds(410, 470, 200, 20);
        ojCheckBox.setFont(font);
        ojCheckBox.setBackground(Color.WHITE);
        c.add(ojCheckBox);

        mjCheckBox = new JCheckBox("Mango Juice(300tk)");
        mjCheckBox.setBounds(410, 490, 200, 20);
        mjCheckBox.setFont(font);
        mjCheckBox.setBackground(Color.WHITE);
        c.add(mjCheckBox);

        csCheckBox = new JCheckBox("Chocolateshake(350tk)");
        csCheckBox.setBounds(410, 510, 200, 20);
        csCheckBox.setFont(font);
        csCheckBox.setBackground(Color.WHITE);
        c.add(csCheckBox);

        valueOfT = new SpinnerNumberModel(1, 0, 1000, 1);
        tSpinner = new JSpinner(valueOfT);
        tSpinner.setBounds(643, 430, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(tSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        tShowLabel = new JLabel("1");
        tShowLabel.setBounds(610, 430, 33, 20);
        tShowLabel.setOpaque(true);
        tShowLabel.setBackground(Color.WHITE);
        tShowLabel.setFont(font);
        c.add(tShowLabel);
        tSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = tSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                tShowLabel.setText("" + intNumber);

            }

        });

        valueOfC = new SpinnerNumberModel(1, 1, 1000, 1);
        cSpinner = new JSpinner(valueOfC);
        cSpinner.setBounds(643, 450, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(cSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        cShowLabel = new JLabel("1");
        cShowLabel.setBounds(610, 450, 33, 20);
        cShowLabel.setOpaque(true);
        cShowLabel.setBackground(Color.WHITE);
        cShowLabel.setFont(font);
        c.add(cShowLabel);
        cSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = cSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                cShowLabel.setText("" + intNumber);

            }

        });

        valueOfOj = new SpinnerNumberModel(1, 1, 1000, 1);
        ojSpinner = new JSpinner(valueOfOj);
        ojSpinner.setBounds(643, 470, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(ojSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        ojShowLabel = new JLabel("1");
        ojShowLabel.setBounds(610, 470, 33, 20);
        ojShowLabel.setOpaque(true);
        ojShowLabel.setBackground(Color.WHITE);
        ojShowLabel.setFont(font);
        c.add(ojShowLabel);
        ojSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = ltSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                ojShowLabel.setText("" + intNumber);

            }

        });

        valueOfMj = new SpinnerNumberModel(1, 1, 1000, 1);
        mjSpinner = new JSpinner(valueOfMj);
        mjSpinner.setBounds(643, 490, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(mjSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        mjShowLabel = new JLabel("1");
        mjShowLabel.setBounds(610, 490, 33, 20);
        mjShowLabel.setOpaque(true);
        mjShowLabel.setBackground(Color.WHITE);
        mjShowLabel.setFont(font);
        c.add(mjShowLabel);
        mjSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = mjSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                mjShowLabel.setText("" + intNumber);

            }

        });

        valueOfCs = new SpinnerNumberModel(1, 1, 1000, 1);
        csSpinner = new JSpinner(valueOfCs);
        csSpinner.setBounds(643, 510, 17, 20);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(csSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        csShowLabel = new JLabel("1");
        csShowLabel.setBounds(610, 510, 33, 20);
        csShowLabel.setOpaque(true);
        csShowLabel.setBackground(Color.WHITE);
        csShowLabel.setFont(font);
        c.add(csShowLabel);
        csSpinner.addChangeListener(new ChangeListener() {

            
            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = csSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int intNumber = Integer.parseInt(number);

                // then seta show koralam
                csShowLabel.setText("" + intNumber);

            }

        });

        // ============Bill===================//
        fishBillShowLabel = new JLabel("0");
        fishBillShowLabel.setBounds(660, 130, 50, 20);
        fishBillShowLabel.setFont(font2);
        fishBillShowLabel.setOpaque(true);
        fishBillShowLabel.setBackground(Color.WHITE);
        c.add(fishBillShowLabel);

        beefBillShowLabel = new JLabel("0");
        beefBillShowLabel.setBounds(660, 150, 50, 20);
        beefBillShowLabel.setFont(font2);
        beefBillShowLabel.setOpaque(true);
        beefBillShowLabel.setBackground(Color.WHITE);
        c.add(beefBillShowLabel);

        muttonBillShowLabel = new JLabel("0");
        muttonBillShowLabel.setBounds(660, 170, 50, 20);
        muttonBillShowLabel.setFont(font2);
        muttonBillShowLabel.setOpaque(true);
        muttonBillShowLabel.setBackground(Color.WHITE);
        c.add(muttonBillShowLabel);

        duckBillShowLabel = new JLabel("0");
        duckBillShowLabel.setBounds(660, 190, 50, 20);
        duckBillShowLabel.setFont(font2);
        duckBillShowLabel.setOpaque(true);
        duckBillShowLabel.setBackground(Color.WHITE);
        c.add(duckBillShowLabel);

        riceBillShowLabel = new JLabel("0");
        riceBillShowLabel.setBounds(660, 210, 50, 20);
        riceBillShowLabel.setFont(font2);
        riceBillShowLabel.setOpaque(true);
        riceBillShowLabel.setBackground(Color.WHITE);
        c.add(riceBillShowLabel);

        apBillShowLabel = new JLabel("0");
        apBillShowLabel.setBounds(660, 280, 50, 20);
        apBillShowLabel.setFont(font2);
        apBillShowLabel.setOpaque(true);
        apBillShowLabel.setBackground(Color.WHITE);
        c.add(apBillShowLabel);

        mkBillShowLabel = new JLabel("0");
        mkBillShowLabel.setBounds(660, 300, 50, 20);
        mkBillShowLabel.setFont(font2);
        mkBillShowLabel.setOpaque(true);
        mkBillShowLabel.setBackground(Color.WHITE);
        c.add(mkBillShowLabel);

        ltBillShowLabel = new JLabel("0");
        ltBillShowLabel.setBounds(660, 320, 50, 20);
        ltBillShowLabel.setFont(font2);
        ltBillShowLabel.setOpaque(true);
        ltBillShowLabel.setBackground(Color.WHITE);
        c.add(ltBillShowLabel);

        ckBillShowLabel = new JLabel("0");
        ckBillShowLabel.setBounds(660, 340, 50, 20);
        ckBillShowLabel.setFont(font2);
        ckBillShowLabel.setOpaque(true);
        ckBillShowLabel.setBackground(Color.WHITE);
        c.add(ckBillShowLabel);

        ccBillShowLabel = new JLabel("0");
        ccBillShowLabel.setBounds(660, 360, 50, 20);
        ccBillShowLabel.setFont(font2);
        ccBillShowLabel.setOpaque(true);
        ccBillShowLabel.setBackground(Color.WHITE);
        c.add(ccBillShowLabel);

        tBillShowLabel = new JLabel("0");
        tBillShowLabel.setBounds(660, 430, 50, 20);
        tBillShowLabel.setFont(font2);
        tBillShowLabel.setOpaque(true);
        tBillShowLabel.setBackground(Color.WHITE);
        c.add(tBillShowLabel);

        cBillShowLabel = new JLabel("0");
        cBillShowLabel.setBounds(660, 450, 50, 20);
        cBillShowLabel.setFont(font2);
        cBillShowLabel.setOpaque(true);
        cBillShowLabel.setBackground(Color.WHITE);
        c.add(cBillShowLabel);

        ojBillShowLabel = new JLabel("0");
        ojBillShowLabel.setBounds(660, 470, 50, 20);
        ojBillShowLabel.setFont(font2);
        ojBillShowLabel.setOpaque(true);
        ojBillShowLabel.setBackground(Color.WHITE);
        c.add(ojBillShowLabel);

        mjBillShowLabel = new JLabel("0");
        mjBillShowLabel.setBounds(660, 490, 50, 20);
        mjBillShowLabel.setFont(font2);
        mjBillShowLabel.setOpaque(true);
        mjBillShowLabel.setBackground(Color.WHITE);
        c.add(mjBillShowLabel);

        csBillShowLabel = new JLabel("0");
        csBillShowLabel.setBounds(660, 510, 50, 20);
        csBillShowLabel.setFont(font2);
        csBillShowLabel.setOpaque(true);
        csBillShowLabel.setBackground(Color.WHITE);
        c.add(csBillShowLabel);

        foodBill = new JLabel("Total food bill :");
        foodBill.setBounds(410, 550, 220, 30);
        foodBill.setCursor(cur);
        foodBill.setFont(font2);
        foodBill.setOpaque(true);
        foodBill.setBackground(Color.WHITE);
        c.add(foodBill);

        foodBillShowLabel = new JLabel("");
        foodBillShowLabel.setBounds(610, 550, 100, 30);
        foodBillShowLabel.setCursor(cur);
        foodBillShowLabel.setFont(font2);
        foodBillShowLabel.setOpaque(true);
        foodBillShowLabel.setBackground(Color.WHITE);
        c.add(foodBillShowLabel);

        // **Cursor***//
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        // *******Button********//
        font2 = new Font("Arial", Font.PLAIN, 10);
        fishBillButton = new JButton("add");
        fishBillButton.setBounds(710, 130, 55, 20);
        fishBillButton.setCursor(cur);
        fishBillButton.setFont(font2);
        c.add(fishBillButton);

        beefBillButton = new JButton("add");
        beefBillButton.setBounds(710, 150, 55, 20);
        beefBillButton.setCursor(cur);
        beefBillButton.setFont(font2);
        c.add(beefBillButton);

        muttonBillButton = new JButton("add");
        muttonBillButton.setBounds(710, 170, 55, 20);
        muttonBillButton.setCursor(cur);
        muttonBillButton.setFont(font2);
        c.add(muttonBillButton);

        duckBillButton = new JButton("add");
        duckBillButton.setBounds(710, 190, 55, 20);
        duckBillButton.setCursor(cur);
        duckBillButton.setFont(font2);
        c.add(duckBillButton);

        riceBillButton = new JButton("add");
        riceBillButton.setBounds(710, 210, 55, 20);
        riceBillButton.setCursor(cur);
        riceBillButton.setFont(font2);
        c.add(riceBillButton);

        apBillButton = new JButton("add");
        apBillButton.setBounds(710, 280, 55, 20);
        apBillButton.setCursor(cur);
        apBillButton.setFont(font2);
        c.add(apBillButton);

        mkBillButton = new JButton("add");
        mkBillButton.setBounds(710, 300, 55, 20);
        mkBillButton.setCursor(cur);
        mkBillButton.setFont(font2);
        c.add(mkBillButton);

        ltBillButton = new JButton("add");
        ltBillButton.setBounds(710, 320, 55, 20);
        ltBillButton.setCursor(cur);
        ltBillButton.setFont(font2);
        c.add(ltBillButton);

        ckBillButton = new JButton("add");
        ckBillButton.setBounds(710, 340, 55, 20);
        ckBillButton.setCursor(cur);
        ckBillButton.setFont(font2);
        c.add(ckBillButton);

        ccBillButton = new JButton("add");
        ccBillButton.setBounds(710, 360, 55, 20);
        ccBillButton.setCursor(cur);
        ccBillButton.setFont(font2);
        c.add(ccBillButton);

        tBillButton = new JButton("add");
        tBillButton.setBounds(710, 430, 55, 20);
        tBillButton.setCursor(cur);
        tBillButton.setFont(font2);
        c.add(tBillButton);

        cBillButton = new JButton("add");
        cBillButton.setBounds(710, 450, 55, 20);
        cBillButton.setCursor(cur);
        cBillButton.setFont(font2);
        c.add(cBillButton);

        ojBillButton = new JButton("add");
        ojBillButton.setBounds(710, 470, 55, 20);
        ojBillButton.setCursor(cur);
        ojBillButton.setFont(font2);
        c.add(ojBillButton);

        mjBillButton = new JButton("add");
        mjBillButton.setBounds(710, 490, 55, 20);
        mjBillButton.setCursor(cur);
        mjBillButton.setFont(font2);
        c.add(mjBillButton);

        csBillButton = new JButton("add");
        csBillButton.setBounds(710, 510, 55, 20);
        csBillButton.setCursor(cur);
        csBillButton.setFont(font2);
        c.add(csBillButton);

        // remove button
        fishCancelButton = new JButton("rem");
        fishCancelButton.setBounds(765, 130, 55, 20);
        fishCancelButton.setCursor(cur);
        fishCancelButton.setFont(font2);
        c.add(fishCancelButton);

        beefCancelButton = new JButton("rem");
        beefCancelButton.setBounds(765, 150, 55, 20);
        beefCancelButton.setCursor(cur);
        beefCancelButton.setFont(font2);
        c.add(beefCancelButton);

        muttonCancelButton = new JButton("rem");
        muttonCancelButton.setBounds(765, 170, 55, 20);
        muttonCancelButton.setCursor(cur);
        muttonCancelButton.setFont(font2);
        c.add(muttonCancelButton);

        duckCancelButton = new JButton("rem");
        duckCancelButton.setBounds(765, 190, 55, 20);
        duckCancelButton.setCursor(cur);
        duckCancelButton.setFont(font2);
        c.add(duckCancelButton);

        riceCancelButton = new JButton("rem");
        riceCancelButton.setBounds(765, 210, 55, 20);
        riceCancelButton.setCursor(cur);
        riceCancelButton.setFont(font2);
        c.add(riceCancelButton);

        apCancelButton = new JButton("rem");
        apCancelButton.setBounds(765, 280, 55, 20);
        apCancelButton.setCursor(cur);
        apCancelButton.setFont(font2);
        c.add(apCancelButton);

        mkCancelButton = new JButton("rem");
        mkCancelButton.setBounds(765, 300, 55, 20);
        mkCancelButton.setCursor(cur);
        mkCancelButton.setFont(font2);
        c.add(mkCancelButton);

        ltCancelButton = new JButton("rem");
        ltCancelButton.setBounds(765, 320, 55, 20);
        ltCancelButton.setCursor(cur);
        ltCancelButton.setFont(font2);
        c.add(ltCancelButton);

        ckCancelButton = new JButton("rem");
        ckCancelButton.setBounds(765, 340, 55, 20);
        ckCancelButton.setCursor(cur);
        ckCancelButton.setFont(font2);
        c.add(ckCancelButton);

        ccCancelButton = new JButton("rem");
        ccCancelButton.setBounds(765, 360, 55, 20);
        ccCancelButton.setCursor(cur);
        ccCancelButton.setFont(font2);
        c.add(ccCancelButton);

        tCancelButton = new JButton("rem");
        tCancelButton.setBounds(765, 430, 55, 20);
        tCancelButton.setCursor(cur);
        tCancelButton.setFont(font2);
        c.add(tCancelButton);

        cCancelButton = new JButton("rem");
        cCancelButton.setBounds(765, 450, 55, 20);
        cCancelButton.setCursor(cur);
        cCancelButton.setFont(font2);
        c.add(cCancelButton);

        ojCancelButton = new JButton("rem");
        ojCancelButton.setBounds(765, 470, 55, 20);
        ojCancelButton.setCursor(cur);
        ojCancelButton.setFont(font2);
        c.add(ojCancelButton);

        mjCancelButton = new JButton("rem");
        mjCancelButton.setBounds(765, 490, 55, 20);
        mjCancelButton.setCursor(cur);
        mjCancelButton.setFont(font2);
        c.add(mjCancelButton);

        csCancelButton = new JButton("rem");
        csCancelButton.setBounds(765, 510, 55, 20);
        csCancelButton.setCursor(cur);
        csCancelButton.setFont(font2);
        c.add(csCancelButton);

        billButton = new JButton("Food Bill");
        billButton.setBounds(850, 130, 120, 30);
        billButton.setCursor(cur);
        billButton.setFont(font);
        c.add(billButton);

        paymentButton = new JButton("Payment");
        paymentButton.setBounds(850, 180, 120, 30);
        paymentButton.setCursor(cur);
        paymentButton.setFont(font);
        c.add(paymentButton);

        backButton = new JButton("Back");
        backButton.setBounds(850, 230, 120, 30);
        backButton.setCursor(cur);
        backButton.setFont(font);
        c.add(backButton);

        c.add(billButton);

        // Action Listener
        billButton.addActionListener(this);
        paymentButton.addActionListener(this);
        backButton.addActionListener(this);
        billButton.addActionListener(this);
        fishBillButton.addActionListener(this);
        muttonBillButton.addActionListener(this);
        beefBillButton.addActionListener(this);
        duckBillButton.addActionListener(this);
        riceBillButton.addActionListener(this);
        apBillButton.addActionListener(this);
        mkBillButton.addActionListener(this);
        ltBillButton.addActionListener(this);
        ckBillButton.addActionListener(this);
        ccBillButton.addActionListener(this);
        tBillButton.addActionListener(this);
        cBillButton.addActionListener(this);
        ojBillButton.addActionListener(this);
        mjBillButton.addActionListener(this);
        csBillButton.addActionListener(this);

        fishCancelButton.addActionListener(this);
        muttonCancelButton.addActionListener(this);
        beefCancelButton.addActionListener(this);
        duckCancelButton.addActionListener(this);
        riceCancelButton.addActionListener(this);
        apCancelButton.addActionListener(this);
        mkCancelButton.addActionListener(this);
        ltCancelButton.addActionListener(this);
        ckCancelButton.addActionListener(this);
        ccCancelButton.addActionListener(this);
        tCancelButton.addActionListener(this);
        cCancelButton.addActionListener(this);
        ojCancelButton.addActionListener(this);
        mjCancelButton.addActionListener(this);
        csCancelButton.addActionListener(this);

        // add background picture...JLabel er maddhome ekta pic add korbo then seta frame er size onujai dibo
        icon2 = new ImageIcon("IMG/a2.jpg");// pic->ImageIcon->JLabel
        bgpic = new JLabel("", icon2, JLabel.CENTER);
        bgpic.setBounds(0, 0, 1000, 680);

        c.add(bgpic);

    }

    public void actionPerformed(ActionEvent e) {
        if (fishCheckBox.isSelected()) {
            if (e.getSource().equals(fishBillButton)) {
                String number = fishShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                fishBillShowLabel.setText("" + 500 * numberInt);
            }
        }
        if (beefCheckBox.isSelected()) {
            if (e.getSource().equals(beefBillButton)) {
                String number = beefShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                beefBillShowLabel.setText("" + 700 * numberInt);
            }
        }
        if (muttonCheckBox.isSelected()) {
            if (e.getSource().equals(muttonBillButton)) {
                String number = muttonShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                muttonBillShowLabel.setText("" + 900 * numberInt);
            }
        }
        if (duckCheckBox.isSelected()) {
            if (e.getSource().equals(duckBillButton)) {
                String number = duckShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                duckBillShowLabel.setText("" + 1000 * numberInt);
            }
        }
        if (riceCheckBox.isSelected()) {
            if (e.getSource().equals(riceBillButton)) {
                String number = riceShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                riceBillShowLabel.setText("" + 100 * numberInt);
            }
        }
        if (applePieCheckBox.isSelected()) {
            if (e.getSource().equals(apBillButton)) {
                String number = apShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                apBillShowLabel.setText("" + 200 * numberInt);
            }
        }
        if (malaiKulfiCheckBox.isSelected()) {
            if (e.getSource().equals(mkBillButton)) {
                String number = mkShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                mkBillShowLabel.setText("" + 200 * numberInt);
            }
        }
        if (lemonTartCheckBox.isSelected()) {
            if (e.getSource().equals(ltBillButton)) {
                String number = ltShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                ltBillShowLabel.setText("" + 200 * numberInt);
            }
        }
        if (coconutKheerCheckBox.isSelected()) {
            if (e.getSource().equals(ckBillButton)) {
                String number = ckShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                ckBillShowLabel.setText("" + 250 * numberInt);
            }
        }
        if (cupCakeCheckBox.isSelected()) {
            if (e.getSource().equals(ccBillButton)) {
                String number = ccShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                ccBillShowLabel.setText("" + 250 * numberInt);
            }
        }
        if (tCheckBox.isSelected()) {
            if (e.getSource().equals(tBillButton)) {
                String number = tShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                tBillShowLabel.setText("" + 100 * numberInt);
            }
        }
        if (cCheckBox.isSelected()) {
            if (e.getSource().equals(cBillButton)) {
                String number = cShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                cBillShowLabel.setText("" + 150 * numberInt);
            }
        }
        if (ojCheckBox.isSelected()) {
            if (e.getSource().equals(ojBillButton)) {
                String number = ojShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                ojBillShowLabel.setText("" + 300 * numberInt);
            }
        }
        if (mjCheckBox.isSelected()) {
            if (e.getSource().equals(mjBillButton)) {
                String number = mjShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                mjBillShowLabel.setText("" + 300 * numberInt);
            }
        }
        if (csCheckBox.isSelected()) {
            if (e.getSource().equals(csBillButton)) {
                String number = csShowLabel.getText().toString();
                int numberInt = Integer.parseInt(number);
                csBillShowLabel.setText("" + 350 * numberInt);
            }
        }

        if (e.getSource().equals(fishCancelButton)) {

            fishBillShowLabel.setText("0");
        }

        if (e.getSource().equals(beefCancelButton)) {

            beefBillShowLabel.setText("0");
        }

        if (e.getSource().equals(muttonCancelButton)) {

            muttonBillShowLabel.setText("0");
        }

        if (e.getSource().equals(duckCancelButton)) {

            duckBillShowLabel.setText("0");
        }

        if (e.getSource().equals(riceCancelButton)) {

            riceBillShowLabel.setText("0");
        }

        if (e.getSource().equals(apCancelButton)) {

            apBillShowLabel.setText("0");
        }

        if (e.getSource().equals(mkCancelButton)) {

            mkBillShowLabel.setText("0");
        }

        if (e.getSource().equals(ltCancelButton)) {

            ltBillShowLabel.setText("0");
        }

        if (e.getSource().equals(ckCancelButton)) {

            ckBillShowLabel.setText("0");
        }

        if (e.getSource().equals(ccCancelButton)) {

            ccBillShowLabel.setText("0");
        }

        if (e.getSource().equals(tCancelButton)) {

            tBillShowLabel.setText("0");
        }

        if (e.getSource().equals(cCancelButton)) {

            cBillShowLabel.setText("0");
        }

        if (e.getSource().equals(ojCancelButton)) {

            ojBillShowLabel.setText("0");
        }

        if (e.getSource().equals(mjCancelButton)) {

            mjBillShowLabel.setText("0");
        }

        if (e.getSource().equals(csCancelButton)) {

            csBillShowLabel.setText("0");
        }

        // Bill Button
        if (e.getSource().equals(billButton)) {

            int fish = 0;
            int beef = 0;
            int mutton = 0;
            int duck = 0;
            int rice = 0;
            int ap = 0;
            int mk = 0;
            int lt = 0;
            int ck = 0;
            int cc = 0;
            int t = 0;
            int c = 0;
            int oj = 0;
            int mj = 0;
            int cs = 0;

            fish = Integer.parseInt(fishBillShowLabel.getText().toString());
            beef = Integer.parseInt(beefBillShowLabel.getText().toString());
            mutton = Integer.parseInt(muttonBillShowLabel.getText().toString());
            duck = Integer.parseInt(duckBillShowLabel.getText().toString());
            rice = Integer.parseInt(riceBillShowLabel.getText().toString());
            ap = Integer.parseInt(apBillShowLabel.getText().toString());
            mk = Integer.parseInt(mkBillShowLabel.getText().toString());
            lt = Integer.parseInt(ltBillShowLabel.getText().toString());
            ck = Integer.parseInt(ckBillShowLabel.getText().toString());
            cc = Integer.parseInt(ccBillShowLabel.getText().toString());
            t = Integer.parseInt(tBillShowLabel.getText().toString());
            c = Integer.parseInt(cBillShowLabel.getText().toString());
            oj = Integer.parseInt(ojBillShowLabel.getText().toString());
            mj = Integer.parseInt(mjBillShowLabel.getText().toString());
            cs = Integer.parseInt(csBillShowLabel.getText().toString());

            int totalBill = fish + beef + mutton + duck + rice + ap + mk + lt + ck + cc + t + c + oj + mj + cs;

            foodBillShowLabel.setText("" + totalBill);
        }

        if (e.getSource() == paymentButton) {

            ImageIcon iconOfYesNo = new ImageIcon("IMG/paid.png");
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to pay food bill through online?", "Payment",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, iconOfYesNo);

            if (choice == JOptionPane.YES_OPTION) {

                ImageIcon icon = new ImageIcon("IMG/onlinepayment.png");
                String[] options = { "Card", "Mobile Banking" };
                int method = JOptionPane.showOptionDialog(null, "Select method",
                        "Payment", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options,
                        options[0]);

                if (method == 0) {

                    ImageIcon iconOfCard = new ImageIcon("IMG/card.png");
                    String cardNumber = (String) JOptionPane.showInputDialog(null, "Enter your Card number",
                            "Card number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxxx-xxxxxx-xxxxx");// as
                   
                    int totalPaid = 0;
                    int due = Integer.parseInt(foodBillShowLabel.getText());
                    String paid = (String) JOptionPane.showInputDialog(null,
                            "Your food bill:" + due,
                            "Amount", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "" + due);

                    String pin = (String) JOptionPane.showInputDialog(null,
                            "Enter otp code", "Pin number", JOptionPane.INFORMATION_MESSAGE, iconOfCard, null,
                            "");

                    int paidAmount = Integer.parseInt(paid);
                    due = due - paidAmount;

                    totalPaid = totalPaid + paidAmount;

                    JOptionPane.showMessageDialog(null,
                            "Your payment is succesfully paid " + paidAmount + "tk" + "\nYour due payment " + due
                                    + "tk",
                            "Payment succesful", JOptionPane.QUESTION_MESSAGE, iconOfCard);

                    foodBillShowLabel.setText("" + due);

                } else {

                    String[] optionsOfMobileBanking = { "BKash", "Rocket", "Nagad" };
                    ImageIcon iconOfMobileBanking = new ImageIcon("IMG/mobilebanking.png");
                    String methodOfMobileBanking = (String) JOptionPane.showInputDialog(null, "Select method",
                            "Mobile banking", JOptionPane.QUESTION_MESSAGE, iconOfMobileBanking, optionsOfMobileBanking,
                            optionsOfMobileBanking[2]);
                    if (methodOfMobileBanking.equals("BKash")) {

                        ImageIcon iconOfCard = new ImageIcon("IMG/bkash.jpg");
                        String MobileNumber = (String) JOptionPane.showInputDialog(null, "Enter your mobile number",
                                "Mobile number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxx-xxxxxxxx");
                        int totalPaid = 0;
                        int due = Integer.parseInt(foodBillShowLabel.getText());
                        String paid = (String) JOptionPane.showInputDialog(null,
                                "Your bill :" + due,
                                "Amount", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "" + due);

                        String pin = (String) JOptionPane.showInputDialog(null,
                                "Enter otp number", "Pin number", JOptionPane.INFORMATION_MESSAGE, iconOfCard, null,
                                "");

                        int paidAmount = Integer.parseInt(paid);
                        due = due - paidAmount;

                        totalPaid = totalPaid + paidAmount;

                        JOptionPane.showMessageDialog(null,
                                "Your payment is succesfully paid " + paidAmount + "tk" + "\nYour due payment " + due
                                        + "tk",
                                "Payment succeful", JOptionPane.QUESTION_MESSAGE, iconOfCard);

                        // paidShowLabel.setText("" + totalPaid);
                        foodBillShowLabel.setText("" + due);

                    } else if (methodOfMobileBanking.equals("Rocket")) {

                        ImageIcon iconOfCard = new ImageIcon("IMG/rocket.png");
                        String MobileNumber = (String) JOptionPane.showInputDialog(null, "Enter your mobile number",
                                "Mobile number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxx-xxxxxxxx");

                        int totalPaid = 0;
                        int due = Integer.parseInt(foodBillShowLabel.getText());

                        String paid = (String) JOptionPane.showInputDialog(null,
                                "Your bill :" + due,
                                "Amount", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "" + due);

                        String pin = (String) JOptionPane.showInputDialog(null,
                                "Enter otp number", "Pin number", JOptionPane.INFORMATION_MESSAGE, iconOfCard, null,
                                "");

                        int paidAmount = Integer.parseInt(paid);
                        due = due - paidAmount;

                        totalPaid = totalPaid + paidAmount;

                        JOptionPane.showMessageDialog(null,
                                "Your payment is succesfully paid " + paidAmount + "tk" + "\nYour due payment " + due
                                        + "tk",
                                "Payment succeful", JOptionPane.QUESTION_MESSAGE, iconOfCard);

                        foodBillShowLabel.setText("" + due);


                    } else {
                        ImageIcon iconOfCard = new ImageIcon("IMG/nagad.png");
                        String MobileNumber = (String) JOptionPane.showInputDialog(null, "Enter your mobile number",
                                "Mobile number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxx-xxxxxxxx");// as

                           int totalPaid = 0;
                        int due = Integer.parseInt(foodBillShowLabel.getText());

                        String paid = (String) JOptionPane.showInputDialog(null,
                                "Your bill :" + due,
                                "Amount", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "" + due);

                        String pin = (String) JOptionPane.showInputDialog(null,
                                "Enter otp number", "Pin number", JOptionPane.INFORMATION_MESSAGE, iconOfCard, null,
                                "");

                        int paidAmount = Integer.parseInt(paid);
                        due = due - paidAmount;

                        totalPaid = totalPaid + paidAmount;

                        JOptionPane.showMessageDialog(null,
                                "Your payment is succesfully paid " + paidAmount + "tk" + "\nYour due payment " + due
                                        + "tk",
                                "Payment succeful", JOptionPane.QUESTION_MESSAGE, iconOfCard);

                        foodBillShowLabel.setText("" + due);

                    }
                }

            } else {

                this.dispose();
                new MemberLogin2().setVisible(true);

            }

        }
        if (e.getSource() == backButton) {

            this.dispose();
            new MemberLogin2().setVisible(true);

        }

    }

    public String reader(String str) {
        String text = null;
        BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(str)));
        try {
            text = txtReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}
