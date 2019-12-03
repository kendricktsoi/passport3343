import javax.swing.*;

public class MainPage {
    private JLabel titleLable;
    private JButton iAmApplicantButton;
    private JButton iAmStaffButton;
    private JPanel panalMain;

    public MainPage(){

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainPage");
        frame.setContentPane(new MainPage().panalMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
