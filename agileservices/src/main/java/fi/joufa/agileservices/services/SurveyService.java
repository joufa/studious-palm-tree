package fi.joufa.agileservices.services;

import fi.joufa.domain.model.Survey;

import java.util.List;

public interface SurveyService {

    List<Survey> findAll();

    Survey update(Survey survey);

    Survey create();

    Survey findOne(Long id);
}
