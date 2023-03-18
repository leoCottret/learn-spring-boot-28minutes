package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	// in url versioning
	@GetMapping("/v1/person")
	public PersonV1 getFristVersionPerson() {
		return new PersonV1("Léo v1");
	}	
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionPerson() {
		return new PersonV2(new Name("LLaMA powered", "Léo v2"));
	}
	
	// in url versioning, params
	@GetMapping( path="/person", params="version=1")
	public PersonV1 getFirstVersionPersonWithRequestParam() {
		return new PersonV1("Léo v1, with request param");
	}
	
	@GetMapping( path="/person", params="version=2")
	public PersonV2 getSecondVersionPersonWithRequestParam() {
		return new PersonV2(new Name("LLaMA powered", "Léo v2 with request param"));
	}
	
	// headers versioning
	@GetMapping( path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionPersonWithHeader() {
		return new PersonV1("Léo v1, with header");
	}
	
	@GetMapping( path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionPersonWithHeader() {
		return new PersonV2(new Name("LLaMA powered", "Léo v2 with header"));
	}
	
	// accept header versioning (or media type)
	@GetMapping( path="/person/accept", produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionPersonWithMediaType() {
		return new PersonV1("Léo v1, with media type");
	}
	
	@GetMapping( path="/person/accept", produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionPersonWithMediaType() {
		return new PersonV2(new Name("LLaMA powered", "Léo v2 with media type"));
	}
	
}
