package br.com.sustentavel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sustentavel.entity.ArvoreModel;

@Repository
public interface ArvoreRepository extends JpaRepository<ArvoreModel, Long> { }