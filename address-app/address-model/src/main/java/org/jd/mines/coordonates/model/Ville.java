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
@Table(name = "Ville")

public class Ville {
    private UUID id;

    private String nom;

    private int codePostal;

    public void setId(UUID id) { this.id = id; }

    @Id
    @Column(name = "uuid", unique = true, nullable = false )
    @UuidGenerator
    public UUID getId() { return id; }

    @Column(name = "nom")
    @NotBlank
    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    @Column(name = "codePostal")
    @Min(1)
    @NotNull
    public int getCodePostal() { return codePostal; }

    public void setCodePostal(int codePostal) { this.codePostal = codePostal; }

    public static final class VilleBuilder {
        private UUID id;

        private String nom;

        private int codePostal;

        private VilleBuilder(){
        }

        public static VilleBuilder aVille() { return new VilleBuilder(); }

        public VilleBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public VilleBuilder withNom(String nom) {
            this.nom = nom;
            return this;
        }

        public VilleBuilder withCodePostal(int codePostal) {
            this.codePostal= codePostal;
            return this;
        }

        public Ville build() {
            var ville = new Ville();
            ville.setId(id);
            ville.setNom(nom);
            ville.setCodePostal(codePostal);
            return ville;
        }
    }
}