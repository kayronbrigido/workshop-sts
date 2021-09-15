package com.workshop.seller.controllers;

import java.util.List;

import com.workshop.seller.dto.SaleDTO;
import com.workshop.seller.dto.SaleSuccessTaxDTO;
import com.workshop.seller.dto.SaleSumDTO;
import com.workshop.seller.services.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

  @Autowired
  private SaleService service;


  @GetMapping
  public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
    Page<SaleDTO> sales = service.findAll(pageable);
    return ResponseEntity.ok().body(sales);
  }

  @GetMapping(value = "/amount-by-seller")
  public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
    List<SaleSumDTO> list = service.amountGroupedBySeller();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/success-by-seller")
  public ResponseEntity<List<SaleSuccessTaxDTO>> successGroupedBySeller(){
    List<SaleSuccessTaxDTO> list = service.successGroupedBySeller();
    return ResponseEntity.ok().body(list);
  }

}
