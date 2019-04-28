package com.example.emrebabayigit.pickoapp.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.emrebabayigit.pickoapp.R;

import java.io.InputStream;


public class ImageSlider extends Fragment {

    String imageUrl;
    String baseUrl;
    String url;
    ImageView imageView;

    public ImageSlider(){ }

    @SuppressLint("ValidFragment")
    public ImageSlider(String url){
        imageUrl = url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_image_slider, container, false);
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        url = baseUrl+"api/vehicle/getimage?url="+imageUrl;
        //imageView = rootView.findViewById(R.id.vehicleImageView);
        url = baseUrl+"api/offertofreight/myoffers?vehiclePlateNumber=66LA442";
        new DownloadImageTask((ImageView) rootView.findViewById(R.id.vehicleImageView))
                .execute(url);

        return rootView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
