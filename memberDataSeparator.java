import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class memberDataSeparator {

    private JTable table;
    private DefaultTableModel model;
    private String[] cols = { "First name", "Last name", "Occupation", "Gender", "NID","Days", "Room no", "Roob bill", "Paid amount", "Due amount", "Phone number", "Password" };

    // row value user theke nibo
    private String[] rows = new String[12];

    public void dataSeparate(int a) {

        table = new JTable();

        TableReader tt5 = new TableReader();
        model = new DefaultTableModel();
        File f = new File("DATA/Data2.txt");
        if (f.length() != 0) {
            model = tt5.createModel("DATA/Data2.txt");
        }
        model.setColumnIdentifiers(cols);
        table.setModel(model);

        memberTable mt = new memberTable(table);

        try {
            mt.saveTable("DATA/member.txt", a - 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
