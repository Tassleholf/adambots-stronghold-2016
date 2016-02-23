package com.github.adambots.stronghold2016.auton;

import java.util.ArrayList;

public class Auton_Barrier {
	public static char[] defenseCat = new char[4];
	public static int[] catNumber = new int[4];
	public static ArrayList<Barrier> bAutons = new ArrayList<Barrier>();
	public static int defIndex;
	public static int curPos;

	/**
	 * 
	 * @param dBCI
	 *            array of chars from the drive station telling what category of
	 *            barrier is in what spot on the field
	 * @param dBCNI
	 *            tells which number of the category is in that position
	 * @param cPN
	 *            current position after the positioning code is done
	 */

	/**
	 * public Auton_Barrier(char[] dBCI, int[] dBCNI,int cPN){ defenseCat=dBCI;
	 * catNumber=dBCNI; curPos=cPN; bAutons.set(0, new Barrier());
	 * bAutons.set(1, new Barrier()); bAutons.set(2, new Barrier());
	 * bAutons.set(3, new Barrier()); bAutons.set(4, new Barrier());
	 * bAutons.set(5, new Barrier()); bAutons.set(6, new Barrier());
	 * bAutons.set(7, new Barrier()); }
	 **/
	/**
	 * 
	 * @param dBCI
	 *            array of chars from the drive station telling what category of
	 *            barrier is in what spot on the field
	 * @param dBCNI
	 *            tells which number of the category is in that position
	 * @param cPN
	 *            current position after the positioning code is done
	 */
	public static void setInput() {

	}

	/**
	 * sorts the barrier code finding the correct one to do
	 */
	public static void autonBarrierGo(char[] dBCI, int[] dBCNI, int cPN) {
		defenseCat = dBCI;
		catNumber = dBCNI;
		curPos = cPN;
		bAutons.set(0, new Barrier());
		bAutons.set(1, new Barrier());
		bAutons.set(2, new Barrier());
		bAutons.set(3, new Barrier());
		bAutons.set(4, new Barrier());
		bAutons.set(5, new Barrier());
		bAutons.set(6, new Barrier());
		bAutons.set(7, new Barrier());
		for (int x = 0; x < 8; x++) {
			if (bAutons.get(x).getCat() == defenseCat[curPos] && bAutons.get(x).getCatNum() == catNumber[curPos]) {
				defIndex = x;
			}
		}
		bAutons.get(defIndex).go();
	}
}
