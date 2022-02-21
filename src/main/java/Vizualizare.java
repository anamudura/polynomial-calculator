import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vizualizare extends JPanel {
    JTextField t1, t2, t3, t4;
    JTextArea t5;
    JLabel p1, p2, op, val, exp;
    JComboBox<String> operator;
    private LinkedList<Monom> polinom;
    public Vizualizare(int width, int height) {
        setLayout(null);
        setBackground(new Color(213, 62, 99));
        setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
        setPreferredSize(new Dimension(width, height)); //sets the size of the panel

        operator = new JComboBox<String>(); //initializes the elements of the interface
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextArea();
        p1 = new JLabel("Enter the first polynomial");
        p2 = new JLabel("Enter the second polynomial");
        op = new JLabel("Enter the operator");
        val = new JLabel("Enter the value at which the first polynomial is to be evaluated");
        exp = new JLabel("Enter the exponent value");

        operator.addItem("+"); //adds options to the combo box
        operator.addItem("-");
        operator.addItem("*");
        operator.addItem("^ (for 1st polynomial)");
        operator.setBackground(Color.WHITE);

        JButton b1 = new JButton("Compute"); //adds two buttons and implements the action listener interface for both buttons

        b1.setBackground(Color.GRAY);

        JButton b2 = new JButton("Clear");

        b2.setBackground(Color.GRAY);

        add(t1); //adds the elements to the frame
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(val);
        add(exp);
        add(p1);
        add(p2);
        add(op);
        add(b1);
        add(operator);
        add(b2);

        p1.setBounds(15, height - 490, width - 30, 23); //sets the size and the location of the elements in the frame
        t1.setBounds(12, height - 465, (width - 165) / 2, 28);
        p2.setBounds(15, height - 425, width - 30, 23);
        t2.setBounds(12, height - 400, (width - 165) / 2, 28);
        val.setBounds(15, height - 360, width - 30, 23);
        t3.setBounds(12, height - 335, (width - 165) / 2, 28);
        exp.setBounds(15, height - 295, width - 30, 23);
        t4.setBounds(12, height - 270, (width - 165) / 2, 28);
        b1.setBounds(width / 2 - 10, height - 303, (width - 30) / 2, 28);
        operator.setBounds(width / 2 - 10, height - 433, (width - 40) / 2, 28);
        op.setBounds(244, height - 458, width - 30, 23);
        t5.setBounds(12, height - 225, width - 24, 172);
        b2.setBounds(width / 2 - 10, height - 40, (width - 30) / 2, 28);



    }
//    String getUserInput() {
//        return m_userInputTf.getText();
//    }
//
//    void setTotal(String newTotal) {
//        m_totalTf.setText(newTotal);
//    }
//
//    void showError(String errMessage) {
//        JOptionPane.showMessageDialog(this, errMessage);
//    }
//
//    void addMultiplyListener(ActionListener mal) {
//        m_multiplyBtn.addActionListener(mal);
//    }
//
//    void addClearListener(ActionListener cal) {
//        m_clearBtn.addActionListener(cal);
//    }
}
