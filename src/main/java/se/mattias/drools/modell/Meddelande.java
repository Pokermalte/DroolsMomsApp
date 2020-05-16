package se.mattias.drools.modell;

import java.io.Serializable;

public class Meddelande implements Serializable {
    private static final long serialVersionUID = 1L;
    private Typ typ;
    private String svarsinfo;
    private String attKomplettera;

    public enum Typ {KOMPLETTERING_KRAVS, NOTERING, VARNING, BESKATTNINGSRESULTAT}

    public Meddelande(Typ typ, String svarsinfo, String attKomplettera){
        this.typ = typ;
        this.svarsinfo = svarsinfo;
        this.attKomplettera = attKomplettera;
    }

    public Meddelande(Typ typ, String svarsinfo){
        this.typ = typ;
        this.svarsinfo = svarsinfo;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public String getSvarsinfo() {
        return svarsinfo;
    }

    public void setSvarsinfo(String svarsinfo) {
        this.svarsinfo = svarsinfo;
    }

    public String getAttKomplettera() {
        return attKomplettera;
    }

    public void setAttKomplettera(String attKomplettera) {
        this.attKomplettera = attKomplettera;
    }
}
