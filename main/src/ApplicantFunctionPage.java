import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicantFunctionPage {
    private JPanel panelMain;
    private JButton summitPassportRegistrationButton;
    private JButton reviewRegistrationStatusButton;
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JFrame frame;

    public ApplicantFunctionPage(){
        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        frame = new JFrame("ApplicantFunctionPage");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Calculate the frame location

        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;


        //Set the new frame location
        frame.setLocation(x, y);
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

    }


}
