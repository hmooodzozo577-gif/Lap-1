import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

// Activity 2 - Question 2
// Distance Converter built with a combination of BorderLayout and FlowLayout.
// NORTH: a FlowLayout panel with the label, text field and button.
// CENTER: the text area showing the conversion results.
public class DistanceConverterBorderFlow extends JFrame implements ActionListener {

    private JLabel milesLabel;
    private JTextField milesField;
    private JButton convertButton;
    private JTextArea resultArea;

    // 1 mile = 1.60934 kilometers
    private static final BigDecimal MILES_TO_KM = new BigDecimal("1.60934");

    public DistanceConverterBorderFlow() {
        setTitle("Distance Converter");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The main frame uses BorderLayout.
        setLayout(new BorderLayout());

        // NORTH panel uses FlowLayout for the label, text field and button.
        JPanel northPanel = new JPanel(new FlowLayout());
        milesLabel = new JLabel("Distance in miles:");
        milesField = new JTextField(8);
        convertButton = new JButton("Convert!");
        convertButton.addActionListener(this);

        northPanel.add(milesLabel);
        northPanel.add(milesField);
        northPanel.add(convertButton);

        // CENTER area shows the conversion results.
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
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
        DistanceConverterBorderFlow frame = new DistanceConverterBorderFlow();
        frame.setVisible(true);
    }
}
