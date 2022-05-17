package be.ehb.insecten.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Insect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Vultet in eh tisj.")
    @Size(max = 60, message = "'t Moeten genoeg karakteires zen eh")
    private String naam;
    private String specialistatie;

    public Insect() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSpecialistatie() {
        return specialistatie;
    }

    public void setSpecialistatie(String specialistatie) {
        this.specialistatie = specialistatie;
    }
}
