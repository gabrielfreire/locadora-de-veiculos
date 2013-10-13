package projeto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Veiculo {


	private int idVeiculo        = 0;
	private String chassi        = null;
	private String placa         = null;
	private String cidade	     = null;
	private String estado        = null;
	private String modelo        = null;
	private String fabricante    = null;
	private int ano              = 0;
	private String tarifaAluguel = null;
	private double kmRodado      = 0;
	private int grupo_id         = 0;
	private int marca_id         = 0;
	private int cor_id           = 0;
	
    
	/**
	 * 
	 * @param idVeiculo
	 */
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setTarifaAluguel(String tarifaAluguel) {
		this.tarifaAluguel = tarifaAluguel;
	}

	public void setKmRodado(double kmRodado) {
		this.kmRodado = kmRodado;
	}

	public void setIdGrupo(int grupo_id) {
		this.grupo_id = grupo_id;
	}

	public void setIdMarca(int marca_id) {
		this.marca_id = marca_id;
	}

	public void setIdCor(int cor_id) {
		this.cor_id = cor_id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdVeiculo() {
		return idVeiculo;
	}
	
	public String getChassi() {
		return chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getModelo() {
		return modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public int getAno() {
		return ano;
	}

	public String getTarifaAluguel() {
		return tarifaAluguel;
	}

	public double getKmRodado() {
		return kmRodado;
	}

	public int getIdGrupo() {
		return grupo_id;
	}

	public int getIdMarca() {
		return marca_id;
	}
	
	public int getIdCor() {
		return cor_id;
	}

	
	
	
	public boolean editar() {
						
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
		
			String sqlUpdate = "UPDATE veiculo SET "
	    			+ "chassi = ?, placa = ?, cidade = ?, estado = ?, modelo = ?, fabricante = ?, ano = ?, "
	    			+ "tarifa_aluguel = ?, km_rodado = ?, grupo_id = ?, marca_id = ?, cor_id = ? "
	    			+ "WHERE id = ?";
			
			Conn bd = new Conn();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlUpdate);

			stm.setString(1, getChassi());
			stm.setString(2, getPlaca());
			stm.setString(3, getCidade());
			stm.setString(4, getEstado());
			stm.setString(5, getModelo());
			stm.setString(6, getFabricante());
			stm.setInt(   7, getAno());
			stm.setString(8, getTarifaAluguel());
			stm.setDouble(9, getKmRodado());
			stm.setInt(  10, getIdGrupo());
			stm.setInt(  11, getIdMarca());
			stm.setInt(  12, getIdCor());
			stm.setInt(  13, getIdVeiculo());			
			stm.execute();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;			
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	
	
	public boolean inserir() {

        PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO veiculo "
        			+ "(chassi, placa, cidade, estado, modelo, fabricante, ano, tarifa_aluguel, "
        			+ "km_rodado, grupo_id, marca_id, cor_id) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Conn bd = new Conn();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert);
    		
    		stm.setString(1, getChassi());
    		stm.setString(2, getPlaca());
    		stm.setString(3, getCidade());
    		stm.setString(4, getEstado());
    		stm.setString(5, getModelo());
    		stm.setString(6, getFabricante());
    		stm.setInt(   7, getAno());
    		stm.setString(8, getTarifaAluguel());
    		stm.setDouble(9, getKmRodado());
    		stm.setInt(  10, getIdGrupo());
    		stm.setInt(  11, getIdMarca());
    		stm.setInt(  12, getIdCor());
    		stm.execute();
            
    		return true;
            
            
        } catch (SQLException e) {
    
            System.out.print(e.getMessage());
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return false;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
	}
	
	
	public static int[] getArrAnos() {
		
		int vetor[] = new int[30];
		
		int ano = 2013; //ano de início
		for(int i=0; i<vetor.length; i++) {
			vetor[i] = ano;
			ano--;
		}		
		return vetor;
	}
	
	public static String[] getArrEstados() {
		
		String vetor[] = new String[27];
		
		vetor[0]  = "Acre";
		vetor[1]  = "Alagoas";
		vetor[2]  = "Amapá";
		vetor[3]  = "Amazonas";
		vetor[4]  = "Bahia";
		vetor[5]  = "Ceará";
		vetor[6]  = "Distrito Federal";
		vetor[7]  = "Espírito Santo";
		vetor[8]  = "Goiás";
		vetor[9]  = "Maranhão";
		vetor[10] = "Mato Grosso";
		vetor[11] = "Mato Grosso do Sul";
		vetor[12] = "Minas Gerais";
		vetor[13] = "Pará";
		vetor[14] = "Paraíba";
		vetor[15] = "Paraná";
		vetor[16] = "Pernambuco";
		vetor[17] = "Piauí";
		vetor[18] = "Rio de Janeiro";
		vetor[19] = "Rio Grande do Norte";
		vetor[20] = "Rio Grande do Sul";
		vetor[21] = "Rondônia";
		vetor[22] = "Roraima";
		vetor[23] = "Santa Catarina";
		vetor[24] = "São Paulo";
		vetor[25] = "Sergipe";
		vetor[26] = "Tocantins";
		
		return vetor;
	}
	
	
	public static ArrayList<Veiculo> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    
        try {
            
        	String sql = "SELECT * FROM veiculo ORDER BY id DESC";
            Conn bd = new Conn();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	Veiculo veiculo = new Veiculo();
            	veiculo.setIdVeiculo(rs.getInt("id"));
        		veiculo.setChassi(rs.getString("chassi"));
        		veiculo.setPlaca(rs.getString("placa"));
        		veiculo.setCidade(rs.getString("cidade"));
        		veiculo.setEstado(rs.getString("estado"));
        		veiculo.setModelo(rs.getString("modelo"));
        		veiculo.setFabricante(rs.getString("fabricante"));
        		veiculo.setAno(rs.getInt("ano"));
        		veiculo.setTarifaAluguel(rs.getString("tarifa_aluguel"));
        		veiculo.setKmRodado(rs.getDouble("km_rodado"));
        		veiculo.setIdGrupo(rs.getInt("grupo_id"));
        		veiculo.setIdMarca(rs.getInt("marca_id"));
        		veiculo.setIdCor(rs.getInt("cor_id"));
        		            	
            	veiculos.add(veiculo);
            }            

            rs.close();            
            return veiculos;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return veiculos;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }		
	}
}
