package com.workshop.seller.services;

import java.util.List;
import java.util.stream.Collectors;

import com.workshop.seller.dto.SellerDTO;
import com.workshop.seller.entities.Seller;
import com.workshop.seller.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

  @Autowired
  private SellerRepository repository;

  public List<SellerDTO> findAll(){
    List<Seller> result = repository.findAll();
    return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
  }
}
