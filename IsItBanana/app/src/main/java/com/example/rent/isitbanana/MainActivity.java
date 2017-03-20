package com.example.rent.isitbanana;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.model.AnnotateImageRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;
import com.google.api.services.vision.v1.model.EntityAnnotation;
import com.google.api.services.vision.v1.model.Feature;
import com.google.api.services.vision.v1.model.Image;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;

    Bitmap bitmap;

    ProgressDialog progress;
    private static String accessToken;
    static final int REQUEST_GALLERY_IMAGE = 10;
    static final int REQUEST_CODE_PICK_ACCOUNT = 11;
    static final int REQUEST_ACCOUNT_AUTHORIZATION = 12;
    static final int REQUEST_PERMISSIONS = 13;
    static final int REQUEST_CAPTURE = 14;
    private final String LOG_TAG = "MainActivity";
    Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getColor(R.color.white));
        setSupportActionBar(toolbar);



        imageView = (ImageView) findViewById(R.id.main_imageView);
        imageView.setImageDrawable(getDrawable(R.drawable.bananaman));
        bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    progress = ProgressDialog.show(MainActivity.this,"","Hold on for a second",true);
                    Bitmap bitmapToSend = resizeBitmap(bitmap);
                    callCloudVision(bitmapToSend);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.GET_ACCOUNTS},
                REQUEST_PERMISSIONS);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        switch (id) {
            case R.id.action_gallery:
                launchImagePicker();
                break;
            case R.id.action_makePhoto:
                launchCamera();
                break;
            case R.id.action_downloadPhoto:
                onDownloadPictureOptionsItemSelected();



        }
        return super.onOptionsItemSelected(item);
    }

    private void onDownloadPictureOptionsItemSelected() {

        AlertDialog dialog=null;
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Download image");
        final EditText input = new EditText(this);
        input.setHint("Type your url here");
        ab.setView(input);
        ab.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                displayPictureFromUrl(input.getText().toString());

            }
        });

        ab.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        dialog=ab.create();
        dialog.show();
    }


    private void displayPictureFromUrl(String url){

        if(url.isEmpty()) return;

        Picasso.with(this)
                .load(url)
                .fit()
                .centerCrop()
                .into(imageView);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PERMISSIONS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getAuthToken();
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_GALLERY_IMAGE && resultCode == RESULT_OK && data != null) {

            updateBitmap(data.getData());

        } else if (requestCode == REQUEST_CODE_PICK_ACCOUNT) {
            if (resultCode == RESULT_OK) {

                String email = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                AccountManager am = AccountManager.get(this);

               try{
                   Account[] accounts = am.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
                   for (Account account : accounts) {
                       if (account.name.equals(email)) {
                           mAccount = account;
                           break;
                       }
                   }
               }
               catch (SecurityException se){
                   se.printStackTrace();
               }

                getAuthToken();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "No Account Selected", Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (requestCode == REQUEST_ACCOUNT_AUTHORIZATION) {
            if (resultCode == RESULT_OK) {
                Bundle extra = data.getExtras();
                onTokenReceived(extra.getString("authtoken"));
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Authorization Failed", Toast.LENGTH_SHORT)
                        .show();
            }
        }

        else if(requestCode==REQUEST_CAPTURE && resultCode==RESULT_OK){

            updateBitmap(data.getData());

        }
    }


    private void launchImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select an image"),
                REQUEST_GALLERY_IMAGE);
    }

    public void updateBitmap(Uri uri){

        bitmap=getBitmap(uri);
        imageView.setImageBitmap(bitmap);

    }

    public void launchCamera(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,REQUEST_CAPTURE);

    }

    private void getAuthToken() {
        String SCOPE = "oauth2:https://www.googleapis.com/auth/cloud-platform";
        if (mAccount == null) {
            pickUserAccount();
        } else {
            new GetTokenTask(MainActivity.this, mAccount, SCOPE, REQUEST_ACCOUNT_AUTHORIZATION)
                    .execute();
        }
    }

    private void pickUserAccount() {
        String[] accountTypes = new String[]{GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE};
        Intent intent = AccountPicker.newChooseAccountIntent(null, null,
                accountTypes, false, null, null, null, null);
        startActivityForResult(intent, REQUEST_CODE_PICK_ACCOUNT);
    }

    public void onTokenReceived(String token){
        accessToken = token;
        Log.d("OnTokenRecieved:", "token: "+token);
        Toast.makeText(this,"Token Recieved",Toast.LENGTH_SHORT).show();

    }

    private void onVisionApiResultFetched(String result){

        if(result.contains("banana")){
            result = "I think, that there is a banana on this picture. This is, what i see: \n"+result;
        }
        else{
            result = "I don't see any banana in this picture. This is, what i found: \n"+result;
        }

        progress.dismiss();
        Toast.makeText(getApplicationContext(),"Data retrieved",Toast.LENGTH_SHORT).show();
        Log.d("AsyncTask", "onPostExecute: "+result);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this,R.style.AppTheme);
        builder.setTitle("Results");
        builder.setMessage(result);
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Cancel", null);
        builder.show();


    }


    private void callCloudVision(final Bitmap bitmap) throws IOException {
        Toast.makeText(this,"Retrieving results from cloud..",Toast.LENGTH_SHORT);

        new AsyncTask<Object, Void, String>() {


            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected String doInBackground(Object... params) {
                try {
                    GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
                    HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();
                    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

                    Vision.Builder builder = new Vision.Builder
                            (httpTransport, jsonFactory, credential);
                    Vision vision = builder.build();

                    List<Feature> featureList = new ArrayList<>();
                    Feature labelDetection = new Feature();
                    labelDetection.setType("LABEL_DETECTION");
                    labelDetection.setMaxResults(10);
                    featureList.add(labelDetection);

//                    Feature textDetection = new Feature();
//                    textDetection.setType("TEXT_DETECTION");
//                    textDetection.setMaxResults(10);
//                    featureList.add(textDetection);
//
//                    Feature landmarkDetection = new Feature();
//                    landmarkDetection.setType("LANDMARK_DETECTION");
//                    landmarkDetection.setMaxResults(10);
//                    featureList.add(landmarkDetection);

                    List<AnnotateImageRequest> imageList = new ArrayList<>();
                    AnnotateImageRequest annotateImageRequest = new AnnotateImageRequest();
                    Image base64EncodedImage = getBase64EncodedJpeg(bitmap);
                    annotateImageRequest.setImage(base64EncodedImage);
                    annotateImageRequest.setFeatures(featureList);
                    imageList.add(annotateImageRequest);

                    BatchAnnotateImagesRequest batchAnnotateImagesRequest =
                            new BatchAnnotateImagesRequest();
                    batchAnnotateImagesRequest.setRequests(imageList);

                    Vision.Images.Annotate annotateRequest =
                            vision.images().annotate(batchAnnotateImagesRequest);
                    // Due to a bug: requests to Vision
                    // API containing large images fail when GZipped.
                    annotateRequest.setDisableGZipContent(true);
                    Log.d(LOG_TAG, "sending request");

                    BatchAnnotateImagesResponse response = annotateRequest.execute();
                    Log.d(LOG_TAG, "got response");

                    return convertResponseToString(response);

                } catch (GoogleJsonResponseException e) {
                    Log.e(LOG_TAG, "Request failed: " + e.getContent());
                } catch (IOException e) {
                    Log.d(LOG_TAG, "Request failed: " + e.getMessage());
                }
                return "Cloud Vision API request failed.";
            }

            protected void onPostExecute(String result) {

                onVisionApiResultFetched(result);

            }
        }.execute();
    }

    private String convertResponseToString(BatchAnnotateImagesResponse response) {
        StringBuilder message = new StringBuilder("\n");
        message.append("Labels:\n");
        List<EntityAnnotation> labels = response.getResponses().get(0).getLabelAnnotations();
        if (labels != null) {
            for (EntityAnnotation label : labels) {
                message.append(String.format(Locale.getDefault(), "%.3f: %s",
                        label.getScore(), label.getDescription()));
                message.append("\n");
            }
        } else {
            message.append("nothing\n");
        }

        message.append("Texts:\n");
        List<EntityAnnotation> texts = response.getResponses().get(0)
                .getTextAnnotations();
        if (texts != null) {
            for (EntityAnnotation text : texts) {
                message.append(String.format(Locale.getDefault(), "%s: %s",
                        text.getLocale(), text.getDescription()));
                message.append("\n");
            }
        } else {
            message.append("nothing\n");
        }

        message.append("Landmarks:\n");
        List<EntityAnnotation> landmarks = response.getResponses().get(0)
                .getLandmarkAnnotations();
        if (landmarks != null) {
            for (EntityAnnotation landmark : landmarks) {
                message.append(String.format(Locale.getDefault(), "%.3f: %s",
                        landmark.getScore(), landmark.getDescription()));
                message.append("\n");
            }
        } else {
            message.append("nothing\n");
        }

        return message.toString();
    }

    public Bitmap resizeBitmap(Bitmap bitmap) {

        int maxDimension = 1024;
        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        int resizedWidth = maxDimension;
        int resizedHeight = maxDimension;

        if (originalHeight > originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = (int) (resizedHeight * (float) originalWidth / (float) originalHeight);
        } else if (originalWidth > originalHeight) {
            resizedWidth = maxDimension;
            resizedHeight = (int) (resizedWidth * (float) originalHeight / (float) originalWidth);
        } else if (originalHeight == originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = maxDimension;
        }
        return Bitmap.createScaledBitmap(bitmap, resizedWidth, resizedHeight, false);
    }

    public Image getBase64EncodedJpeg(Bitmap bitmap) {
        Image image = new Image();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        image.encodeContent(imageBytes);
        return image;
    }


    public Bitmap getBitmap(Uri uri){

        Bitmap source = null;
        try {
            source = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return source;


    }

}
