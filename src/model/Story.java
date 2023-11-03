package model;

public class Story implements IVisitable{
	private int likesAmount;
	private String imageDirection;
	
	public Story(String pImageDirection) {
		imageDirection = pImageDirection;
		likesAmount = 0;
	}
	public int getLikesAmount() {
		return likesAmount;
	}
	public void setLikesAmount() {
		likesAmount++;
	}
	public String getImageDirection() {
		return imageDirection;
	}
	@Override
	public int accept(IVisitor visitor) {
		return visitor.visit(this);
	}

}
