package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPage {
    private JLabel titleLabel;
    private JLabel userIDLabel;
    private JTextField userIDTextField;
    private JLabel passwordLabel;
    private JButton resetButton;
    private JButton summitButton;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JPanel panelMain;
    private JPasswordField passwordTextField;
    private JFrame frame;

    private String inputPage;

    public LoginPage(String inputPage){

        this.inputPage = inputPage;


        frame = new JFrame("LoginPage");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

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

        summitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String staffID = userIDTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());

                if(staffID.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(null, "Please input ID and password");
                    return;
                }

                Connection c = SQLiteJDBC.CreateConnection();
                String query = "Select * from Staff where staffID =" + staffID + " and password = " + password;

                Statement stat = null;
                try {
                    stat = c.createStatement();
                    ResultSet rs = stat.executeQuery(query);

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "There are no this staff" );
                    }else{
                        frame.setVisible(false);
                        StaffFunctionPage page = new StaffFunctionPage();
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
