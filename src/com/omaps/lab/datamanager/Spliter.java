package com.omaps.lab.datamanager;

/**
 * @author Omap (agusprasetyo811@gmail.com) OMAPS-LAB
 * 
 * Manipulate Data with spliter like implode
 * 
 */
public class Spliter {
	
	private String data;
	private String spliter;

	public Spliter() {
		data = "";
	}

	public String getData() {
		return data;
	}

	/**
	 * (OMAPS-LAB) Set String data to split with 2 parameter
	 * 
	 * @param data
	 * @param spliter
	 */
	public void setData(String data, String spliter) {
		this.data = data;
		this.spliter = spliter;
	}

	/**
	 * (OMAPS-LAB) Set array data to split with 2 parameter
	 * 
	 * @param data
	 * @param spliter
	 */
	public void setData(String[] data, String spliter) {
		for (int i = 0; i < data.length; i++) {
			this.data += data[i] + spliter;
			this.spliter = spliter;
		}
	}

	public void prepareData() {
		String split = this.spliter;
		String getData = this.data;
		StringBuilder shoppingListEditing = new StringBuilder(getData.replace(this.spliter, split));
		this.data = shoppingListEditing.append(split).toString();
		this.spliter = split;
	}

	/**
	 * (OMAPS-LAB) Get Data From Spliter Data with index
	 * 
	 * @param index
	 * @return
	 */
	public String getValue(int index) {
		if (data == "") {
			return data;
		}
		int a = -1;
		for (int i = 0; i < index; i++) {
			a = this.data.indexOf(spliter, a + 1);
		}
		return data.substring(a + 1, data.indexOf(spliter, a + 1));
	}

	/**
	 * (OMAPS-LAB) Get Number of Value From Spliter
	 * 
	 * @param split
	 * @return
	 */
	public int getNumberOfValue(char split) {
		int counter = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == split) {
				counter++;
			}
		}
		return counter;
	}

}
