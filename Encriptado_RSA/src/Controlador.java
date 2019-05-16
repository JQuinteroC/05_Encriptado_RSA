
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class Controlador implements ActionListener, KeyListener {

    Vista d;
    RSA t;

    public Controlador(Vista d, RSA t) {
        this.d = d;
        this.t = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(d.btnEncriptar)) {
            d.setSize(new Dimension(d.getWidth(), d.getHeight()+ 30));
            d.txtResultado.setSize(d.txtResultado.getWidth(), d.txtResultado.getHeight() + 30);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!e.getSource().equals(d.txtPalabra)) {
            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        } else {
            if (Character.isDigit(e.getKeyChar()) || Character.isUpperCase(e.getKeyChar())) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
