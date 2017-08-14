package derbyapps.ac.nz.catchybird;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by eugene on 10/08/2017.
 */

public class BirdLocationItem {

    /**
     * Item bird
     */
    @com.google.gson.annotations.SerializedName("bird")
    private String mBird;

    /**
     * Item latitude
     */
    @com.google.gson.annotations.SerializedName("latitude")
    private float mLatitude;

    /**
     * Item longitude
     */
    @com.google.gson.annotations.SerializedName("longitude")
    private float mLongitude;

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    private boolean mBox;
    private int mImg;
    private int mCount;
    private Marker mMarker;

    /**
     * BirdLocationItem constructor
     */
    public BirdLocationItem() {
        this.setBox(true);
    }

    /**
     * Initializes a new BirdLocationItem
     *
     * @param img
     *            The image identifier
     * @param bird
     *            The row_bird_location bird
     */
    public BirdLocationItem(int count, int img, String bird) {
        this.setCount(count);
        this.setImg(img);
        this.setBird(bird);
        this.setBox(true);
    }

    /**
     * Returns the row_bird_location bird
     */
    public String getBird() {
        return mBird;
    }

    /**
     * Sets the row_bird_location bird
     *
     * @param bird
     *            bird to set
     */
    public final void setBird(String bird) {
        mBird = bird;
    }

    /**
     * Returns the row_bird_location latitude
     */
    public float getLatitude() {
        return mLatitude;
    }

    /**
     * Sets the row_bird_location latitude
     *
     * @param latitude
     *            latitude to set
     */
    public final void setLatitude(float latitude) {
        mLatitude = latitude;
    }

    /**
     * Returns the row_bird_location longitude
     */
    public float getLongitude() {
        return mLongitude;
    }

    /**
     * Sets the row_bird_location longitude
     *
     * @param longitude
     *            longitude to set
     */
    public final void setLongitude(float longitude) {
        mLongitude = longitude;
    }

    /**
     * Returns the row_bird_location id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the row_bird_location id
     *
     * @param id
     *            id to set
     */
    public final void setId(String id) {
        mId = id;
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

    public Marker getMarker() {
        return mMarker;
    }

    public void setMarker(Marker marker) {
        mMarker = marker;
    }
}
