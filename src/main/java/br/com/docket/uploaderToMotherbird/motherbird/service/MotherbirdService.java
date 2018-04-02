package br.com.docket.uploaderToMotherbird.motherbird.service;

import br.com.docket.uploaderToMotherbird.motherbird.Token;
import br.com.docket.uploaderToMotherbird.output.wrapper.ArquivoOutputWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MotherbirdService {

	@Autowired
	private Token token;

	@Value("${motherbird.solicitacao.url}")
	private String mothebirdUrl;

	public void sendToMotherbird(ArquivoOutputWrapper  arquivoOutputWrapper) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token.getToken());

		HttpEntity<ArquivoOutputWrapper> entity = new HttpEntity<>(arquivoOutputWrapper, httpHeaders);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(mothebirdUrl, entity, String.class);

		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());

	}
}
