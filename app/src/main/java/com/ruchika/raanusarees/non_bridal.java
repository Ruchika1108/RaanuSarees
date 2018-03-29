package com.ruchika.raanusarees;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import static com.ruchika.raanusarees.description.iv;
//import com.bumptech.glide.Glide;

public class non_bridal extends AppCompatActivity {
ImageView imageView;
GridView androidGridView;

Integer[] imageIDs = {R.drawable.gha1, R.drawable.gha2, R.drawable.gha3, R.drawable.gha4, R.drawable.gha5, R.drawable.gha6, R.drawable.gha7, R.drawable.saa9 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_bridal);
       /* imageView =(ImageView)findViewById(R.id.image);
        String url = "https://firebasestorage.googleapis.com/v0/b/raanusarees.appspot.com/o/sarees%20images%2Fsaa8.jpg?alt=media&token=3ba00f9b-ceb2-4551-95f5-3a1134282aa7";
        Glide.with(getApplicationContext()).load(url).into(imageView); */

        androidGridView = (GridView) findViewById(R.id.gridview_android_example);
        androidGridView.setAdapter(new ImageAdapterGridView(this));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()  {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                    Intent i = new Intent(non_bridal.this, description.class);
                    i.putExtra("pos",position);
                //  Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
                startActivity(i);



            }
        });
    }
        public class ImageAdapterGridView extends BaseAdapter {
            private Context mContext;

            public ImageAdapterGridView(Context c) {
                mContext = c;
            }

            public int getCount() {
                return imageIDs.length;
            }

            public Object getItem(int position) {
                return null;
            }

            public long getItemId(int position) {
                return 0;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView mImageView;

                if (convertView == null) {
                    mImageView = new ImageView(mContext);
                    mImageView.setLayoutParams(new GridView.LayoutParams(350, 350));
                    mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    mImageView.setPadding(16, 16, 16, 16);
                } else {
                    mImageView = (ImageView) convertView;
                }
                mImageView.setImageResource(imageIDs[position]);
                return mImageView;
            }
        }
    }


