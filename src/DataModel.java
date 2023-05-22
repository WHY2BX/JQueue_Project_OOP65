import javax.swing.table.DefaultTableModel;

public class DataModel {
    private DefaultTableModel tableModel;

    public DataModel() {
        String[] columnNames = {"Assignment", "Assignment name", "Deadline"};
        tableModel = new DefaultTableModel(columnNames, 0);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addItem(int assignment , String name, String deadline) {
        Object[] rowData = {assignment, name, deadline};
        tableModel.addRow(rowData);
    }
}
