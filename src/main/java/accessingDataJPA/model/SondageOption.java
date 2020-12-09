package accessingDataJPA.model;/*package accessingDataJPA.model;

import accessingDataJPA.model.Sondage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SondageOption {
    private final Map<String, Sondage> sondages = new HashMap<String, Sondage>();
    public SondageOption(){
        super();
    }

    public List<Sondage> findAll() {
        return sondages.values().stream()
                .collect(Collectors.toList());
    }

    //Mettre à jour un sondage
    public Sondage update(final Sondage sondage) {
        sondages.put(sondage.getId(), sondage);
        return sondage;
    }

    //Trouver un sondage avec l'id
    public Sondage findById(final String id) {
        return sondages.get(id);
    }

    // Effacer un sondage
    public void remove(final Sondage sondage) {
        sondages.remove(sondage);
    }

    // Ajouter un sondage
    public Sondage add(final Sondage sondage) {
        final String id = "fr" + System.currentTimeMillis() + "d";
        final Sondage newSondage = new Sondage(id,
                sondage.getName());
                /*sondage.getDescription(),
                sondage.getPlace(),
                sondage.getDate());
        sondages.put(id, newSondage);
        return newSondage;

    }
}*/
