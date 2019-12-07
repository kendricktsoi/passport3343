import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class ViewPassportRegistrationPage {
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JPanel panelMain;

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

        String query = "Select * from Registration";
        Vector data = new Vector();

        try {
            data = getData(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable registrationTable = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(registrationTable);

        frame.add( panelMain, BorderLayout.NORTH);

        frame.add( scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


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

                record.addElement(registrationID);
                record.addElement(lastName);
                record.addElement(firstName);
                record.addElement(gender);
                record.addElement(address);
                record.addElement(telephone);
                record.addElement(email);
                record.addElement(approved);

                data.addElement(record);

            }

            rs.close();
            stat.close();
            c.close();

            return data;

    }



}
