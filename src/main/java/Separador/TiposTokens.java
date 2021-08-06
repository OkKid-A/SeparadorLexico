package Separador;

public enum TiposTokens {
    IDENTIFICADOR("ID"),
    ENTERO("Entero"),
    DECIMAL("Decimal"),
    SIMBOLO("Simbolo"),
    ERROR("Error");

    private String nombreToken;

    TiposTokens(String identificador) {
        nombreToken = identificador;
    }

    public String getNombreToken() {
        return nombreToken;
    }

    public void setNombreToken(String nombreToken) {
        this.nombreToken = nombreToken;
    }
}
