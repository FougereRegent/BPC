package org.sam.mines.address.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "target")
public class TargetEntity {
    private UUID id;
    private String firstname;
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

    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "targets")
    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }
}
