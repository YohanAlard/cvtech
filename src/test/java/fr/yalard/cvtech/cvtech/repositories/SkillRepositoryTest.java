package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Skill;
import org.springframework.beans.factory.annotation.Autowired;

class SkillRepositoryTest extends AbstractRepositoryTest<Skill, SkillRepository> {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill getObjectToSave() {
        return new Skill();
    }

    @Override
    public SkillRepository getRepository() {
        return skillRepository;
    }
}