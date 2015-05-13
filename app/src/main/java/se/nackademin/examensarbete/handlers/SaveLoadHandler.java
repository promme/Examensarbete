package se.nackademin.examensarbete.handlers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import se.nackademin.examensarbete.SaveFile;
import timber.log.Timber;

public class SaveLoadHandler {
    private static String fileName = "savefile.json";
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static void SaveResourceHandler(Context context) {
        String json = gson.toJson(new SaveFile());
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
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            Timber.d("Read file successfully!");
            SaveFile s = gson.fromJson(sb.toString(), SaveFile.class);
            BuildingHandler.setInstance(s.getBuildingHandler());
            ResourceHandler.setInstance(s.getResourceHandler());
            StatisticHandler.setInstance(s.getStatisticHandler());
            BuildingHandler.getInstance().updateBuildingHandler();
        } catch (IOException e) {
            e.printStackTrace();
            Timber.e(e.toString());
        }

        Timber.d("Could not read file");
    }
}