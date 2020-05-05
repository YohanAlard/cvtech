package fr.yalard.cvtech.cvtech.repositories;

import fr.yalard.cvtech.cvtech.model.sql.Level;
import fr.yalard.cvtech.cvtech.model.sql.Resume;
import fr.yalard.cvtech.cvtech.model.sql.Skill;
import fr.yalard.cvtech.cvtech.model.sql.Study;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResumeRepositoryTest extends AbstractRepositoryTest<Resume, ResumeRepository> {

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private StudyRepository studyRepository;
    @Autowired
    private ResumeRepository resumeRepository;
    private Resume resume = new Resume();

    @BeforeEach
    void setUp() {
        Skill java = Skill.builder().description("langage").level(Level.BEGINNER).name("JAVA").build();
        Skill python = Skill.builder().description("langage").level(Level.EXPERT).name("Python").build();
        Study master = Study.builder().diploma("Ingeneer").school("polytech lille").startYear(LocalDate.ofYearDay(2001, 1)).endYear(LocalDate.ofYearDay(2004, 1)).build();
        Study iut = Study.builder().diploma("bac+2").school("IUT ").startYear(LocalDate.ofYearDay(1999, 1)).endYear(LocalDate.ofYearDay(2001, 1)).build();
        resume.getSkills().addAll(Arrays.asList(java, python));
        resume.getStudies().addAll(Arrays.asList(master, iut));
    }

    @Override
    public Resume getObjectToSave() {
        return resume;
    }

    @Test
    public void checkCascadeCreation() {
        Resume resumeSaved = resumeRepository.save(resume);
        assertEquals(resumeSaved.getStudies().size(), resume.getStudies().size());
        assertEquals(resumeSaved.getSkills().size(), resume.getSkills().size());
        List<Long> skillsID = resumeSaved.getSkills().stream().map(Skill::getId).collect(Collectors.toList());
        List<Long> studiesID = resumeSaved.getStudies().stream().map(Study::getId).collect(Collectors.toList());
        resumeRepository.deleteAll();
        //Check skills & studies are kept.= when resume is deleted.
        skillsID.forEach(id -> assertTrue(skillRepository.existsById(id)));
        studiesID.forEach(id -> assertTrue(skillRepository.existsById(id)));
    }

    @Override
    public ResumeRepository getRepository() {
        return resumeRepository;
    }


}