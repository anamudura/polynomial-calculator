import javax.swing.*;
import java.util.LinkedList;

public class MVC {
    public static void main(String[] args) {
        JFrame window = new JFrame("Polynomial Calculator");
        Vizualizare view = new Vizualizare(500,500);
        Polinom p =  new Polinom();
        Control c = new Control(view,new LinkedList<Monom>());
        window.setContentPane(view);
        window.pack();
        window.setResizable(true);
        window.setLocation(150,100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
