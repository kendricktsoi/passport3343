import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;


public class ViewPassportRegistrationPage {
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JPanel panelMain;
    private JButton approveButton;
    private JTextField registrationIDtextField;
    private JTextField lastNameTextField;
    private JTextField firstNameTextField;
    private JButton rejectButton;

    private JTable registrationTable;

    private JFrame frame;


    public ViewPassportRegistrationPage(){
        frame = new JFrame("ViewPassportRegistrationPage");

        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Registration ID");
        columnNames.addElement("Last Name");
        columnNames.addElement("First Name");
        columnNames.addElement("Gender");
        columnNames.addElement("Address");
        columnNames.addElement("Telephone");
        columnNames.addElement("Email");
        columnNames.addElement("Approved");
        columnNames.addElement("Ref. Code");

        String query = "Select * from Registration";
        Vector data = new Vector();

        try {
            data = getData(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        registrationTable = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(registrationTable);

        frame.add( panelMain, BorderLayout.NORTH);
        frame.add( scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        registrationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // get the model from the jtable
                DefaultTableModel model = (DefaultTableModel)registrationTable.getModel();

                // get the selected row index
                int selectedRowIndex = registrationTable.getSelectedRow();

                // set the selected row data into jtextfields
                registrationIDtextField.setText(model.getValueAt(selectedRowIndex, 0).toString());
                lastNameTextField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                firstNameTextField.setText(model.getValueAt(selectedRowIndex, 2).toString());
            }
        });

        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = SQLiteJDBC.CreateConnection();

                String ID = registrationIDtextField.getText();

                String Query = "UPDATE Registration SET Approved = TRUE where registrationID = " + ID;

                try {

                    PreparedStatement pstmt = c.prepareStatement(Query);
                    pstmt.executeUpdate();

                    pstmt.close();
                    c.close();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }



                DefaultTableModel model = (DefaultTableModel)registrationTable.getModel();

                model.setValueAt("true", Integer.parseInt(ID)-1, 7);

            }
        });

        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = SQLiteJDBC.CreateConnection();

                String ID = registrationIDtextField.getText();

                String Query = "UPDATE Registration SET Approved = FALSE where registrationID = " + ID;

                try {

                    PreparedStatement pstmt = c.prepareStatement(Query);
                    pstmt.executeUpdate();

                    pstmt.close();
                    c.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }



                DefaultTableModel model = (DefaultTableModel)registrationTable.getModel();

                model.setValueAt("false", Integer.parseInt(ID)-1, 7);
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainPage page = new MainPage();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StaffFunctionPage page = new StaffFunctionPage();
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

                int registrationID = rs.getInt("registrationID");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                int telephone = rs.getInt("telephone");
                String email = rs.getString("email");
                Boolean approved = rs.getBoolean("approved");
                int code = rs.getInt("refCode");

                record.addElement(registrationID);
                record.addElement(lastName);
                record.addElement(firstName);
                record.addElement(gender);
                record.addElement(address);
                record.addElement(telephone);
                record.addElement(email);
                record.addElement(approved);
                record.addElement(code);

                data.addElement(record);

            }

            rs.close();
            stat.close();
            c.close();

            return data;

    }




}
