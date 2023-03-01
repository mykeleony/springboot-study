package io.github.mykeleony.domain.repository;

import io.github.mykeleony.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByNameLike(String name);

    @Query(value = " SELECT * FROM customers c WHERE c.name LIKE '%:name%' ", nativeQuery = true)
    List<Customer> findByNameLike2(@Param("name") String name);

    @Query("SELECT c FROM customers c LEFT JOIN FETCH c.orders WHERE c.id =:id")
    Customer findCustomerFetchOrOrders(@Param("id") Long id);

}
