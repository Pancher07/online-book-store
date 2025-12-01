package onlinebookstore.mapper;

import onlinebookstore.config.MapperConfig;
import onlinebookstore.dto.BookDto;
import onlinebookstore.dto.BookRequestDto;
import onlinebookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(BookRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    void updateBookFromDto(BookRequestDto dto, @MappingTarget Book book);
}
