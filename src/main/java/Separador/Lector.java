package Separador;

import java.util.ArrayList;
import static Separador.TiposTokens.*;

public class Lector {

    private String textoASeparar;
    private ArrayList<Token> tokens;
    private ArrayList<String> lexemas;
    private Discernor discernor;

    public Lector(String textoASeparar) {
        lexemas = new ArrayList<String>();
        this.textoASeparar = textoASeparar;
        tokens = new ArrayList<Token>();
    }

    public void separarLexemas() {
        textoASeparar = textoASeparar.replace('\n', ' ');
        char[] caracteresTotales = textoASeparar.toCharArray();
        int cont = textoASeparar.length();
        int inicio = 0;
        int fin = 0;
        boolean pasado = false;
        do {
            char analizado = caracteresTotales[fin];
            if ((analizado == ',' || analizado == ' ') && fin - inicio < 1) {
                inicio++;
            } else if ((analizado == ',' || analizado == ' ' || fin == cont - 1)|| analizado == ';'|| analizado == '{'|| analizado == '['||analizado== ']'||analizado == '}') {
                if (fin-inicio<1||fin == cont-1){
                    lexemas.add(textoASeparar.substring(inicio, fin+1));
                } else {
                    lexemas.add(textoASeparar.substring(inicio, fin));
                }
                inicio = fin + 1;
                pasado = true;
            }
            if (fin<cont-1&&!pasado) {
                char siguiente = caracteresTotales[fin + 1];
                if (siguiente == ';'|| siguiente == '{'|| siguiente == '['||siguiente== ']'||siguiente == '}'){
                    lexemas.add(textoASeparar.substring(inicio, fin + 1));
                    inicio = fin + 1;
                }
            }
            pasado = false;
            fin++;
        } while (fin < cont);
        crearTokens();
    }

    public void crearTokens() {
        for (int k = 0; k < lexemas.size();k++){
            Token token = new Token(probarToken(lexemas.get(k)),lexemas.get(k));
            tokens.add(token);
        }
    }

    public TiposTokens probarToken(String lexema){
        TiposTokens respectivo = null;
        try {
            Integer.parseInt(lexema);
            respectivo = ENTERO;
        } catch (NumberFormatException x){
            try {
                Double.parseDouble(lexema);
                respectivo = DECIMAL;
            } catch (NumberFormatException e){
                char[] lexemaSimple = lexema.toCharArray();
                if (lexema.equals(";")|| lexema.equals("{")|| lexema.equals("[")||lexema.equals("]")||lexema.equals("}")){
                    respectivo = SIMBOLO;
                } else if (lexemaSimple.length>1&&!Character.isDigit(lexemaSimple[0])&&probarID(lexemaSimple)){
                    respectivo = IDENTIFICADOR;
                } else {
                    respectivo = ERROR;
                }
            }
        }
        return respectivo;
    }

    public boolean probarID(char[] caracteres){
        boolean paso = true;
        for (int k = 0; k < caracteres.length;k++){
            if (!Character.isLetter(caracteres[k])&&!Character.isDigit(caracteres[k])){
                paso = false;
            }
        }
        return paso;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
}
