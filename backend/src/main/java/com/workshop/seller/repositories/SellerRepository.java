package com.workshop.seller.repositories;

import com.workshop.seller.entities.Seller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
  
}
