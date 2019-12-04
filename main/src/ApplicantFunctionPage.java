import javax.swing.*;

public class ApplicantFunctionPage {
    private JPanel panalMain;
    private JButton summitPassportRegistrationButton;
    private JButton reviewRegistrationStatusButton;
    private JLabel titleLabel;
    private JLabel sectionLabel;
    private JFrame frame;

    public ApplicantFunctionPage(){
        frame = new JFrame("ApplicantFunctionPage");
        frame.setContentPane(new ApplicantFunctionPage().panalMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
