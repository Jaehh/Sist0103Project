package boot.data;

import java.util.List;

public interface BookMapperInter {

	public int getTotalBook();
	public void insertBook(BookDto dto);
	public List<BookDto> getAllBooks();
	public BookDto getBook(String num);
	public void updateBook(BookDto dto);
	public void deleteBook(String num);
}
