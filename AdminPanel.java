import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class AdminPanel extends JFrame implements ActionListener, MouseListener {

    private String Data2, absbill, dmc, immc, indiuti, mmc, utility;
    private Container c;
    private ImageIcon icon, icon2;// icon for icon,,icon2 for background picture

    private JLabel titleLabel, fnLabel, lnLabel, phoneLabel, ocpLabel, gndLabel, gndShowLabel, nidLabel, membLabel, membShowLabel, checkInTimeLabel, checkInTimeShowLabel, daysLabel, daysShowLabel, roomsLabel, roomsShowLabel, rtLabel, rnLabel, adLabel, arLabel, rbLabel, rbShowLabel, paidLabel, paidShowLabel, dueLabel, dueShowLabel, passLabel, bgpic;

    private JTextField fnTf, lnTf, phoneTf, ocpTf, nidTf, srTf;
    private JPasswordField passPf;
    private JSpinner membSpinner, daysSpinner, roomsSpinner;
    private Cursor cur;

    private JButton addButton, updateButton, deleteButton, clearButton, billButton, paymentButton, saveButton, backButton;

    private JRadioButton male, female, custom;
    private ButtonGroup buttongroup;

    private JComboBox rtComboBox, datesComboBox, monthsComboBox, yearsComboBox, arsComboBox, ardComboBox, arpComboBox;

    private String[] roomsType = { "Standard Room(5000tk)", "Deluxe Room(10000tk)", "Presidential Suite(50000tk)" };

    private Date date;

    // eii 'i' ta nilam roomsType and roomsNo er moddhe somducko create korar jonno
    // jate room type e "Standard" select hole shudhu "Standard" er room gula show hobe... "Deluxe" select hole "Deluxe " room gula show kore..."President " select hole "president room gula show korbe

    // if else er maddhome "i" eikhane row er number hisebe use korbo

    public int i;
    private String roomsNoStandard[] = { "Standard-1", "Standard-2", "Standard-3", "Standard-4", "Standard-5", "Standard-6", "Standard-7", "Standard-8", "Standard-9", "Standard-10","Standard-11", "Standard-12", "Standard-13", "Standard-14", "Standard-15", "Standard-16", "Standard-17", "Standard-18", "Standard-19", "Standard-20", "Standard-21", "Standard-22", "Standard-23", "Standard-24", "Standard-25", "Standard-26", "Standard-27", "Standard-28", "Standard-29", "Standard-30", "Standard-31" };

    private String roomsNoDeluxe[] = { "Deluxe-1", "Deluxe-2", "Deluxe-3", "Deluxe-4", "Deluxe-5", "Deluxe-6", "Deluxe-7", "Deluxe-8", "Deluxe-9", "Deluxe-10", "Deluxe-11", "Deluxe-12", "Deluxe-13", "Deluxe-14", "Deluxe-15" };

    private String roomsNoPresident[] = { "PR. Suite-1", "PR. Suite-2", "PR. Suite-3", "PR. Suite-4", "PR. Suite-5", "PR. Suite-6" };

    private int roomsIndex;

    private Font font;
    private JTable table;

    // table create hoi jetar row and column thkbe na
    private DefaultTableModel model;
    private JScrollPane scroll;

    private String[] cols = { "First name", "Last name", "Occupation", "Gender", "NID",
            "Days", "Room no", "Roob bill", "Paid amount", "Due amount", "Phone number", "Password" };

    // row value user theke nibo
    private String[] rows = new String[12];

    AdminPanel(String Data2, String absbill, String dmc, String immc, String indiuti, String mmc, String utility) {
        this.Data2 = Data2;
        this.absbill = absbill;
        this.dmc = dmc;
        this.immc = immc;
        this.indiuti = indiuti;
        this.mmc = mmc;
        this.utility = utility;

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 680);
        this.setLocationRelativeTo(null);
        this.setTitle("Check-in");

        initComponents();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("IMG/icon1.png"));
        this.setIconImage(icon.getImage());

        // fontstyle
        font = new Font("Arial", Font.BOLD, 16);
        
        // label,field
        titleLabel = new JLabel("New Guest Registration");
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(10, 10, 250, 50);
        c.add(titleLabel);

        

        // First Name
        fnLabel = new JLabel("First Name ");
        fnLabel.setBounds(10, 80, 140, 30);
        fnLabel.setFont(font);
        fnLabel.setForeground(Color.WHITE);
        c.add(fnLabel);

        fnTf = new JTextField();
        fnTf.setBounds(110, 80, 200, 30);
        fnTf.setFont(font);
        c.add(fnTf);

        // Last Name
        lnLabel = new JLabel("Last Name ");
        lnLabel.setBounds(10, 130, 140, 30);
        lnLabel.setFont(font);
        lnLabel.setForeground(Color.WHITE);
        c.add(lnLabel);

        lnTf = new JTextField();
        lnTf.setBounds(110, 130, 200, 30);
        lnTf.setFont(font);
        c.add(lnTf);

        // Phone
        phoneLabel = new JLabel("Phone ");
        phoneLabel.setBounds(10, 180, 140, 30);
        phoneLabel.setFont(font);
        phoneLabel.setForeground(Color.WHITE);
        c.add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(110, 180, 200, 30);
        phoneTf.setFont(font);
        c.add(phoneTf);

        // Occupation
        ocpLabel = new JLabel("Occupation");
        ocpLabel.setBounds(10, 230, 140, 30);
        ocpLabel.setFont(font);
        ocpLabel.setForeground(Color.WHITE);
        c.add(ocpLabel);

        ocpTf = new JTextField();
        ocpTf.setBounds(110, 230, 200, 30);
        ocpTf.setFont(font);
        c.add(ocpTf);

        // Gender
        gndLabel = new JLabel("Gender");
        gndLabel.setBounds(10, 280, 140, 30);
        gndLabel.setFont(font);
        gndLabel.setForeground(Color.WHITE);
        c.add(gndLabel);

        // Gender er jaigai textfield er jaigai jlabel use korlam jate user edit na
        // korte pare..female/male seta to radiobutton dara select kora jabe
        gndShowLabel = new JLabel();
        gndShowLabel.setBounds(110, 280, 200, 30);
        gndShowLabel.setOpaque(true);// Shudhu matro jlabel er background color set korar jonno eita true kore dite hoi..karon eita default false thake
        gndShowLabel.setBackground(Color.WHITE);
        gndShowLabel.setFont(font);
        c.add(gndShowLabel);

        // button grp e male,female radio button rakhbo..jate ekta select korle arekta
        // unselect hoi jai
        buttongroup = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(20, 320, 90, 20);
        male.setFont(font);
        male.setBackground(Color.WHITE);
        // male.setSelected(true);// run korar por first ei auto male select thkbe
        c.add(male);

        female = new JRadioButton("Female");
        female.setBounds(120, 320, 90, 20);
        female.setFont(font);
        female.setBackground(Color.WHITE);

        c.add(female);

        custom = new JRadioButton("Custom");
        custom.setBounds(220, 320, 90, 20);
        custom.setFont(font);
        custom.setBackground(Color.WHITE);

        c.add(custom);

        // buttongroup eijonno banacchi jate radiobutton ekta select korle arekta unselect hoi jai
        buttongroup.add(male);
        buttongroup.add(female);
        buttongroup.add(custom);

        // male,female action listener part
        male.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gndShowLabel.setText("Male");
            }
        });

        female.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gndShowLabel.setText("Female");
            }
        });

        custom.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gndShowLabel.setText("Custom");
            }
        });

        // Nid Number
        nidLabel = new JLabel("Nid Number");
        nidLabel.setBounds(10, 360, 140, 30);
        nidLabel.setFont(font);
        nidLabel.setForeground(Color.WHITE);
        c.add(nidLabel);

        nidTf = new JTextField();
        nidTf.setBounds(110, 360, 200, 30);
        nidTf.setFont(font);
        c.add(nidTf);

        // Members
        membLabel = new JLabel("Members");
        membLabel.setBounds(10, 410, 140, 30);
        membLabel.setFont(font);
        membLabel.setForeground(Color.WHITE);
        c.add(membLabel);

        // Jspinner e initial value,minimum,maximum,stepSize set korar jonno
        SpinnerNumberModel valueOfMember = new SpinnerNumberModel(1, 1, 1000, 1);
        membSpinner = new JSpinner(valueOfMember);
        membSpinner.setBounds(293, 410, 17, 30);
        // spinner er width short nilam karon amra value ta spinner e dekhbo na value dekhbo JLabel e jate user edit korte na pare
        c.add(membSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        membShowLabel = new JLabel("1");
        membShowLabel.setBounds(110, 410, 183, 30);
        membShowLabel.setOpaque(true);
        membShowLabel.setBackground(Color.WHITE);
        membShowLabel.setFont(font);
        c.add(membShowLabel);
        membSpinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = membSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int valueOfMember = Integer.parseInt(number);

                // then seta show koralam
                membShowLabel.setText("" + valueOfMember);

            }

        });

        // Arrival Date

        date = new Date();

        checkInTimeLabel = new JLabel("Checkin Time");
        checkInTimeLabel.setBounds(410, 30, 140, 30);
        checkInTimeLabel.setFont(font);
        checkInTimeLabel.setForeground(Color.WHITE);
        c.add(checkInTimeLabel);

        checkInTimeShowLabel = new JLabel("" + date);
        checkInTimeShowLabel.setBounds(550, 30, 250, 30);
        checkInTimeShowLabel.setFont(font);
        checkInTimeShowLabel.setForeground(Color.GREEN);
        c.add(checkInTimeShowLabel);

        // Total Days

        daysLabel = new JLabel("Total Days");
        daysLabel.setBounds(410, 80, 140, 30);
        daysLabel.setFont(font);
        daysLabel.setForeground(Color.WHITE);
        c.add(daysLabel);

        // Jspinner e initial value,minimum,maximum,stepSize set korar jonno
        SpinnerNumberModel valueOfDays = new SpinnerNumberModel(1, 1, 1000, 1);
        daysSpinner = new JSpinner(valueOfDays);
        daysSpinner.setBounds(693, 80, 17, 30);

        // spinner er width short nilam karon amra value ta spinner e dekhbo na
        // value dekhbo JLabel e jate user edit korte na pare
        c.add(daysSpinner);

        // Jlabel e create korlam jate user edit korte na pare
        daysShowLabel = new JLabel("1");
        daysShowLabel.setBounds(510, 80, 183, 30);
        daysShowLabel.setOpaque(true);
        daysShowLabel.setBackground(Color.WHITE);
        daysShowLabel.setFont(font);
        c.add(daysShowLabel);
        daysSpinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                // membSpinner er value ta ekta string variable number er moddhe rakhlam
                String number = daysSpinner.getValue().toString();

                // then se int ke String e niye gelam

                int valueOfDays = Integer.parseInt(number);

                // then seta show koralam
                daysShowLabel.setText("" + valueOfDays);

            }

        });

        // Total Rooms

        // Room Type

        rtLabel = new JLabel("Types");
        rtLabel.setBounds(410, 130, 140, 30);
        rtLabel.setFont(font);
        rtLabel.setForeground(Color.WHITE);
        c.add(rtLabel);

        rtComboBox = new JComboBox(roomsType);// Combo box e roomsType Array String rakhlam..sekhaner value holo "Standard Room","Deluxe Room","Presidential Room"
        rtComboBox.setBounds(480, 130, 230, 30);
        rtComboBox.setFont(font);

        // combo box e jodi kichu likhte chai
        rtComboBox.setEditable(false);
        rtComboBox.setSelectedItem(null);

        // jokhon run korabo tokhon ekta select thkbe seta koto no ta set korte 
        c.add(rtComboBox);

        // Available room
        // available Standard room
        arsComboBox = new JComboBox(roomsNoStandard);// Combo box e roomsType Array String rakhlam..sekhaner value holo"Standard Room","Deluxe Room","Presidential Room"

        arsComboBox.setBounds(550, 180, 160, 30);
        arsComboBox.setFont(font);
        arsComboBox.setEditable(false);
        arsComboBox.setSelectedItem(null);
        // arsComboBox.setSelectedIndex(0);
        c.add(arsComboBox);
        // available Deluxe room

        ardComboBox = new JComboBox(roomsNoDeluxe);// Combo box e roomsType Array String rakhlam..sekhaner value
        // holo
        // "Standard Room","Deluxe Room","Presidential Room"

        ardComboBox.setBounds(550, 180, 160, 30);
        ardComboBox.setFont(font);
        ardComboBox.setEditable(false);
        // ardComboBox.setSelectedIndex(0);
        ardComboBox.setSelectedItem(null);
        c.add(ardComboBox);

        // available President room
        arpComboBox = new JComboBox(roomsNoPresident);// Combo box e roomsType Array String rakhlam..sekhaner value holo "Standard Room","Deluxe Room","Presidential Room"

        arpComboBox.setBounds(550, 180, 160, 30);
        arpComboBox.setFont(font);
        arpComboBox.setEditable(false);
        arpComboBox.setSelectedItem(null);
        c.add(arpComboBox);

        // roomtype combo box ActionListener
        rtComboBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                String roomType = rtComboBox.getSelectedItem().toString();

                if (roomType.equals("Standard Room(5000tk)")) {

                    arsComboBox.setVisible(true);
                    ardComboBox.setVisible(false);
                    arpComboBox.setVisible(false);

                } else if (roomType.equals("Deluxe Room(10000tk)")) {

                    arsComboBox.setVisible(false);
                    ardComboBox.setVisible(true);
                    arpComboBox.setVisible(false);

                } else {

                    arsComboBox.setVisible(false);
                    ardComboBox.setVisible(false);
                    arpComboBox.setVisible(true);
                }
            }
        });

        arLabel = new JLabel("Available Room");
        arLabel.setBounds(410, 180, 140, 30);
        arLabel.setFont(font);
        arLabel.setForeground(Color.WHITE);
        c.add(arLabel);

        // Selected Rooms No

        rnLabel = new JLabel("Room No");
        rnLabel.setBounds(410, 230, 140, 30);
        rnLabel.setFont(font);
        rnLabel.setForeground(Color.WHITE);
        c.add(rnLabel);

        srTf = new JTextField();
        srTf.setBounds(510, 230, 200, 30);
        srTf.setFont(font);
        c.add(srTf);

        // Available Standard Room combo box ActionListener
        // Available Standard Room combo box and select room text field relation
        arsComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String availableRoomStandard = arsComboBox.getSelectedItem().toString();
                srTf.setText("" + availableRoomStandard);

            }
        });

        // Available Deluxe Room combo box ActionListener
        // Available Deluxe Room combo box and select room text field relation
        ardComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String availableRoomDeluxe = ardComboBox.getSelectedItem().toString();
                srTf.setText("" + availableRoomDeluxe);

            }
        });

        // Available President Room combo box ActionListener
        // Available President Room combo box and select room text field relation
        arpComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String availableRoomPresidential = arpComboBox.getSelectedItem().toString();
                srTf.setText("" + availableRoomPresidential);

            }
        });

        // Bill

        rbLabel = new JLabel("Room Bill");
        rbLabel.setBounds(410, 280, 140, 30);
        rbLabel.setFont(font);
        rbLabel.setForeground(Color.WHITE);
        c.add(rbLabel);

        rbShowLabel = new JLabel();
        rbShowLabel.setBounds(510, 280, 200, 30);
        rbShowLabel.setFont(font);
        rbShowLabel.setOpaque(true);
        rbShowLabel.setBackground(Color.WHITE);
        c.add(rbShowLabel);

        // paid
        paidLabel = new JLabel("Paid Amount");
        paidLabel.setBounds(410, 330, 140, 30);
        paidLabel.setFont(font);
        paidLabel.setForeground(Color.WHITE);
        c.add(paidLabel);

        paidShowLabel = new JLabel();
        paidShowLabel.setBounds(510, 330, 200, 30);
        paidShowLabel.setFont(font);
        paidShowLabel.setOpaque(true);
        paidShowLabel.setBackground(Color.WHITE);
        c.add(paidShowLabel);

        // due
        dueLabel = new JLabel("Due Amount");
        dueLabel.setBounds(410, 380, 140, 30);
        dueLabel.setFont(font);
        dueLabel.setForeground(Color.WHITE);
        c.add(dueLabel);

        dueShowLabel = new JLabel();
        dueShowLabel.setBounds(510, 380, 200, 30);
        dueShowLabel.setFont(font);
        dueShowLabel.setOpaque(true);
        dueShowLabel.setBackground(Color.WHITE);
        c.add(dueShowLabel);

        // Password
        Font passFont = new Font("Arial", Font.BOLD, 20);
        passLabel = new JLabel("Password");
        passLabel.setBounds(410, 430, 140, 30);
        passLabel.setFont(font);
        passLabel.setForeground(Color.WHITE);
        c.add(passLabel);

        passPf = new JPasswordField();
        passPf.setBounds(510, 430, 200, 30);
        passPf.setEchoChar('*');
        passPf.setFont(passFont);
        c.add(passPf);

        // **Cursor***//
        cur = new Cursor(Cursor.HAND_CURSOR);

        // *******Button********//
        billButton = new JButton("Bill");
        billButton.setBounds(850, 80, 120, 30);
        billButton.setCursor(cur);
        billButton.setFont(font);
        c.add(billButton);

        paymentButton = new JButton("Payment");
        paymentButton.setBounds(850, 130, 120, 30);
        paymentButton.setCursor(cur);
        paymentButton.setFont(font);
        c.add(paymentButton);

        addButton = new JButton("Add");
        addButton.setBounds(850, 180, 120, 30);
        addButton.setCursor(cur);
        addButton.setFont(font);
        c.add(addButton);

        deleteButton = new JButton("Check-out");
        deleteButton.setBounds(850, 380, 120, 30);
        deleteButton.setCursor(cur);
        deleteButton.setFont(font);
        c.add(deleteButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(850, 230, 120, 30);
        updateButton.setCursor(cur);
        updateButton.setFont(font);
        c.add(updateButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(850, 280, 120, 30);
        clearButton.setCursor(cur);
        clearButton.setFont(font);
        c.add(clearButton);

        saveButton = new JButton("Save");
        saveButton.setBounds(850, 330, 120, 30);
        saveButton.setCursor(cur);
        saveButton.setFont(font);
        c.add(saveButton);

        backButton = new JButton("Back");
        backButton.setBounds(850, 430, 120, 30);
        backButton.setCursor(cur);
        backButton.setFont(font);
        c.add(backButton);

        // button actionListener
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        // update button e click korle change data jate abar same postion e table e update hoi jai
        updateButton.addActionListener(this);
        billButton.addActionListener(this);
        paymentButton.addActionListener(this);
        saveButton.addActionListener(this);
        backButton.addActionListener(this);

        // table
        table = new JTable();
        TableReader tt5 = new TableReader();
        model = new DefaultTableModel();
        File f = new File(Data2);
        if (f.length() != 0) {
            model = tt5.createModel(Data2);
        }
        model.setColumnIdentifiers(cols);
        table.setModel(model);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 480, 965, 190);
        c.add(scroll);

        table.addMouseListener(this);

        // add background picture...JLabel er maddhome ekta pic add korbo then seta frame er size onujai dibo
        icon2 = new ImageIcon("IMG/a10.jpg");// pic->ImageIcon->JLabel->Cotainer
        bgpic = new JLabel("", icon2, JLabel.CENTER);
        bgpic.setBounds(0, 0, 1000, 680);
        c.add(bgpic);
    }

    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        int numberOfRow = table.getSelectedRow();

        String fname = model.getValueAt(numberOfRow, 0).toString();
        String lname = model.getValueAt(numberOfRow, 1).toString();
        String ocp = model.getValueAt(numberOfRow, 2).toString();
        String gnd = model.getValueAt(numberOfRow, 3).toString();
        String nid = model.getValueAt(numberOfRow, 4).toString();
        String days = model.getValueAt(numberOfRow, 5).toString();
        String r_no = model.getValueAt(numberOfRow, 6).toString();
        String r_bill = model.getValueAt(numberOfRow, 7).toString();
        String paid = model.getValueAt(numberOfRow, 8).toString();
        String due = model.getValueAt(numberOfRow, 9).toString();
        String phone = model.getValueAt(numberOfRow, 10).toString();
        String pass = model.getValueAt(numberOfRow, 11).toString();

        fnTf.setText(fname);
        lnTf.setText(lname);
        ocpTf.setText(ocp);
        gndShowLabel.setText(gnd);
        nidTf.setText(nid);
        daysShowLabel.setText(days);
        srTf.setText(r_no);
        rbShowLabel.setText(r_bill);
        paidShowLabel.setText(paid);
        dueShowLabel.setText(due);
        phoneTf.setText(phone);
        passPf.setText(pass);

    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    // Action Listener
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == addButton) {

            if (fnTf.getText().length() > 0 && lnTf.getText().length() > 0 && phoneTf.getText().length() > 0
                    && ocpTf.getText().length() > 0 && gndShowLabel.getText().length() > 0
                    && nidTf.getText().length() > 0 && srTf.getText().length() > 0 && passPf.getText().length() > 0) {
                if (rbLabel.getText().length() > 0) {
                    // user je data gula dibe ta rows array er 4ta element e rakhlam
                    rows[0] = fnTf.getText();
                    rows[1] = lnTf.getText();

                    rows[2] = ocpTf.getText();
                    rows[3] = gndShowLabel.getText();
                    rows[4] = nidTf.getText();

                    rows[5] = daysShowLabel.getText();
                    rows[6] = srTf.getText();
                    rows[7] = rbShowLabel.getText();
                    rows[8] = paidShowLabel.getText();
                    rows[9] = dueShowLabel.getText();
                    rows[10] = phoneTf.getText();
                    rows[11] = passPf.getText();

                    // eibar row ta defaultmodeltable er sthe add korbo
                    model.addRow(rows);
                    String selectedRoom = srTf.getText();
                    arsComboBox.removeItem(selectedRoom);
                    ardComboBox.removeItem(selectedRoom);
                    arpComboBox.removeItem(selectedRoom);

                } else {
                    JOptionPane.showMessageDialog(null, "Please tab 'Bill' button first to see room bill");

                }

            } else {
                JOptionPane.showMessageDialog(null, "Please fill up the full form");
            }

        } else if (e.getSource() == updateButton) {
            int numberOfRow = table.getSelectedRow();

            // user text field e abar je value disse se gula get korbo
            String f_name = fnTf.getText();
            String l_name = lnTf.getText();
            String ocp = ocpTf.getText();
            String gnd = gndShowLabel.getText();
            String nid = nidTf.getText();
            String days = daysShowLabel.getText();
            String r_no = srTf.getText();
            String r_bill = rbShowLabel.getText();
            String paid = paidShowLabel.getText();
            String due = dueShowLabel.getText();
            String phone = phoneTf.getText();
            String pass = passPf.getText();

            // eibar segula abar set korbo model e setValueAt method er maddhome..parmeter er moddhe(value,row,column) thkbe

            model.setValueAt(f_name, numberOfRow, 0);
            model.setValueAt(l_name, numberOfRow, 1);

            model.setValueAt(ocp, numberOfRow, 2);
            model.setValueAt(gnd, numberOfRow, 3);
            model.setValueAt(nid, numberOfRow, 4);
            model.setValueAt(days, numberOfRow, 5);
            model.setValueAt(r_no, numberOfRow, 6);
            model.setValueAt(r_bill, numberOfRow, 7);
            model.setValueAt(paid, numberOfRow, 8);
            model.setValueAt(due, numberOfRow, 9);
            model.setValueAt(phone, numberOfRow, 10);
            model.setValueAt(pass, numberOfRow, 11);
        } else if (e.getSource() == deleteButton) {
            int numberOfRow = table.getSelectedRow();
            if (numberOfRow >= 0) {
                model.removeRow(numberOfRow);
            } else {
                JOptionPane.showMessageDialog(null, "No row exists or has been selected");
            }

            fnTf.setText("");
            lnTf.setText("");

            ocpTf.setText("");
            gndShowLabel.setText("");
            nidTf.setText("");

            daysShowLabel.setText("");
            srTf.setText("");
            rbShowLabel.setText("");
            paidShowLabel.setText("");
            dueShowLabel.setText("");
            phoneTf.setText("");
            passPf.setText("");


        } else if (e.getSource() == clearButton) {

            fnTf.setText("");
            lnTf.setText("");

            ocpTf.setText("");
            gndShowLabel.setText("");
            nidTf.setText("");

            daysShowLabel.setText("");
            srTf.setText("");
            rbShowLabel.setText("");
            paidShowLabel.setText("");
            dueShowLabel.setText("");
            phoneTf.setText("");
            passPf.setText("");

        }

        else if (e.getSource() == paymentButton) {

            ImageIcon iconOfYesNo = new ImageIcon("IMG/paid.png");
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to pay through online?", "Payment",
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
                            "Card number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxxx-xxxxxx-xxxxx");
                    // eikhane kew dui ba tar otodik bar payment korte pare..se khetre kintu total bill ekoi thakbe ebong joto bar payment korbe totobar due,and paidbill immidiate ager payment er sapekkhe change hobe.. ejonno due=deu-paidamount.

                    int totalPaid = Integer.parseInt(paidShowLabel.getText());
                    int due = Integer.parseInt(dueShowLabel.getText());
                    // Integer.parseInt() diye int e convert kore

                    String paid = (String) JOptionPane.showInputDialog(null,
                            "Due room bill :" + due + "\nHow much you want to pay?",
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
                            "Payment succesful", JOptionPane.QUESTION_MESSAGE, iconOfCard);

                    paidShowLabel.setText("" + totalPaid);
                    dueShowLabel.setText("" + due);

                } else {

                    String[] optionsOfMobileBanking = { "BKash", "Rocket", "Nagad" };
                    ImageIcon iconOfMobileBanking = new ImageIcon("IMG/mobilebanking.png");
                    String methodOfMobileBanking = (String) JOptionPane.showInputDialog(null, "Select method",
                            "Mobile banking", JOptionPane.QUESTION_MESSAGE, iconOfMobileBanking, optionsOfMobileBanking,
                            optionsOfMobileBanking[2]);
                    if (methodOfMobileBanking.equals("BKash")) {

                        ImageIcon iconOfCard = new ImageIcon("IMG/bkash.jpg");
                        String MobileNumber = (String) JOptionPane.showInputDialog(null, "Enter your mobile number",
                                "Mobile number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxx-xxxxxxxx");// as

                        // eikhane kew dui ba tar otodik bar payment korte pare..se khetre kintu total bill ekoi thakbe ebong joto bar payment korbe totobar due,and paidbill immidiate ager payment er sapekkhe change hobe..ejonno due=deu-paidamount;

                        int totalPaid = Integer.parseInt(paidShowLabel.getText());
                        int due = Integer.parseInt(dueShowLabel.getText());
                        String paid = (String) JOptionPane.showInputDialog(null,
                                "Due room bill :" + due + "\nHow much you want to pay?",
                                "Amount", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "" + due);

                        String pin = (String) JOptionPane.showInputDialog(null,
                                "Enter your otp", "Pin number", JOptionPane.INFORMATION_MESSAGE, iconOfCard, null,
                                "");

                        int paidAmount = Integer.parseInt(paid);
                        due = due - paidAmount;

                        totalPaid = totalPaid + paidAmount;

                        JOptionPane.showMessageDialog(null,
                                "Your payment is succesfully paid " + paidAmount + "tk" + "\nYour due payment " + due
                                        + "tk",
                                "Payment succeful", JOptionPane.QUESTION_MESSAGE, iconOfCard);

                        paidShowLabel.setText("" + totalPaid);
                        dueShowLabel.setText("" + due);

                    } else if (methodOfMobileBanking.equals("Rocket")) {

                        ImageIcon iconOfCard = new ImageIcon("IMG/rocket.png");
                        String MobileNumber = (String) JOptionPane.showInputDialog(null, "Enter your mobile number",
                                "Mobile number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxx-xxxxxxxx");
                        int totalPaid = Integer.parseInt(paidShowLabel.getText());
                        int due = Integer.parseInt(dueShowLabel.getText());

                        String paid = (String) JOptionPane.showInputDialog(null,
                                "Due room bill :" + due + "\nHow much you want to pay?",
                                "Amount", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "" + due);

                        String pin = (String) JOptionPane.showInputDialog(null,
                                "Enter otp number", "Otp number", JOptionPane.INFORMATION_MESSAGE, iconOfCard, null,
                                "");

                        int paidAmount = Integer.parseInt(paid);
                        due = due - paidAmount;

                        totalPaid = totalPaid + paidAmount;

                        JOptionPane.showMessageDialog(null,
                                "Your payment is succesfully paid " + paidAmount + "tk" + "\nYour due payment " + due
                                        + "tk",
                                "Payment succeful", JOptionPane.QUESTION_MESSAGE, iconOfCard);

                        paidShowLabel.setText("" + totalPaid);
                        dueShowLabel.setText("" + due);

                    } else {
                        ImageIcon iconOfCard = new ImageIcon("IMG/nagad.png");
                        String MobileNumber = (String) JOptionPane.showInputDialog(null, "Enter your mobile number",
                                "Mobile number", JOptionPane.QUESTION_MESSAGE, iconOfCard, null, "xxx-xxxxxxxx");
                        int totalPaid = Integer.parseInt(paidShowLabel.getText());
                        int due = Integer.parseInt(dueShowLabel.getText());
                        String paid = (String) JOptionPane.showInputDialog(null,
                                "Due room bill :" + due + "\nHow much you want to pay?",
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

                        paidShowLabel.setText("" + totalPaid);
                        dueShowLabel.setText("" + due);

                    }
                }

            } else {

                this.dispose();
            new AdminLogin().setVisible(true);

            }

        }

        else if (e.getSource() == saveButton) {
            TableSaver save = new TableSaver(table);

            try {
                save.saveTable(Data2);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // userpass
            rowSeparator userPass = new rowSeparator(table);
            try {
                userPass.separate("DATA/userPass.txt", 10, 11);
            } catch (Exception ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Saving Successful");
        } else if (e.getSource() == billButton) {

            try {

                // text field e string value input newa hoi ..take int e convert korar jonno parseInt
                int days = Integer.parseInt(daysShowLabel.getText());
                int roomBill = 0;

                String roomType = rtComboBox.getSelectedItem().toString();

                if (roomType.equals("Standard Room(5000tk)")) {

                    roomBill = days * 5000;

                } else if (roomType.equals("Deluxe Room(10000tk)")) {

                    roomBill = days * 10000;
                }

                else if (roomType.equals("Presidential Suite(50000tk)")) {

                    roomBill = days * 50000;
                } else {
                    JOptionPane.showMessageDialog(null, "Please select room");

                }
                rbShowLabel.setText(String.valueOf(roomBill));// string.valueOd() diye string e convert kore
                dueShowLabel.setText(String.valueOf(roomBill));
                paidShowLabel.setText("" + 0);

            } catch (Exception ec) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "Could not calculate");
                ec.printStackTrace();
            }

        } else if (e.getSource() == backButton) {

            this.dispose();
            new AdminLogin().setVisible(true);

        }

        else {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void update() {
        int numberOfRow = table.getSelectedRow();

        // user text field e abar je value disse se gula get korbo
        String f_name = fnTf.getText();
        String l_name = lnTf.getText();

        String ocp = ocpTf.getText();
        String gnd = gndShowLabel.getText();
        String nid = nidTf.getText();
        String days = daysShowLabel.getText();
        String r_no = srTf.getText();
        String r_bill = rbShowLabel.getText();
        String paid = paidShowLabel.getText();
        String due = dueShowLabel.getText();
        String phone = phoneTf.getText();
        String pass = passPf.getText();

        model.setValueAt(f_name, numberOfRow, 0);
        model.setValueAt(l_name, numberOfRow, 1);

        model.setValueAt(ocp, numberOfRow, 2);
        model.setValueAt(gnd, numberOfRow, 3);
        model.setValueAt(nid, numberOfRow, 4);
        model.setValueAt(days, numberOfRow, 5);
        model.setValueAt(r_no, numberOfRow, 6);
        model.setValueAt(r_bill, numberOfRow, 7);
        model.setValueAt(paid, numberOfRow, 8);
        model.setValueAt(due, numberOfRow, 9);
        model.setValueAt(phone, numberOfRow, 10);
        model.setValueAt(pass, numberOfRow, 11);

    }

    public void savetxt(String s, String s2) throws IOException {
        File txtFile = new File(s);
        FileWriter fWriter = new FileWriter(txtFile);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.write(s2);
        bWriter.close();
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
