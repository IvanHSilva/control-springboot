package br.com.hvc.control.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hvc.control.entities.Category;
import br.com.hvc.control.entities.Order;
import br.com.hvc.control.entities.OrderItem;
import br.com.hvc.control.entities.Product;
import br.com.hvc.control.entities.User;
import br.com.hvc.control.entities.enums.OrderStatus;
import br.com.hvc.control.repositories.CategoryRepository;
import br.com.hvc.control.repositories.OrderItemRepository;
import br.com.hvc.control.repositories.OrderRepository;
import br.com.hvc.control.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

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
		
		Product p1 = new Product(null, "The Lord of the Rings", "Primeiro livro da série", 70.0, "");
		Product p2 = new Product(null, "Smart TV", "Full HD 1080P, Compatível com os Melhores apps", 2500.0, "");
		Product p3 = new Product(null, "Macbook Pro", "O melhor note em todas as categorias", 1850.0, "");
		Product p4 = new Product(null, "PC Gamer", "O micro turbinado e poderoso pra quem gosta de jogar", 3800.0, "");
		Product p5 = new Product(null, "Crisis on Infinite Earths", "Uma das melhores sagas clássicas dos Quadrinhos", 100.00, "");
		Product p6 = new Product(null, "Game Of Thrones", "A fantástica série, agora completa em DVD e Blu-Ray", 600.00, "");
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat4);
		p6.getCategories().add(cat5);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p5, 3, p5.getPrice());
		OrderItem oi4 = new OrderItem(o3, p2, 1, p2.getPrice());
		OrderItem oi5 = new OrderItem(o3, p3, 1, p3.getPrice());
		OrderItem oi6 = new OrderItem(o4, p6, 1, p6.getPrice());
		OrderItem oi7 = new OrderItem(o5, p4, 1, p4.getPrice());
		OrderItem oi8 = new OrderItem(o5, p3, 1, p3.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5, oi6, oi7, oi8));
	}
}
