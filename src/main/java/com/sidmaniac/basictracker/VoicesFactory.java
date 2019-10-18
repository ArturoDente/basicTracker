/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidmaniac.basictracker;

import Presets.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class VoicesFactory {

    
    /*public static Vector getAllPresets() throws ClassNotFoundException{
        List<Class> presets = Support.ClassFinder.getClassesFromPackage("Presets");
        Vector ret=new  Vector();
        
        for (Class c : presets) {
            String classname = c.getCanonicalName();
            
                try {
                    Preset preset = (Preset)Class.forName(classname).newInstance();
                    if (preset.getClass().getSuperclass().getCanonicalName().equals(Preset.class.getCanonicalName()) ) {
                        ret.add((Preset)Class.forName(preset.getClass().getCanonicalName()).newInstance());
                    }
                } catch (InstantiationException ex) {
                    Logger.getLogger(VoicesFactory.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(VoicesFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        return ret;
    }*/
     public static Vector getAllPresets() throws ClassNotFoundException, IOException{
         Vector ret=new Vector();
         Class[] classi = Support.ClassFinder.getClasses("Presets",new Preset());
         //System.out.println("parsing "+classi.length+" classes");
         for (int t = 0; t < classi.length; t++) {
            Class classe = classi[t];
            try {
                Object tmp = classe.newInstance();
                if (tmp instanceof Preset) {
                    //System.out.println("EUREKA");
                    Preset toInstance = (Preset) Class.forName(tmp.getClass().getName()).newInstance();
                    if (!toInstance.getClass().getSimpleName().equals("Preset")) {
                        {   
                            ret.add(toInstance);
                        }
                    }
                }
            } catch (Exception ex) {
                //Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
      return ret;   
     }
             
    
    public static Preset getPresetById(int id) throws ClassNotFoundException {
         try {
             /* List<Class> presets = Support.ClassFinder.getClassesFromPackage("Presets");
             
             for (Class c : presets) {
             String classname = c.getCanonicalName();
             
             try {
             Preset preset = (Preset)Class.forName(classname).newInstance();
             if (preset.getClass().getSuperclass().getCanonicalName().equals(Preset.class.getCanonicalName()) && preset.getPreset_id() == id) {
             return (Preset)Class.forName(preset.getClass().getCanonicalName()).newInstance();
             }
             } catch (InstantiationException ex) {
             Logger.getLogger(VoicesFactory.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IllegalAccessException ex) {
             Logger.getLogger(VoicesFactory.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             }
             return null;*/
             Vector<Preset> presets=getAllPresets();
             for (Preset p: presets){
                 if(p.getPreset_id()==id)
                     return p;
             }
             return null;
         } catch (IOException ex) {
             Logger.getLogger(VoicesFactory.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
}
