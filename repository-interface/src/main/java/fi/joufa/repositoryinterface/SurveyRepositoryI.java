package fi.joufa.repositoryinterface;

import fi.joufa.domain.model.Survey;

public interface SurveyRepositoryI {

    Survey save(Survey survey);
    Survey create(Survey survey);

}
