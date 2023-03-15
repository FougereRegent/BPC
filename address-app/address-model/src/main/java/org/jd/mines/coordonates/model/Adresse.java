package org.jd.mines.coordonates.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "adresse")
public class Adresse {
    private UUID id;
    private Set<Ville> ville;
    private Set<Pays> pays;

    public void setId(UUID id) { this.id = id; }

    @Id
    @Column(name = "uuid", unique = true, nullable = false)
    @UuidGenerator
    public UUID getId() { return id; }

    @OneToMany(mappedBy = "ville")
    public Set<Ville> getVille() { return ville; }

    public void setVille(Set<Ville> ville) { this.ville = ville; }

    @OneToMany(mappedBy = "pays")
    public Set<Pays> getPays() { return pays; }

    public void setPays(Set<Pays> pays) { this.pays = pays; }

    public static final class AdresseBuilder {
        private UUID id;
        private Set<Ville> ville;
        private Set<Pays> pays;

        private AdresseBuilder() {
        }

        public static AdresseBuilder aAdresse() { return new AdresseBuilder(); }

        public AdresseBuilder withId (UUID id) {
            this.id = id;
            return this;
        }

        public AdresseBuilder withVille(Set<Ville> ville) {
            this.ville = ville;
            return this;
        }

        public AdresseBuilder withPays(Set<Pays> pays) {
            this.pays = pays;
            return this;
        }

        public Adresse build() {
            var adresse = new Adresse();
            adresse.setId(id);
            adresse.setVille(ville);
            adresse.setPays(pays);
            return adresse;
        }
    }

}