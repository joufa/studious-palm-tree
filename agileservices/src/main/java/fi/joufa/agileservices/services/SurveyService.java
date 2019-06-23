package fi.joufa.agileservices.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;

public interface SurveyService {

    List<Survey> findAll();

    List<Survey> findOpen();

    Survey update(Survey survey);

    Survey create(String name) throws AgileException;

    Survey findOne(SurveyId surveyId);
}
