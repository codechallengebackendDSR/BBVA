package com.pruebatecnica.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


public class MarketRequest {
	@JsonProperty("reference")
	String reference;
	@JsonProperty("price")
	BigInteger price;
	
	
	
	public MarketRequest() {
		// TODO Auto-generated constructor stub
	}
	public BigInteger getPrice() {
		return price;
	}
	public void setPrice(BigInteger price) {
		this.price = price;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	
	
	
	
}
