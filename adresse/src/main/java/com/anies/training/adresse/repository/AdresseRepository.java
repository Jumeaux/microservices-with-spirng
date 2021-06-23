package com.anies.training.adresse.repository;


import com.anies.training.core.entity.adresse.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Long> {
}
