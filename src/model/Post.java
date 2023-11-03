package model;

public class Post implements IVisitable{
	private int likesAmount;
	private int commentariesAmount;
	private String imageDirection;
	
	public Post(String pImageDirection) {
		imageDirection = pImageDirection;
		likesAmount = 0;
		commentariesAmount = 0;		
	}
	
	public int getLikesAmount() {
		return likesAmount;
	}
	public void setLikesAmount() {
		likesAmount++;
	}
	public int getCommentariesAmount() {
		return commentariesAmount;
	}
	public void setCommentariesAmount() {
		commentariesAmount++;
	}

	public String getImageDirection() {
		return imageDirection;
	}


	@Override
	public int accept(IVisitor visitor) {
		return visitor.visit(this);
	}

}
