package lbyp24.breastcancerawareness;



        import android.content.Intent;
        import android.content.res.AssetFileDescriptor;
        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import java.io.IOException;

public class WhatToHappen extends MainMenu {


    private ListView Options;
    private ArrayAdapter<String> adapter;
    private String Opt[]={"Diagnosis","Treatment"};
    private String Opt1[]={"Treatment Advances","Survivor Stories"};
    private int index, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();

        z=intent.getIntExtra("Position",0);
        switch(z){
            case 1:
                happen();break;
            case 2:
                expect();break;
        }


    }
    public void expect(){
        setContentView(R.layout.second_menu_layout);
        adapter = new ArrayAdapter<>(this, R.layout.second_menu_textdesign,Opt1);
        Options = (ListView) findViewById(R.id.listView);
        Options.setAdapter(adapter);
        Options.setOnItemClickListener(new
                                               AdapterView.OnItemClickListener() {
                                                   @Override
                                                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                       index = position;
//                                                          playSound("Music1.wav");

                                                       if(position==0){
                                                           Intent intent = new Intent(getBaseContext(), WhatToHappenX.class);
                                                           intent.putExtra("Position", (index+2));
                                                           startActivity(intent);
                                                       }
                                                       else{
                                                           Intent intent = new Intent(getBaseContext(), Survivor.class);
                                                           startActivity(intent);
                                                           }


                                                   }
                                               });
    }
    public void happen(){
        setContentView(R.layout.second_menu_layout);
        adapter = new ArrayAdapter<>(this, R.layout.second_menu_textdesign,Opt);
        Options = (ListView) findViewById(R.id.listView);
        Options.setAdapter(adapter);
        Options.setOnItemClickListener(new
                                               AdapterView.OnItemClickListener() {
                                                   @Override
                                                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                       index = position;
//                                                          playSound("Music1.wav");
                                                       Intent intent = new Intent(getBaseContext(), WhatToHappenX.class);
                                                       intent.putExtra("Position", index);
                                                       startActivity(intent);

                                                   }
                                               });
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




}