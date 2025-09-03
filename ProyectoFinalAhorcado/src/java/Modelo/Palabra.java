package Modelo;

public class Palabra {
    private String palabra;
    private String pista1;
    private String pista2;
    private String pista3;

    public Palabra() {}

    public Palabra(String palabra, String pista1, String pista2, String pista3) {
        this.palabra = palabra;
        this.pista1 = pista1;
        this.pista2 = pista2;
        this.pista3 = pista3;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPista1() {
        return pista1;
    }

    public void setPista1(String pista1) {
        this.pista1 = pista1;
    }

    public String getPista2() {
        return pista2;
    }

    public void setPista2(String pista2) {
        this.pista2 = pista2;
    }

    public String getPista3() {
        return pista3;
    }

    public void setPista3(String pista3) {
        this.pista3 = pista3;
    }
}