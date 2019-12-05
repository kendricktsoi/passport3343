import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        frame = new JFrame("SummitPassportPage");

        JScrollPane scrollPane = new JScrollPane(panelMain);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.setContentPane(scrollPane);
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
                ApplicantFunctionPage page = new ApplicantFunctionPage();
            }
        });

    }
}
