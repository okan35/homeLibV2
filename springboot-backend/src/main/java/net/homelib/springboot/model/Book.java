package net.homelib.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "table_books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "uuid")
	private UUID uuid = UUID.randomUUID();

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "last_name")
	private String author;
	
	@Column(name = "publish_date")
	private String publishDate;

	public Book(String bookName, String author, String publishDate) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
	}
}
