package projeto.model;

abstract public class Cliente {

	private long cpf         = 0;
	private String nome      = null;
	private String telefone  = null;
	private String email     = null;
	private String endereco  = null;
	private String cidade    = null;
	private String estado    = null;
	private String cep       = null;
	private String tipo      = null;

	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}	
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	/**
	 * Métodos para serem implementados em classes filhas
	 */
	abstract protected boolean inserir(); 
	
	abstract protected boolean editar();
	
	abstract protected boolean excluir(); 
}
