package fi.joufa.agilesurvey.repository;

import fi.joufa.agilesurvey.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {}
