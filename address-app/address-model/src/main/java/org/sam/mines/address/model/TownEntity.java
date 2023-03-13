package org.sam.mines.address.model;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "town")
public class TownEntity {
    private UUID id;
    private int postCode;
    private String name;
    private Set<AddressEntity> addresses;

    public void setId(UUID id) {
        this.id = id;
    }

    @Id
    @Column(name = "uuid", unique = true, nullable = false)
    @UuidGenerator
    public UUID getId() {
        return id;
    }

    @Column(name = "postcode")
    @Min(1)
    @NotNull
    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "town")
    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }


    public static final class TownBuilder {
        private UUID id;
        private int postCode;
        private String name;
        private Set<AddressEntity> addresses;

        private TownBuilder() {
        }

        public static TownBuilder aTown() {
            return new TownBuilder();
        }

        public TownBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public TownBuilder withPostCode(int postCode) {
            this.postCode = postCode;
            return this;
        }

        public TownBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TownBuilder withAddresses(Set<AddressEntity> addresses) {
            this.addresses = addresses;
            return this;
        }

        public TownEntity build() {
            var town = new TownEntity();
            town.setId(id);
            town.setPostCode(postCode);
            town.setName(name);
            town.setAddresses(addresses);
            return town;
        }
    }
}
