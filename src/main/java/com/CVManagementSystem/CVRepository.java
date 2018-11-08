package com.CVManagementSystem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<UserCV, String> {
    Page<UserCV> findByUserId(Long userId, Pageable pageable);
}
