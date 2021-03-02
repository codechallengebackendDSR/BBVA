package com.pruebatecnica.cotrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.InstrumentRequest;
import com.pruebatecnica.models.MarketRequest;


@RestController
public interface InstrumentController {

	
	public ResponseEntity<GeneralResult> createInstrument(@RequestBody InstrumentRequest transactionRequest) ;

	public ResponseEntity<GeneralResult> updatePrice(@RequestBody MarketRequest transactionRequest);	


}
