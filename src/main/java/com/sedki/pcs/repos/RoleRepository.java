package com.sedki.pcs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sedki.pcs.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
