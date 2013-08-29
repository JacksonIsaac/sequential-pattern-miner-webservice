package edu.indiana.d2i.seqmining.webservice;

public class Figure {
	private String name;
	private byte[] content;

	public Figure() {

	}

	public Figure(String name, byte[] content) {
		super();
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
