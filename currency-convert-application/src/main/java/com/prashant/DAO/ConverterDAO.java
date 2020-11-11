package com.prashant.DAO;

import java.math.BigDecimal;

import com.prashant.model.ConverterModel;
import com.prashant.model.ResponseModel;
import com.prashant.util.Currency;

public interface ConverterDAO {
	
	public ResponseModel getConvertedValue(Currency source, Currency target, BigDecimal amount);
	public ConverterModel getConverterModel();

}
