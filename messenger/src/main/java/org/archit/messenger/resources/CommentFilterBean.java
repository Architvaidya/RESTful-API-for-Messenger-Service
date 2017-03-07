package org.archit.messenger.resources;

import javax.ws.rs.QueryParam;

public class CommentFilterBean {
	
	private @QueryParam("commentId") long commentId;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	
	
	
	

}
