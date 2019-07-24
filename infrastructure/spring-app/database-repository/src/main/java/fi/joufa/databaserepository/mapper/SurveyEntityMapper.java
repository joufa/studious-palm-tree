package fi.joufa.databaserepository.mapper;

import fi.joufa.databaserepository.config.DateFactory;
import fi.joufa.databaserepository.model.QuestionEntity;
import fi.joufa.databaserepository.model.QuestionSetEntity;
import fi.joufa.databaserepository.model.SurveyEntity;
import fi.joufa.domain.model.*;
import fi.joufa.domain.model.common.TeamId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SurveyEntityMapper {

  private DateFactory dateFactory = new DateFactory();

  public SurveyEntity surveyToEntity(Survey survey) {
    final SurveyEntity se = new SurveyEntity();
    se.setId(survey.getSurveyId() != null ? survey.getSurveyId().get() : null);
    se.setName(survey.getName());

    final List<QuestionSetEntity> questionSets = new ArrayList<>();

    if (survey.getQuestionSets() != null) {
      final List<QuestionSet> setsInSurvey = survey.getQuestionSets().getAsList();
      AtomicInteger counter = new AtomicInteger(0);

      for (QuestionSet qs : setsInSurvey) {
        QuestionSetEntity qse = new QuestionSetEntity();
        qse.setOrdering(counter.incrementAndGet());
        qse.setName(qs.getName());
        // the questions
        List<QuestionEntity> questions = new ArrayList<>();
        List<Question> questionsFromSet = qs.getQuestionMap().getAsList();
        AtomicInteger questionCounter = new AtomicInteger(0);
        for (Question q : questionsFromSet) {
          final QuestionEntity qe = new QuestionEntity();
          qe.setOrdering(questionCounter.getAndIncrement());
          qe.setText(q.getQuestion());
          qe.setSet(qse);
          questions.add(qe);
        }

        qse.setQuestions(questions);
        questionSets.add(qse);
      }
      se.setSets(questionSets);
    }
    se.setCreatedAt(dateFactory.convertToDate(survey.getStatusHistory().getCreatedAt()));
    se.setUpdatedAt(dateFactory.convertToDate(survey.getStatusHistory().getUpdatedAt()));
    if (survey.getTeams() != null) {
      se.setTeams(this.mapTeams(survey.getTeams()));
    }
    return se;
  }

  public Survey entityToSurvey(SurveyEntity se) {
    List<QuestionSetEntity> sets = se.getSets();
    List<QuestionSet> qsList = new ArrayList<>();
    Collections.sort(sets);
    for (QuestionSetEntity qse : sets) {
      if (qse.getQuestions() != null) {
        final List<QuestionEntity> questionsFromSet = qse.getQuestions();
        final QuestionMap<Question> qm = toQuestions(questionsFromSet);
        final QuestionSet qs = QuestionSet.create(qse.getName(), qm);
        qsList.add(qs);
      }
    }
    final QuestionMap<QuestionSet> questMap = QuestionMap.createQuestionMap(qsList);
    return new SurveyBuilder()
        .setSurveyId(se.getId())
        .setName(se.getName())
        .setQuestionSets(questMap)
        .setAllTeams(mapLong(se.getTeams()))
        .initStatus()
        .setStatusHistory(
            new StatusHistory(
                dateFactory.convertToLocalDateTime(se.getCreatedAt()),
                dateFactory.convertToLocalDateTime(se.getUpdatedAt())))
        .createSurvey();
  }

  private QuestionMap<Question> toQuestions(List<QuestionEntity> questionEntities) {
    Collections.sort(questionEntities);
    final List<Question> questions =
        questionEntities.stream().map(q -> new Question(q.getText())).collect(Collectors.toList());
    return QuestionMap.createQuestionMap(questions);
  }

  private Set<Long> mapTeams(Set<TeamId> teams) {
    if (teams == null || teams.isEmpty()) {
      return Collections.emptySet();
    }
    return teams.stream().map(team -> team.getId()).collect(Collectors.toSet());
  }

  private Set<TeamId> mapLong(Set<Long> teams) {
    if (teams == null || teams.isEmpty()) {
      return Collections.emptySet();
    }
    return teams.stream().map(id -> new TeamId(id)).collect(Collectors.toSet());
  }
}
