import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NumberGuessingGame {
    private JPanel number;
    private JButton checkButton;
    private JTextField useru;
    private JLabel showNumber;
    private JLabel result;
    private JButton showTheNumberButton;
    int cu = 0;
    String s = " ";

    public NumberGuessingGame() {
        showNumber.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                cu = (int) (Math.random() * 100 + 1);
                s = Integer.toString(cu);

            }
        });
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String user = useru.getText();
                int un = Integer.parseInt(user);


                if (un == cu) {
                    result.setText("Correct Guess");
                    showNumber.setText("Congrats.! , play again");
                } else if (un <= 0 || un > 100) {
                    result.setText("Invalid Guess");
                } else if (un > cu) {
                    result.setText("Your Guess Is Too High");
                } else if (un < cu) {
                    result.setText("Your Guess Is Too Low ");
                } else {
                    result.setText("Your Guess Is Incorrect....!");
                }
            }

        });
        showTheNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                showNumber.setText(s);
            }

        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NumberGuessingGame");
        frame.setContentPane(new NumberGuessingGame().number);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(900, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
