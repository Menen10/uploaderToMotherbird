package br.com.docket.uploaderToMotherbird.motherbird;

import org.springframework.stereotype.Component;

@Component
public class Token {
	private String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtb3RoZXJiaXJkIiwicm9sZSI6IlJPTEVfQURNSU4iLCJjcmVhdGVkIjoxNTI2MDQyNDExMzU0LCJleHAiOjE1Mjg2MzQ0MTF9.PKDwJoNuWOGXMH7TkdTL6To6E25iIL-btrmHGkhnFYjIhjVjXhMpqDRl1dewvLFtfak3YMGSGnU376Xz3cI4wQ";

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
