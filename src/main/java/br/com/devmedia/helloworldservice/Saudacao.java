package br.com.devmedia.helloworldservice;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

public class Saudacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 593827349269203562L;
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Saudacao [value=" + value + "]";
	}
	
}
