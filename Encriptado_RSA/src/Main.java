
/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista f = new Vista();
        RSA m = new RSA();
        Controlador u = new Controlador(f, m);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(f.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        f.mostrar();
        f.asignaOyentes(u);
    }
}
