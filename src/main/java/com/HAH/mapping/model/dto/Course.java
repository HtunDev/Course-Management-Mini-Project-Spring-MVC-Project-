package com.HAH.mapping.model.dto;

import java.util.Objects;

public class Course {

	private int id;
	private String name;
	private int duration;
	private Level level;
	private int fees;

	public Course() {
	}

	public Course(String name, int duration, Level level, int fees) {
		super();
		this.name = name;
		this.duration = duration;
		this.level = level;
		this.fees = fees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, fees, id, level, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return duration == other.duration && fees == other.fees && id == other.id && Objects.equals(level, other.level)
				&& Objects.equals(name, other.name);
	}

}
