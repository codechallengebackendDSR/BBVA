package com.pruebatecnica.cotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.InstrumentRequest;
import com.pruebatecnica.models.MarketRequest;
import com.pruebatecnica.services.InstrumentService;







@RestController
public  class InstrumentControllerImpl implements  InstrumentController{

	@Autowired
	InstrumentService instrumentService;
	@RequestMapping(value = "/create")
	@Override
	public  ResponseEntity<GeneralResult> createInstrument(@RequestBody InstrumentRequest transactionRequest) {
		GeneralResult generalResult=new GeneralResult();
		try {
		return ResponseEntity.ok(instrumentService.createTransaction(transactionRequest));
		} catch(Exception e) {
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/updateprice")
	@Override
	public  ResponseEntity<GeneralResult> updatePrice(MarketRequest transactionRequest) {
		GeneralResult generalResult=new GeneralResult();
		try {
		return ResponseEntity.ok(instrumentService.updatePrice(transactionRequest));
		} catch(Exception e) {
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
