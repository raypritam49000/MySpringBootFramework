package com.rest.api.exception;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.dto.PostDto;
import com.rest.api.entity.Post;
import com.rest.api.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PostService postService;

	@GetMapping
	public List<PostDto> getAllPosts() {

		return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) throws Exception {
		Post post = postService.getPostById(id);
		// convert entity to DTO
		PostDto postResponse = modelMapper.map(post, PostDto.class);
		return ResponseEntity.ok().body(postResponse);
	}

	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

		// convert DTO to entity
		Post postRequest = modelMapper.map(postDto, Post.class);

		Post post = postService.createPost(postRequest);

		// convert entity to DTO
		PostDto postResponse = modelMapper.map(post, PostDto.class);

		return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);
	}

	// change the request for DTO
	// change the response for DTO
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) throws Exception {

		// convert DTO to Entity
		Post postRequest = modelMapper.map(postDto, Post.class);

		Post post = postService.updatePost(id, postRequest);

		// entity to DTO
		PostDto postResponse = modelMapper.map(post, PostDto.class);

		return ResponseEntity.ok().body(postResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id) {
		Boolean result = postService.deletePost(id);
		if(result) {
			return ResponseEntity.ok(Map.of("success",result,"message","Post deleted successfully","status",HttpStatus.OK));
		}
		else {
			return ResponseEntity.ok(Map.of("success",result,"message","Post can not deleted","status",HttpStatus.BAD_GATEWAY));
		}
	
	}
}