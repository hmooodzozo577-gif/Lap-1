import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class DistanceConverterFlow extends JFrame implements ActionListener {

    private JLabel milesLabel;
    private JTextField milesField;
    private JButton convertButton;
    private JTextArea resultArea;

    private static final BigDecimal MILES_TO_KM = new BigDecimal("1.60934");

    public DistanceConverterFlow() {
        setTitle("Distance Converter");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        milesLabel = new JLabel("Distance in miles:");
        milesField = new JTextField(8);
        convertButton = new JButton("Convert!");
        convertButton.addActionListener(this);

        resultArea = new JTextArea(8, 24);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(milesLabel);
        add(milesField);
        add(convertButton);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int miles = Integer.parseInt(milesField.getText().trim());
            BigDecimal km = new BigDecimal(miles).multiply(MILES_TO_KM);
            String kmText = km.stripTrailingZeros().toPlainString();
            resultArea.append(miles + " miles = " + kmText + " km\n");
        } catch (NumberFormatException ex) {
            resultArea.append("Please enter a valid integer.\n");
        }
    }

    public static void main(String[] args) {
        DistanceConverterFlow frame = new DistanceConverterFlow();
        frame.setVisible(true);
    }
}
