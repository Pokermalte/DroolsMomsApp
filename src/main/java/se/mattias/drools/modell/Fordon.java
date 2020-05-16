package se.mattias.drools.modell;

import java.io.Serializable;

public class Fordon implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean pbmcEnligtML;
    private String regNr;
    private Fordonsslag fordonsslag;
    private int totalvikt;
    private String karosserikod; //TODO: Enum? Hur får vi det att fungera?
    private boolean harLuftspalt;
    private boolean lattLastbil;
    private Andamal andamal;
    private boolean avdragsgilltAndamal;
    private int milIMomspliktigVerksamhet;

    public  enum Fordonsslag {PB1, PB2, BUSS, LB, MC}

    public enum Andamal {ATERFORSALJNING, UTHYRNING, PERSONTRANSPORTER_ENLIGT_TAXITRAFIKLAGEN,
        TRANSPORTER_AV_AVLIDNA, SKATTEPLIKTIG_KORKORTSUTBILDNING, OVRIGT}

    public Fordon(String regNr, Fordonsslag fordonsslag, int totalvikt, String karosserikod,
                  boolean harLuftspalt, Andamal andamal, int milIMomspliktigVerksamhet) {
        this.pbmcEnligtML = false;
        this.regNr = regNr;
        this.fordonsslag = fordonsslag;
        this.totalvikt = totalvikt;
        this.karosserikod = karosserikod;
        this.harLuftspalt = harLuftspalt;
        this.lattLastbil = false;
        this.andamal = andamal;
        this.avdragsgilltAndamal = false;
        this.milIMomspliktigVerksamhet = milIMomspliktigVerksamhet;
    }

    public Fordon(String regNr, Fordonsslag fordonsslag, int totalvikt, String karosserikod,
                  Andamal andamal, int milIMomspliktigVerksamhet) {
        this.pbmcEnligtML = false;
        this.regNr = regNr;
        this.fordonsslag = fordonsslag;
        this.totalvikt = totalvikt;
        this.karosserikod = karosserikod;
        this.harLuftspalt = false;
        this.lattLastbil = false;
        this.andamal = andamal;
        this.avdragsgilltAndamal = false;
        this.milIMomspliktigVerksamhet = milIMomspliktigVerksamhet;
    }

    public boolean isPbmcEnligtML() {
        return pbmcEnligtML;
    }

    public void setPbmcEnligtML(boolean pbmcEnligtML) {
        this.pbmcEnligtML = pbmcEnligtML;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public Fordonsslag getFordonsslag() {
        return fordonsslag;
    }

    public void setFordonsslag(Fordonsslag fordonsslag) {
        this.fordonsslag = fordonsslag;
    }

    public int getTotalvikt() {
        return totalvikt;
    }

    public void setTotalvikt(int totalvikt) {
        this.totalvikt = totalvikt;
    }

    public String getKarosserikod() {
        return karosserikod;
    }

    public void setKarosserikod(String karosserikod) {
        this.karosserikod = karosserikod;
    }

    public boolean isHarLuftspalt() {
        return harLuftspalt;
    }

    public void setHarLuftspalt(boolean harLuftspalt) {
        this.harLuftspalt = harLuftspalt;
    }

    public boolean isLattLastbil() {
        return lattLastbil;
    }

    public void setLattLastbil(boolean lattLastbil) {
        this.lattLastbil = lattLastbil;
    }

    public Andamal getAndamal() {
        return andamal;
    }

    public void setAndamal(Andamal andamal) {
        this.andamal = andamal;
    }

    public boolean isAvdragsgilltAndamal() {
        return avdragsgilltAndamal;
    }

    public void setAvdragsgilltAndamal(boolean avdragsgilltAndamal) {
        this.avdragsgilltAndamal = avdragsgilltAndamal;
    }

    public int getMilIMomspliktigVerksamhet() {
        return milIMomspliktigVerksamhet;
    }

    public void setMilIMomspliktigVerksamhet(int milIMomspliktigVerksamhet) {
        this.milIMomspliktigVerksamhet = milIMomspliktigVerksamhet;
    }
}
