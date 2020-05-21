package se.mattias.drools.util;

import se.mattias.model.MittForetagBasinfo;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<String> hamtaSNI(String orgnr) {
        //Simulerar hämtning från beskattningsdatabasen
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

    public static MittForetagBasinfo taEmotBasinfo(){
        List<MittForetagBasinfo.Verksamhet> verksamheter = new ArrayList<>();
        verksamheter.add(MittForetagBasinfo.Verksamhet.OVRIGT);
        return new MittForetagBasinfo("969696-9696", "Företaget HB", verksamheter);
    }
}
