package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.Post;

public interface PostService {
	public abstract List<Post> getAllPosts();

	public abstract Post createPost(Post post);

	public abstract Post updatePost(long id, Post post) throws Exception;

	public abstract boolean deletePost(long id);

	public abstract Post getPostById(long id) throws Exception;
}