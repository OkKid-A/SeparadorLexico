package Componentes;

import Separador.TiposTokens;
import Separador.Token;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TokensTabla{

    private ArrayList<Token> tokens;
    private String[] errores, ids, enteros, decimales, simbolos;
    private int erroresInt, idsInt, enterosInt, decimalesInt, simbolosInt,tamao = 0;
    private JTable tokensTabla;

    public TokensTabla(ArrayList<Token> tokens) {
        this.tokens = tokens;
        separarTokens();
    }

    public void separarTokens() {
        for (int k = 0; k < tokens.size(); k++) {
            switch (tokens.get(k).getTipo()){
                case ERROR:
                    erroresInt++;
                    break;
                case ENTERO:
                    enterosInt++;
                    break;
                case DECIMAL:
                    decimalesInt++;
                    break;
                case SIMBOLO:
                    simbolosInt++;
                    break;
                case IDENTIFICADOR:
                    idsInt++;
                    break;
            }
        }
        if (simbolosInt<enterosInt){
            tamao = enterosInt;
        }
        if (enterosInt<idsInt){
            tamao= idsInt;
        }
        if (idsInt<decimalesInt){
            tamao = decimalesInt;
        }
        if (decimalesInt<erroresInt){
            tamao = erroresInt;
        }
        if (erroresInt<simbolosInt){
            tamao = simbolosInt;
        }
        errores = new String[tamao+1];
        enteros = new String[tamao+1];
        decimales = new String[tamao+1];
        ids = new String[tamao+1];
        simbolos = new String[tamao+1];
        simbolosInt = 1;
        enterosInt = 1;
        decimalesInt = 1;
        idsInt =1;
        erroresInt = 1;
        errores[0] = "Errores";
        enteros[0] = "Enteros";
        decimales[0] = "Decimales";
        ids[0] = "ID";
        simbolos[0] = "Simbolos";
        for (int k = 1; k < tokens.size(); k++) {
            switch (tokens.get(k).getTipo()){
                case ERROR:
                    errores[erroresInt] = tokens.get(k).getContenido();
                    erroresInt++;
                    break;
                case ENTERO:
                    enteros[enterosInt] =  tokens.get(k).getContenido();
                    enterosInt++;
                    break;
                case DECIMAL:
                    decimales[decimalesInt] =  tokens.get(k).getContenido();
                    decimalesInt++;
                    break;
                case SIMBOLO:
                    simbolos[simbolosInt] =  tokens.get(k).getContenido();
                    simbolosInt++;
                    break;
                case IDENTIFICADOR:
                    ids[idsInt] =  tokens.get(k).getContenido();
                    idsInt++;
                    break;
            }
        }
        createTable();
    }

    public void createTable(){
        String[][] datos = new String[5][tamao+1];
        datos[3] = enteros;
        datos[1] = decimales;
        datos[2] = simbolos;
        datos[4] = errores;
        datos[0] = ids;
        DefaultTableModel tableModel = new DefaultTableModel(datos, ids) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tokensTabla = new JTable(tableModel);
        tokensTabla.setModel(tableModel);
    }

    public JTable getTokensTabla() {
        return tokensTabla;
    }
}
