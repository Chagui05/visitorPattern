package model;

public class LikeVisitor implements IVisitor {
	
	public LikeVisitor() {
	}

	@Override
	public int visit(Post post) {
		post.setLikesAmount();
		post.setCommentariesAmount();
		System.out.println("El post tiene: "+post.getLikesAmount()+" likes");
		System.out.println("El post tiene: "+post.getCommentariesAmount()+" comentarios\n");
		
		return post.getCommentariesAmount()+post.getCommentariesAmount();
	}

	@Override
	public int visit(Story story) {
		story.setLikesAmount();
		System.out.println("La story tiene: "+story.getLikesAmount()+" likes\n");	
		return story.getLikesAmount();
	}

}
