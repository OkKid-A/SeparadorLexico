import InterfazGrafica.VentanaUnica;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaUnica unica = new VentanaUnica();
            }
        });
    }
}
