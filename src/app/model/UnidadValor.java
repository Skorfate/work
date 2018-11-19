package app.model;

import java.util.Objects;

public class UnidadValor {
	private String key;
	private String valorRomano;
	private Boolean isCredit;
	private Double valorCredito;

	public UnidadValor(String key, String valorRomano, Boolean isCredit, Double valorCredito) {
		this.key = key;
		this.valorRomano = valorRomano;
		this.isCredit = isCredit;
		this.valorCredito = valorCredito;
	}

	public UnidadValor() {
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValorRomano() {
		return valorRomano;
	}

	/**
	 * @param value the value to set
	 */
	public void setValorRomano(String valorRomano) {
		this.valorRomano = valorRomano;
	}

	/**
	 * @return the isCredit
	 */
	public Boolean getIsCredit() {
		return isCredit;
	}

	/**
	 * @param isCredit the isCredit to set
	 */
	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}

	public Double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.key);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {

		if (!Objects.equals(this.key, obj)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "UnidadValor [key=" + key + ", valorRomano=" + valorRomano + ", isCredit=" + isCredit + ", valorCredito="
				+ valorCredito + "]";
	}

	

}
