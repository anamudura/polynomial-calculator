import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vizualizare extends JPanel {
    JTextField t1, t2 ,t3;
    JTextArea t5;
    JLabel p1, p2, op, val, exp,p3;
    JButton b1 = new JButton("Compute");
    JButton b2 = new JButton("Clear");
    JComboBox<String> operator;
    private LinkedList<Monom> polinom;
    public Vizualizare(int width, int height) {
        setLayout(null);
        setBackground(new Color(252, 109, 151, 171));
        setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
        setPreferredSize(new Dimension(width, height));

        operator = new JComboBox<String>();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t5 = new JTextArea();
        p1 = new JLabel("Enter the first polynomial");
        p2 = new JLabel("Enter the second polynomial");
        p3 = new JLabel("Enter the polynomial for derivation");
        op = new JLabel("Enter the operator");

        operator.addItem("+");
        operator.addItem("-");
        operator.addItem("*");
        operator.addItem("deriv");
        operator.addItem("integrate");
        operator.setBackground(Color.WHITE);
        b1.setBackground(Color.GRAY);
        b2.setBackground(Color.GRAY);

        add(t1);
        add(t2);

        add(t5);

        add(p1);
        add(p2);
        add(p3);
        add(op);
        add(b1);
        add(operator);
        add(b2);
        add(t3);

        p1.setBounds(15, height - 490, width - 30, 23);
        t1.setBounds(12, height - 465, (width - 165) / 2, 28);
        p2.setBounds(15, height - 425, width - 30, 23);
        p3.setBounds(15, height - 350, width - 30, 23);
        t2.setBounds(12, height - 400, (width - 165) / 2, 28);
        b1.setBounds(width / 4 - 10, height - 270, (width - 30) /2, 28);
        operator.setBounds(width / 2 - 10, height - 433, (width - 40) / 2, 28);
        op.setBounds(244, height - 458, width - 30, 23);
        t5.setBounds(12, height - 225, width - 24, 172);
        b2.setBounds(width / 2 - 10, height - 40, (width - 30) / 2, 28);
        t3.setBounds(12, height - 330, (width - 165) / 2, 28);



    }
    String getUserInput() {
        return p1.getText();
    }

    void setTotal(String newTotal) {
        t5.setText(newTotal);
    }

    void addComputeButton(ActionListener comp) {
        b1.addActionListener(comp);
    }

    void addClearListener(ActionListener clear) {
        b2.addActionListener(clear);
    }
}
