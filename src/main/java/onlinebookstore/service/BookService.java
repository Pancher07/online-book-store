package onlinebookstore.service;

import java.util.List;
import onlinebookstore.dto.book.BookDto;
import onlinebookstore.dto.book.BookRequestDto;

public interface BookService {
    BookDto save(BookRequestDto dto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto update(Long id, BookRequestDto dto);

    void delete(Long id);
}
