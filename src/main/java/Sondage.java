public class Sondage {
    public String name;
    public String place;
    public String date;
    public String description;

    public Sondage(String name, String place, String date, String description){

        super();
        this.name = name;
        this.place = place;
        this.date = date;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getPlace() {
        return place;
    }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Session paintball [ Name:" + name + ", Description:" + description + ", Date de rendez-vous:" + date + ", Lieu:" + place + "]";
    }
}
