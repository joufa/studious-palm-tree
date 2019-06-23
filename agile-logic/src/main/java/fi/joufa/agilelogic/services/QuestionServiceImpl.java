package fi.joufa.agilelogic.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.QuestionService;
import fi.joufa.domain.model.Question;
import fi.joufa.domain.model.QuestionSet;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

  @Override
  public QuestionSet createSet(String name) throws AgileException {
    return null;
  }

  @Override
  public QuestionSet updateSet(QuestionSet questionSet) throws AgileException {
    return null;
  }

  @Override
  public Question create(Question question) throws AgileException {
    return null;
  }

  @Override
  public QuestionSet delete(QuestionSet questionSet) throws AgileException {
    return null;
  }

  @Override
  public Question delete(Question question) throws AgileException {
    return null;
  }

  @Override
  public List<Question> findAllQuestions() {
    return null;
  }

  @Override
  public List<QuestionSet> findAllSets() {
    return null;
  }
}
