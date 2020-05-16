package se.mattias.drools.modell;

import java.io.Serializable;
import java.util.Set;

public class Svar implements Serializable {
    private static final long serialVersionUID = 1L;
    private Set<Meddelande> meddelanden;
    private Leverantorsfaktura leverantorsfaktura;

    public Svar(Set<Meddelande> meddelanden, Leverantorsfaktura leverantorsfaktura){
        this.meddelanden = meddelanden;
        this.leverantorsfaktura = leverantorsfaktura;
    }

    public Set<Meddelande> getMeddelanden() {
        return meddelanden;
    }

    public void setMeddelanden(Set<Meddelande> meddelanden) {
        this.meddelanden = meddelanden;
    }

    public Leverantorsfaktura getLeverantorsfaktura() {
        return leverantorsfaktura;
    }

    public void setSvarsobjekt(Leverantorsfaktura leverantorsfaktura) {
        this.leverantorsfaktura = leverantorsfaktura;
    }
}