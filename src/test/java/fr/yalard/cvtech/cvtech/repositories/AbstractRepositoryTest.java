package fr.yalard.cvtech.cvtech.repositories;


import fr.yalard.cvtech.cvtech.model.sql.AbstractEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public abstract class AbstractRepositoryTest<T extends AbstractEntity, S extends CrudRepository<T, Long>> {
    public static final long DEFAULT_DATA_SQL_ID = 1L;
    public static final long DEFAULT_FIRST_ID = 2L;
    public static final int ZERO_RESULT = 0;

    @Test
    public void save_create() {
        S repo = getRepository();
        T savedEntity = repo.save(getObjectToSave());
        assertNotNull(savedEntity);
        assertEquals(savedEntity.getId(), DEFAULT_FIRST_ID);
    }

    @Test
    public void save_update() {
        S repo = getRepository();
        T entityToSave = getObjectToSave();
        entityToSave.setId(DEFAULT_DATA_SQL_ID);
        T savedEntity = repo.save(entityToSave);
        assertNotNull(savedEntity);
        assertEquals(savedEntity.getId(), DEFAULT_DATA_SQL_ID);
    }


    @Test
    public void checkExistingId() {
        S repo = getRepository();
        assertTrue(repo.existsById(DEFAULT_DATA_SQL_ID));
    }

    @Test
    public void findById() {
        S repo = getRepository();
        Optional<T> entity = repo.findById(DEFAULT_DATA_SQL_ID);
        assertTrue(entity.isPresent());
        assertEquals(entity.get().getId(), DEFAULT_DATA_SQL_ID);
    }


    @Test
    public void findAll() {
        S repo = getRepository();
        Iterable<T> entities = repo.findAll();
        assertEquals(StreamSupport.stream(entities.spliterator(), false).count(), 1);
        assertEquals(entities.iterator().next().getId(), DEFAULT_DATA_SQL_ID);
    }

    @Test
    public void count() {
        S repo = getRepository();
        assertEquals(repo.count(), 1);
    }

    @Test
    public void deleteById() {
        S repo = getRepository();
        repo.deleteById(DEFAULT_DATA_SQL_ID);
        assertEquals(ZERO_RESULT, repo.count());
    }

    @Test
    public void deleteAll() {
        S repo = getRepository();
        repo.deleteAll();
        assertEquals(ZERO_RESULT, repo.count());
    }

    public abstract T getObjectToSave();

    public abstract S getRepository();
}
