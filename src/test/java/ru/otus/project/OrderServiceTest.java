package ru.otus.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.project.service.OrderService;

import static org.assertj.core.api.Assertions.assertThat;

@Import(OrderService.class)
@DataJpaTest
class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	@Autowired
	private TestEntityManager testEntityManager;

	private static final int EXPECTED_ORDER_COUNT = 2;
	private static final long ORDER_1_ID = 1L;
	private static final String TEST_USER_1 = "petrov.ae";
	private static final String TEST_USER_2 = "ivanova.ys";

	@DisplayName("Сосчитать кол-во заказов")
	@Test
	void shouldReturnExpectedAuthorCount() {
		Long actualAuthorCount = orderService.count();
		assertThat(actualAuthorCount).isEqualTo(EXPECTED_ORDER_COUNT);
	}

	@DisplayName("Сменить юзера в заказе")
	@Test
	void shouldInsertAuthor() {
		assertThat(orderService.getById(ORDER_1_ID).getClientManager().getUsername()).isEqualTo(TEST_USER_1);
		orderService.changeUser(ORDER_1_ID, TEST_USER_2);
		assertThat(orderService.getById(ORDER_1_ID).getClientManager().getUsername()).isEqualTo(TEST_USER_2);
	}
}
