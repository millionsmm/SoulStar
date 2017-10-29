package millionsmm.soulstar;

import java.util.List;

/**
 * Created by Wilber
 * on 27/10/2017.
 * 一个星系有很多行星
 */

public class Galaxy {
    private List<Star> stars;
    private int radius;
    private float[] starARGB;

    public Galaxy(List<Star> stars, int radius) {
        this.stars = stars;
        this.radius = radius;
    }


    public void produce() {
        for (int i = 0; i < stars.size(); i++) {
            int j = stars.get(i).getPriority();

        }
    }

    private void position(Star star) {
        double phi = Math.random() * (Math.PI);
        double theta = Math.random() * (Math.PI * 2);

        star.setxPos((float) (radius * Math.cos(theta) * Math.sin(phi)));
        star.setyPos((float) (radius * Math.sin(theta) * Math.sin(phi)));
        star.setzPos((float) (radius * Math.cos(phi)));

    }

    private void positionAll() {
        double phi = 0;// could change the value to make the figure you would;
        double theta = 0;
        int num = stars.size();
        for (int i = 1; i <= num; i++) {
            phi = Math.acos(-1.0 + (2.0 * i - 1.0) / num);
            theta = Math.sqrt(num * Math.PI) * phi;


            stars.get(i - 1).setxPos((float) (radius * Math.cos(theta) * Math.sin(phi)));
            stars.get(i - 1).setyPos((float) (radius * Math.sin(theta) * Math.sin(phi)));
            stars.get(i - 1).setzPos((float) (radius * Math.cos(phi)));
        }

    }


    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Star getStar(int position) {
        return stars.get(position);
    }

    public float[] getStarARGB() {
        return starARGB;
    }

    public void setStarARGB(float[] starARGB) {
        this.starARGB = starARGB;
    }
}
