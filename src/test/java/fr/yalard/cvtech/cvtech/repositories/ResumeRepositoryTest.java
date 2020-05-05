package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Resume;
import org.springframework.beans.factory.annotation.Autowired;

class ResumeRepositoryTest extends AbstractRepositoryTest<Resume, ResumeRepository> {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume getObjectToSave() {
        return new Resume();
    }

    @Override
    public ResumeRepository getRepository() {
        return resumeRepository;
    }
}