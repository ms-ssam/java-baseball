package model;

import model.enums.ScoreStatus;

public class ScoreModel {
    private Integer ball;

    private Integer strike;

    public ScoreModel(Integer ball, Integer strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    /**
     * myAnswer, realAnswer를 비교해서 ball, strike 개수를 계산한 뒤에 ScoreModel을 반환하는 static method
     *
     * @param myAnswer
     * @param realAnswer
     * @return
     */
    public static ScoreModel fromAnswers(String myAnswer, String realAnswer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < myAnswer.length(); i++) {
            if (myAnswer.charAt(i) == realAnswer.charAt(i)) {
                strike += 1;
            } else if (realAnswer.indexOf(myAnswer.charAt(i)) != -1) {
                ball += 1;
            }
        }

        return new ScoreModel(ball, strike);
    }

    public ScoreStatus getGameStatus() {
        if (ball == 0 && strike == 0) {
            return ScoreStatus.NOTHING;
        }

        if (strike == 3) {
            return ScoreStatus.END;
        }

        if (ball != 0 && strike != 0) {
            return ScoreStatus.STRIKE_AND_BALL;
        } else if (ball != 0) {
            return ScoreStatus.BALL_ONLY;
        }

        return ScoreStatus.STRIKE_ONLY;
    }
}
