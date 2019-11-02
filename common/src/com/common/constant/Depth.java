package com.common.constant;

public enum Depth {
	ONE(1),
	TWO(2);
	
	private int depth;
	
	Depth(int depth){
		this.depth = depth;
	}
	
	public int getValue(){
		return depth;
	}

}
