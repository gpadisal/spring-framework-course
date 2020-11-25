package com.gopal.pma.example;

public class Car {
	
	private Engine engine;
	private Tires tires;
	private Steering steering;
	
	public Car(Engine engine, Tires tyres, Steering steering) {
		this.engine = engine;
		this.tires = tyres;
		this.steering = steering;
	}
	
	
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", tyres=" + tires + ", steering=" + steering + "]";
	}

	
}
