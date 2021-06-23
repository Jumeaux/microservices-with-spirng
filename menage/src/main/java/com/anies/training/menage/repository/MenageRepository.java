package com.anies.training.menage.repository;

import com.anies.training.core.entity.menage.Menage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenageRepository extends JpaRepository<Menage,Long> {
}
