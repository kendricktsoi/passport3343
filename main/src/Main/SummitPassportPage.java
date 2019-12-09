package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SummitPassportPage {
    private JPanel panelMain;
    private JLabel titleLabel;
    private JTextField lastNameTextField;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel genderLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JPanel genderPanel;
    private JTextField addessLineOneTextField;
    private JTextField addessLineTwoTextField;
    private JTextField addessLineThreeTextField;
    private JTextField telephoneTextField;
    private JTextField emailTextField;
    private JButton resetButton;
    private JButton summitButton;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;

    private JFrame frame;

    public SummitPassportPage() {

        frame = new JFrame("SummitPassportPage");

        JScrollPane scrollPane = new JScrollPane(panelMain);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.setContentPane(scrollPane);
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
                ApplicantFunctionPage page = new ApplicantFunctionPage();



            }
        });

        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                femaleRadioButton.setSelected(false);
            }
        });

        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maleRadioButton.setSelected(false);
            }
        });

        summitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastName = lastNameTextField.getText();
                String firstName = firstNameTextField.getText();
                String gender = getGender();
                String address = addessLineOneTextField.getText() + "|" + addessLineTwoTextField.getText() + "|" + addessLineThreeTextField.getText() + "|";
                String telephone = telephoneTextField.getText();
                String email = emailTextField.getText();
                int refCode = Integer.parseInt(RandomRefCode.getRandomNumberString());

                Connection c = SQLiteJDBC.CreateConnection();
                PreparedStatement pstmt = null;
                String sql = "INSERT INTO Registration(lastName , firstName, gender, address, telephone, email, approved,  refCode) VALUES(?,?,?,?,?,?,?,?)";

                try  {
                    pstmt = c.prepareStatement(sql);
                    pstmt.setString(1, lastName);
                    pstmt.setString(2, firstName);
                    pstmt.setString(3, gender);
                    pstmt.setString(4, address);
                    pstmt.setString(5, telephone);
                    pstmt.setString(6, email);
                    pstmt.setString(7, "False");
                    pstmt.setInt(8, refCode);

                    pstmt.executeUpdate();

                    pstmt.close();
                    c.close();
                } catch (SQLException event) {
                    System.out.println(event.getMessage());
                }

                JOptionPane.showMessageDialog(null, "Please mark down your Reference Code: \n" + refCode);




                frame.setVisible(false);
                ApplicantFunctionPage page = new ApplicantFunctionPage();

            }
        });
    }

    private String getGender(){

        if(maleRadioButton.isSelected()){
            return "Male";
        }

        return "Female";

    }

}
