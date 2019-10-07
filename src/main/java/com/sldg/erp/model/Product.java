package com.sldg.erp.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sldg.erp.model.enuns.TipoCategoria;

/**
 * 
 * Classe Modelo que representa um produto
 * @author Danilo e Gessica
 * @since 21/11/2015
 *
 */
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	private Long codigo;

	@Column(name = "nomeProduto")
	private String nomeProduto;

	@Column(name = "marcaProduto")
	private String marcaProduto;

	@Column(name = "valorProduto")
	private BigDecimal valorProduto;

	@Enumerated(EnumType.STRING)
	private TipoCategoria tipoCategoria;

	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public TipoCategoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(TipoCategoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result
				+ ((marcaProduto == null) ? 0 : marcaProduto.hashCode());
		result = prime * result
				+ ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		result = prime * result
				+ ((tipoCategoria == null) ? 0 : tipoCategoria.hashCode());
		result = prime * result
				+ ((valorProduto == null) ? 0 : valorProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (marcaProduto == null) {
			if (other.marcaProduto != null)
				return false;
		} else if (!marcaProduto.equals(other.marcaProduto))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (tipoCategoria != other.tipoCategoria)
			return false;
		if (valorProduto == null) {
			if (other.valorProduto != null)
				return false;
		} else if (!valorProduto.equals(other.valorProduto))
			return false;
		return true;
	}

}
