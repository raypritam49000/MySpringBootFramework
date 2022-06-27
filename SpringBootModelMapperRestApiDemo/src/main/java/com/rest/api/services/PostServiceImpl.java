package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Post;
import com.rest.api.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(long id, Post postRequest) throws Exception{
		Post post = postRepository.findById(id).get();

		if (post != null) {
			post.setTitle(postRequest.getTitle());
			post.setDescription(postRequest.getDescription());
			post.setContent(postRequest.getContent());
			return postRepository.save(post);
			
		}
		else {
			throw new Exception("Post Not Found");
		}
	}

	@Override
	public boolean deletePost(long id) {
		Post post = postRepository.findById(id).get();
		if(post!=null) {
			postRepository.delete(post);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Post getPostById(long id) throws Exception {
		Post post = postRepository.findById(id).get();
		if(post!=null) {
			return post;
		}
		else {
			throw new Exception("Post Not Found");
		}
		
	}
}