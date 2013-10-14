package projeto.model;

public class ClientePF extends Cliente {

	private String rg              = null;
	private String passaporte      = null;
	private String data_nascimento = null;
	private String genero          = null;
	private String habilitacao     = null;
	private String registro        = null;
	private String estado_emissor  = null;
	private String validade        = null;
	
	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getEstado_emissor() {
		return estado_emissor;
	}

	public void setEstado_emissor(String estado_emissor) {
		this.estado_emissor = estado_emissor;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
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
