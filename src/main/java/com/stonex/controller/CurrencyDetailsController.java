package com.stonex.controller;

import com.stonex.bean.CurrencyDetails;
import com.stonex.service.CurrencyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currency")
public class CurrencyDetailsController {

    @Autowired
    private CurrencyDetailsService service;

    @GetMapping("/{isocode}")
    public List<CurrencyDetails> getCurrencyDetails(@PathVariable String isocode) {
        List<CurrencyDetails> list = service.getDetailsBasedOnCurrency(isocode);
        return list;
    }

    @GetMapping("/currencies")
    public List<CurrencyDetails> getAllDetails() {
        List<CurrencyDetails> list = service.getAllDetails();
        return list;
    }

    @PostMapping("/")
    public ResponseEntity addCurrencyDetails(@RequestBody CurrencyDetails currencyDetails) {
        CurrencyDetails currencyDetails1 = service.addCurrencyDetails(currencyDetails);
        System.out.print(currencyDetails1.getId()+" "+currencyDetails1.getCurrencyCode());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{isocode}").buildAndExpand(currencyDetails1.getCurrencyCode()).toUri();
        ResponseEntity res = new ResponseEntity(uri, HttpStatus.CREATED);
        return res;
    }
    @DeleteMapping("/")
    public String deleteCurrencyDetails(@RequestBody CurrencyDetails currencyDetails) {
        String response = service.deleteCurrencyDetails(currencyDetails);
        return response;
    }
    @PutMapping("/")
    public ResponseEntity updateCurrencyDetails(@RequestBody CurrencyDetails currencyDetails) {
        CurrencyDetails currencyDetails1 = service.updateCurrencyDetails(currencyDetails);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{isocode}").buildAndExpand(currencyDetails1.getCurrencyCode()).toUri();
        ResponseEntity res = new ResponseEntity(uri,HttpStatus.CREATED);
        return res;
    }
    @PatchMapping("/{id}")
    public ResponseEntity updateFieldsOfCurrencyDetails(@PathVariable String id,@RequestBody CurrencyDetails currencyDetails) {
        currencyDetails.setId(id);
        CurrencyDetails currencyDetailsUpdated = service.updateFieldsOfCurrencyDetails(currencyDetails);
        URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/currency/{isocode}").buildAndExpand(currencyDetailsUpdated.getCurrencyCode()).toUri();
        ResponseEntity res = new ResponseEntity(uri,HttpStatus.CREATED);
        return res;
    }
}
