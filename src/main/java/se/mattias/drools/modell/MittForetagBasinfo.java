package se.mattias.drools.modell;

import java.io.Serializable;
import java.util.List;

public class MittForetagBasinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String orgnr;
    private String firma;
    private List<Verksamhet> verksamheter;

    public enum Verksamhet {ATERFORSALJNING_AV_FORDON, UTHYRNING_AV_FORDON, PERSONTRANSPORTER_ENLIGT_TAXITRAFIKLAGEN,
        TRANSPORTER_AV_AVLIDNA, KORKORTSUTBIDLNING_SKATTEPLIKTIG_ENLIGT_ML, OVRIGT}

    public MittForetagBasinfo(String orgnr, String firma, List<Verksamhet> verksamheter){
        this.orgnr = orgnr;
        this.firma = firma;
        this.verksamheter = verksamheter;
    }

    public String getOrgnr() {
        return orgnr;
    }

    public void setOrgnr(String orgnr) {
        this.orgnr = orgnr;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public List<Verksamhet> getVerksamheter() {
        return verksamheter;
    }

    public void setVerksamheter(List<Verksamhet> verksamheter) {
        this.verksamheter = verksamheter;
    }
}
