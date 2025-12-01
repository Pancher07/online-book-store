package onlinebookstore.service;

import java.util.List;
import onlinebookstore.dto.BookDto;
import onlinebookstore.dto.BookRequestDto;

public interface BookService {
    BookDto save(BookRequestDto bookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto update(Long id, BookRequestDto dto);

    void delete(Long id);
}
