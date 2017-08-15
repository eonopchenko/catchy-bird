package derbyapps.ac.nz.catchybird;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by eugene on 10/08/2017.
 */

public class BirdLocationItem {

    /**
     * Item marker pointer
     */
    private Marker mMarker;

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

    /**
     * Returns the row_bird_list latitude
     */
    public float getLatitude() {
        return mLatitude;
    }

    /**
     * Sets the row_bird_list latitude
     *
     * @param latitude
     *            latitude to set
     */
    public final void setLatitude(float latitude) {
        mLatitude = latitude;
    }

    /**
     * Returns the row_bird_list longitude
     */
    public float getLongitude() {
        return mLongitude;
    }

    /**
     * Sets the row_bird_list longitude
     *
     * @param longitude
     *            longitude to set
     */
    public final void setLongitude(float longitude) {
        mLongitude = longitude;
    }

    /**
     * Returns the row_bird_list id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the row_bird_list id
     *
     * @param id
     *            id to set
     */
    public final void setId(String id) {
        mId = id;
    }

    /**
     * Returns
     */
    public Marker getMarker() {
        return mMarker;
    }

    /**
     * Sets
     *
     * @param marker
     *            marker to set
     */
    public void setMarker(Marker marker) {
        mMarker = marker;
    }
}
