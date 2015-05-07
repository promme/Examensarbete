package se.nackademin.examensarbete.handlers;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import timber.log.Timber;

/**
 * Created by olofberg on 15-04-29.
 */
public class SaveLoadHandler {
    private static String fileName = "savefile.json";
    private static Gson gson = new Gson();

    public static void SaveResourceHandler(Context context, ResourceHandler resourceHandler) {
        String json = gson.toJson(ResourceHandler.getInstance());
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(json.getBytes());
            outputStream.close();
            Timber.d("Saved file successfully");
        } catch (IOException e) {
            e.printStackTrace();
            Timber.d("Could not save file");
        }
    }

    public static ResourceHandler LoadResourcehandler(Context context) {
        FileInputStream inputStream;
        InputStreamReader isr;
        try {
            FileInputStream fis = context.openFileInput(fileName);
            isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Timber.d("Read file successfully!");
            return gson.fromJson(sb.toString(), ResourceHandler.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Timber.d("Could not read file");
        return null;
    }
}