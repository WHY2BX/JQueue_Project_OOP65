import javax.swing.table.DefaultTableModel;

public class DataModel_2 {
    private DefaultTableModel tableModel;

    public DataModel_2() {
        String[] columnNames = {"Student name", "Assignment name", "Table number", "TA name"};
        tableModel = new DefaultTableModel(columnNames, 0);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addItem(String studentName , String Asname, String tableNum, String taName) {
        Object[] rowData = {studentName, Asname, tableNum, taName};
        tableModel.addRow(rowData);
    }
}
