package ViajantesMolde;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import Crud_Viajantes.Viajante;
import ViajantesFactory.ConnectionFactory;


public class ViajantesMolde {

	public void salvar(Viajante viajante) {
		int id_local = viajante.getId_local();
		int id_viajante = viajante.getId_viajante();
		String sql = "INSERT INTO viajante(id_viajante, nome, data_viagem_ida, data_viagem_volta) VALUES (?, ?, ?, ?)";
		String sql2 = "UPDATE `viajantes`.`viajante` SET `id_local` = "+id_local+" WHERE (`id_viajante` = "+id_viajante+")";
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		ClientPreparedStatement pstm2 = null;
		
		
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			pstm2 = (ClientPreparedStatement) conn.prepareStatement(sql2);
			pstm.setInt(1, viajante.getId_viajante());
			pstm.setString(2, viajante.getNome());
			pstm.setDate(3, new Date (viajante.getData_viagem_ida().getTime()));
			pstm.setDate(4, new Date( viajante.getData_viagem_volta().getTime()));
			pstm.execute();
			pstm2.execute();
			System.out.println("Viajante com data Marcada :)");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null && pstm!=null) {
					pstm.close();
					pstm2.close();
					
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<Viajante> getViajante(){
		String sql = "select * From viajante a "+
	"join locais b "+
				"on a.id_viajante = b.id_local";
		List<Viajante> viajante = new ArrayList<Viajante>();
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		ResultSet resultado = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			resultado = pstm.executeQuery();
			
			while (resultado.next()) {
				Viajante viajanteLista = new Viajante();
				viajanteLista.setId_viajante(resultado.getInt("id_viajante"));
				viajanteLista.setNome(resultado.getString("nome"));
				viajanteLista.setData_viagem_ida(resultado.getDate("data_viagem_ida"));
				viajanteLista.setData_viagem_volta(resultado.getDate("data_viagem_volta"));
				viajanteLista.setNome_local(resultado.getString("nome_local"));
				viajanteLista.setId_local(resultado.getInt("id_local"));				
				viajante.add(viajanteLista);
			}
			}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(resultado!=null) {
							resultado.close();
						}
						if(pstm!=null) {
							pstm.close();
						}
						if(conn!=null) {
							conn.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					
					}				
				}		
				return viajante;
				}
			

	public void update (Viajante viajante) {
		String sql = "UPDATE viajante SET nome = ?, data_viagem_ida = ?, data_viagem_volta = ?, id_local = ? "+
	"WHERE id_viajante = ?";
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, viajante.getNome());
			pstm.setDate(2, new Date (viajante.getData_viagem_ida().getTime()));
			pstm.setDate(3, new Date(viajante.getData_viagem_volta().getTime()));
			pstm.setInt(4, viajante.getId_local());
			pstm.setInt(5, viajante.getId_viajante());
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void delete(int id_viajante) {
		String sql = "DELETE FROM viajante WHERE id_viajante = ?";
		Connection conn = null;
		ClientPreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (ClientPreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id_viajante);
			pstm.execute();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}

				
		
	


