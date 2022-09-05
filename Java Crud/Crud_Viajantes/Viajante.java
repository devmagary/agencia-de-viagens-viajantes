package Crud_Viajantes;

import java.util.Date;

public class Viajante {
	private int id_viajante;
	private int id_local;
	private Date data_viagem_ida;
	private Date data_viagem_volta;
	private String nome;
	private String nome_local;
	public int getId_viajante() {
		return id_viajante;
	}
	public void setId_viajante(int id_viajante) {
		this.id_viajante = id_viajante;
	}
	public int getId_local() {
		return id_local;
	}
	public void setId_local(int id_local) {
		this.id_local = id_local;
	}
	public Date getData_viagem_ida() {
		return data_viagem_ida;
	}
	public void setData_viagem_ida(Date data_viagem_ida) {
		this.data_viagem_ida = data_viagem_ida;
	}
	public Date getData_viagem_volta() {
		return data_viagem_volta;
	}
	public void setData_viagem_volta(Date data_viagem_volta) {
		this.data_viagem_volta = data_viagem_volta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome_local() {
		return nome_local;
	}
	public void setNome_local(String nome_local) {
		this.nome_local = nome_local;
	}


}
