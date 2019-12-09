import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffFunctionPage {

    private JPanel panelMain;
    private JLabel titleLabel;
    private JButton viewPassportRegistrationButton;
    private JButton confirmPassportCollectionButton;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JFrame frame;

    public StaffFunctionPage(){

        frame = new JFrame("StaffFunctionPage");
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
                LoginPage page = new LoginPage("StaffFunctionPage");
            }
        });

        viewPassportRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ViewPassportRegistrationPage page = new ViewPassportRegistrationPage();
            }
        });

        confirmPassportCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ConfirmPassportCollection page = new ConfirmPassportCollection();
            }
        });

    }



}
