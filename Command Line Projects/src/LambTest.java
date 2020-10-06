import javax.swing.*;


public class LambTest extends JFrame {


    LambTest() {
        JButton button = new JButton("Click me");
        button.addActionListener((e) -> System.out.println("Clicked " + e.getSource())); //Lambda Expression
        this.getContentPane().add(button);
        this.setSize(100,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new LambTest();
    }
}
