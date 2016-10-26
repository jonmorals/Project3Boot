package project3.objectcontainer;

import java.util.List;

public class PostContainer {

	private String authorName;
	private String postTitle;
	private String postContent;
	private int postId;
	private String profPicURL;
	private List<List<String>> replyContent;
	private String date;

	public PostContainer(){}

	public PostContainer(String authorName, String postTitle, String postContent, int postId, String profPicURL, List<List<String>> replyContent) {
		super();
		this.authorName = authorName;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postId = postId;
		this.profPicURL = profPicURL;
		this.setReplyContent(replyContent);
	}

	public PostContainer(String authorName, String postTitle, String postContent, int postId, String profPicURL,
			List<List<String>> replyContent, String date) {
		super();
		this.authorName = authorName;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postId = postId;
		this.profPicURL = profPicURL;
		this.replyContent = replyContent;
		this.date = date;
	}

	public String getProfPicURL() {
		return profPicURL;
	}

	public void setProfPicURL(String profPicURL) {
		this.profPicURL = profPicURL;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}



	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}



	public List<List<String>> getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(List<List<String>> replyContent2) {
		this.replyContent = replyContent2;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PostContainer [authorName=" + authorName + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postId=" + postId + ", profPicURL=" + profPicURL + ", replyContent=" + replyContent + "]";
	}

	
	
}
