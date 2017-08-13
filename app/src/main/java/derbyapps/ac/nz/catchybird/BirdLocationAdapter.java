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

/**
 * Created by eugene on 13/08/2017.
 */

public class BirdLocationAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mInflater;
    ArrayList<BirdLocationItem> mObjects;

    public BirdLocationAdapter(Context context, ArrayList<BirdLocationItem> birds) {
        mContext = context;
        mObjects = birds;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.row_bird_location, parent, false);
        }

        BirdLocationItem p = getBirdLocationItem(position);

        ((TextView) view.findViewById(R.id.tvRowBird)).setText(p.getBird());
        ((TextView) view.findViewById(R.id.tvRowPrice)).setText(100 + "");
        ((ImageView) view.findViewById(R.id.ivRowBird)).setImageResource(R.mipmap.ic_launcher);

        CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbRowBird);
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);
        return view;
    }

    BirdLocationItem getBirdLocationItem(int position) {
        return ((BirdLocationItem) getItem(position));
    }

    ArrayList<BirdLocationItem> getBox() {
        ArrayList<BirdLocationItem> box = new ArrayList<BirdLocationItem>();
        for (BirdLocationItem p : mObjects) {
            if (p.box)
                box.add(p);
        }
        return box;
    }

    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            getBirdLocationItem((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}
