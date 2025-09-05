package Modelo;

public class Palabra {
    private int codigoPalabra;
    private String palabra;
    private String pistaUno;
    private String pistaDos;
    private String pistaTres;

    public Palabra() {
    }

    public Palabra(int codigoPalabra,String palabra, String pistaUno, String pistaDos, String pistaTres) {
        this.codigoPalabra=codigoPalabra;
        this.palabra = palabra;
        this.pistaUno = pistaUno;
        this.pistaDos = pistaDos;
        this.pistaTres = pistaTres;
    }

    public int getCodigoPalabra() {
        return codigoPalabra;
    }

    public void setCodigoPalabra(int codigoPalabra) {
        this.codigoPalabra = codigoPalabra;
    }
    

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPistaUno() {
        return pistaUno;
    }

    public void setPistaUno(String pistaUno) {
        this.pistaUno = pistaUno;
    }

    public String getPistaDos() {
        return pistaDos;
    }

    public void setPistaDos(String pistaDos) {
        this.pistaDos = pistaDos;
    }

    public String getPistaTres() {
        return pistaTres;
    }

    public void setPistaTres(String pistaTres) {
        this.pistaTres = pistaTres;
    }
    
    
    
}