package com.cyc.mydemo.repository;

import com.cyc.mydemo.entity.Depart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DepartRepository  extends JpaRepository<Depart,Long> {

    List<Depart> getDepartByName(String name);


    @Modifying
    @Transactional
    @Query(value = "update depart m set name = ?2 ,update_time = ?3 where id =?1",nativeQuery = true)
    void updateDepartByName(Long id, String name, LocalDateTime date);


    @Query(value = "SELECT * FROM depart WHERE name = ?1",
            countQuery = "SELECT count(*) FROM depart WHERE name = ?1",
            nativeQuery = true)
    Page<Depart> findByName(String name, Pageable pageable);
}
