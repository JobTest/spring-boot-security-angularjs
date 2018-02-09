package org.techforumist.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techforumist.addressbook.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser findOneByUsername(String username);
}
