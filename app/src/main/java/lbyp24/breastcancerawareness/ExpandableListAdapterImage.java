package lbyp24.breastcancerawareness;

/**
 * Created by cobalt on 8/27/14.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;




import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapterImage extends BaseExpandableListAdapter implements Database {

    private Context _context;
    private Structlist<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, Structlist<String>> _listDataChild;
    private TextView lblListHeader;
    private int _score[];
    private int _numberOfQuestions;
    private boolean isShowAnswer = false;


    public ExpandableListAdapterImage(Context context, Structlist<String> listDataHeader,
                                 HashMap<String, Structlist<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;

    }


    public ExpandableListAdapterImage(Context context, Structlist<String> listDataHeader,
                                 HashMap<String, Structlist<String>> listChildData, int score[], int numberOfQuestions) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this._numberOfQuestions = numberOfQuestions;

        _score = new int[numberOfQuestions];

        for (int i = 0; i < numberOfQuestions; i++) {
            this._score[i] = score[i];
        }

        isShowAnswer = true;
    }


    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.getitem(groupPosition))
                .getitem(childPosition+1);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition+1, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.exp_layout, null);
        }
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
        ImageView profile = (ImageView) convertView.findViewById(R.id.professor);
        int REsid = _context.getResources().getIdentifier(_listDataHeader.getitem(groupPosition+1).replaceAll("\\s+","").toLowerCase(), "drawable", _context.getPackageName());
//        int REsid = _context.getResources().getIdentifier("mammogram", "drawable", _context.getPackageName());
        profile.setImageResource(REsid);
        txtListChild.setText(Html.fromHtml(childText).toString());

        txtListChild.setGravity(Gravity.CENTER);
        return convertView;
    }




    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.getitem(groupPosition+1))
                .listsize();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.getitem(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.listsize();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition+1;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition+1);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);

       if (isExpanded) {
         lblListHeader.setBackgroundResource(R.drawable.exp_design1);lblListHeader.setTextColor(Color.WHITE);
       }
       else {
           lblListHeader.setBackgroundResource(R.drawable.exp_design2);
           lblListHeader.setTextColor(Color.parseColor("#88FF55A6"));
       }

//
//        if (isShowAnswer) {
//            if (_score[groupPosition] != 1) {
//                lblListHeader.setBackgroundColor(Color.RED);
//            } else {
//                lblListHeader.setBackgroundColor(Color.parseColor("#006400"));
//            }
//        } else {
//            lblListHeader.setBackgroundColor(Color.DKGRAY);
//        }

      //  lblListHeader.setTypeface(null, Typeface.BOLD);
    lblListHeader.setText(Html.fromHtml(headerTitle).toString());
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}


