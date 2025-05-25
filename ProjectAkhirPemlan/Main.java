public class Main {
    public static void main(String[] args) {

        SplashScreen splash = new SplashScreen(3000); // Membuat objek SplashScreen (Constructor, Asosiasi)
        splash.setVisible(true);
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LostItemApp(); // Membuat objek LostItemApp (Constructor, Asosiasi)
        });
    }
}
