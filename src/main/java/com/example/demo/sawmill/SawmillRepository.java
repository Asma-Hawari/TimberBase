package com.example.demo.sawmill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SawmillRepository
        extends JpaRepository<Sawmill,Long> {

}
