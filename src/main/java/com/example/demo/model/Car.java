package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity // to use relation with other tables
@Table(name="CarTable")//to create table automatically

public class Car {
	@Id // value will be unique
	@GeneratedValue(strategy=GenerationType.AUTO) // database will generate unique ID
	@Column(name="Id")//id column will be in table
	private int id;
	
	@NotEmpty
	@NotNull
	@Size(min=3, max=20)
	@Column(name="Engine")
	private String engine;
	
	@NotNull
	@Min(0)
	@Max(400)
	@Column(name="Speed")

	private double speed;
	
	@NotNull
	@Min(1900)
	@Max(2019)
	@Column(name="Year")
	private int year;
	
	
	@NotEmpty
	@NotNull
	@Size(min=3, max=10)
	@Pattern(regexp="[a-zA-z]+", message="describe with letters")
	@Column(name="Color")
	private String color;
	
	
	public Car() {
	
	}
	
	public Car(String e, double s, int y, String c) {
		/*engine = e;
		speed = s;
		year = y;
		color = c;
		*/
		
		setEngine(e);
		setSpeed(s);
		setYear(y);
		setColor(c); 
	//	setId(); 
	}
	

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		if (engine == null) {
			this.engine = "abc";
		}
		else {
			this.engine = engine;
		}

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		if (speed < 50) {
			this.speed = 0;
		}
		else {
					this.speed = speed;
		}
		/* if (speed >= 0 && speed < 250) {
			this.speed = speed;
		} else {
			this.speed = 50;
		}
		System.out.println(speed);
		System.out.println(this.speed);
		*/

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 1900) {
			this.year = 2000;
		} else {
			this.year = year;
		}
	/*	if (year > 1900 && year < 2019) {
			this.year = year;
		} else {
			this.year = 2019;
		}
		System.out.println(year);
		System.out.println(this.year);
*/
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		
		if (color != null) {
			boolean isOnlyLetters = false;
			for (int i = 0; i < color.length(); i++) {
				if (Character.isLetter(color.charAt(i))) {
					isOnlyLetters = true;
				} else {
					isOnlyLetters = false;
					break;
				}

			}
			if (isOnlyLetters) {
				this.color = color;
			} else {
				this.color = "silver";
			}
		}

		else {
			this.color = "none";
		}
	}
	
	public int getId() {
		return id;
	}

	/* public void setId() {
		this.id = idCounter;
		idCounter++;
		*/
	
	

	@Override
	public String toString() {
		return "Car engine= " + engine + ", speed=" + speed + "km/h, " + "year= " + year +  "color= " + color;
	}
}
