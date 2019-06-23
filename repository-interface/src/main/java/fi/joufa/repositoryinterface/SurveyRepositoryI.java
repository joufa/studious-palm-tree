package fi.joufa.repositoryinterface;

import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;

public interface SurveyRepositoryI {

    Survey save(Survey survey);
    List<Survey> findAll();
    Survey findById(SurveyId surveyId);

}
