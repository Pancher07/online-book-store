package onlinebookstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import onlinebookstore.dto.BookDto;
import onlinebookstore.dto.BookRequestDto;
import onlinebookstore.exception.EntityNotFoundException;
import onlinebookstore.mapper.BookMapper;
import onlinebookstore.model.Book;
import onlinebookstore.repository.BookRepository;
import onlinebookstore.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(BookRequestDto bookRequestDto) {
        Book book = bookRepository.save(bookMapper.toModel(bookRequestDto));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = findBookByIdOrElseThrow(id);
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto update(Long id, BookRequestDto dto) {
        Book existingBook = findBookByIdOrElseThrow(id);
        bookMapper.updateBookFromDto(dto, existingBook);
        return bookMapper.toDto(bookRepository.save(existingBook));
    }

    private Book findBookByIdOrElseThrow(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }
}
