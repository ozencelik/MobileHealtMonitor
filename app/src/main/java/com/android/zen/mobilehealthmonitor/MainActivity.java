package com.android.zen.mobilehealthmonitor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final int SECONDS = 1000;

    private FloatingActionButton showStatus;

    CountDownTimer timer;
    TextView time;

    PhysicalActivity jogging;
    PhysicalActivity cycling;
    PhysicalActivity football;

    NonPhysicalActivity studying;
    NonPhysicalActivity cinema;
    NonPhysicalActivity music;

    RegularActivity eating;
    RegularActivity sleeping;

    BodyParts brain;
    BodyParts eyes;
    BodyParts arms;
    BodyParts heart;
    BodyParts legs;

    ImageView brainView;
    ImageView leftEye;
    ImageView rightEye;
    ImageView heartView;
    ImageView leftArm;
    ImageView rightArm;
    ImageView legsView;

    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //////////////////////////////////////////////////
        time = (TextView)findViewById(R.id.textView3);

        jogging = new PhysicalActivity("Jogging",20);
        cycling = new PhysicalActivity("Cycling",40);
        football = new PhysicalActivity("Football",10);

        studying = new NonPhysicalActivity("Studying",50);
        cinema = new NonPhysicalActivity("Cinema",10);
        music = new NonPhysicalActivity("Music",5);

        eating = new RegularActivity("Eating",50);
        sleeping = new RegularActivity("Sleeping",80);


        brain = new BodyParts("Brain",300);
        eyes = new BodyParts("Eyes",500);
        arms = new BodyParts("Arms",100);
        heart = new BodyParts("Hearts",1000);
        legs = new BodyParts("Legs",400);

        brainView = (ImageView)findViewById(R.id.headImage);
        leftEye = (ImageView)findViewById(R.id.imageView4);
        rightEye = (ImageView)findViewById(R.id.imageView5);
        heartView = (ImageView)findViewById(R.id.heartImage);
        leftArm = (ImageView)findViewById(R.id.imageView7);
        rightArm = (ImageView)findViewById(R.id.imageView8);
        legsView = (ImageView)findViewById(R.id.imageView6);
        ////////////////////////////////////////////////
        start();//Timer is being started.


        heartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Heart Health Level : "+heart.getLocalHealth(), Toast.LENGTH_SHORT).show();
            }
        });
        brainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Brain Health Level : "+brain.getLocalHealth(), Toast.LENGTH_SHORT).show();
            }
        });
        leftEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Eye Health Level : "+eyes.getLocalHealth(), Toast.LENGTH_SHORT).show();
            }
        });
        rightEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Eye Health Level : "+eyes.getLocalHealth(), Toast.LENGTH_SHORT).show();
            }
        });
        leftArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Arm Health Level : "+arms.getLocalHealth(), Toast.LENGTH_SHORT).show();
            }
        });
        rightArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Arm Health Level : "+arms.getLocalHealth(), Toast.LENGTH_SHORT).show();
            }
        });
        legsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Legs Health Level : "+legs.getLocalHealth(), Toast.LENGTH_SHORT).show();
            }
        });


        showStatus = (FloatingActionButton) findViewById(R.id.fab);
        showStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();*/


            //showMaterialDialog();

            Toast.makeText(MainActivity.this,"Heart Health Level : "+heart.getLocalHealth()+"\n"+
                    "Brain Health Level : "+brain.getLocalHealth()+"\n"+
                    "Eye Health Level : "+eyes.getLocalHealth()+"\n"+
                    "Arm Health Level : "+arms.getLocalHealth()+"\n"+
                    "Legs Health Level : "+legs.getLocalHealth(),Toast.LENGTH_SHORT).show();

            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
    }

    private void showMaterialDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme);
        builder.setTitle(getString(R.string.dialog_title));
        builder.setMessage(getString(R.string.dialog_message));
        builder.setCancelable(false);


        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        //cancel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_settings) {
            return true;
        }
        */

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.jog) {
            if(jogging.isActive()){
                Toast.makeText(MainActivity.this,"Jogging Activity is being stopped...",Toast.LENGTH_SHORT).show();
                //Stop Timer
                jogging.setActive(false);
            }
            else{
                Toast.makeText(MainActivity.this,"Jogging Activity is being activated...",Toast.LENGTH_SHORT).show();
                //Start Timer
                jogging.setActive(true);
            }

        } else if (id == R.id.bic) {
            if(cycling.isActive()){
                Toast.makeText(MainActivity.this,"Cycling is already active!!!Activity is being stopped...",Toast.LENGTH_SHORT).show();
                cycling.setActive(false);
             }
            else{
                Toast.makeText(MainActivity.this,"Cycling Activity is being activated...",Toast.LENGTH_SHORT).show();
                cycling.setActive(true);

            }

        } else if (id == R.id.soc) {
            if(football.isActive()){
                Toast.makeText(MainActivity.this,"Football Activity is being stopped...",Toast.LENGTH_SHORT).show();
                football.setActive(false);
            }
            else{
                Toast.makeText(MainActivity.this,"Football Activity is being activated...",Toast.LENGTH_SHORT).show();
                football.setActive(true);

            }

        } else if (id == R.id.study) {
            if(studying.isActive()){
                Toast.makeText(MainActivity.this,"Studying Activity is being stopped...",Toast.LENGTH_SHORT).show();
                studying.setActive(false);
            }
            else{
                Toast.makeText(MainActivity.this,"Studying Activity is being activated...",Toast.LENGTH_SHORT).show();
                studying.setActive(true);

            }

        } else if (id == R.id.film) {
            if(cinema.isActive()){
                Toast.makeText(MainActivity.this,"Cinema Activity is being stopped...",Toast.LENGTH_SHORT).show();
                cinema.setActive(false);
            }
            else{
                Toast.makeText(MainActivity.this,"Cinema Activity is being activated...",Toast.LENGTH_SHORT).show();
                cinema.setActive(true);
            }

        } else if (id == R.id.music) {
            if(music.isActive()){
                Toast.makeText(MainActivity.this,"Music Activity is being stopped...",Toast.LENGTH_SHORT).show();
                music.setActive(false);
            }
            else{
                Toast.makeText(MainActivity.this,"Music Activity is being activated...",Toast.LENGTH_SHORT).show();
                music.setActive(true);

            }

        } else if (id == R.id.eat) {
            if(eating.isActive()){
                Toast.makeText(MainActivity.this,"Eating Activity is being stopped...",Toast.LENGTH_SHORT).show();
                eating.setActive(false);
            }
            else{
                Toast.makeText(MainActivity.this,"Eating Activity is being activated...",Toast.LENGTH_SHORT).show();
                eating.setActive(true);

            }

        } else if (id == R.id.sleep) {
            if(sleeping.isActive()){
                Toast.makeText(MainActivity.this,"Sleeping Activity is being stopped...",Toast.LENGTH_SHORT).show();
                sleeping.setActive(false);
            }
            else{
                Toast.makeText(MainActivity.this,"Sleeping Activity is being activated...",Toast.LENGTH_SHORT).show();
               sleeping.setActive(true);
            }

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void start(){
        timer = new CountDownTimer(SECONDS * 1000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {

                time.setText(""+millisUntilFinished/1000);

                if(jogging.isActive()){
                    decreaseHeartLevel(jogging);
                    decreaseArmsLevel(jogging);
                    decreaseLegsLevel(jogging);
                }
                if(cycling.isActive()){
                    decreaseHeartLevel(cycling);
                    decreaseArmsLevel(cycling);
                    decreaseLegsLevel(cycling);
                }
                if(football.isActive()){
                    decreaseHeartLevel(football);
                    decreaseArmsLevel(football);
                    decreaseLegsLevel(football);
                }
                ////////////////////////////////////////////
                if(studying.isActive()){
                    decreaseBrainLevel(studying);
                    decreaseEyesLevel(studying);
                }
                if(cinema.isActive()){
                    decreaseBrainLevel(cinema);
                    decreaseEyesLevel(studying);
                }
                if(music.isActive()){
                    decreaseBrainLevel(music);
                    decreaseEyesLevel(studying);
                }
                ////////////////////////////////////////////
                if(eating.isActive()){
                    increaseArmsLevel(eating);
                    increaseBrainLevel(eating);
                    increaseEyesLevel(eating);
                    increaseHeartLevel(eating);
                    increaseLegsLEvel(eating);
                }
                if(sleeping.isActive()){
                    increaseArmsLevel(sleeping);
                    increaseBrainLevel(sleeping);
                    increaseEyesLevel(sleeping);
                    increaseHeartLevel(sleeping);
                    increaseLegsLEvel(sleeping);
                }
                setHeartViewBackground();
                setArmsViewBackground();
                setBrainViewBackground();
                setEyesViewBackground();
                setLegsViewBackground();

            }
            @Override
            public void onFinish() {
                time.setText("Done !");
            }
        }.start();
    }


    public void cancel(){
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }

    public void decreaseHeartLevel(PhysicalActivity activity){
        if((heart.getLocalHealth()-activity.getDecreaseSeconds())<0)
            heart.setLocalHealth(0);
        else {
            heart.setLocalHealth(heart.getLocalHealth()-activity.getDecreaseSeconds());
        }//Heart Part
    }
    public void increaseHeartLevel(RegularActivity activity){
        if((heart.getLocalHealth()+activity.getIncreaseSeconds())>heart.getTotalHealth())
            heart.setLocalHealth(heart.getTotalHealth());
        else {
            heart.setLocalHealth(heart.getLocalHealth()+activity.getIncreaseSeconds());
        }//Heart Part
    }
    public void setHeartViewBackground(){
        status = heart.getStatus();
        if(status == 0)
            heartView.setBackgroundResource(R.drawable.bheart);
        else if(status == 1)
            heartView.setBackgroundResource(R.drawable.rheart);
        else if(status == 2)
            heartView.setBackgroundResource(R.drawable.oheart);
        else if(status == 3)
            heartView.setBackgroundResource(R.drawable.yheart);
        else if(status == 4)
            heartView.setBackgroundResource(R.drawable.gheart);
    }


    public void decreaseArmsLevel(PhysicalActivity activity){
        if((arms.getLocalHealth()-activity.getDecreaseSeconds())<0)
            arms.setLocalHealth(0);
        else{
            arms.setLocalHealth(arms.getLocalHealth()-activity.getDecreaseSeconds());

        }//Arm Part
    }
    public void increaseArmsLevel(RegularActivity activity){
        if((arms.getLocalHealth()+activity.getIncreaseSeconds())>arms.getTotalHealth())
            arms.setLocalHealth(arms.getTotalHealth());
        else {
            arms.setLocalHealth(arms.getLocalHealth()+activity.getIncreaseSeconds());
        }
    }
    public void setArmsViewBackground(){
        status = arms.getStatus();

        if(status == 0){
            leftArm.setImageResource(R.drawable.brarm);
            rightArm.setImageResource(R.drawable.blarm);
        }
        else if(status == 1){
            leftArm.setImageResource(R.drawable.rrarm);
            rightArm.setImageResource(R.drawable.rlarm);
        }
        else if(status == 2){
            leftArm.setImageResource(R.drawable.orarm);
            rightArm.setImageResource(R.drawable.olarm);
        }
        else if(status == 3){
            leftArm.setImageResource(R.drawable.yrarm);
            rightArm.setImageResource(R.drawable.ylarm);
        }
        else if(status == 4){
            leftArm.setImageResource(R.drawable.grarm);
            rightArm.setImageResource(R.drawable.glarm);
        }
    }

    public void decreaseLegsLevel(PhysicalActivity activity){
        if((legs.getLocalHealth()-activity.getDecreaseSeconds())<0)
            legs.setLocalHealth(0);
        else{
            legs.setLocalHealth(legs.getLocalHealth()-activity.getDecreaseSeconds());
        }//Leg Part
    }
    public void increaseLegsLEvel(RegularActivity activity){
        if((legs.getLocalHealth()+activity.getIncreaseSeconds())>legs.getTotalHealth())
            legs.setLocalHealth(legs.getTotalHealth());
        else {
            legs.setLocalHealth(legs.getLocalHealth()+activity.getIncreaseSeconds());
        }
    }
    public void setLegsViewBackground(){
        status = legs.getStatus();

        if(status == 0)
            legsView.setImageResource(R.drawable.bordoleg);
        else if(status == 1)
            legsView.setImageResource(R.drawable.redleg);
        else if(status == 2)
            legsView.setImageResource(R.drawable.orangeleg);
        else if(status == 3)
            legsView.setImageResource(R.drawable.yellowleg);
        else if(status == 4)
            legsView.setImageResource(R.drawable.greenleg);
    }


    public void decreaseBrainLevel(NonPhysicalActivity activity){
        if((brain.getLocalHealth()-activity.getDecreaseSeconds())<0)
            brain.setLocalHealth(0);
        else{
            brain.setLocalHealth(brain.getLocalHealth()-activity.getDecreaseSeconds());
        }//Brain Part
    }
    public void increaseBrainLevel(RegularActivity activity){
        if((brain.getLocalHealth()+activity.getIncreaseSeconds())>brain.getTotalHealth())
            brain.setLocalHealth(brain.getTotalHealth());
        else {
            brain.setLocalHealth(brain.getLocalHealth()+activity.getIncreaseSeconds());
        }
    }
    public void setBrainViewBackground(){

        status = brain.getStatus();

        if(status == 0)
            brainView.setBackgroundResource(R.drawable.bhead);
        else if(status == 1)
            brainView.setBackgroundResource(R.drawable.rhead);
        else if(status == 2)
            brainView.setBackgroundResource(R.drawable.ohead);
        else if(status == 3)
            brainView.setBackgroundResource(R.drawable.yhead);
        else if(status == 4)
            brainView.setBackgroundResource(R.drawable.ghead);
    }


    public void decreaseEyesLevel(NonPhysicalActivity activity){
        if((eyes.getLocalHealth()-activity.getDecreaseSeconds())<0)
            eyes.setLocalHealth(0);
        else{
            eyes.setLocalHealth(eyes.getLocalHealth()-activity.getDecreaseSeconds());
        }//Eyes Part
    }
    public void increaseEyesLevel(RegularActivity activity){
        if((eyes.getLocalHealth()+activity.getIncreaseSeconds())>eyes.getTotalHealth())
            eyes.setLocalHealth(eyes.getTotalHealth());
        else {
            eyes.setLocalHealth(eyes.getLocalHealth()+activity.getIncreaseSeconds());
        }
    }
    public void setEyesViewBackground(){

        status = eyes.getStatus();

        if(status == 0){
            leftEye.setBackgroundResource(R.drawable.bordoeye1);
            rightEye.setBackgroundResource(R.drawable.bordoeye);
        }
        else if(status == 1){
            leftEye.setBackgroundResource(R.drawable.redeye1);
            rightEye.setBackgroundResource(R.drawable.redeye);
        }
        else if(status == 2){
            leftEye.setBackgroundResource(R.drawable.orangeeye1);
            rightEye.setBackgroundResource(R.drawable.orangeeye);
        }
        else if(status == 3){
            leftEye.setBackgroundResource(R.drawable.yelloweye1);
            rightEye.setBackgroundResource(R.drawable.yelloweye);
        }
        else if(status == 4){
            leftEye.setBackgroundResource(R.drawable.greeneye1);
            rightEye.setBackgroundResource(R.drawable.greeneye);
        }
    }
}


