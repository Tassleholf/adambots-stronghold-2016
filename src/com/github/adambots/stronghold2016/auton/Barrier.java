package com.github.adambots.stronghold2016.auton;

public class Barrier {
	char category;
	int categoryNum;
	boolean running = false;

	public Barrier() {
		running = true;
	}

	public void go() {

	}

	public char getCategory() {
		return category;
	}

	public int getCategoryNum() {
		return categoryNum;

	}

	public boolean running() {
		return running;

	}
}
