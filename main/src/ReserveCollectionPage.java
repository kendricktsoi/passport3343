

import org.jdatepicker.impl.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ReserveCollectionPage {
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JPanel panelMain;
    private JButton resetButton;
    private JButton summitButton;
    private JPanel datePanel;


    private JDatePickerImpl datePicker;

    private JFrame frame;

    private String refCode;

    public ReserveCollectionPage(String refCode){

        this.refCode = refCode;

        frame = new JFrame("ReserveCollectionPage");

        initDatePicker();

        datePanel.add(datePicker);

        frame.add( panelMain);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        summitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection c = SQLiteJDBC.CreateConnection();

                String collectionDate = datePicker.getJFormattedTextField().getText();

                String Query = "INSERT INTO Appointment(refCode,collectionDate,collected) VALUES(?,?,?)";

                try {
                    PreparedStatement pstmt = c.prepareStatement(Query);
                    pstmt.setString(1, refCode);
                    pstmt.setString(2, collectionDate);
                    pstmt.setBoolean(3, false);
                    pstmt.executeUpdate();

                    pstmt.close();
                    c.close();

                    JOptionPane.showMessageDialog(null, "The passport collection is reserved for this case: \n" + refCode);
                } catch (SQLException event) {
                    System.out.println(event.getMessage());
                }
            }



        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datePicker.getJFormattedTextField().setText("");
            }
        });
    }

    public void initDatePicker(){
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

    }



}


