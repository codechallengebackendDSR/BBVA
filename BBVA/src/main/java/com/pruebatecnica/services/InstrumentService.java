package com.pruebatecnica.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import com.pruebatecnica.domain.Instruments;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.InstrumentRequest;
import com.pruebatecnica.models.MarketRequest;


@Service
public interface InstrumentService {


	public  GeneralResult createTransaction(final InstrumentRequest transactionRequest);

	public GeneralResult updatePrice(MarketRequest transactionRequest); 

	

	
}
