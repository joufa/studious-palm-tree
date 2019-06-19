package fi.joufa.agileservices.services;

import fi.joufa.domain.model.Question;
import fi.joufa.domain.model.QuestionSet;

public interface QuestionService {
    QuestionSet addToSet(Question question);
    Question create(Question question);
    Question update(Question question);
    Question delete(Question question);
    QuestionSet removeFromSet(Question question);
}
