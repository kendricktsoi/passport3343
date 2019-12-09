import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class ConfirmPassportCollection {
    private JPanel panelMain;
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JButton collectButton;
    private JTextField refCodeDtextField;
    private JTextField dateTextField;
    private JTextField collectionIDTextField;

    private JTable collectionTable;

    private JFrame frame;

    public ConfirmPassportCollection(){

        frame = new JFrame("ConfirmPassportCollection");

        Vector<String> columnNames = new Vector<String>();

        columnNames.addElement("Collection ID");
        columnNames.addElement("Ref. Code");
        columnNames.addElement("Date");
        columnNames.addElement("Collected");

        String query = "Select * from Appointment";
        Vector data = new Vector();

        try {
            data = getData(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        collectionTable = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(collectionTable);

        frame.add( panelMain, BorderLayout.NORTH);
        frame.add( scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        collectionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // get the model from the jtable
                DefaultTableModel model = (DefaultTableModel)collectionTable.getModel();

                // get the selected row index
                int selectedRowIndex = collectionTable.getSelectedRow();

                // set the selected row data into jtextfields
                collectionIDTextField.setText(model.getValueAt(selectedRowIndex, 0).toString());
                refCodeDtextField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                dateTextField.setText(model.getValueAt(selectedRowIndex, 2).toString());
            }
        });


        collectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = SQLiteJDBC.CreateConnection();

                String ID = collectionIDTextField.getText();

                String Query = "UPDATE Appointment SET collected = TRUE where collectionID = " + ID;

                try {

                    PreparedStatement pstmt = c.prepareStatement(Query);
                    pstmt.executeUpdate();

                    pstmt.close();
                    c.close();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }



                DefaultTableModel model = (DefaultTableModel)collectionTable.getModel();

                model.setValueAt("true", Integer.parseInt(ID)-1, 3);
            }
        });

    }


    public Vector getData(String Query) throws SQLException {

        Vector<Object> data = new Vector();

        Connection c = SQLiteJDBC.CreateConnection();
        Statement stat = c.createStatement();
        ResultSet rs = stat.executeQuery(Query);

        while(rs.next())
        {
            Vector<Object> record = new Vector();

            String collectionID = rs.getString("collectionID");
            String refCode = rs.getString("refCode");
            String collectionDate = rs.getString("collectionDate");
            Boolean collected = rs.getBoolean("collected");

            record.addElement(collectionID);
            record.addElement(refCode);
            record.addElement(collectionDate);
            record.addElement(collected);

            data.addElement(record);

        }

        rs.close();
        stat.close();
        c.close();

        return data;

    }


}
