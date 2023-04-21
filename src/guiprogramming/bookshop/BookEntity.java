package guiprogramming.bookshop;

public class BookEntity {
	
	private String authorName;
	private String bookName;
	private String editionYear;
	private String bookPrice;
	
	public BookEntity() {	
		
	}
    public BookEntity(String  authorName,String bookName,String editionYear, String bookPrice) {	
		this.authorName = authorName;
		
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorName() {
		return this.authorName;
	}
	
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return this.bookName;
	}
	
	
	public void setEditionYear(String editionYear) {
		this.editionYear = editionYear;
	}
	public String getEditionYear() {
		return this.editionYear;
	}

	
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPrice() {
		return this.bookPrice;
	}

}
