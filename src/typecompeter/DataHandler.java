/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typecompeter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;

/**
 *
 * @author dylanmoss
 */
public class DataHandler {
    
    //extensions for data whose names are generated automatically
   
    
    public static ArrayList<Text> getSavedTexts() {
        return null;
        //iterate through "texts" folder and return all
    }
    
    public static ArrayList<Profile> getSavedProfiles() {
        return null;
        //iterate through "profiles" folder and return all
    }
    
    
    public static String parseText(File f) {
        try {
            String ret = "";
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                ret+=s.next();
            }
            return ret;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void saveObject(Object o) {
        try {
            if (o instanceof Profile) {
                Profile toSave = (Profile)o;
                FileOutputStream saveFile = new FileOutputStream(new File("./Profiles/"+toSave.getKey()+".tcpf"));
                ObjectOutputStream save = new ObjectOutputStream(saveFile);
                save.writeObject(toSave);
                save.close();
            }
            if (o instanceof Text) {
                Text toSave = (Text)o;
                FileOutputStream saveFile = new FileOutputStream(new File("./Texts/"+toSave.getName()+".tctxt"));
                ObjectOutputStream save = new ObjectOutputStream(saveFile);
                save.writeObject(toSave);
                save.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
