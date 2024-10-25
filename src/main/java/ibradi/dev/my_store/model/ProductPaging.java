package ibradi.dev.my_store.model;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductPaging {

	private List<Product> product;
	private long totalProduct;

}