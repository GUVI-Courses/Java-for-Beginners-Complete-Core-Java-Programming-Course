package AdavanceQuizApplication;


public class AdvanceQuestion extends MultipleChoiceQuestion {

    /**
     * 
     */
    public AdvanceQuestion(String questionText, String[] optionList, int correctAnswerPos) {
        super(questionText, optionList, correctAnswerPos);
    }

    // Correct answer = +1, wrong = 0
    @Override
    public int calculateScore(int userChoice) {
        if (validateAnswer(userChoice)) {
            return 2;
        }
        return -1;
    }
    
    @Override
    public void displayQuestion() {
        System.out.println("[ADVANCED QUESTION - Negative Marking]");
        super.displayQuestion();
    }


}
