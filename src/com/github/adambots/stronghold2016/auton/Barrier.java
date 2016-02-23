package com.github.adambots.stronghold2016.auton;

public class Barrier {
	char cat;
	int catNum;
	boolean running = false;

	public Barrier() {
		running = true;
	}

	public void go() {

	}

	public char getCat() {
		return cat;
	}

	public int getCatNum() {
		return catNum;

	}

	public boolean running() {
		return running;

	}
}
