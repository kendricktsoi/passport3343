import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPage {
    private JLabel titleLabel;
    private JButton iAmApplicantButton;
    private JButton iAmStaffButton;
    private JPanel panelMain;
    private JFrame frame;

    public MainPage(){

        frame = new JFrame("MainPage");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        iAmApplicantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);
                ApplicantFunctionPage page = new ApplicantFunctionPage();


            }
        });

        iAmStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                LoginPage page = new LoginPage("StaffFunctionPage");
            }
        });


    }


}
