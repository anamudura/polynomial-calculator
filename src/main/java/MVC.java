import javax.swing.*;

public class MVC {
    public static void main(String[] args) {
        JFrame window = new JFrame("Polynomial Calculator");
        window.setContentPane(new Vizualizare(500,500));
        window.pack();
        window.setResizable(true);
        window.setLocation(150,100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
