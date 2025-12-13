package onlinebookstore.dto.book;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotBlank(message = "title must not be blank")
    @Size(max = 255, message = "title must be no longer than 255 characters")
    private String title;
    @Size(max = 255, message = "author must be no longer than 255 characters")
    @NotBlank(message = "author must not be blank")
    private String author;
    @NotBlank(message = "isbn must not be blank")
    @Pattern(
            regexp = "^(\\d{10}|\\d{13}|[\\d-]{13,17})$",
            message = "isbn must be 10 or 13 digits (hyphens allowed)"
    )
    private String isbn;
    @NotNull(message = "price must not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "price must be greater than 0")
    private BigDecimal price;
    @Size(max = 1000, message = "description must be no longer than 1000 characters")
    private String description;
    @Size(max = 255, message = "coverImage must be no longer than 255 characters")
    private String coverImage;
}
