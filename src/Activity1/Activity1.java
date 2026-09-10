import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame1 extends JFrame implements ActionListener {

    private JButton clickButton;
    private MyFrame2 frame2;

    public MyFrame1() {
        setTitle("MyFrame 1");
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        clickButton = new JButton("click");
        clickButton.addActionListener(this);
        add(clickButton);
    }

    public void setFrame2(MyFrame2 frame2) {
        this.frame2 = frame2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        frame2.setVisible(true);
    }
}

class MyFrame2 extends JFrame implements ActionListener {

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

    public void setFrame1(MyFrame1 frame1) {
        this.frame1 = frame1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        frame1.setVisible(true);
    }
}

public class Activity1 {
    public static void main(String[] args) {
        MyFrame1 frame1 = new MyFrame1();
        MyFrame2 frame2 = new MyFrame2();

        frame1.setFrame2(frame2);
        frame2.setFrame1(frame1);

        frame1.setVisible(true);
    }
}
