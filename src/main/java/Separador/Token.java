package Separador;

public class Token {

    private TiposTokens tipo;
    private String contenido;

    public Token(TiposTokens tipo, String contenido){
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public TiposTokens getTipo() {
        return tipo;
    }

    public void setTipo(TiposTokens tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
