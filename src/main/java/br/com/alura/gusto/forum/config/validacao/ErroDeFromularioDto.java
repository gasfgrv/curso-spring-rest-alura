package br.com.alura.gusto.forum.config.validacao;

public class ErroDeFromularioDto {

	private final String campo;
	private final String erro;

	public ErroDeFromularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
