package com.workshop.seller.services;

import java.util.List;

import com.workshop.seller.dto.SaleDTO;
import com.workshop.seller.dto.SaleSuccessTaxDTO;
import com.workshop.seller.dto.SaleSumDTO;
import com.workshop.seller.entities.Sale;
import com.workshop.seller.repositories.SaleRepository;
import com.workshop.seller.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {
  
  @Autowired
  private SaleRepository repository;

  /*
  * Below we will call the SallerRepository just to handle
  * a query to DB, cuz without this, every request will do
  * a query do to DB for each Seller in our DB, set the
  * method findAll() of this Repository, the sellers will be
  * stored in cache memory
  */
  @Autowired 
  private SellerRepository sellerRepository;

  @Transactional(readOnly = true)
  public Page<SaleDTO> findAll(Pageable pageable){
    sellerRepository.findAll();
    Page<Sale> sales = repository.findAll(pageable);
    return sales.map(x -> new SaleDTO(x));
  }

  @Transactional(readOnly = true)
  public List<SaleSumDTO> amountGroupedBySeller(){
    return repository.amountGroupedBySeller();
  }

  @Transactional(readOnly = true)
  public List<SaleSuccessTaxDTO> successGroupedBySeller(){
    return repository.successGroupedBySeller();
  }
}
