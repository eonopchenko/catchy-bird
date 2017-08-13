package derbyapps.ac.nz.catchybird;

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

    boolean box;

    /**
     * BirdLocationItem constructor
     */
    public BirdLocationItem() {
    }

    /**
     * Initializes a new BirdLocationItem
     *
     * @param bird
     *            The item bird
     * @param latitude
     *            The item latitude
     * @param longitude
     *            The item longitude
     * @param id
     *            The item id
     */
    public BirdLocationItem(String bird, float latitude, float longitude, String id) {
        this.setBird(bird);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setId(id);
        this.box = false;
    }

    /**
     * Returns the item bird
     */
    public String getBird() {
        return mBird;
    }

    /**
     * Sets the item bird
     *
     * @param bird
     *            bird to set
     */
    public final void setBird(String bird) {
        mBird = bird;
    }

    /**
     * Returns the item latitude
     */
    public float getLatitude() {
        return mLatitude;
    }

    /**
     * Sets the item latitude
     *
     * @param latitude
     *            latitude to set
     */
    public final void setLatitude(float latitude) {
        mLatitude = latitude;
    }

    /**
     * Returns the item longitude
     */
    public float getLongitude() {
        return mLongitude;
    }

    /**
     * Sets the item longitude
     *
     * @param longitude
     *            longitude to set
     */
    public final void setLongitude(float longitude) {
        mLongitude = longitude;
    }

    /**
     * Returns the item id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the item id
     *
     * @param id
     *            id to set
     */
    public final void setId(String id) {
        mId = id;
    }
}
