package annotatin;


import java.util.Arrays;

//@Authors({@Author(name = "Tom"),@Author(name = "Jack")})
@Author(name = "Tom")
@Author(name = "Jack")
public class Book {

    public static void main(String[] args) {
        Author[] authors = Book.class.getAnnotationsByType(Author.class);
        Arrays.asList(authors).forEach(s->{
            System.out.println(s.name());
        });
    }

}
