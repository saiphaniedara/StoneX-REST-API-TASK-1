package com.stonex.dao;

import com.stonex.bean.CurrencyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyDetailsDAO extends MongoRepository<CurrencyDetails,String> {
     Optional<List<CurrencyDetails>> findCurrencyDetailsByCurrencyCode(String currencyCode);
}
