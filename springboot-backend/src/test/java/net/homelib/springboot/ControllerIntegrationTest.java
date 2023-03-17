package net.homelib.springboot;

import net.homelib.springboot.UI.model.dto.BookDto;
import net.homelib.springboot.controller.BookController;
import net.homelib.springboot.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.UUID;
import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
@AutoConfigureWebMvc
public class ControllerIntegrationTest {

    @MockBean
    private BookServiceImpl bookService;

    @Autowired
    private MockMvc mockMvc;
    private BookDto mockBookDto;

    private final UUID randomUUID = UUID.fromString("0637bdfd-ed72-4f8f-8a0f-3e4f599fa9b5");

    @BeforeEach
    void setUp() {
        this.mockBookDto = new BookDto(1,randomUUID,"book1","author","1000");
    }

    @Test
    public void whenGetBookByIdThenReturBookById() throws Exception {
       when(this.bookService.getBookDtoByUUID(randomUUID)).thenReturn(mockBookDto);

       mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/"+randomUUID))
               .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(mockBookDto.getId()));
    }

}
