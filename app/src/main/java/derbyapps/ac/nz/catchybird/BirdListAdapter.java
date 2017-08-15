package derbyapps.ac.nz.catchybird;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 13/08/2017.
 */

public class BirdListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<BirdListItem> mBirds;
    private List<BirdFilterListener> filterListeners = new ArrayList<BirdFilterListener> ();

    public BirdListAdapter(Context context, ArrayList<BirdListItem> birds) {
        mContext = context;
        mBirds = birds;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setOnBirdFilterListener (BirdFilterListener listener)
    {
        // Store the listener object
        this.filterListeners.add(listener);
    }

    @Override
    public int getCount() {
        return mBirds.size();
    }

    @Override
    public Object getItem(int position) {
        return mBirds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.row_bird_list, parent, false);
        }

        BirdListItem p = getBirdListItem(position);

        ((TextView) view.findViewById(R.id.tvRowBird)).setText(p.getBird());
        ((TextView) view.findViewById(R.id.tvRowCount)).setText(p.getCount() + "");
        ((ImageView) view.findViewById(R.id.ivRowBird)).setImageResource(p.getImg());

        CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbRowBird);
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.isBox());
        return view;
    }

    BirdListItem getBirdListItem(int position) {
        return ((BirdListItem) getItem(position));
    }

    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            getBirdListItem((Integer) buttonView.getTag()).setBox(isChecked);

            for (BirdFilterListener listener : filterListeners) {
                listener.onBirdFilter(mBirds);
            }
        }
    };
}
