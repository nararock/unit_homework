package homework3.task3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void addUser() {
        UserRepository repository = new UserRepository();
        User user1 = new User("Bill", "bill123", true);
        User user2 = new User("Monica", "mony456", false);
        User user3 = new User("Hillary", "i_am_hillary", false);
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        assertEquals(3, repository.data.size());
    }

    @Test
    void findByName() {
        UserRepository repository = new UserRepository();
        User user1 = new User("Bill", "bill123", true);
        User user2 = new User("Monica", "mony456", false);
        User user3 = new User("Hillary", "i_am_hillary", false);
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        assertTrue(repository.findByName("Monica"));
        assertFalse(repository.findByName("Donald"));
    }

    @Test
    void logOutUsers() {
        UserRepository repository = new UserRepository();
        User user1 = new User("Bill", "bill123", true);
        User user2 = new User("Monica", "mony456", false);
        User user3 = new User("Hillary", "i_am_hillary", false);
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        repository.logOutUsers();
        assertEquals(1, repository.data.size());
    }
}