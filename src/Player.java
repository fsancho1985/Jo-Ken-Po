public class Player {
//    Attributes
    private String name;
    private Integer score;

//    Constructor
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void incrementScore() {
        this.setScore(this.getScore() + 1);
    }

//    Methods Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
