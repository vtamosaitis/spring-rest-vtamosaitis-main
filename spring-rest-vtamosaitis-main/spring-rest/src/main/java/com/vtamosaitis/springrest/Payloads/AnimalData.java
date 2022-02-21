package com.vtamosaitis.springrest.Payloads;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "specie_id", "enc_id" })
public class AnimalData {
	public String name;
	public Long specie_id;
	public Long enc_id;	
}
