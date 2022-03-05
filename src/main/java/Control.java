import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Control {
    private Vizualizare view;
    private LinkedList<Monom> polinom;

    public Control(Vizualizare view, LinkedList<Monom> polinom) {
        this.view = view;
        this.polinom = polinom;
        view.addComputeButton(new ComputeListener());
        view.addClearListener(new ClearListener());
    }

    class ComputeListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (view.b1.getText().equals("Compute")) {
                if (view.t3.getText() != null && ((view.t1.getText().equals("") || view.t2.getText().equals("")))) {
                    Polinom y = new Polinom();
                    y.getInput(view.t3.getText());
                    y.derivation(y);
                    view.t5.setText("The resultant polynomial is: " + y.toString() + "\n");
                } else if ((view.t1.getText().equals("") || view.t2.getText().equals(""))) {
                    view.t5.setText("INTRODU AMBELE POLINOAME\n");
                } else {
                    Polinom y = new Polinom();
                    Polinom x = new Polinom();
                    x.getInput(view.t1.getText());
                    y.getInput(view.t2.getText());
                    switch (view.operator.getSelectedIndex()) {
                        case 0: //add
                        {
                            x.add(y);
                            view.t5.setText("The resultant polynomial is: " + x.toString() + "\n");
                        }
                        break;

                        case 1: //subtract
                        {
                            x.subtract(y);
                            view.t5.setText("The resultant polynomial is: " + x.toString() + "\n");
                        }
                        break;
                        case 2: //multiply
                        {
                            x.multiply(y);
                            view.t5.setText("The resultant polynomial is: " + x.toString() + "\n");
                        }
                        break;

                    }
                }
            }

        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (view.b2.getText().equals("Clear")) {
                view.t5.setText("");
                view.t1.setText("");
                view.t2.setText("");
                view.t3.setText("");
            }
        }
    }
}