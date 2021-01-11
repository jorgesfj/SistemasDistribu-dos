
import com.ufal.br.repository.BookRepository;

@RestController
@RequestMapping({"/autores"})
public class AuthorController{
    private BookRepository repository;

    BookController(AuthorRepository authorRepository) {
        this.repository = authorRepository;
    }

    
}