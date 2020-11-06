
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
        // TO DO
        return sondage;
    }

    // Effacer un sondage
    public void remove(final Sondage name) {
        sondages.remove(name);
    }

    // Ajouter un sondage
    public Sondage add(final Sondage sondage) {
        final Sondage newSondage = new Sondage(sondage.name,
                sondage.description,
                sondage.place,
                sondage.date);
        return newSondage;

    }
}
