package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class ApplicantFunctionPage {
    private JPanel panelMain;
    private JButton summitPassportRegistrationButton;
    private JButton reviewRegistrationStatusButton;
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JButton reservePassportCollectionButton;
    private JFrame frame;

    public ApplicantFunctionPage(){

        frame = new JFrame("ApplicantFunctionPage");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        summitPassportRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SummitPassportPage page = new SummitPassportPage();
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
                MainPage page = new MainPage();
            }
        });

        reviewRegistrationStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String refCode = "000000";

                refCode= JOptionPane.showInputDialog("Please input your refCode: ");

                if(refCode == null){
                    return;
                }

                if(Objects.equals(refCode, "")){
                    JOptionPane.showMessageDialog(null, "You input nothing");
                    return;
                }

                Connection c = SQLiteJDBC.CreateConnection();
                String query = "Select * from Registration where refCode =" + refCode;

                Statement stat = null;
                try {
                    stat = c.createStatement();
                    ResultSet rs = stat.executeQuery(query);

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "There are no case for this code: \n" + refCode);
                    }else{
                        Boolean approved = rs.getBoolean("approved");
                        if(approved){
                            JOptionPane.showMessageDialog(null, "The application is approved for this code: \n" + refCode);
                        }else{
                            JOptionPane.showMessageDialog(null, "The application is not approved for this code: \n" + refCode);
                        }
                    }

                    c.close();
                    stat.close();
                    rs.close();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
        });

        reservePassportCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String refCode = "000000";

                refCode= JOptionPane.showInputDialog("Please input your refCode: ");

                if(refCode == null){
                    return;
                }

                if(Objects.equals(refCode, "")){
                    JOptionPane.showMessageDialog(null, "You input nothing");
                    return;
                }

                Connection c = SQLiteJDBC.CreateConnection();
                String query = "Select * from Registration where refCode =" + refCode;

                Statement stat = null;
                try {
                    stat = c.createStatement();
                    ResultSet rs = stat.executeQuery(query);

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "There are no case for this code: \n" + refCode);
                    }else{
                        Boolean approved = rs.getBoolean("approved");
                        if(!approved){
                            JOptionPane.showMessageDialog(null, "The application is approved for this code: \n" + refCode);
                        }else{
                            frame.setVisible(false);
                            ReserveCollectionPage page = new ReserveCollectionPage(refCode);
                        }
                    }

                    c.close();
                    stat.close();
                    rs.close();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
        });

    }


}
