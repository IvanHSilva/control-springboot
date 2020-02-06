package br.com.hvc.control.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hvc.control.entities.Category;
import br.com.hvc.control.entities.Order;
import br.com.hvc.control.entities.User;
import br.com.hvc.control.entities.enums.OrderStatus;
import br.com.hvc.control.repositories.CategoryRepository;
import br.com.hvc.control.repositories.OrderRepository;
import br.com.hvc.control.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria José", "maria@gmail.com", "91234-5678", "00000");
		User u2 = new User(null, "José Antonio", "jose@gmail.com", "98765-4321", "111111");
		User u3 = new User(null, "Yuri Sakamoto", "yuri@gmail.com", "90011-2233", "22222");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2019-07-23T16:00:00Z"), OrderStatus.DELIVERED, u1);
		Order o5 = new Order(null, Instant.parse("2019-08-01T18:09:05Z"), OrderStatus.SHIPPED, u2);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		Category cat4 = new Category(null, "Comics");
		Category cat5 = new Category(null, "Movies");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
	}
}
