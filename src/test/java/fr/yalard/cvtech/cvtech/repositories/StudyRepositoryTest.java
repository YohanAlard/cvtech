package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Study;
import org.springframework.beans.factory.annotation.Autowired;

class StudyRepositoryTest extends AbstractRepositoryTest<Study, StudyRepository> {

    @Autowired
    private StudyRepository studyRepository;

    @Override
    public Study getObjectToSave() {
        return new Study();
    }

    @Override
    public StudyRepository getRepository() {
        return studyRepository;
    }
}