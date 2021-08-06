package InterfazGrafica;

import Componentes.TokensTabla;
import Separador.Lector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUnica extends JFrame{
    private JPanel VentanaUnica;
    private JPanel EntradaPanel;
    private JPanel SalidaPanel;
    private JButton verificarButton;
    private JTextArea textoPruebaArea;
    private JTable resultadosTable;
    private JScrollPane resultadosScroll;

    public VentanaUnica(){
        fixComponents();
        verificarTexto();
    }

    private void fixComponents(){
        this.setContentPane(VentanaUnica);
        this.setTitle("Separador Lexico");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void verificarTexto(){
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lector lector = new Lector(textoPruebaArea.getText());
                lector.separarLexemas();
                TokensTabla tokensTabla = new TokensTabla(lector.getTokens());
                resultadosScroll.removeAll();
                resultadosTable = tokensTabla.getTokensTabla();
                resultadosScroll = new JScrollPane(resultadosTable);
                resultadosScroll.revalidate();
                SalidaPanel.removeAll();
                SalidaPanel.setLayout(new GridLayout());
                SalidaPanel.add(resultadosTable);
                SalidaPanel.repaint();
                redundar().revalidate();
                redundar().repaint();
            }
        });
    }

    private JFrame redundar(){
        return this;
    }
}
