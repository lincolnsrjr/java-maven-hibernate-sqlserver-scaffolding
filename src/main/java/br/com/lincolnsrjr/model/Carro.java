package br.com.lincolnsrjr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CARRO")
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CARRO")
    private Integer id;
	
	@Column(name = "DES_NOME")
    private String nome;
	
	@Column(name = "DAT_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date compra;
	
	@Column(name = "DAT_VENDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date venda;
	
	@Column(name = "NUM_ANO_FABRICACAO")
    private Integer anoFabricacao;
		
	@Column(name = "NUM_ANO_MODELO")
    private Integer anoModelo;
	
	@JoinColumn(name = "NUM_CONCESSIONARIA", referencedColumnName = "NUM_CONCESSIONARIA")
    @ManyToOne(optional = false)    
    private Concessionaria concessionaria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getCompra() {
		return compra;
	}

	public void setCompra(Date compra) {
		this.compra = compra;
	}

	public Date getVenda() {
		return venda;
	}

	public void setVenda(Date venda) {
		this.venda = venda;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
