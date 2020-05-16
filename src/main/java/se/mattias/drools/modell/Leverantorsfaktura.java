package se.mattias.drools.modell;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Leverantorsfaktura implements Serializable {
    private static final long serialVersionUID = 1L;

    private  String fakturaNr;
    private LocalDate fakturadatum;
    private List<Produkt> produkter;
    private Leverantor leverantor;
    private double nettobelopp;
    private double summaMoms;
    private double attBetala;

    public Leverantorsfaktura(String fakturaNr, LocalDate fakturadatum, List<Produkt> produkter, Leverantor leverantor,
                              double nettobelopp, double summaMoms, double attBetala) {
        this.fakturaNr = fakturaNr;
        this.fakturadatum = fakturadatum;
        this.produkter = produkter;
        this.leverantor = leverantor;
        this.nettobelopp = nettobelopp;
        this.summaMoms = summaMoms;
        this.attBetala = attBetala;
    }
    public Leverantorsfaktura(){};

    public String getFakturaNr() {
        return fakturaNr;
    }

    public void setFakturaNr(String fakturaNr) {
        this.fakturaNr = fakturaNr;
    }

    public LocalDate getFakturadatum() {
        return fakturadatum;
    }

    public void setFakturadatum(LocalDate fakturadatum) {
        this.fakturadatum = fakturadatum;
    }

    public List<Produkt> getProdukter() {
        return produkter;
    }

    public void setProdukter(List<Produkt> produkter) {
        this.produkter = produkter;
    }

    public Leverantor getLeverantor() {
        return leverantor;
    }

    public void setLeverantor(Leverantor leverantor) {
        this.leverantor = leverantor;
    }

    public double getNettobelopp() {
        return nettobelopp;
    }

    public void setNettobelopp(double nettobelopp) {
        this.nettobelopp = nettobelopp;
    }

    public double getSummaMoms() {
        return summaMoms;
    }

    public void setSummaMoms(double summaMoms) {
        this.summaMoms = summaMoms;
    }

    public double getAttBetala() {
        return attBetala;
    }

    public void setAttBetala(double attBetala) {
        this.attBetala = attBetala;
    }
}
