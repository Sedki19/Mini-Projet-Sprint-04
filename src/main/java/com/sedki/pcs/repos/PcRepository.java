package com.sedki.pcs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sedki.pcs.entities.Pc;

public interface PcRepository extends JpaRepository<Pc, Long> {

}
