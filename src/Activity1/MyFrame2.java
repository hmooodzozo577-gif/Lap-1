import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MyFrame2 - second frame with a "click" button.
// Clicking the button hides this frame and shows MyFrame1.
public class MyFrame2 extends JFrame implements ActionListener {

    private JButton clickButton;
    private MyFrame1 frame1;

    public MyFrame2() {
        setTitle("MyFrame 2");
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        clickButton = new JButton("click");
        clickButton.addActionListener(this);
        add(clickButton);
    }

    // Give this frame a reference to the other frame so it can switch to it.
    public void setFrame1(MyFrame1 frame1) {
        this.frame1 = frame1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        frame1.setVisible(true);
    }
}
