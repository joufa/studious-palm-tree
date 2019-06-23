package fi.joufa.agileservices.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Question;
import fi.joufa.domain.model.QuestionSet;

import java.util.List;

public interface QuestionService {
    /**
     * Creates an empty question set with custom name
     * @param name The name of of the question set
     * @return The question set
     * @throws AgileException if name is empty or a set with proposed name exists.
     */
    QuestionSet createSet(String name) throws AgileException;

    /**
     * Updates a Question set
     * @param questionSet
     * @return
     * @throws AgileException
     */
    QuestionSet updateSet(QuestionSet questionSet) throws AgileException;
    /**
     * Creates a new question.
     *
     * @param question Question object
     * @return Created question
     * @throws AgileException if the question is already present.
     */
    Question create(Question question) throws AgileException;

    /**
     * Deletes a question set.
     *
     * @param questionSet The set to be deleted
     * @return The deleted question set
     * @throws AgileException if set cannot be deleted
     *
     *   Delete will fail if question set is part of an active survey
     *
     */
    QuestionSet delete(QuestionSet questionSet) throws AgileException;

    /**
     * Deletes a question.
     *
     * @param question Question to be deled
     * @return The deleted quesion
     */
    Question delete(Question question) throws AgileException;

    List<Question> findAllQuestions();
    List<QuestionSet> findAllSets();

}
