 package com.example.suraksha;

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.os.Handler;
 import android.view.MenuItem;
 import android.view.animation.Animation;
 import android.view.animation.AnimationUtils;
 import android.widget.ImageView;

 import androidx.appcompat.app.ActionBarDrawerToggle;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.Toolbar;
 import androidx.drawerlayout.widget.DrawerLayout;

 import com.google.android.material.navigation.NavigationView;

 import java.util.Timer;
 import java.util.TimerTask;

 public class NavigationComplaint extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    //FragmentManager mFragmentManager;
    //FragmentTransaction mFragmentTransaction;


     public int currentimageindex=0;
     //    Timer timer;
//    TimerTask task;
     ImageView slidingimage;

     private int[] IMAGE_IDS = {
             R.drawable.domesticviolence1, R.drawable.corruption1, R.drawable.theft1,
             R.drawable.threat1, R.drawable.eveteasing1
     };


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_complaint);



         final Handler mHandler = new Handler();

         // Create runnable for posting
         final Runnable mUpdateResults = new Runnable() {
             public void run() {

                 AnimateandSlideShow();

             }
         };

         int delay = 1000; // delay for 1 sec.

         int period = 5000; // repeat every 4 sec.

         Timer timer = new Timer();

         timer.scheduleAtFixedRate(new TimerTask() {

             public void run() {

                 mHandler.post(mUpdateResults);

             }

         }, delay, period);



         /**
          *Setup the DrawerLayout and NavigationView
          */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

//       mFragmentManager = getSupportFragmentManager();
//       mFragmentTransaction = mFragmentManager.beginTransaction();
//        mFragmentTransaction.replace(R.id.content_frame,new TabFragment()).commit();
//        /**
//         * Setup click events on the Navigation View Items.
//         */

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();



                if (menuItem.getItemId() == R.id.Home) {
                    Intent intent=new Intent(NavigationComplaint.this,MainActivity.class);
                    startActivity(intent);
                }

                if (menuItem.getItemId() == R.id.mail) {
//                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
//                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
//
                    Intent intent=null, chooser=null;
                    intent=new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("mailto:"));
                    String[] to={"ishumehta99@gmail.com"};
                    intent.putExtra(Intent.EXTRA_EMAIL,to);
                    intent.setType("message/rfc822");
                    chooser=Intent.createChooser(intent,"Send Email");
                    startActivity(chooser);

                }

                if (menuItem.getItemId()== R.id.complaints){

                    Intent i=new Intent(NavigationComplaint.this,TabBars.class);
                    startActivity(i);

                }
                if (menuItem.getItemId()== R.id.Help){

                    Intent i=new Intent(NavigationComplaint.this,Help.class);
                    startActivity(i);

                }
                if (menuItem.getItemId()== R.id.AboutUs){

                    Intent i=new Intent(NavigationComplaint.this,AboutUs.class);
                    startActivity(i);

                }


                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }



     /**
      * Helper method to start the animation on the splash screen
      */
     private void AnimateandSlideShow() {


         slidingimage = (ImageView)findViewById(R.id.ImageView3_Left);
         slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);

         currentimageindex++;

         Animation rotateimage = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);


         slidingimage.startAnimation(rotateimage);



     }



 }