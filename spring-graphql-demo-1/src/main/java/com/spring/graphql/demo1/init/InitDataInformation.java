package com.spring.graphql.demo1.init;

import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.graphql.demo1.domain.Commentary;
import com.spring.graphql.demo1.domain.Post;
import com.spring.graphql.demo1.domain.User;
import com.spring.graphql.demo1.repository.CommentaryRepository;
import com.spring.graphql.demo1.repository.PostRepository;
import com.spring.graphql.demo1.repository.UserRepository;

@Component
public class InitDataInformation implements CommandLineRunner {

	private UserRepository userRepository;
	
	private PostRepository postRepository;
	
	private CommentaryRepository commentaryRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User publisher = new User();
		publisher.setFullName("Elias Gustavo Torres Perez");
		publisher.setUuid(getUuid());
		publisher.setBirthday(getCustomDate(1990, 2, 20));
		publisher.setNumberCard("00000000");
		publisher = userRepository.save(publisher);
		
		Post post = new Post();
		post.setUuid(getUuid());
		post.setTitle("Diseño de App Movil");
		post.setDescription("Estamos diseñando una nueva app movil, se aceptan sugerencias en cuanto a la realizacion de la misma.");
		post.setPublish(getCustomDate(2015, 1, 15, 14, 35, 0));
		post.setIdUser(publisher.getIdUser());
		
		post = postRepository.save(post);
		
		User user1 = new User();
		user1.setFullName("Marcelo Ramirez Rojas");
		user1.setUuid(getUuid());
		user1.setBirthday(getCustomDate(1991, 6, 13));
		user1.setNumberCard("11111111");
		user1 = userRepository.save(user1);
		
		Commentary comment1 = new Commentary();
		comment1.setDescription("Deberiamos empezar definiendo los objetivos para la construccion de la app movil.");
		comment1.setUuid(getUuid());
		comment1.setPublish(getCustomDate(2015, 1, 15, 18, 20, 0));
		comment1.setIdPost(post.getIdPost());
		comment1.setIdUser(user1.getIdUser());
		comment1 = commentaryRepository.save(comment1);
		
		User user2 = new User();
		user2.setFullName("José Manuel Andrade Garcia");
		user2.setUuid(getUuid());
		user2.setBirthday(getCustomDate(1990, 7, 5));
		user2.setNumberCard("22222222");
		user2 = userRepository.save(user2);
		
		Commentary comment2 = new Commentary();
		comment2.setDescription("Estoy de acuerdo debemos definir que hacer para luego establecer el alcance :)");
		comment2.setUuid(getUuid());
		comment2.setPublish(getCustomDate(2015, 1, 16, 11, 40, 0));
		comment2.setIdPost(post.getIdPost());
		comment2.setIdUser(user2.getIdUser());
		comment2 = commentaryRepository.save(comment2);
		
		User user3 = new User();
		user3.setFullName("Patty Lucia Miranda Torres");
		user3.setUuid(getUuid());
		user3.setBirthday(getCustomDate(1992, 4, 10));
		user3.setNumberCard("33333333");
		user3 = userRepository.save(user3);
		
		Commentary comment3 = new Commentary();
		comment3.setDescription("Empezamos el proyecto chicos, espero podamos hacer un gran equipo.");
		comment3.setUuid(getUuid());
		comment3.setPublish(getCustomDate(2015, 1, 20, 16, 20, 0));
		comment3.setIdPost(post.getIdPost());
		comment3.setIdUser(user3.getIdUser());
		comment3 = commentaryRepository.save(comment3);
	}

	
	private String getUuid(){
		return UUID.randomUUID().toString();
	}
	
	private Date getCustomDate(int year, int monthOfYear, int dayOfMonth){
		return getCustomDate(year, monthOfYear, dayOfMonth, 0, 0, 0);
	}
	
	private Date getCustomDate(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute){
		DateTime dt = new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute);
		return dt.toDate();
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Autowired
	public void setCommentaryRepository(CommentaryRepository commentaryRepository) {
		this.commentaryRepository = commentaryRepository;
	}
}
