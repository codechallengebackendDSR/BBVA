package com.pruebatecnica.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.domain.Instruments;





public interface InstrumentRepository extends JpaRepository<Instruments, String> {
@Modifying
@Query("update Instruments p set p.price= ?1")
@Transactional
void updateAvg(Integer media);
}
