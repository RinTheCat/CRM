package ru.otus.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.project.domain.Order;
import ru.otus.project.repository.ProductQuantityRepository;
import ru.otus.project.service.CommentService;
import ru.otus.project.service.OrderService;

import static org.assertj.core.api.Assertions.assertThat;

@Import({OrderService.class, CommentService.class})
@DataJpaTest
class PersistenceServiceTest {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ProductQuantityRepository productQuantityRepository;
	@Autowired
	private TestEntityManager testEntityManager;

	private static final int EXPECTED_ORDER_COUNT = 2;
	private static final long ORDER_1_ID = 1L;
	private static final long PRODUCT_1_ID = 1L;
	private static final int PRODUCT_1_ORDER_1_QUANTITY = 9;
	private static final int NEW_PRODUCT_1_ORDER_1_QUANTITY = 4;
	private static final String TEST_USER_1 = "petrov.ae";
	private static final String TEST_USER_2 = "ivanova.ys";
	private static final String TEST_CLIENT_1 = "ИП Иванов Иван";
	private static final String TEST_CLIENT_2 = "ОАО Ромашка";
	private static final String TEST_COMMENT_TEXT = "Посылка собрана";
	private static final String NEW_COMMENT_TEXT = "Посылка отправлена";
	private static final String PRODUCT_1_NAME = "Ананас";
	private static final long TEST_COMMENT_ID = 4L;

	@DisplayName("Сосчитать кол-во заказов")
	@Test
	void shouldReturnExpectedOrderCount() {
		Long actualAuthorCount = orderService.count();
		assertThat(actualAuthorCount).isEqualTo(EXPECTED_ORDER_COUNT);
	}

	@DisplayName("Сменить юзера в заказе")
	@Test
	void shouldChangeUser() {
		assertThat(orderService.getById(ORDER_1_ID).getClientManager().getUsername()).isEqualTo(TEST_USER_1);
		orderService.changeUser(ORDER_1_ID, TEST_USER_2);
		assertThat(orderService.getById(ORDER_1_ID).getClientManager().getUsername()).isEqualTo(TEST_USER_2);
	}

	@DisplayName("Сменить клиента в заказе")
	@Test
	void shouldChangeClient() {
		assertThat(orderService.getById(ORDER_1_ID).getClient().getName()).isEqualTo(TEST_CLIENT_1);
		orderService.changeClient(ORDER_1_ID, TEST_CLIENT_2);
		assertThat(orderService.getById(ORDER_1_ID).getClient().getName()).isEqualTo(TEST_CLIENT_2);
	}

	@DisplayName("Добавить продукт в заказ")
	@Test
	void shouldAddNewProduct() {
		int n = orderService.getById(ORDER_1_ID).getProductQuantities().size();
		orderService.addNewProduct(ORDER_1_ID, PRODUCT_1_NAME, 10);
		assertThat(orderService.getById(ORDER_1_ID).getProductQuantities().size()).isEqualTo(n + 1);
	}

	@DisplayName("Создать новый заказ")
	@Test
	void shouldCreateNewOrder() {
		assertThat(orderService.count()).isEqualTo(EXPECTED_ORDER_COUNT);
		orderService.createNewOrder(TEST_USER_1);
		assertThat(orderService.count()).isEqualTo(EXPECTED_ORDER_COUNT + 1);
	}

	@DisplayName("Добавить комментарий")
	@Test
	void shouldAddNewComment() {
		Order order = orderService.getById(ORDER_1_ID);
		int n = order.getComments().size();
		testEntityManager.detach(order);

		orderService.addNewComment(ORDER_1_ID, NEW_COMMENT_TEXT);
		assertThat(orderService.getById(ORDER_1_ID).getComments().size()).isEqualTo(n + 1);
	}

	@DisplayName("Изменить количество продуктов")
	@Test
	void shouldChangeProductQuantity() {
		assertThat(orderService.getById(ORDER_1_ID).getProductQuantities().get(0).getQuantity()).isEqualTo(PRODUCT_1_ORDER_1_QUANTITY);
		orderService.addProductQuantity(ORDER_1_ID, PRODUCT_1_ID, NEW_PRODUCT_1_ORDER_1_QUANTITY);
		assertThat(orderService.getById(ORDER_1_ID).getProductQuantities().get(0).getQuantity()).isEqualTo(NEW_PRODUCT_1_ORDER_1_QUANTITY);
	}

	@DisplayName("Удалить продукт из заказа")
	@Test
	void shouldDeleteProduct() {
		Order order = orderService.getById(ORDER_1_ID);
		int n = order.getProductQuantities().size();
		orderService.deleteProduct(ORDER_1_ID, PRODUCT_1_ID);
		assertThat(productQuantityRepository.findByOrder(orderService.getById(ORDER_1_ID)).size()).isEqualTo(n - 1);
	}

	@DisplayName("Заменить комментарий")
	@Test
	void shouldEditText() {
		assertThat(commentService.getById(TEST_COMMENT_ID).getText()).isEqualTo(TEST_COMMENT_TEXT);
		commentService.editText(TEST_COMMENT_ID, NEW_COMMENT_TEXT);
		assertThat(commentService.getById(TEST_COMMENT_ID).getText()).isEqualTo(NEW_COMMENT_TEXT);
	}
}
