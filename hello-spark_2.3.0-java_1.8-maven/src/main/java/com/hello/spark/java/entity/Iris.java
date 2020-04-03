package com.hello.spark.java.entity;

public class Iris {

	/** 花萼长度 */
	private float SepalLengthCm;
	/** 花萼宽度 */
	private float SepalWidthCm;
	/** 花瓣长度 */
	private float PetalLengthCm;
	/** 花瓣宽度 */
	private float PetalWidthCm;

	/** 种类 */
	private String Species;


	public float getSepalLengthCm() {
		return SepalLengthCm;
	}

	public void setSepalLengthCm(float sepalLengthCm) {
		SepalLengthCm = sepalLengthCm;
	}

	public float getSepalWidthCm() {
		return SepalWidthCm;
	}

	public void setSepalWidthCm(float sepalWidthCm) {
		SepalWidthCm = sepalWidthCm;
	}

	public float getPetalLengthCm() {
		return PetalLengthCm;
	}

	public void setPetalLengthCm(float petalLengthCm) {
		PetalLengthCm = petalLengthCm;
	}

	public float getPetalWidthCm() {
		return PetalWidthCm;
	}

	public void setPetalWidthCm(float petalWidthCm) {
		PetalWidthCm = petalWidthCm;
	}

	public String getSpecies() {
		return Species;
	}

	public void setSpecies(String species) {
		Species = species;
	}
}
