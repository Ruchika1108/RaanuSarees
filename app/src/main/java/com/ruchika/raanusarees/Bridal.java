package com.ruchika.raanusarees;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Bridal extends AppCompatActivity {
    GridView androidGridView;
    Integer[] imageIDs = {R.drawable.gha1bri, R.drawable.ghabri2, R.drawable.ghabri3, R.drawable.ghabri4, R.drawable.ghabri5, R.drawable.ghabri6, R.drawable.ghabri7, R.drawable.saa9 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridal);
        androidGridView = (GridView) findViewById(R.id.gridview_bridal);
        androidGridView.setAdapter(new Bridal.ImageAdapterGridView(this));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()  {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent i = new Intent(Bridal.this, description_bridal.class);
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
