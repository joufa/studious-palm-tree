package fi.joufa.restservices.controller;

import fi.joufa.agileservices.exceptions.AgileException;
import fi.joufa.agileservices.services.SurveyService;
import fi.joufa.domain.model.SurveyUpdate;
import java.util.List;
import java.util.stream.Collectors;
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
  public List<SurveyDto> findAll() {
    return surveyService.findAll().stream()
        .map(survey -> dtoMapper.toDto(survey))
        .collect(Collectors.toList());
  }

  @PostMapping(path = "/surveys")
  public SurveyDto create(@RequestBody SurveyDto surveyDto) throws AgileException {
    return dtoMapper.toDto(this.surveyService.create(surveyDto.getName()));
  }

  @PutMapping(path = "/surveys")
  public SurveyDto update(@RequestBody SurveyDto surveyDto) throws AgileException {
    final SurveyUpdate toUpdate = dtoMapper.toUpdate(surveyDto);
    return dtoMapper.toDto(this.surveyService.update(toUpdate));
  }
}
