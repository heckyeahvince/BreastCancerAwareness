package lbyp24.breastcancerawareness;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;

public class WhatToHappenX extends WhatToHappen implements Database {
    private Structlist<String> listDataHeader;


    private HashMap<String, Structlist<String>> listDataChild;
    private int x;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        x = intent.getIntExtra("Position",0);
        switch(x){
            case 0:
                Diagnosis();
                break;
            case 1:
                Treatment();break;
            case 2:
                Advances();break;
        }

    }

    private void Advances(){
        ExpandableListView Explistview;
        ExpandableListAdapterImage listadapter;
        setContentView(R.layout.whattohappen);
        prepareAdvances();
        listadapter = new ExpandableListAdapterImage(this, listDataHeader, listDataChild);
        Explistview = (ExpandableListView) findViewById(R.id.expandableListView);
        Explistview.setAdapter(listadapter);
        Explistview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

//                playSound("Music1.wav");
                return false;
            }
            // Toast.makeText(getApplicationContext(),
            // "Group Clicked " + listDataHeader.get(groupPosition),
            // Toast.LENGTH_SHORT).show();


        });
    }
      private void Diagnosis(){
          ExpandableListView Explistview;
          ExpandableListAdapterImage listadapter;
          setContentView(R.layout.whattohappen);
          prepareDiagnosis();
          listadapter = new ExpandableListAdapterImage(this, listDataHeader, listDataChild);
          Explistview = (ExpandableListView) findViewById(R.id.expandableListView);
          Explistview.setAdapter(listadapter);
          Explistview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

              @Override
              public boolean onGroupClick(ExpandableListView parent, View v,
                                          int groupPosition, long id) {

//                playSound("Music1.wav");
                  return false;
              }
              // Toast.makeText(getApplicationContext(),
              // "Group Clicked " + listDataHeader.get(groupPosition),
              // Toast.LENGTH_SHORT).show();


          });
      }
    private void Treatment(){
        ExpandableListView Explistview;
        ExpandableListAdapterImage listadapter;
        setContentView(R.layout.whattohappen);
        prepareTreatment();
        listadapter = new ExpandableListAdapterImage(this, listDataHeader, listDataChild);
        Explistview = (ExpandableListView) findViewById(R.id.expandableListView);
        Explistview.setAdapter(listadapter);
        Explistview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

//                playSound("Music1.wav");
                return false;
            }
            // Toast.makeText(getApplicationContext(),
            // "Group Clicked " + listDataHeader.get(groupPosition),
            // Toast.LENGTH_SHORT).show();


        });
    }
//    private void acquireFaculty() {
//
//        allFaculty.initializelist(cursor.getCount());
//
//
//
//        if (cursor.getCount() > 0) {
//
//
//            do {
//                Professor all = new Professor(); // create a new Question object
//                all.setName(cursor.getString(0));//same here for the question and the answers
//                all.setPosition(cursor.getString(1));
//
//                allFaculty.add(maxthesis + 1, all);//finally add the question to the list
//                maxthesis++;
//            } while (cursor.moveToNext()); //move to next question until you finish with all of them
//            cursor.close(); /// closing the cursor
//            db.close(); /// closing the database
//
//
//        }
//        else{
//            showToast("NO RESULTS FOUND!");
//        }
//    }

    private void prepareDiagnosis() {
        listDataHeader = new Structlist<>();
        listDataChild = new HashMap<>();
        Structlist[] q = new Structlist[19];
        listDataHeader.initializelist(19);



        for (int i = 0; i < 19; i++) {

            listDataHeader.add(i+1,Diagnosis[i]);
            q[i]= new Structlist<>();
            q[i].initializelist(2);
            q[i].add(1, DiagnosisDescription[i]);
            listDataChild.put(listDataHeader.getitem(i+1),q[i]); // Header, Child data


        }
    }

    private void prepareAdvances() {
        listDataHeader = new Structlist<>();
        listDataChild = new HashMap<>();
        Structlist[] q = new Structlist[2];
        listDataHeader.initializelist(2);



        for (int i = 0; i < 2; i++) {

            listDataHeader.add(i+1,AdvanceTreatment[i]);
            q[i]= new Structlist<>();
            q[i].initializelist(2);
            q[i].add(1, AdvanceTreatmentDescrption[i]);
            listDataChild.put(listDataHeader.getitem(i+1),q[i]); // Header, Child data


        }
    }
    private void prepareTreatment() {
        listDataHeader = new Structlist<>();
        listDataChild = new HashMap<>();
        Structlist[] q = new Structlist[6];
        listDataHeader.initializelist(6);



        for (int i = 0; i < 6; i++) {

            listDataHeader.add(i+1,Treatments[i]);
            q[i]= new Structlist<>();
            q[i].initializelist(2);
            q[i].add(1, TreatmentsDescription[i]);
            listDataChild.put(listDataHeader.getitem(i+1),q[i]); // Header, Child data


        }
    }
    public void playSound(String fileName) {
        final MediaPlayer mp = new MediaPlayer();

        if (mp.isPlaying()) {
            mp.stop();
            mp.reset();
        }
        try {

            AssetFileDescriptor afd;
            afd = getAssets().openFd(fileName);
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }




//      private void showToast(String message) {
//        LayoutInflater inflater = getLayoutInflater();
//        // Inflate the Layout
//        View layout = inflater.inflate(R.layout.my_toast,
//                (ViewGroup) findViewById(R.id.custom_toast_layout));
//
//        TextView text = (TextView) layout.findViewById(R.id.textToShow);
//
//
//
//        // Set the Text to show in TextView
//        text.setText(message);
//
//        final Toast toast = new Toast(getApplicationContext());
//        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setView(layout);
//        toast.show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
