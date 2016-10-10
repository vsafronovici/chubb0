package com.chubb.rest;

import com.chubb.rest.model.Quote;
import com.chubb.rest.model.user.User;
import com.chubb.rest.model.user.UserList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) {
		System.out.println("vasea");
		SpringApplication.run(Application.class);

		/*RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(quote.toString());*/
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());

			System.out.println("=========================================================================");

			User user = getUser(restTemplate, 1);
			log.info(user.toString());

			User userJson = getUserJSON(restTemplate, 2);
			log.info(userJson.toString());

			User userJson2 = getUserJSON2(restTemplate, 3);
			log.info(userJson2.toString());

			//User userFail = getUserFailsUnmarshal(restTemplate, 4);

			UserList list = getUsers(restTemplate);
			log.info(list.toString());

			UserList listXml = getUsersAsXML(restTemplate);
			log.info(listXml.toString());

			User removedUser = removeUser(restTemplate, 5);
			log.info("Removed user :" + removedUser);

			User newUser = new User();
			newUser.setName("myName");
			newUser.setLastname("myLastName");
			User createdUser = createUser(restTemplate, newUser);
			log.info("Created user :" + createdUser);

			User updateUser = new User();
			updateUser.setId(7);
			updateUser.setName("myName");
			updateUser.setLastname("myLastName");
			updateUser = updateUser(restTemplate, updateUser);
			log.info("Updated user :" + updateUser);



		};
	}


	private User getUser(RestTemplate restTemplate, int id) {
		String uri = "http://localhost:8080/jersey/rest/userres/users/user/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);
		User user = result.getBody();

		return user;
	}

	private User getUserJSON(RestTemplate restTemplate, int id) {
		String uri = "http://localhost:8080/jersey/rest/userres/users/user/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); // Not necesary to put, just ensure that response is a JSON format
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);
		User user = result.getBody();

		return user;
	}

	private User getUserJSON2(RestTemplate restTemplate, int id) {
		User user = restTemplate.getForObject("http://localhost:8080/jersey/rest/userres/users/userJSON/" + id, User.class, 200);
		return user;
	}

	private User getUserFailsUnmarshal(RestTemplate restTemplate, int id) {
		String uri = "http://localhost:8080/jersey/rest/userres/users/userJSON/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML)); //this throws err code 406 because response is a JSON
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);
		User user = result.getBody();

		return user;
	}


	private UserList getUsers(RestTemplate restTemplate) {
		String uri = "http://localhost:8080/jersey/rest/userres/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<UserList> result = restTemplate.exchange(uri, HttpMethod.GET, entity, UserList.class);
		UserList list = result.getBody();

		return list;
	}

	private UserList getUsersAsXML(RestTemplate restTemplate) {
		String uri = "http://localhost:8080/jersey/rest/userres/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<UserList> result = restTemplate.exchange(uri, HttpMethod.GET, entity, UserList.class);
		UserList list = result.getBody();

		return list;
	}

	private User removeUser(RestTemplate restTemplate, int id) {
		String uri = "http://localhost:8080/jersey/rest/userres/users/user/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, User.class);
		User user = result.getBody();

		return user;
	}

	private User createUser(RestTemplate restTemplate, User user) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writter = mapper.writer().withDefaultPrettyPrinter();
		String userStr = null;
		try {
			userStr = writter.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		String uri = "http://localhost:8080/jersey/rest/userres/users/user/create";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(userStr, headers);

		ResponseEntity<Integer> result = restTemplate.exchange(uri, HttpMethod.POST, entity, Integer.class);
		int userId = result.getBody();

		user.setId(userId);

		return user;

	}

	private User updateUser(RestTemplate restTemplate, User user) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writter = mapper.writer().withDefaultPrettyPrinter();
		String userStr = null;
		try {
			userStr = writter.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		String uri = "http://localhost:8080/jersey/rest/userres/users/user/edit/" + user.getId();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(userStr, headers);

		ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, User.class);
		user = result.getBody();

		return user;

	}


}