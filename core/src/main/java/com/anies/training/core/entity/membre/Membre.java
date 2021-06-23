package com.anies.training.core.entity.membre;

import com.anies.training.core.entity.menage.Menage;


import javax.persistence.*;

@Entity
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "id_membre")
    String idMembre;
    @Column(name = "nom_membre")
    String nomMembre;

    @Column(name = "prenom_membre")
    String prenomMembre;

    /*@ManyToOne()
    @JoinColumn(name = "menage_id", nullable = false)
    @JsonIgnoreProperties(value = "membres",allowSetters = true)*/

    @Transient
    Menage menage;

    Long menage_id;

    public Long getMenage_id() {
        return menage_id;
    }

    public void setMenage_id(Long menage_id) {
        this.menage_id = menage_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(String idMembre) {
        this.idMembre = idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public Menage getMenage() {
        return menage;
    }

    public void setMenage(Menage menage) {
        this.menage = menage;
    }
}
