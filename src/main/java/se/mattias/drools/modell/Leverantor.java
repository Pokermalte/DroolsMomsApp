package se.mattias.drools.modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Leverantor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firma;
    private String orgnr;
    private String momsregnr;
    private List<String> verksamheter;

    public Leverantor(String firma, String momsregnr){
        this.firma = firma;
        this.momsregnr = momsregnr;
    }

    public List<String> HamtaSNI(String orgnr) {
        //Simulerar hämtning från beskattningsdatabasen
        System.out.println("Hämtar SNI-koder för " + orgnr);
        List<String> snikoder = new ArrayList<>();
        switch (orgnr){
            case "SE556036079301":
                snikoder.add("45110");
                snikoder.add("64911");
                break;
            case "SE556036071201":
                snikoder.add("45110");
                snikoder.add("64918");
                break;
            case "SE556039157101":
                snikoder.add("64911");
                break;
        }
        return snikoder;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getOrgnr() {
        return orgnr;
    }

    public void setOrgnr(String orgnr) {
        this.orgnr = orgnr;
    }

    public String getMomsregnr() {
        return momsregnr;
    }

    public void setMomsregnr(String momsregnr) {
        this.momsregnr = momsregnr;
    }

    public List<String> getVerksamheter() {
        return verksamheter;
    }

    public void setVerksamheter(List<String> verksamheter) {
        this.verksamheter = verksamheter;
    }
}
