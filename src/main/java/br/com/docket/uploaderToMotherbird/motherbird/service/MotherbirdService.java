package br.com.docket.uploaderToMotherbird.motherbird.service;

import br.com.docket.uploaderToMotherbird.motherbird.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class MotherbirdService {

	@Autowired
	private Token token;

	@Value("${motherbird.solicitacao.url}")
	private String mothebirdUrl;

	@Value("${webhook.url}")
	private String webHookUrl;

	public void sendToMotherbird(byte[] file, String mimeType) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token.getToken());
		httpHeaders.add("Content-Type", mimeType);
		httpHeaders.add("Url-WebHook", webHookUrl);

		HttpEntity<byte[]> entity = new HttpEntity<>(file, httpHeaders);

		RestTemplate restTemplate = new RestTemplate();

		try {
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(mothebirdUrl, entity, String.class);
			System.out.println(responseEntity.getStatusCode());
			System.out.println(responseEntity.getBody());
		} catch(HttpClientErrorException e) {
			System.err.println(e.getStatusCode());
			System.err.println(e.getResponseBodyAsString());
		}
	}
}
