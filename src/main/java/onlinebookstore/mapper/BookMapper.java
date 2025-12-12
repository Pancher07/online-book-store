package onlinebookstore.mapper;

import onlinebookstore.config.MapperConfig;
import onlinebookstore.dto.book.BookDto;
import onlinebookstore.dto.book.BookRequestDto;
import onlinebookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(BookRequestDto requestDto);

    void updateBookFromDto(BookRequestDto dto, @MappingTarget Book book);
}
