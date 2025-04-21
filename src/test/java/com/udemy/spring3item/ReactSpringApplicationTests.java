package com.udemy.react-spring;

-spring.controller.ItemController;
-spring.repo.ItemRepository;
import com.udemy.react-spring.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class react-springApplicationTests {

	@Autowired
	private ItemController itemController;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	// アプリケーションがSpringコンテキストを正常にロードできたかどうかを検証する
	@Test
	void contextLoads() {
		// AssertJを利用した検証を実装する
		// assertThatの引数に検証の値を入れる
		// 続けてメソッドにて期待値を指定。この場合はNullでないこと。
		assertThat(itemController).isNotNull();
		assertThat(itemService).isNotNull();
		assertThat(itemRepository).isNotNull();
	}

}
