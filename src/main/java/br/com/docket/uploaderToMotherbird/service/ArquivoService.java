package br.com.docket.uploaderToMotherbird.service;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class ArquivoService {

	public String getMimeTypeByBase64(String fileBase64) throws IOException {

		Base64 base64 = new Base64();

		byte[] bytes = base64.decode(fileBase64);

		StringBuilder fileName = new StringBuilder();

		fileName.append("/tmp/motherbird/fileToMimeTypeTest/");
		fileName.append("arquivo");
		fileName.append(UUID.randomUUID());

		File file = new File(fileName.toString());

		FileUtils.writeByteArrayToFile(file, bytes);

		return Files.probeContentType(file.toPath());
	}

}
