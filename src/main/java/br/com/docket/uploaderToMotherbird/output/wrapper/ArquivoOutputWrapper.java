package br.com.docket.uploaderToMotherbird.output.wrapper;


import br.com.docket.uploaderToMotherbird.output.ArquivoOutput;

import java.util.Objects;

public class ArquivoOutputWrapper extends Wrapper {

	private ArquivoOutput arquivo;

	private String urlWebHook;

	public ArquivoOutput getArquivo() {
		return arquivo;
	}

	public void setArquivo(ArquivoOutput arquivo) {
		this.arquivo = arquivo;
	}

	public String getUrlWebHook() {
		return urlWebHook;
	}

	public void setUrlWebHook(String urlWebHook) {
		this.urlWebHook = urlWebHook;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArquivoOutputWrapper that = (ArquivoOutputWrapper) o;
		return Objects.equals(arquivo, that.arquivo) &&
				Objects.equals(urlWebHook, that.urlWebHook);
	}

	@Override
	public int hashCode() {

		return Objects.hash(arquivo, urlWebHook);
	}

	@Override
	public String toString() {
		return "ArquivoOutputWrapper{" +
				"arquivo=" + arquivo +
				", urlWebHook='" + urlWebHook + '\'' +
				'}';
	}
}
