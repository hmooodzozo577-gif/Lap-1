import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MyFrame1 - first frame with a "click" button.
// Clicking the button hides this frame and shows MyFrame2.
public class MyFrame1 extends JFrame implements ActionListener {

    private JButton clickButton;
    private MyFrame2 frame2;

    public MyFrame1() {
        setTitle("MyFrame 1");
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridBagLayout with no constraints keeps the button small
        // and centers it in the middle of the frame.
        setLayout(new GridBagLayout());

        clickButton = new JButton("click");
        clickButton.addActionListener(this);
        add(clickButton);
    }

    // Give this frame a reference to the other frame so it can switch to it.
    public void setFrame2(MyFrame2 frame2) {
        this.frame2 = frame2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        frame2.setVisible(true);
    }
}
