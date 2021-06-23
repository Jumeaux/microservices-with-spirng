INSERT INTO MEMBRE(ID,ID_MEMBRE, NOM_MEMBRE, PRENOM_MEMBRE,MENAGE_ID) VALUES
  (1,'21041070085242','DIAKITE','KELEFA',1),
  (2,'21041070085243','SOUMAH','FATOUMATA',2),
  (3,'21041070085244','CAMARA','ABDOULAYE',3),
  (4,'21041070085245','CONDE','ALHPA',4),
  (5,'21041070085242','DIALLO','IBRAHIMA',5),





    /*@ManyToOne()
    @JoinColumn(name = "menage_id", nullable = false)
    @JsonIgnoreProperties(value = "membres",allowSetters = true)*/

    @Transient
    Menage menage;

    Long menage_id;
