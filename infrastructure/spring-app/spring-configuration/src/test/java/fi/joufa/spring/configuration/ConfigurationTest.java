/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.joufa.spring.configuration;

import fi.joufa.repositoryinterface.TeamRepositoryI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/** @author udanre */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationLogicFactory.class)
public class ConfigurationTest {

  @MockBean private TeamRepositoryI teamRepositoryI;

  @Test
  public void contextLoads() {
    MockitoAnnotations.initMocks(this);
  }
}
