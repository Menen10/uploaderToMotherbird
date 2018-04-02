package br.com.docket.uploaderToMotherbird.controller;

import br.com.docket.uploaderToMotherbird.motherbird.service.MotherbirdService;
import br.com.docket.uploaderToMotherbird.output.ArquivoOutput;
import br.com.docket.uploaderToMotherbird.output.wrapper.ArquivoOutputWrapper;
import br.com.docket.uploaderToMotherbird.service.ArquivoService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

	@Value("${webhook.url}")
	private String webHookUrl;

	@Autowired
	private MotherbirdService motherbirdService;

	@GetMapping
	public String solicitacao(Model model){
		model.addAttribute("success", false);
		return "solicitacao";

	}

	@PostMapping
	public String novaSolicitacao(Model model, List<MultipartFile> multipartFileList) throws IOException {

		if(multipartFileList.isEmpty()) {
			return "redirect:/solicitacoes";
		}

		Set<ArquivoOutputWrapper> arquivoOutputWrappers = new HashSet<>();

		for(MultipartFile multipartFile: multipartFileList) {

			ArquivoOutput arquivoOutput = new ArquivoOutput();
			arquivoOutput.setBase64(bytesToBase64(multipartFile.getBytes()));
			arquivoOutput.setMimeType(multipartFile.getContentType());

			ArquivoOutputWrapper arquivoOutputWrapper = new ArquivoOutputWrapper();
			arquivoOutputWrapper.setArquivo(arquivoOutput);
			arquivoOutputWrapper.setUrlWebHook(webHookUrl);

			motherbirdService.sendToMotherbird(arquivoOutputWrapper);
		}



		model.addAttribute("success", true);
		return "solicitacao";
	}

	private String bytesToBase64(byte[] file) {
		Base64 base64 = new Base64();
		return base64.encodeAsString(file);
	}
}
