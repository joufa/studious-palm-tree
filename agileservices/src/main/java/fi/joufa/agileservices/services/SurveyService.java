package fi.joufa.agileservices.services;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;
import java.util.Optional;

public interface SurveyService {

    List<Survey> findAll();

    List<Survey> findAllOpen();

    Survey update(Survey survey) throws AgileException;

    Survey create(String name) throws AgileException;

    Survey createFrom(SurveyId surveyId) throws AgileException;

    Optional<Survey> findOne(SurveyId surveyId);

}
