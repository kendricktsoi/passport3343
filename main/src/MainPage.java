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

        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        frame = new JFrame("MainPage");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Calculate the frame location

        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;


        //Set the new frame location
        frame.setLocation(x, y);
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
