package com.stonex.service;

import com.stonex.bean.CurrencyDetails;
import com.stonex.dao.CurrencyDetailsDAO;
import com.stonex.exceptions.NoCurrencyDetailsFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyDetailsService {
    @Autowired()
    private CurrencyDetailsDAO dao;

    public List<CurrencyDetails> getDetailsBasedOnCurrency(String currencyCode) {
        Optional<List<CurrencyDetails>> details = dao.findCurrencyDetailsByCurrencyCode(currencyCode);
        List<CurrencyDetails> list = details.get();
        if(list.isEmpty()) {
            throw new NoCurrencyDetailsFoundException("No Currency Details Found with the given Currency Code.");
        }
        return list;
    }
    public List<CurrencyDetails> getAllDetails() {
        List<CurrencyDetails> listOfAllDetails = dao.findAll();
        if(listOfAllDetails.isEmpty()) {
            throw new NoCurrencyDetailsFoundException("No Currency Details Found with the given Currency Code.");
        }
        return listOfAllDetails;
    }
    public CurrencyDetails addCurrencyDetails(CurrencyDetails currencyDetails) {
        CurrencyDetails currencyDetailsAdded = dao.save(currencyDetails);
        return currencyDetailsAdded;
    }
    public String deleteCurrencyDetails(CurrencyDetails currencyDetails) {
        Optional<CurrencyDetails> currencyDetailsFound = dao.findById(currencyDetails.getId());
        if(currencyDetailsFound.isPresent()) {
            dao.delete(currencyDetails);
            return "Deleted Successfully";
        }
        else {
            throw new NoCurrencyDetailsFoundException("No Currency Details Matched to delete.");
        }
    }
    public CurrencyDetails updateCurrencyDetails(CurrencyDetails currencyDetails) {
        Optional<CurrencyDetails> currencyDetailsFound = dao.findById(currencyDetails.getId());
        if(currencyDetailsFound.isPresent()) {
            CurrencyDetails currencyDetailsUpdated = dao.save(currencyDetails);
            return currencyDetailsUpdated;
        }
        else {
            throw new NoCurrencyDetailsFoundException("No Currency Details Found to update.");
        }
    }
    public CurrencyDetails updateFieldsOfCurrencyDetails(CurrencyDetails currencyDetails) {
        System.out.println(currencyDetails);
        Optional<CurrencyDetails> currencyDetailsFound = dao.findById(currencyDetails.getId());
        if(currencyDetailsFound.isPresent()) {
            CurrencyDetails currencyDetailsWithUpdatedFields = currencyDetailsFound.get();
            System.out.println(currencyDetailsWithUpdatedFields.getId()+" "+currencyDetailsWithUpdatedFields.getCountryName());
            if(currencyDetails.getModificationFlag()!=null) {
                currencyDetailsWithUpdatedFields.setModificationFlag(currencyDetails.getModificationFlag());
            }
            if(currencyDetails.getFractionalDigit()!=null) {
                currencyDetailsWithUpdatedFields.setFractionalDigit(currencyDetails.getFractionalDigit());
            }
            if(currencyDetails.getCurrencyCode()!=null) {
                currencyDetailsWithUpdatedFields.setCurrencyCode(currencyDetails.getCurrencyCode());
            }
            if(currencyDetails.getCurrencyName()!=null) {
                currencyDetailsWithUpdatedFields.setCurrencyName(currencyDetails.getCurrencyName());
            }
            if(currencyDetails.getCountryCode()!=null) {
                currencyDetailsWithUpdatedFields.setCountryCode(currencyDetails.getCountryCode());
            }
            if(currencyDetails.getCountryName()!=null) {
                currencyDetailsWithUpdatedFields.setCountryName(currencyDetails.getCountryName());
            }
            CurrencyDetails currencyDetailsUpdated = dao.save(currencyDetailsWithUpdatedFields);
            return currencyDetailsUpdated;
        }
        else {
            throw new NoCurrencyDetailsFoundException("No Currency Details Found to Update.");
        }
    }
}
