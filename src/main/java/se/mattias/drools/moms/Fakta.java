package se.mattias.drools.moms;

import se.mattias.model.*;

import java.util.ArrayList;
import java.util.List;

public class Fakta {

    public static MittForetagBasinfo taEmotBasinfo(){
        List<MittForetagBasinfo.Verksamhet> verksamheter = new ArrayList<>();
        verksamheter.add(MittForetagBasinfo.Verksamhet.OVRIGT);
        return new MittForetagBasinfo("969696-9696", "Företaget HB", verksamheter);
    }
}
