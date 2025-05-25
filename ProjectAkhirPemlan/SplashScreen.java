import javax.swing.*;

import java.awt.*;

public class SplashScreen extends JWindow { // Inheritance (extends JWindow)
    public SplashScreen (int duration){ // Constructor
        JPanel content = (JPanel) getContentPane();
        content.setBackground(new Color(45, 155, 243)); // Ganti dengan warna yang diinginkan

        JLabel label = new JLabel(new ImageIcon("LogoPanjang.png")); // path logo
        JLabel Copyrt = new JLabel ("loading, sabar yakk....", JLabel.CENTER);
        Copyrt.setFont(new Font("Arial", Font.BOLD, 20));
       

        int width = 400;
        int height = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        content.setLayout(new BorderLayout());
        content.add(label, BorderLayout.CENTER);
        content.add(Copyrt, BorderLayout.SOUTH);
        setVisible(true);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {}
        setVisible(false);
        dispose();
    }
}