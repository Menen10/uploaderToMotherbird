package br.com.docket.uploaderToMotherbird.output.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class Wrapper {
	
//	public String toJson() {
//		return new Gson().toJson(this);
//	}
	
}
