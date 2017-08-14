package derbyapps.ac.nz.catchybird;

import java.util.List;

/**
 * Created by eugene on 10/08/2017.
 */

interface BirdLocationAvailableListener {
    void onBirdLocationAvailable(List<BirdLocationItem> birds);
}
