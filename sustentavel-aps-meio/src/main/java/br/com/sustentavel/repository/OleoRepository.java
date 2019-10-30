package br.com.sustentavel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sustentavel.entity.OleoModel;

@Repository
public interface OleoRepository extends JpaRepository<OleoModel, Long> { }