package millionsmm.soulstar;

import java.util.List;

/**
 * Created by Wilber
 * on 27/10/2017.
 * 一个星系有很多行星
 */

public class Galaxy {
    private List<Star> stars;

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public Star getStar(int position) {
        return stars.get(position);
    }
}
