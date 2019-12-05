import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private JLabel titleLabel;
    private JLabel userIDLabel;
    private JTextField userIDTextField;
    private JTextField passwordTextField;
    private JLabel passwordLabel;
    private JButton resetButton;
    private JButton summitButton;
    private JLabel sectionLabel;
    private JButton homeButton;
    private JButton backButton;
    private JPanel panelMain;
    private JFrame frame;

    private String inputPage;

    public LoginPage(String inputPage){

        this.inputPage = inputPage;

        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        frame = new JFrame("LoginPage");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Calculate the frame location

        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;


        //Set the new frame location
        frame.setLocation(x, y);
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
                frame.setVisible(false);
                StaffFunctionPage page = new StaffFunctionPage();
            }
        });
    }

}
