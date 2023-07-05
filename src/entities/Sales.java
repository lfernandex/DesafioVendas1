package entities;

public class Sales implements Comparable<Sales>{
	
	private Integer month;
	private Integer year;
	private String seller;
	private Integer items;
	private Double total;
	
	public Sales(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.items = items;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	public String getSeller() {
		return seller;
	}

	public Integer getItems() {
		return items;
	}

	public Double getTotal() {
		return total;
	}
	
	public Double avaragePrice() {
		return total / items;
	}

	@Override
	public String toString() {
		return month + "/" + year + ", " + seller + ", " + items + ", "
				+ total + ", pm: " + String.format("%.2f", avaragePrice());
	}

	@Override
	public int compareTo(Sales o) {
		return avaragePrice().compareTo(o.avaragePrice());
	}
	
	

}
