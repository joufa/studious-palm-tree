package fi.joufa.repositoryinterface;

import fi.joufa.domain.model.Survey;
import fi.joufa.domain.model.common.SurveyId;

import java.util.List;

public interface SurveyRepositoryI {

    Survey save(Survey survey);
    List<Survey> findAll();
    List<Survey> findAllOpen();
    Survey findById(SurveyId surveyId);
    Survey findByName(String name);


}
