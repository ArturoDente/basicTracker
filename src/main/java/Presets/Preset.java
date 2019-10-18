/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presets;

/**
 *
 * @author franc
 */
public class Preset {
    protected String presetName;
    protected int tc;//minim duration
    protected int preset_id;
    protected int ad;
    protected int sr;
    protected int il;
    protected int ih;
    protected int wi;

    public Preset(String presetName, int tc, int preset_id, int ad, int sr, int il, int ih, int wi) {
        this.presetName = presetName;
        this.tc = tc;
        this.preset_id = preset_id;
        this.ad = ad;
        this.sr = sr;
        this.il = il;
        this.ih = ih;
        this.wi = wi;
    }

    public Preset() {
    }

    
    

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public int getPreset_id() {
        return preset_id;
    }

    public void setPreset_id(int preset_id) {
        this.preset_id = preset_id;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public int getIl() {
        return il;
    }

    public void setIl(int il) {
        this.il = il;
    }

    public int getIh() {
        return ih;
    }

    public void setIh(int ih) {
        this.ih = ih;
    }

    public int getWi() {
        return wi;
    }

    public void setWi(int wi) {
        this.wi = wi;
    }
    
    
}
