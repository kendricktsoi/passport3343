import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private JLabel titleLabel;
    private JButton iAmApplicantButton;
    private JButton iAmStaffButton;
    private JPanel panalMain;
    private  JFrame frame;

    public MainPage(){

        JFrame frame = new JFrame("MainPage");
        frame.setContentPane(new MainPage().panalMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        iAmApplicantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();

                ApplicantFunctionPage page = new ApplicantFunctionPage();


            }
        });
    }

    public static void main(String[] args) {
        new MainPage();
    }
}
