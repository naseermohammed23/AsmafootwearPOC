/**
 * 
 */
package com.aa.poc.nno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.poc.nno.entity.Customer;

/**
 * @author 842018
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
