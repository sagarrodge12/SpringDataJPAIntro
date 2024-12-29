package com.sagar.SpringDataJPAIntro;

import com.sagar.SpringDataJPAIntro.entity.Product;
import com.sagar.SpringDataJPAIntro.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

// We're not doing an actual unit testing of Repository layer here, we're just checking if CRUD working or not
@SpringBootTest
class SpringDataJpaIntroApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void saveProductMethod() {   // INSERT
		Product product = new Product();
		product.setName("Apple iPhone 15");
		product.setDescription("Latest model of Apple iPhone with 128GB storage");
		product.setPrice(new BigDecimal("999.99"));
		product.setActive(true);
		product.setStockKeepingUnit("SKU12345");
		product.setImageUrl("https://images.pexels.com/photos/8066712/pexels-photo-8066712.png");
		Product save = productRepository.save(product);

		System.out.println(save.toString());
	}

	@Test
	void updateProductUsingSaveMethod(){  // UPDATE
		// Find or Retrieve entity
		long id =3L;
		Product existingProduct = productRepository.findById(id).orElse(null);

		// Update entity information
		existingProduct.setName("Samsung Galaxy S23");
		existingProduct.setDescription("Samsung Galaxy S23 with 256GB storage and 5G connectivity");

        // Save updated entity
		productRepository.save(existingProduct);
	}

	@Test
	void findProductById(){  // SELECT
		long id= 3L;
		Product retreiveProduct = productRepository.findById(id).orElse(null);
		System.out.println("Here is the item: "+retreiveProduct);
	}

	@Test
	void findAllProduct(){
		List<Product> retreiveAllProduct = productRepository.findAll();
		for (Product prod : retreiveAllProduct){
			System.out.println(prod);
		}
	}

	@Test
	void deleteProductById(){  // DELETE
		long id = 1L;
		productRepository.deleteById(id);
		List<Product> retreiveAllProduct = productRepository.findAll();
		for (Product prod : retreiveAllProduct){
			System.out.println(prod);
		}
	}

}
