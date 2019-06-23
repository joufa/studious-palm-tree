package fi.joufa.agileservices.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Question;
import fi.joufa.domain.model.QuestionSet;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;

public interface SurveyService {

    List<Survey> findAll();

    List<Survey> findOpen();

    Survey update(Survey survey);

    Survey update(SurveyId surveyId, QuestionSet qs) throws AgileException;

    Survey create(String name) throws AgileException;

    Survey findOne(SurveyId surveyId);
}
