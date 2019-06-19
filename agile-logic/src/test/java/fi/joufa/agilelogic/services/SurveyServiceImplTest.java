package fi.joufa.agilelogic.services;

import static org.junit.Assert.*;

import fi.joufa.repositoryinterface.SurveyRepositoryI;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SurveyServiceImplTest {

  @Mock private SurveyRepositoryI surveyRepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void findAll() {}

  @Test
  public void update() {}

  @Test
  public void create() {}

  @Test
  public void findOne() {}

  private void initMocks() {}
}
