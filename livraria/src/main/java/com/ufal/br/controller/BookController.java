import com.ufal.br.repository.BookRepository;

@RestController
@RequestMapping({"/livros"})
public class BookController{
    
    @AutoWired
    private BookRepository repository;

    BookController(ContactRepository bookRepository) {
        this.repository = bookRepository;
    }

    @GetMapping("/")
    public List<Book> findAll() {           
           return repository.findAll();
    }



}