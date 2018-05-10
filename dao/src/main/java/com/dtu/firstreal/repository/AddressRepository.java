package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
