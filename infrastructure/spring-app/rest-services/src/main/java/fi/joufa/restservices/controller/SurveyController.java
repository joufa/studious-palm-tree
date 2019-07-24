package fi.joufa.restservices.controller;

import fi.joufa.agileservices.services.SurveyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class SurveyController {

  private SurveyService surveyService;
  private DtoMapper dtoMapper = new DtoMapper();

  public SurveyController(SurveyService surveyService) {
    this.surveyService = surveyService;
  }

  @GetMapping(path = "/surveys")
  public SurveyDto findAll() {
    return null;
  }

  @PostMapping(path = "/surveys")
  public SurveyDto create(@RequestBody SurveyDto surveyDto) throws Exception {
    System.out.println(surveyDto);
    return dtoMapper.toDto(this.surveyService.create(surveyDto.getName()));
  }
}
