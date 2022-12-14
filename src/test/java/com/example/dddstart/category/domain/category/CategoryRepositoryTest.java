package com.example.dddstart.category.domain.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@BeforeEach
	void setUp() {
		jdbcTemplate.update("truncate table category");
		jdbcTemplate.update("insert into category values (1, 'cat1')");
		jdbcTemplate.update("insert into category values (2, 'cat2')");
	}

	@Test
	void findAll() {
		List<Category> categories = categoryRepository.findAll();
		assertThat(categories).hasSize(2);
	}

	@Test
	void findById() {
		Optional<Category> optionalCategory =
			categoryRepository.findById(CategoryId.of(2L));
		assertThat(optionalCategory).isPresent();
		assertThat(optionalCategory.get().getName()).isEqualTo("cat2");
	}
}
