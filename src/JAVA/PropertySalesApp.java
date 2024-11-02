package JAVA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

public class PropertySalesApp
{
    private JFrame frame;
    private JTextArea reportArea;
    private JTextField agentNameField, propertyPriceField, commissionPercentageField;
    private JComboBox<String> agentLocationComboBox;
    private NumberFormat numberFormat;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new PropertySalesApp().createAndShowGUI());
    }

    private void createAndShowGUI()
    {
        frame = new JFrame("Estate Agent Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Components
        agentLocationComboBox = new JComboBox<>(new String[] { "Cape Town", "Durban", "Victoria" });
        agentNameField = new JTextField(10);
        propertyPriceField = new JTextField(10);
        commissionPercentageField = new JTextField(5);
        reportArea = new JTextArea(10, 30);
        reportArea.setLineWrap(true);
        reportArea.setWrapStyleWord(true);
        reportArea.setEditable(false);
        
        // Number format for European style
        numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);

        // Buttons
        JButton calculateButton = new JButton("Calculate Commission");
        calculateButton.addActionListener(e -> calculateCommission());

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearFields());

        // Layout components
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Agent Location:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(agentLocationComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Agent Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(agentNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(new JLabel("Property Price:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(propertyPriceField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(new JLabel("Commission %:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(commissionPercentageField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        frame.add(calculateButton, gbc);
        gbc.gridy = 5;
        frame.add(clearButton, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        frame.add(new JScrollPane(reportArea), gbc);
        
        frame.pack();
        frame.setVisible(true);
    }

    private void calculateCommission()
    {
        try
        {
            double price = Double.parseDouble(propertyPriceField.getText());
            double commissionRate = Double.parseDouble(commissionPercentageField.getText());
            double commission = price * (commissionRate / 100);
            reportArea.append("Agent: " + agentNameField.getText() + "\n");
            reportArea.append("Commission: " + numberFormat.format(commission) + "\n\n");
        }
        catch (NumberFormatException e)
        {
            reportArea.append("Invalid input. Please enter valid numbers.\n");
        }
    }

    private void clearFields()
    {
        agentNameField.setText("");
        propertyPriceField.setText("");
        commissionPercentageField.setText("");
        reportArea.setText("");
    }
}
