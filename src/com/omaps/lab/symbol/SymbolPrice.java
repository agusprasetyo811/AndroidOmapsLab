package com.omaps.lab.symbol;

/**
 * @author omap (agusprasetyo811@gmail.com) OMAPS-LAB
 * 
 */
public class SymbolPrice {

	/**
	 * (OMAPS-LAB)
	 * Symbol Price RP (Rupiah) Convert number to Rp.
	 * 
	 * @param money
	 * @return {@link String}
	 * 
	 */
	public static String rp(String money) {
		String rupiah = "";
		int jml = money.length();

		while (jml > 3) {
			rupiah = "." + money.substring(0, 3) + rupiah;
			int l = money.length() - 3;
			money = money.substring(0, l);
			jml = money.length();
		}
		return rupiah = "Rp " + money + rupiah + ",-";
	}

}
