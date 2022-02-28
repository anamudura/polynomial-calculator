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
    }

    class ComputeListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             // String action = event.getActionCommand();
            if (view.b1.getText().equals("Compute")) {
                System.out.println("Am intrat");
                if (view.t1.getText().equals("") || view.t2.getText().equals("")) { //checks for empty text fields
                    view.t5.setText("Enter both polynomials.");
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
}
