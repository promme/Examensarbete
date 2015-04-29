package se.nackademin.examensarbete.handlers;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import timber.log.Timber;

/**
 * Created by olofberg on 15-04-29.
 */
public class SaveLoadHandler {
    private static String fileName = "savefile.txt";
    public static void SaveResourceHandler(Context context, ResourceHandler resourceHandler){
        try {
        FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(resourceHandler);
            outputStream.close();
            Timber.d("Saved to file successfully.");
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Timber.e("Could not save to file!");
        }
    }

    public static ResourceHandler LoadResourcehandler(Context context){
        try {
        FileInputStream fis = context.openFileInput(fileName);
        ObjectInputStream is = new ObjectInputStream(fis);
        ResourceHandler resourceHandler = (ResourceHandler) is.readObject();
        is.close();
        fis.close();
        Timber.d("Loaded file successfully.");
        return resourceHandler;
        } catch (IOException e) {
            e.printStackTrace();
            Timber.d("Could not read file");
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Timber.d("Class not found");
            return null;
        }

    }

}
