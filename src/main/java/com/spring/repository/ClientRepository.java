package com.spring.repository;

import com.spring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {


    @Query(value = "SELECT c FROM Client c WHERE c.name LIKE '%' || :string || '%'"
            + " OR c.email LIKE '%' || :string || '%'"
            + " OR c.address LIKE '%' || :string || '%'")
    List<Client> search(@Param("string") String keyword);
}
