package model;

public interface IVisitor {
	public int visit(Post post);
	public int visit(Story story);
}
