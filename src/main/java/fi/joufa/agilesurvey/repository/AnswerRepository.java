package fi.joufa.agilesurvey.repository;

import fi.joufa.agilesurvey.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {}
