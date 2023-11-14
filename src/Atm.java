import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Atm {
    public static void main(String[] args) {
        // Create a JFrame to hold the application
        JFrame frame = new JFrame("Student Grade System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Create labels and text fields for name, division, and standard
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        JTextField nameField = new JTextField(150);
        nameField.setBounds(100, 20, 200, 25);

        JLabel divisionLabel = new JLabel("Division:");
        divisionLabel.setBounds(20, 60, 80, 25);
        JTextField divisionField = new JTextField(150);
        divisionField.setBounds(100, 60, 200, 25);

        JLabel standardLabel = new JLabel("Standard:");
        standardLabel.setBounds(20, 100, 80, 25);
        JTextField standardField = new JTextField(150);
        standardField.setBounds(100, 100, 200, 25);

        // Create labels and text fields for subject marks
        JLabel marksLabel = new JLabel("Enter Subject Marks:");
        marksLabel.setBounds(20, 140, 200, 25);

        JLabel marathiLabel = new JLabel("Marathi :");
        marathiLabel.setBounds(20, 200, 80, 25);
        JTextField marathiField = new JTextField(150);
        marathiField.setBounds(100, 200, 200, 25);

        JLabel hindiLabel = new JLabel("Hindi :");
        hindiLabel.setBounds(20, 240, 80, 25);
        JTextField hindiField = new JTextField(150);
        hindiField.setBounds(100, 240, 200, 25);

        JLabel englishLabel = new JLabel("English :");
        englishLabel.setBounds(20, 280, 80, 25);
        JTextField englishField = new JTextField(150);
        englishField.setBounds(100, 280, 200, 25);

        JLabel mathLabel = new JLabel("Maths :");
        mathLabel.setBounds(20, 320, 80, 25);
        JTextField mathField = new JTextField(150);
        mathField.setBounds(100, 320, 200, 25);

        JLabel scienceLabel = new JLabel("Science :");
        scienceLabel.setBounds(20, 360, 80, 25);
        JTextField scienceField = new JTextField(150);
        scienceField.setBounds(100, 360, 200, 25);

        // Create a button to calculate average and grade
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 450, 100, 40);

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(divisionLabel);
        panel.add(divisionField);
        panel.add(standardLabel);
        panel.add(standardField);
        panel.add(marksLabel);

        panel.add(marathiLabel);
        panel.add(marathiField);

        panel.add(hindiLabel);
        panel.add(hindiField);

        panel.add(englishLabel);
        panel.add(englishField);

        panel.add(mathLabel);
        panel.add(mathField);

        panel.add(scienceLabel);
        panel.add(scienceField);
        panel.add(calculateButton);

        // Add the panel to the frame
        frame.add(panel);

        // Display the frame
        frame.setVisible(true);

        // Action listener for the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int marathiMarks = Integer.parseInt(marathiField.getText());
                int hindiMarks = Integer.parseInt(hindiField.getText());
                int englishMarks = Integer.parseInt(englishField.getText());
                int mathMarks = Integer.parseInt(mathField.getText());
                int scienceMarks = Integer.parseInt(scienceField.getText());

                int totalMarks = marathiMarks + hindiMarks + englishMarks + mathMarks + scienceMarks;
                double average = totalMarks / 5.0;

                String grade;
                if (average >= 90) {
                    grade = "A+";
                } else if (average >= 80) {
                    grade = "A";
                } else if (average >= 70) {
                    grade = "B";
                } else if (average >= 60) {
                    grade = "C";
                } else {
                    grade = "F";
                }

                JOptionPane.showMessageDialog(frame, "Total Marks: " + totalMarks + "\nAverage: " + average + "\nGrade: " + grade);
            }
        });
    }
}