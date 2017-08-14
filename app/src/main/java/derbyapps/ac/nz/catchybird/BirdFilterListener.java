package derbyapps.ac.nz.catchybird;

import java.util.List;

/**
 * Created by eugene on 14/08/2017.
 */

public interface BirdFilterListener {
    void onBirdFilter(List<BirdLocationItem> birds);
}
