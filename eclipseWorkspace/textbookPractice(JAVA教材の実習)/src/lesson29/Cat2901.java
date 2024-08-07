package lesson29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cat2901 {
	
	/** 名前 */
	private String name;
	/** 年齢 */
	private int age;
	/** 体重 */
	private double weight;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	
	public Cat2901() {
		/** 名前 */
		this.name = "miu";
		/** 年齢 */
		this.age = 6;
		/** 体重 */
		this.weight = 20;
	}
	
	public void catInfo() {
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.weight);
	}
	
	public void catMeow() {
		System.out.println("nya");
	}
	
	public void catSleep() {
		this.weight += 0.1;
	}
	
}
