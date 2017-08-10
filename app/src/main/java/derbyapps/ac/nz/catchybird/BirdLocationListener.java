package derbyapps.ac.nz.catchybird;

import java.util.List;

/**
 * Created by eugene on 10/08/2017.
 */

public interface BirdLocationListener {
    void onBirdLocationAvailable(List<BirdLocationItem> locations);
}
