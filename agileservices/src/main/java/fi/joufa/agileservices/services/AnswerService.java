package fi.joufa.agileservices.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.AnswerSet;

public interface AnswerService {

    /**
     *
     * @param answerSet
     * @throws AgileException
     */
    void answer(AnswerSet answerSet) throws AgileException;
}
