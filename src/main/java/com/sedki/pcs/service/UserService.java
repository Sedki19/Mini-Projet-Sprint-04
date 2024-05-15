package com.sedki.pcs.service;

import com.sedki.pcs.entities.Role;
import com.sedki.pcs.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}
