package handler;

import model.ScoreModel;
import model.enums.ScoreStatus;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameHandler {
    /**
     * scoreModel로부터 결과 문장을 받아오는 메소드
     * @param scoreModel
     * @return
     */
    public String getResultFromScoreModel(ScoreModel scoreModel) {
        switch (scoreModel.getGameStatus()) {
            case STRIKE_ONLY:
                return scoreModel.getStrike() + "strike";
            case BALL_ONLY:
                return scoreModel.getBall() + "ball";
            case STRIKE_AND_BALL:
                return scoreModel.getBall() + "ball " + scoreModel.getStrike() + "strike";
            case NOTHING:
                return "nothing";
            default:
                return "Game end";
        }
    }

    public Boolean isGameEnd(ScoreModel scoreModel) {
        return scoreModel.getGameStatus() == ScoreStatus.END;
    }

    public Integer getRandomNumber() {
        int result = 0;
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            int number = (int) (Math.random() * 9) + 1;
            if (numberList.contains(number)) {
                numberList.add(number);
            }
        }

        for (int i = numberList.size(); i > 0; i--) {
            result += numberList.get(i - 3) * Math.pow(10, i - 1);
        }

        return result;
    }
}
