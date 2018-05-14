package br.com.docket.uploaderToMotherbird.controller;

import br.com.docket.uploaderToMotherbird.motherbird.service.MotherbirdService;
import org.springframework.beans.factory.annotation.Autowired;
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

		for(MultipartFile multipartFile: multipartFileList) {
			motherbirdService.sendToMotherbird(multipartFile.getBytes(), multipartFile.getContentType());
		}

		model.addAttribute("success", true);
		return "solicitacao";
	}
}
