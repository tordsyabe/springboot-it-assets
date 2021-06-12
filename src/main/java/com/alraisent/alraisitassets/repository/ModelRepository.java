package com.alraisent.alraisitassets.repository;

import com.alraisent.alraisitassets.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Model findByModelId(String modelId);
}
