package com.thbs.Repository;

import com.thbs.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<Users, String> {
}
