package dat.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PoemControllerTest {

    @BeforeEach
    void setUp() {
    }


    @AfterEach
    void tearDown() {
    }
    @Test
    void is5Plus510(){
        Integer number = 5;
        Integer expectedOutcome = 10;
        assertThat(number + number, equalTo(expectedOutcome));
    }
    void is5Plus511(){
        Integer number = 5;
        Integer expectedOutcome = 11;
        assertThat(number + number, equalTo(expectedOutcome));
    }
    @Test
    void getAllPoems() {
    }

    @Test
    void getPoemById() {
    }

    @Test
    void createPoem() {
    }

    @Test
    void createPoems() {
    }

    @Test
    void updatePoem() {
    }

    @Test
    void deletePoem() {
    }
}