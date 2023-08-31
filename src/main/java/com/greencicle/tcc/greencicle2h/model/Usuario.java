package com.greencicle.tcc.greencicle2h.model;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="Usuario")
public class Usuario {
	
	private Long id;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	private String logradouro;
	private String cep;
	private String bairro;
	private String uf;
	
	private boolean CodStatusUsurario;
    private boolean getCodStatusUsurario(boolean CodStatusUsurario) {
    return CodStatusUsurario; 
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public boolean getCodStatusUsurario() {
		return CodStatusUsurario;
	}

	public void setCodStatusUsurario(boolean codStatusUsurario) {
		CodStatusUsurario = codStatusUsurario;
	} 
	
	}
