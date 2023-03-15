package org.jd.mines.coordonates.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@Table(name = "pays")
public class Pays {
    private UUID id;

    private String nom;

    private String continent;

    public void setId(UUID id) { this.id = id; }

    @Id
    @Column(name = "uuid", unique = true, nullable = false)
    @UuidGenerator
    public UUID getId() { return id; }

    @Column(name = "nom")
    @NotBlank
    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    @Column(name = "continent")
    @NotBlank
    public String getContinent() { return continent; }

    public void setContinent(String continent) { this.continent = continent; }

    public static final class PaysBuilder {
        private UUID id;
        private String nom;
        private String continent;

        private PaysBuilder() {
        }

        public static PaysBuilder aPays() { return new PaysBuilder(); }

        public PaysBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public PaysBuilder withNom(String nom) {
            this.nom = nom;
            return this;
        }

        public PaysBuilder withContinent(String continent) {
            this.continent = continent;
            return this;
        }

        public Pays build() {
            var pays = new Pays();
            pays.setId(id);
            pays.setNom(nom);
            pays.setContinent(continent);
            return pays;
        }
    }
}
