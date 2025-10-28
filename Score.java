public class Score {
    Variables vars = new Variables();

    public void addPoints(int points){
        this.vars.totalScore += points;
}

    public int getTotalScore (){
        return vars.totalScore;
    }

}
