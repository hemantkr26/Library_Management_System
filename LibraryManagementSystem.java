import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryManagementSystem extends JFrame implements ActionListener {
    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton[] buttons;
    private JPanel mainPanel;
    private ArrayList<String[]> books = new ArrayList<>();

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeComponents();

        mainPanel = new JPanel(new GridLayout(12, 0, 10, 10));
        for (int i = 0; i < labels.length; i++) {
            mainPanel.add(labels[i]);
            mainPanel.add(textFields[i]);
        }
        for (JButton button : buttons) {
            button.addActionListener(this);
            mainPanel.add(button);
        }

        add(mainPanel);
        setVisible(true);
    }

    private void initializeComponents() {
        labels = new JLabel[]{
            new JLabel("Book ID"), new JLabel("Book Title"), new JLabel("Author"),
            new JLabel("Publisher"), new JLabel("Year of Publication"), new JLabel("ISBN"),
            new JLabel("Number of Copies")
        };

        textFields = new JTextField[]{
            new JTextField(10), new JTextField(20), new JTextField(20),
            new JTextField(20), new JTextField(10), new JTextField(20),
            new JTextField(10)
        };

        buttons = new JButton[]{
            new JButton("Add"), new JButton("View"), new JButton("Edit"),
            new JButton("Delete"), new JButton("Clear"), new JButton("Exit")
        };
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            String[] book = new String[7];
            for (int i = 0; i < textFields.length; i++) {
                book[i] = textFields[i].getText();
            }
            books.add(book);
            String message = "<html><strong>Book added successfully:</strong><br>"
                    + "Book ID: <em>" + book[0] + "</em><br>"
                    + "Book Title: <em>" + book[1] + "</em></html>";
            JOptionPane.showMessageDialog(this, message);
            clearFields();
        } else if (e.getSource() == buttons[1]) {
            // View books functionality
        } else if (e.getSource() == buttons[2]) {
            // Edit book functionality
        } else if (e.getSource() == buttons[3]) {
            // Delete book functionality
        } else if (e.getSource() == buttons[4]) {
            clearFields();
        } else if (e.getSource() == buttons[5]) {
            System.exit(0);
        }
    }

    private void clearFields() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementSystem());
    }
}
