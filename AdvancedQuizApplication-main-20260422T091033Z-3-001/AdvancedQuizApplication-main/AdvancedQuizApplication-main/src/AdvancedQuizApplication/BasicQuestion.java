package AdavanceQuizApplication;


public class BasicQuestion extends MultipleChoiceQuestion {

    /**
     * 
     */
    public BasicQuestion(String questionText, String[] optionList, int correctAnswerPos) {
        super(questionText, optionList, correctAnswerPos);
    }

    // Correct answer = +1, wrong = 0
    @Override
    public int calculateScore(int userChoice) {
        if (validateAnswer(userChoice)) {
            return 1;
        }
        return 0;
    }

}
