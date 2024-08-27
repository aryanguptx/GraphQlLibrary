package com.example.GraphQlLibrary.service;

import com.example.GraphQlLibrary.generated.types.AddBookInput;
import com.example.GraphQlLibrary.generated.types.AddBookPayload;
import com.example.GraphQlLibrary.generated.types.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LibraryService {
    ArrayList<Book> library;

    public LibraryService() {
        ArrayList<Book> library = new ArrayList<>();

        Book book1 = Book.newBuilder()
                .id("book1")
                .title("To Kill a Mockingbird")
                .author("Harper Lee")
                .publicationYear(1960)
                .genre("Novel")
                .build();

        Book book2 = Book.newBuilder()
                .id("book2")
                .title("1984")
                .author("George Orwell")
                .publicationYear(1949)
                .genre("Dystopian Fiction")
                .build();

        Book book3 = Book.newBuilder()
                .id("book3")
                .title("Pride and Prejudice")
                .author("Jane Austen")
                .publicationYear(1813)
                .genre("Romance")
                .build();

        library.add(book1);
        library.add(book3);
        library.add(book2);

        this.library = library;
    }

    public Book getBookById(String id){
        return library.parallelStream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public AddBookPayload addBook(AddBookInput input){
        Book newBook = Book.newBuilder()
                .id(input.getId())
                .author(input.getAuthor())
                .genre(input.getGenre())
                .title(input.getTitle())
                .publicationYear(input.getPublicationYear())
                .build();

        library.add(newBook);

        return AddBookPayload.newBuilder()
                .book(newBook)
                .status("200")
                .build();
    }

}
