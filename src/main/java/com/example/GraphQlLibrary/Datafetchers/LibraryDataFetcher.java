package com.example.GraphQlLibrary.Datafetchers;

import com.example.GraphQlLibrary.generated.types.AddBookInput;
import com.example.GraphQlLibrary.generated.types.AddBookPayload;
import com.example.GraphQlLibrary.generated.types.Book;
import com.example.GraphQlLibrary.service.LibraryService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;


@DgsComponent
public class LibraryDataFetcher {

    LibraryService libraryService;

    @Autowired
    public LibraryDataFetcher(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @DgsQuery
    public Book getBookById(@InputArgument String id){
        return libraryService.getBookById(id);
    }

    @DgsMutation
    public AddBookPayload addBook(@InputArgument AddBookInput input){
        return libraryService.addBook(input);
    }

}
