package br.com.docket.uploaderToMotherbird.motherbird;

import org.springframework.stereotype.Component;

@Component
public class Token {
	private String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtb3RoZXJiaXJkIiwicm9sZSI6IlJPTEVfQURNSU4iLCJjcmVhdGVkIjoxNTIyNTE3ODUxNzQyLCJleHAiOjE1MjMxMjI2NTF9.5f1cS-QTB2EzuHUKvOvvSSdDfbUTCDOGnhLFCdpr8HegWizQ_WGnyEfKGNQYEUcjt3JDQH-H6nsbxDA20dWnUA";

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
