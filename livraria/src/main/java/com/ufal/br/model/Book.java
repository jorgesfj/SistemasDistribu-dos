import jdk.jfr.Category;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;
    private boolean price;
	private int evaluation;
	@ManyToOne
	@JoinColumn(name = "author_id")
    private Author author;
    private int edition;
	private int stock;;

    
    public Book(){}
    public Book(String name, boolean price, int evaluation, Author author, int edition, int stock){
        this.name = name;
        this.price = price;
        this.evaluation = evaluation;
        this.author = author;
        this.edition = edition;
		this.stock = stock;

    }
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrice() {
		return this.price;
	}

	public void setPrice(boolean price) {
		this.price = price;
	}

	public int getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getEdition() {
		return this.edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


}