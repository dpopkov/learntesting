package learn.junitia.ch02core.tags;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("repository")
@DisplayName("Repository должен")
class RepositoryTest {
    public static final String NAME = "Jane Doe";

    private final Repository repository = new Repository();

    @Test
    @DisplayName("показывать отсутствие клиентов с несуществующим именем")
    void testNonExistence() {
        assertFalse(repository.contains(NAME));
    }

    @Test
    @DisplayName("показывать наличие клиента с существующим именем")
    void testPersistence() {
        repository.persist(new Customer(NAME));
        assertTrue(repository.contains(NAME));
    }
}