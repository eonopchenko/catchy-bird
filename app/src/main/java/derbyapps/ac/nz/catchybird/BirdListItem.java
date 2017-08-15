package derbyapps.ac.nz.catchybird;

/**
 * Created by eugene on 15/08/2017.
 */

public class BirdListItem {

    private String mBird;
    private boolean mBox;
    private int mCount;
    private int mImg;

    /**
     * Initializes a new BirdLocationItem
     *
     * @param bird
     *            The row_bird_list bird
     * @param count
     *            The row_bird_list bird
     * @param img
     *            The image identifier
     */
    public BirdListItem(String bird, int count, int img) {
        this.setBird(bird);
        this.setCount(count);
        this.setImg(img);
        this.setBox(true);
    }

    /**
     * Returns the row_bird_list bird
     */
    public String getBird() {
        return mBird;
    }

    /**
     * Sets the row_bird_list bird
     *
     * @param bird
     *            bird to set
     */
    public final void setBird(String bird) {
        mBird = bird;
    }

    public boolean isBox() {
        return mBox;
    }

    public void setBox(boolean box) {
        this.mBox = box;
    }

    public int getImg() {
        return mImg;
    }

    public void setImg(int img) {
        this.mImg = img;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

    public void incCount() {
        mCount++;
    }
}
