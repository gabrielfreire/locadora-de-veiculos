package projeto.model;

public class ClientePJ extends Cliente {
	
	private String razao_social        = null;
	private String nome_comercial      = null;
	private int    cnpj                = 0;
	private String inscricao_estadual  = null;
	private String data_fundacao       = null;
	private int    numero_funcionarios = 0;
	

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_comercial() {
		return nome_comercial;
	}

	public void setNome_comercial(String nome_comercial) {
		this.nome_comercial = nome_comercial;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricao_estadual() {
		return inscricao_estadual;
	}

	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}

	public String getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(String data_fundacao) {
		this.data_fundacao = data_fundacao;
	}

	public int getNumero_funcionarios() {
		return numero_funcionarios;
	}

	public void setNumero_funcionarios(int numero_funcionarios) {
		this.numero_funcionarios = numero_funcionarios;
	}

	
	
	@Override
	protected boolean inserir() {
		// TODO Stub de método gerado automaticamente
		return false;
	}

	@Override
	protected boolean editar() {
		// TODO Stub de método gerado automaticamente
		return false;
	}

	@Override
	protected boolean excluir() {
		// TODO Stub de método gerado automaticamente
		return false;
	}
}
