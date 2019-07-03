package fi.joufa.agileservices;

import fi.joufa.domain.model.AnswerSet;
import fi.joufa.domain.model.QuestionSet;

import java.util.Set;

public interface AnswerValidator {

    boolean validate(AnswerSet answerSet, Set<QuestionSet> questions);
}
