package br.com.devmedia.helloworldservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Info {

	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
