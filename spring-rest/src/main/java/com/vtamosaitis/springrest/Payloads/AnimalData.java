package com.vtamosaitis.springrest.Payloads;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "specie_id", "enc_id" })
public class AnimalData {
	public String name;
	public Long specie_id;
	public Long enc_id;

	@Override
	public String toString() {
		return "AnimalData{" +
				"name='" + name + '\'' +
				", specie_id=" + specie_id +
				", enc_id=" + enc_id +
				'}';
	}
}
