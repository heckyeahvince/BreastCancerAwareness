package lbyp24.breastcancerawareness;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragThird);
        tv.setText(getArguments().getString("msg"));

        return v;
    }

    public static ThirdFragment newInstance(String text) {

        ThirdFragment f = new ThirdFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}

