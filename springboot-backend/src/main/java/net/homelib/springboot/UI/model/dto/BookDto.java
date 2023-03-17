package net.homelib.springboot.UI.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    public long id;
    public UUID uuid;
    public String bookName;
    public String author;
    public String publishDate;

    public BookDto(long id, UUID uuid, String bookName, String author, String publishDate) {
        this.id = id;
        this.uuid = uuid;
        this.bookName = bookName;
        this.author = author;
        this.publishDate = publishDate;
    }
}
