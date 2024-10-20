import javax.swing.*;
import java.awt.*;

public class FadCalculatorApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public FadCalculatorApp() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Main Menu Panel
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(3, 1));

        JButton hypotenuseButton = new JButton("Hypotenuse Calculator");
        hypotenuseButton.addActionListener(e -> cardLayout.show(mainPanel, "Hypotenuse"));

        JButton circumferenceButton = new JButton("Circumference Calculator");
        circumferenceButton.addActionListener(e -> cardLayout.show(mainPanel, "Circumference"));

        JButton normalCalcButton = new JButton("Normal Calculator");
        normalCalcButton.addActionListener(e -> cardLayout.show(mainPanel, "Normal"));

        mainMenuPanel.add(hypotenuseButton);
        mainMenuPanel.add(circumferenceButton);
        mainMenuPanel.add(normalCalcButton);

        // Hypotenuse Calculator Panel
        JPanel hypotenusePanel = new JPanel(new GridLayout(4, 2));
        JTextField sideAField = new JTextField();
        JTextField sideBField = new JTextField();
        JLabel hypotenuseResult = new JLabel("Result: ");
        JButton calcHypotenuseButton = new JButton("Calculate");

        calcHypotenuseButton.addActionListener(e -> {
            double sideA = Double.parseDouble(sideAField.getText());
            double sideB = Double.parseDouble(sideBField.getText());
            double hypotenuse = Math.sqrt(sideA * sideA + sideB * sideB);
            hypotenuseResult.setText("Result: " + hypotenuse);
        });

        hypotenusePanel.add(new JLabel("Side A: "));
        hypotenusePanel.add(sideAField);
        hypotenusePanel.add(new JLabel("Side B: "));
        hypotenusePanel.add(sideBField);
        hypotenusePanel.add(calcHypotenuseButton);
        hypotenusePanel.add(hypotenuseResult);
        JButton hypotenuseBackButton = new JButton("Back to Main Menu");
        hypotenuseBackButton.addActionListener(e -> cardLayout.show(mainPanel, "Main Menu"));
        hypotenusePanel.add(hypotenuseBackButton);

        // Circumference Calculator Panel
        JPanel circumferencePanel = new JPanel(new GridLayout(3, 2));
        JTextField radiusField = new JTextField();
        JLabel circumferenceResult = new JLabel("Result: ");
        JButton calcCircumferenceButton = new JButton("Calculate");

        calcCircumferenceButton.addActionListener(e -> {
            double radius = Double.parseDouble(radiusField.getText());
            double circumference = 2 * Math.PI * radius;
            circumferenceResult.setText("Result: " + circumference);
        });

        circumferencePanel.add(new JLabel("Radius: "));
        circumferencePanel.add(radiusField);
        circumferencePanel.add(calcCircumferenceButton);
        circumferencePanel.add(circumferenceResult);
        JButton circumferenceBackButton = new JButton("Back to Main Menu");
        circumferenceBackButton.addActionListener(e -> cardLayout.show(mainPanel, "Main Menu"));
        circumferencePanel.add(circumferenceBackButton);

        // Normal Calculator Panel
        JPanel normalCalcPanel = new JPanel(new GridLayout(4, 4));
        JTextField calcField = new JTextField();
        calcField.setEditable(false);
        normalCalcPanel.add(calcField);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(e -> {
                String command = e.getActionCommand();
                if (command.equals("=")) {
                    try {
                        calcField.setText(eval(calcField.getText()));
                    } catch (Exception ex) {
                        calcField.setText("Error");
                    }
                } else {
                    calcField.setText(calcField.getText() + command);
                }
            });
            normalCalcPanel.add(button);
        }

        JButton normalCalcBackButton = new JButton("Back to Main Menu");
        normalCalcBackButton.addActionListener(e -> cardLayout.show(mainPanel, "Main Menu"));
        normalCalcPanel.add(normalCalcBackButton);

        // Adding panels to mainPanel
        mainPanel.add(mainMenuPanel, "Main Menu");
        mainPanel.add(hypotenusePanel, "Hypotenuse");
        mainPanel.add(circumferencePanel, "Circumference");
        mainPanel.add(normalCalcPanel, "Normal");

        add(mainPanel);

        setTitle("Calculator App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private String eval(String expression) {
        // Basic expression evaluation for the normal calculator
        // Using JavaScript engine for simplicity
        try {
            return String.valueOf(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression));
        } catch (Exception e) {
            return "Error";
        }
    }

    public static void main(String[] args) {
        new FadCalculatorApp();
    }
}FadCalculatorApp.java
