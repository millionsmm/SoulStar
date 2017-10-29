package millionsmm.soulstar;

import android.view.View;

/**
 * Created by Wilber
 * on 27/10/2017.
 * 代表每个星
 */

public class Star {
    private static final int DEFAULT_PRIORITY = 5;
    private int priority;//可以考虑用这个欢迎度属性来调整星星亮度
    private float xPos, yPos, zPos;
    private float[] argb;
    private View view;

    public Star() {
        this(0, 0f, 0f, 0f);
    }

    public Star(int priority) {
        this(priority, 0f, 0f, 0f);
    }

    public Star(float xPos, float yPos, float zPos) {
        this(DEFAULT_PRIORITY, 0f, 0f, 0f);
    }

    public Star(int priority, float xPos, float yPos, float zPos) {
        this.priority = priority;
        this.xPos = xPos;
        this.yPos = yPos;
        this.zPos = zPos;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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

    public float getzPos() {
        return zPos;
    }

    public void setzPos(float zPos) {
        this.zPos = zPos;
    }

    public float[] getArgb() {
        return argb;
    }

    public void setArgb(float[] argb) {
        this.argb = argb;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
