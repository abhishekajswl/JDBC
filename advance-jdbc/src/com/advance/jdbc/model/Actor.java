package com.advance.jdbc.model;

public class Actor {
	
	private int actorId;
	private String actorName;
	
	public Actor(int actorId, String actorName) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
	}
	
	public int getActorId() {
		return actorId;
	}
	public String getActorName() {
		return actorName;
	}
	
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + "]";
	}
	
	
	

}
