package fi.joufa.domain.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerSet {
    private List<Answer> answers;

    public AnswerSet() {
        this.answers = new ArrayList<>();
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
