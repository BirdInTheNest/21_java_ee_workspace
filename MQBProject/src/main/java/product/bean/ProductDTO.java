package product.bean;

import lombok.Data;

@Data
public class ProductDTO {
	private int seq;
	private String img;
	private String name;
	private int unit;
	private int qty;
	private int total;
	private double rate;
	private int discount;
	private int price;
}
