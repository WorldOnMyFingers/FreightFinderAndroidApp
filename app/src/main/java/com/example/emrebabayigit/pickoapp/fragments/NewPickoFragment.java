package com.example.emrebabayigit.pickoapp.fragments;


import android.app.Activity;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.models.Dimensions;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewPickoFragment extends Fragment {

    EditText editText;
    Button submitButton;
    ImageView image1, image2, image3, image4;
    int SELECT_FILE = 100;
    int REQUEST_CAMERA = 50;
    final int image_1 = 0;
    final int image_2 = 1;
    final int image_3 = 2;
    final int image_4 = 3;
    int clickedImage = -1;
    int width;
    int height;


    ImageView[] imageViews = new ImageView[4];



    public NewPickoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =  inflater.inflate(R.layout.fragment_new_picko, container, false);

        editText = (EditText) view.findViewById(R.id.descriptionText);
        SharedPreferences settings = this.getActivity().getSharedPreferences("PREFS", 0);
        editText.setText(settings.getString("value", ""));
        submitButton = (Button) view.findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        image1 = (ImageView) view.findViewById(R.id.image1);
        image2 = (ImageView) view.findViewById(R.id.image2);
        image3 = (ImageView) view.findViewById(R.id.image3);
        image4 = (ImageView) view.findViewById(R.id.image4);

        SetUi();

        fillImageViewArray();


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedImage = image_1;
                selectImage();

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedImage = image_2;
                selectImage();

            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedImage = image_3;
                selectImage();

            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedImage = image_4;
                selectImage();

            }
        });

        return view;
    }

    public void fillImageViewArray()
    {
        imageViews[0] = image1;
        imageViews[1] = image2;
        imageViews[2] = image3;
        imageViews[3] = image4;
    }

    public void SetUi()
    {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
         width = size.x;
         height = size.y;

        Dimensions editTextDimensions = new Dimensions();
        editTextDimensions.setHeight((height*13)/100);
        editTextDimensions.setRightMargin((width*1)/100);
        editTextDimensions.setLeftMargin((width*1)/100);
        editTextDimensions.setBottomMargin((height*1)/100);
        editTextDimensions.setTopMargin((height*1)/100);
        LinearLayout.LayoutParams editTextParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, editTextDimensions.getHeight());
        editTextParams.setMargins(editTextDimensions.getLeftMargin(), editTextDimensions.getTopMargin(),
                editTextDimensions.getRightMargin(), editTextDimensions.getBottomMargin());
        editText.setLayoutParams(editTextParams);

        SetImageUi(image_1);
        SetImageUi(image_2);
        SetImageUi(image_3);
        SetImageUi(image_4);

        Dimensions buttonDimensions = new Dimensions();
        buttonDimensions.setRightMargin((width*1)/100);
        buttonDimensions.setLeftMargin((width*1)/100);
        buttonDimensions.setBottomMargin((height*1)/100);
        buttonDimensions.setTopMargin((height*1)/100);
        buttonDimensions.setWidth((width*30)/100);
        buttonDimensions.setHeight((height*10)/100);

        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(buttonDimensions.getWidth(), buttonDimensions.getHeight());
        buttonParams.setMargins(buttonDimensions.getLeftMargin(), buttonDimensions.getTopMargin(),
                buttonDimensions.getRightMargin(), buttonDimensions.getBottomMargin());
        buttonParams.gravity = Gravity.CENTER_HORIZONTAL;

        submitButton.setLayoutParams(buttonParams);



    }

    private void SetImageUi(int imageNumber)
    {
        Dimensions imageDimensions = new Dimensions();
        imageDimensions.setRightMargin((width*1)/100);
        imageDimensions.setLeftMargin((width*1)/100);
        imageDimensions.setBottomMargin((height*1)/100);
        imageDimensions.setTopMargin((height*1)/100);
        imageDimensions.setWidth((width*45)/100);
        imageDimensions.setHeight((height*22)/100);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(imageDimensions.getWidth(), imageDimensions.getHeight());
        imageParams.setMargins(imageDimensions.getLeftMargin(), imageDimensions.getTopMargin(),
                imageDimensions.getRightMargin(), imageDimensions.getBottomMargin());
        switch (imageNumber)
        {
            case image_1:
                image1.setLayoutParams(imageParams);
                break;
            case image_2:
                image2.setLayoutParams(imageParams);
                break;
            case image_3:
                image3.setLayoutParams(imageParams);
                break;
            case image_4:
                image4.setLayoutParams(imageParams);
                break;
        }
    }



    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Remove Photo", "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Library")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    startActivityForResult(intent, SELECT_FILE);
                } else if (items[item].equals("Remove Photo")) {
                    RemovePhoto();
                    dialog.dismiss();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)

                setImages(onSelectFromGalleryResult(data));

//            else if (requestCode == REQUEST_CAMERA)
//                onCaptureImageResult(data);
        }

    }

    public void setImages(ArrayList<Bitmap> bitmaps) {
        switch (clickedImage)
        {
            case image_1:
                setImageViews(image_1, bitmaps);
                break;
            case image_2:
                setImageViews(image_2, bitmaps);
                break;
            case image_3:
                setImageViews(image_3, bitmaps);
                break;
            case image_4:
                setImageViews(image_4, bitmaps);
                break;
        }

    }

    public void setImageViews(int imageNumber, ArrayList<Bitmap> bitmaps) {

        int numberOfPhotos = bitmaps.size();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5, 5, 5, 5);

        for (int i = imageNumber; i<numberOfPhotos+imageNumber; i++ )
        {
            if(i<4)
            {
                imageViews[i].setLayoutParams(lp);
                imageViews[i].setImageBitmap(bitmaps.get(i-imageNumber));
            }


        }

    }

    private ArrayList<Bitmap> onSelectFromGalleryResult(Intent data) {

        ClipData clipdata = data.getClipData();
        ArrayList<Bitmap> bitmaps = new ArrayList<>();


        int imageWidth = (int) ((width*45)/100);
        int imageHeight = (int) ((height*23)/100);

        for (int i=0; i<clipdata.getItemCount();i++)
        {

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), clipdata.getItemAt(i).getUri());
                bitmap = Bitmap.createScaledBitmap(bitmap,imageWidth,imageHeight, false);
                bitmaps.add(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return bitmaps;

    }


    public void startTheGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, 2);

    }

    public void RemovePhoto()
    {
        switch (clickedImage)
        {
            case image_1:
                image1.setImageBitmap(null);
                SetImageUi(image_1);
                break;
            case image_2:
                image2.setImageBitmap(null);
                SetImageUi(image_2);
                break;
            case image_3:
                image3.setImageBitmap(null);
                SetImageUi(image_3);
                break;
            case image_4:
                image4.setImageBitmap(null);
                SetImageUi(image_4);
                break;
        }
    }


}
