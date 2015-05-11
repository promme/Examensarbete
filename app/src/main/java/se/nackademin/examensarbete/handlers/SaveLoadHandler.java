package se.nackademin.examensarbete.handlers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

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

    public static void SaveResourceHandler(Context context) {
        String json = gson.toJson(ResourceHandler.getInstance()) + "&&&" + gson.toJson(BuildingHandler.getInstance());
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

    public static void LoadResourcehandler(Context context) {
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
            String [] json = sb.toString().split("&&&");
            BuildingHandler.setInstance(gson.fromJson(json[1], BuildingHandler.class));
            ResourceHandler.getInstance().updateResourceHandlerFromJson(new JSONObject(json[0]));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Timber.d("Could not read file");
    }
}