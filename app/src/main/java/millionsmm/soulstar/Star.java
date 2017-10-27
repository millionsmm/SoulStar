package millionsmm.soulstar;

/**
 * Created by Wilber
 * on 27/10/2017.
 * 代表每个星
 */

public class Star {
    private int popularity;//可以考虑用这个欢迎度属性来调整星星亮度
    private float xPos, yPos;//zPos;

    public Star(int popularity) {
        this(popularity, 0f, 0f);
    }

    public Star(float xPos, float yPos) {
        this(0, xPos, yPos);
    }

    public Star(int popularity, float xPos, float yPos) {
        this.popularity = popularity;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }
}
