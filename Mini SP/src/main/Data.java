package main;

public class Data {
	private int index;
	private int dataInteger;
	private char dataCharacter;
	
	public Data(int dataInteger, int index) {
		this.dataInteger = dataInteger;
		this.index = index;
	}
	
	public Data(char dataCharacter, int index) {
		this.dataCharacter = dataCharacter;
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getDataInteger() {
		return dataInteger;
	}
	
	public void setDataInteger(int dataInteger) {
		this.dataInteger = dataInteger;
	}
	
	public char getDataCharacter() {
		return dataCharacter;
	}
	
	public void setDataCharacter(char dataCharacter) {
		this.dataCharacter = dataCharacter;
	}
}
