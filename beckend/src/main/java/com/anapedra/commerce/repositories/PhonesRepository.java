package com.anapedra.commerce.repositories;

import com.anapedra.commerce.entities.Phones;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository extends JpaRepository<Phones,Long> {
}
