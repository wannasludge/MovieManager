package ru.netology;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;
import ru.netology.manager.MoviesManager;

import static org.junit.jupiter.api.Assertions.*;

public class MoviesManagerTest {
    Movies one = new Movies(1, "Первый", 1, false);
    Movies two = new Movies(2, "Второй", 2, true);
    Movies three = new Movies(3, "третий", 3, true);
    Movies four = new Movies(4, "Четвёртый", 4, false);
    Movies five = new Movies(5, "Пятый", 3, false);
    Movies six = new Movies(6, "Шестой", 1, true);
    Movies seven = new Movies(7, "Седьмой", 4, false);
    Movies eight = new Movies(8, "Восьмой", 3, false);
    Movies nine = new Movies(9, "Девятый", 2, false);
    Movies ten = new Movies(10, "Десятый", 3, true);
    Movies eleven = new Movies(11, "Одиннадцатый", 1, false);

    @Test
    public void shouldCheck(){
        MoviesManager manager = new MoviesManager();
        manager.add(one);
        Movies expected = new Movies(1, "Первый", 1, false);
        Movies actual = new Movies(one.getId(), one.getName(), one.getGenre(), one.isPremiere());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmsBelowLimit() {
        MoviesManager manager = new MoviesManager();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{three, two, one};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetFilmsOverLimit() {
        MoviesManager manager = new MoviesManager();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{eleven, ten, nine, eight, seven, six, five, four, three, two};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSomeFilmsUnderLimit(){
        MoviesManager manager = new MoviesManager(4);
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{six, five, four, three};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSomeFilmsOverLimit(){
        MoviesManager manager = new MoviesManager(8);
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{six, five, four, three, two, one};
        assertArrayEquals(expected, actual);

        
    }
}