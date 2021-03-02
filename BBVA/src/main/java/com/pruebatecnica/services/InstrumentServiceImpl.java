package com.pruebatecnica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebatecnica.consta.Constantes;
import com.pruebatecnica.domain.Instruments;
import com.pruebatecnica.domain.Market;
import com.pruebatecnica.models.GeneralResult;
import com.pruebatecnica.models.InstrumentRequest;
import com.pruebatecnica.models.MarketRequest;
import com.pruebatecnica.respository.InstrumentRepository;
import com.pruebatecnica.respository.MarketRepository;

@Service
public class InstrumentServiceImpl implements InstrumentService {

	@Autowired
	InstrumentRepository instrumentRepository;
	@Autowired
	MarketRepository marketRepository;

	public GeneralResult createTransaction(InstrumentRequest transactionRequest) {
		GeneralResult generalResult = new GeneralResult();
		try {

			Instruments transaction = new Instruments();
			transaction.setReference(transactionRequest.getReference());
			transaction.setDescription(transactionRequest.getDescription());
			transaction.setPrice(transactionRequest.getPrice());
			transaction.setDate(transactionRequest.getDate());
			transaction.setIban(transactionRequest.getIban());

			Instruments temp = this.instrumentRepository.save(transaction);
			if (temp != null) {
				generalResult.setReference(transactionRequest.getReference());
				generalResult.setDescription(Constantes.OK_TRANS_CREATE);
				return (generalResult);
			}
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(Constantes.ERROR_EXCEPTION);
			return (generalResult);

		} catch (Exception e) {
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(e.getMessage());
			return (generalResult);
		}
	}

	@Override
	public GeneralResult updatePrice(MarketRequest transactionRequest) {
		GeneralResult generalResult = new GeneralResult();
		try {

			Market transaction = new Market();
			transaction.setReference(transactionRequest.getReference());
			transaction.setPrice(transactionRequest.getPrice());

			Market temp = this.marketRepository.save(transaction);
			if (temp != null) {
				generalResult.setDescription(Constantes.OK_TRANS_CREATE);

				Integer n = this.marketRepository.priceAvg();
				this.instrumentRepository.updateAvg(n);
				

				generalResult.setReference(n.toString());
				return (generalResult);
			}
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(Constantes.ERROR_EXCEPTION);
			return (generalResult);

		} catch (Exception e) {
			generalResult.setReference(transactionRequest.getReference());
			generalResult.setDescription(e.getMessage());
			return (generalResult);
		}
	}

}
