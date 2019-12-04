import javax.swing.*;
import java.awt.*;

public class ApplicantFunctionPage {
    private JPanel panalMain;
    private JButton summitPassportRegistrationButton;
    private JButton reviewRegistrationStatusButton;
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JFrame frame;

    public ApplicantFunctionPage(){
        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        frame = new JFrame("ApplicantFunctionPage");
        frame.setSize(500, 500);
        frame.setContentPane(panalMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Calculate the frame location

        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;


        //Set the new frame location
        frame.setLocation(x, y);
        frame.pack();
        frame.setVisible(true);
    }


}
