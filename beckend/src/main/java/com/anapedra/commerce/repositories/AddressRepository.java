package com.anapedra.commerce.repositories;

import com.anapedra.commerce.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
