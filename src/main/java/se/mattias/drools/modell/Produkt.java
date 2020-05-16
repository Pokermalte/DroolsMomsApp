package se.mattias.drools.modell;

import java.io.Serializable;

public class Produkt implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum Produkttyp {FORDON_HYRA, FORDON_FORVARV, OVRIGT}

    private String fakturaSpec;
    private Produkttyp produkttyp;
    private Fordon fordon;
    private int antal;
    private double pris;
    private double momssats;
    private double summa;
    private double momsbelopp;
    private double avdragsgilltBelopp;
    private String svarskod;
    private String meddelande;

    public Produkt(){};

    public Produkt(String fakturaSpec, Produkttyp produkttyp, Fordon fordon, int antal,
                   double pris, double momssats, double summa, double momsbelopp) {
        this.fakturaSpec = fakturaSpec;
        this.produkttyp = produkttyp;
        this.fordon = fordon;
        this.antal = antal;
        this.pris = pris;
        this.momssats = momssats;
        this.summa = summa;
        this.momsbelopp = momsbelopp;
    }

    public Produkt(String fakturaSpec, Produkttyp produkttyp, int antal, double pris,
                   double momssats, double summa, double momsbelopp) {
        this.fakturaSpec = fakturaSpec;
        this.produkttyp = produkttyp;
        this.antal = antal;
        this.pris = pris;
        this.momssats = momssats;
        this.summa = summa;
        this.momsbelopp = momsbelopp;
    }

    public Produkt(String fakturaSpec, int antal, double pris, double momssats, double summa, double momsbelopp) {
        this.fakturaSpec = fakturaSpec;
        this.antal = antal;
        this.pris = pris;
        this.momssats = momssats;
        this.summa = summa;
        this.momsbelopp = momsbelopp;
    }

    public String getFakturaSpec() {
        return fakturaSpec;
    }

    public void setFakturaSpec(String fakturaSpec) {
        this.fakturaSpec = fakturaSpec;
    }

    public Produkttyp getProdukttyp() {
        return produkttyp;
    }

    public void setProdukttyp(Produkttyp produkttyp) {
        this.produkttyp = produkttyp;
    }

    public Fordon getFordon() {
        return fordon;
    }

    public void setFordon(Fordon fordon) {
        this.fordon = fordon;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public double getMomssats() {
        return momssats;
    }

    public void setMomssats(double momssats) {
        this.momssats = momssats;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public double getMomsbelopp() {
        return momsbelopp;
    }

    public void setMomsbelopp(double momsbelopp) {
        this.momsbelopp = momsbelopp;
    }

    public double getAvdragsgilltBelopp() {
        return avdragsgilltBelopp;
    }

    public void setAvdragsgilltBelopp(double avdragsgilltBelopp) {
        this.avdragsgilltBelopp = avdragsgilltBelopp;
    }

    public String getSvarskod() {
        return svarskod;
    }

    public void setSvarskod(String svarskod) {
        this.svarskod = svarskod;
    }

    public String getMeddelande() {
        return meddelande;
    }

    public void setMeddelande(String meddelande) {
        this.meddelande = meddelande;
    }
}
