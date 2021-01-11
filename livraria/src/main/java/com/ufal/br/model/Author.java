import javax.annotation.processing.Generated;

@Entity
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;
    private String name;
    private String birthDate;

    public Author(){}
    public Author(List<Book> books, String name, String birthDate){
        this.birthDate = birthDate;
        this.books = books;
        this.name = name;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}