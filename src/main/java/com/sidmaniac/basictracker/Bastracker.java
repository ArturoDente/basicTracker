/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidmaniac.basictracker;

import Presets.Preset;
import Support.Utilities;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class Bastracker {

    /**
     * @param args the command line arguments
     */
    private static int[] fq = new int[97];
    private static Vector<Dupla>[] vnotes = new Vector[3];
    private static String voices;
    private static int[] octaveTranspose={0,0,0};
    private static int rownum = 10;
    private static int arraydim = 0;
    private static String debugInfo="";

    private static String left$(String str, int n) {
        try {
            return str.substring(0, n);
        } catch (Exception e) {
            //System.out.println("Error with token "+str+", n="+n);
            throw new IllegalStateException("Error with token " + str + ", n=" + n);
        }
    }

    private static int len(String str) {
        return str.length();
    }

    private static String right$(String str, int n) {
        return str.substring(str.length() - n, str.length());
    }
    
    
     private static int convertNoteToFreq(String f$) {
         return convertNoteToFreq(f$, 0);
     }
    

    private static int convertNoteToFreq(String f$,int octaveTranspose) {

        int i1 = 0;
        String k1$ = left$(f$, len(f$) - 1);
        String o1$ = right$(f$, 1);
        if (f$.equals("-1")) {
            return -1;
        }
        if (f$.equals("0")) {
            return 0;
        }
        if (k1$.equals("c")) {
            i1 = 1;
        }
        if (k1$.equals("cs")) {
            i1 = 2;
        }
        if (k1$.equals("d")) {
            i1 = 3;
        }
        if (k1$.equals("ds")) {
            i1 = 4;
        }
        if (k1$.equals("e")) {
            i1 = 5;
        }
        if (k1$.equals("f")) {
            i1 = 6;
        }
        if (k1$.equals("fs")) {
            i1 = 7;
        }
        if (k1$.equals("g")) {
            i1 = 8;
        }
        if (k1$.equals("gs")) {
            i1 = 9;
        }
        if (k1$.equals("a")) {
            i1 = 10;
        }
        if (k1$.equals("as")) {
            i1 = 11;
        }
        if (k1$.equals("b")) {
            i1 = 12;
        }
        i1 = 12 * (Integer.valueOf(o1$)+octaveTranspose ) + i1;
        return fq[i1];
    }

    private static void initArray() {

        fq[1] = 268;
        fq[2] = 284;
        fq[3] = 301;
        fq[4] = 318;
        fq[5] = 337;
        fq[6] = 358;
        fq[7] = 379;
        fq[8] = 401;
        fq[9] = 425;
        fq[10] = 451;
        fq[11] = 477;
        fq[12] = 506;
        fq[13] = 536;
        fq[14] = 568;
        fq[15] = 602;
        fq[16] = 637;
        fq[17] = 675;
        fq[18] = 716;
        fq[19] = 758;
        fq[20] = 803;
        fq[21] = 851;
        fq[22] = 902;
        fq[23] = 955;
        fq[24] = 1012;
        fq[25] = 1072;
        fq[26] = 1136;
        fq[27] = 1204;
        fq[28] = 1275;
        fq[29] = 1351;
        fq[30] = 1432;
        fq[31] = 1517;
        fq[32] = 1607;
        fq[33] = 1703;
        fq[34] = 1804;
        fq[35] = 1911;
        fq[36] = 2025;
        fq[37] = 2145;
        fq[38] = 2273;
        fq[39] = 2408;
        fq[40] = 2551;
        fq[41] = 2703;
        fq[42] = 2864;
        fq[43] = 3034;
        fq[44] = 3215;
        fq[45] = 3406;
        fq[46] = 3608;
        fq[47] = 3823;
        fq[48] = 4050;
        fq[49] = 4291;
        fq[50] = 4547;
        fq[51] = 4817;
        fq[52] = 5103;
        fq[53] = 5407;
        fq[54] = 5728;
        fq[55] = 6069;
        fq[56] = 6430;
        fq[57] = 6812;
        fq[58] = 7217;
        fq[59] = 7647;
        fq[60] = 8101;
        fq[61] = 8583;
        fq[62] = 9094;
        fq[63] = 9634;
        fq[64] = 10207;
        fq[65] = 10814;
        fq[66] = 11457;
        fq[67] = 12139;
        fq[68] = 12860;
        fq[69] = 13625;
        fq[70] = 14435;
        fq[71] = 15294;
        fq[72] = 16203;
        fq[73] = 17167;
        fq[74] = 18188;
        fq[75] = 19269;
        fq[76] = 20415;
        fq[77] = 21629;
        fq[78] = 22915;
        fq[79] = 24278;
        fq[80] = 25721;
        fq[81] = 27251;
        fq[82] = 28871;
        fq[83] = 30588;
        fq[84] = 32407;
        fq[85] = 34334;
        fq[86] = 36376;
        fq[87] = 38539;
        fq[88] = 40830;
        fq[89] = 43258;
        fq[90] = 45830;
        fq[91] = 48556;
        fq[92] = 51443;
        fq[93] = 54502;
        fq[94] = 57743;
        fq[95] = 61176;
        fq[96] = 64874;

    }

    private static String readFile(String path) throws IOException {
        Path p = Paths.get(path);
        List rows = Files.readAllLines(p);
        Iterator it = rows.iterator();
        String ret = "";
        while (it.hasNext()) {
            ret += (String) it.next() + ",";
        }

        return ret;
    }

    private static void initVoicesNotes(String csvPath) throws IOException {
        String content = readFile(csvPath).replaceAll(":", "").replaceAll("\\<.*?>","");
        String[] arr = content.split(",");
        vnotes[0] = new Vector();
        vnotes[1] = new Vector();
        vnotes[2] = new Vector();

        int v = 0;
        for (int t = 0; t < arr.length - 1; t = t + 2) {
            Dupla dupla = new Dupla(arr[t], arr[t + 1]);
            int freq = convertNoteToFreq(dupla.getNote(),octaveTranspose[v]);
            Dupla freqAndDuration = new Dupla("" + freq, dupla.getDuration());
            if (!dupla.isTransitionDupla()) {
                vnotes[v].add(freqAndDuration);
            } else {
                v = v + 1;
            }
        }
    }
    
    public static String getDataBlockHLMIXED(){
        boolean end=false;
        rownum += 10;
        String[] presetsId = voices.split(",");
        String ret = "";
        Preset[] presets = new Preset[3];
        for (int t = 0; t < 3; t++) {
            try {
                presets[t] = VoicesFactory.getPresetById(Integer.valueOf(presetsId[t]));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Bastracker.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        Vector duple0=vnotes[0];
        Vector duple1=vnotes[1];
        Vector duple2=vnotes[2];
        int[] indexVector={0,0,0};
        boolean end1=false;
        boolean end2=false;
        boolean end3=false;
        
        
        do{
            try{
            Dupla dupla0=((Dupla)duple0.elementAt(indexVector[0]));
            Dupla dupla1=((Dupla)duple1.elementAt(indexVector[1]));
            Dupla dupla2=((Dupla)duple2.elementAt(indexVector[2]));
            String blocco0="";
            String blocco1="";
            String blocco2="";
            
            int[] progressToGoal={0,0,0};
            int goal=getMax(dupla0.getDurationRevised(presets[0].getTc()),
                    dupla1.getDurationRevised(presets[1].getTc()),
                   dupla2.getDurationRevised(presets[2].getTc())
                    );
            
                int c0=0;
                while(true){
                    //System.out.println("goal="+goal+" , progressToGoal0="+progressToGoal[0]);
                if (progressToGoal[0]>=goal)
                    break;
                blocco0+= (dupla0.getFh() + ",") + (dupla0.getFl() + ",") + dupla0.getDurationRevised(presets[0].getTc()) + ",";
                progressToGoal[0]+=dupla0.getDurationRevised(presets[0].getTc());
                indexVector[0]++;
                try{
                    dupla0=((Dupla)duple0.elementAt(indexVector[0]));
                } catch (Exception ee){
                    end1=true;
                }
                c0++;
                }
                blocco0=c0+","+blocco0;
                
                int c1=0;
                while(true){
                if (progressToGoal[1]>=goal)
                    break;
                blocco1+= (dupla1.getFh() + ",") + (dupla1.getFl() + ",") + dupla1.getDurationRevised(presets[1].getTc()) + ",";
                progressToGoal[1]+=dupla1.getDurationRevised(presets[1].getTc());
                indexVector[1]++;
                try{
                    dupla1=((Dupla)duple1.elementAt(indexVector[1]));
                }catch(Exception ee){
                    end2=true;
                }
                c1++;
                }
                blocco1=c1+","+blocco1;
                
                int c2=0;
                while(true){
                if (progressToGoal[2]>=goal)
                    break;
                blocco2+= (dupla2.getFh() + ",") + (dupla2.getFl() + ",") + dupla2.getDurationRevised(presets[2].getTc()) + ",";
                progressToGoal[2]+=dupla2.getDurationRevised(presets[2].getTc());
                indexVector[2]++;
                try{
                    dupla2=((Dupla)duple2.elementAt(indexVector[2]));
                }catch(Exception ee){
                    end3=true;
                }
                c2++;
                }
                blocco2=c2+","+blocco2;
                
                String blocco=blocco0+blocco1+blocco2;
                if (blocco.length()>79){
                    Vector blocchisplit=splitBlock(blocco);
                    for(int t=0;t<blocchisplit.size();t++){
                         String bloccosplit=(String)blocchisplit.elementAt(t);
                         if (bloccosplit.endsWith(","))
                             bloccosplit=bloccosplit.substring(0, bloccosplit.length() - 1);
                        ret+="\n"+rownum+"data"+bloccosplit;                         
                         rownum+=10;
                    }
                }else {
                ret+="\n"+rownum+"data"+blocco;
                ret=ret.substring(0, ret.length() - 1);
                rownum+=10;}
            }catch(Exception e){
                e.printStackTrace();
                System.exit(1);
            }
        }while(!end1&&!end2&&!end3);
        return ret;
    }
    
    
    
    private static Vector splitBlock(String block){
        
        if (block.length()<=80)
        {
            Vector ret=new Vector();
            ret.add(block);
            return ret;
        }
        try{
            int pos=79;
            while(!block.substring(pos-1, pos).equals(","))
                pos--;
            Vector ret=new Vector();
            ret.add(block.substring(0,pos));
            ret.addAll(splitBlock(block.substring(pos,block.length()-1)));
           return ret;
        }catch(Exception e){
           return null;
        }
    }
    
    private static int getMax(int a,int b,int c){
        return Math.max(a, Math.max(b, c));
    }
    
    public static String getDataBlockHL() {
        rownum += 10;
        String[] presetsId = voices.split(",");
        String ret = "";
        Preset[] presets = new Preset[3];
        for (int t = 0; t < 3; t++) {
            try {
                presets[t] = VoicesFactory.getPresetById(Integer.valueOf(presetsId[t]));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Bastracker.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }

        for (int v = 0; v < 3; v++) {
            //arraydim=0;//last one is ok
            Vector dupleVoceN = vnotes[v];
            int caratteririga = 0;
            ret = ret + "\n" + (rownum + " data ");
            int debugDuration=0;
            for (int d = 0; d < dupleVoceN.size(); d++) {
                Dupla freqDuration = (Dupla) dupleVoceN.elementAt(d);
                int fh = freqDuration.getFh();
                int fl = freqDuration.getFl();
                int durationRevisited = freqDuration.getDurationRevised(presets[v].getTc());
                debugDuration+=durationRevisited;
                //arraydim=arraydim+(2*durationRevisited);
                String block = (fh + ",") + (fl + ",") + durationRevisited + ",";
                caratteririga += block.length();
                if (caratteririga >= 68 - (((rownum + 10) + "").length())) {
                    rownum += 10;
                    caratteririga = 0;
                    ret = ret.substring(0, ret.length() - 1);
                    ret = ret + "\n" + (rownum + " data ");
                }
                ret += (block);
            }
            if (ret.endsWith(",")) {
                ret = ret.substring(0, ret.length() - 1);
            }
            rownum += 10;
            ret += "\n" + rownum + " data -1,-1,-1";
            rownum += 10;
            debugInfo+="\n"+debugDuration;
        }
        return ret;
    }

    private static void calculateArrayDim() throws ClassNotFoundException {
        arraydim = 0;
        String[] presetsId = voices.split(",");
        for (int d = 0; d < vnotes[0].size(); d++) {
            Dupla freqDuration = (Dupla) vnotes[0].elementAt(d);
            Preset preset0 = VoicesFactory.getPresetById(Integer.valueOf(presetsId[0]));
            int durationRevisited = freqDuration.getDurationRevised(preset0.getTc());
            arraydim = arraydim + (2 * durationRevisited);
        }
        arraydim+=2;
    }
    
    private static void purgeVoices(){
        
            /*
            side effect on voices array. If an entry is not a number, tries to find the preset
            for that name. If the preset does not exist, error
            */
            String[] arrVoices=voices.split(",");
            for (int t=0;t<arrVoices.length;t++){
                if (!Utilities.isNumber(arrVoices[t])){
                    try{
                        Preset found=VoicesFactory.getPresetByName(arrVoices[t]);
                        arrVoices[t]=""+found.getPreset_id();
                    } catch (Exception e){
                        throw new IllegalStateException("Preset "+arrVoices[t]+" not found");
                    }
                }
            }
            voices="";
            for (int t=0;t<arrVoices.length;t++){
                voices+=arrVoices[t]+((t<arrVoices.length-1)?",":"");
            }
    }

    private static String getDefInstrumentsBlock() throws ClassNotFoundException, IOException {        
        Vector<Preset> allpresets=VoicesFactory.getAllPresets();
        int numstrum=allpresets.size();
        String ret = rownum + " dim ad("+numstrum+"):dim sr("+numstrum+"):dim il("+numstrum+"):dim ih("+numstrum+"):dim wi("+numstrum+")";
        String[] presetsId = voices.split(",");
        Preset[] presets = new Preset[3];
        for (int t = 0; t < 3; t++) {
            try {
                presets[t] = VoicesFactory.getPresetById(Integer.valueOf(presetsId[t]));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Bastracker.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        
        
        if (allpresets==null || allpresets.size()==0){
            throw new IllegalStateException("No instruments defined. Subclass Preset class in order to define at least one");
        }
        
        rownum += 10;        
        ret += "\n" + rownum;
        for (int t=0;t<allpresets.size();t++)
            ret += "ad("+allpresets.elementAt(t).getPreset_id()+")=" + allpresets.elementAt(t).getAd() + ":";
        
        rownum += 10;
        ret += "\n" + rownum;
        for (int t=0;t<allpresets.size();t++)
            ret += "sr("+allpresets.elementAt(t).getPreset_id()+")=" + allpresets.elementAt(t).getSr() + ":";
        
        
        rownum += 10;
        ret += "\n" + rownum;
        for (int t=0;t<allpresets.size();t++)
            ret += "il("+allpresets.elementAt(t).getPreset_id()+")=" + allpresets.elementAt(t).getIl() + ":";
        
        
        rownum += 10;
        ret += "\n" + rownum;
        for (int t=0;t<allpresets.size();t++)
            ret += "ih("+allpresets.elementAt(t).getPreset_id()+")=" + allpresets.elementAt(t).getIh() + ":";
        
        
        rownum += 10;
        ret += "\n" + rownum;
        for (int t=0;t<allpresets.size();t++)
            ret += "wi("+allpresets.elementAt(t).getPreset_id()+")=" + allpresets.elementAt(t).getWi() + ":";
        
        
        rownum += 10;
        ret += "\n" + rownum + "s1=" + presetsId[0] + ":s2=" + presetsId[1] + ":s3=" + presetsId[2] + ":r$=\"000000\"";

        calculateArrayDim();

        rownum += 10;
        ret += "\n" + rownum + "dim f%(" + arraydim + ",2):dim tc(3)";

        rownum += 10;
        ret += "\n" + rownum + "tc(0)=" + presets[0].getTc() + ":tc(1)=" + presets[1].getTc() + ":tc(2)=" + presets[2].getTc() + ":rem minimum durations";

        String block = "?\"processing data...\" \n"
                + "vn=0:cn=0:rem reset counters v n # \n"
                + "read fh,fl,dr \n"
                + "if fh=-1 then f%(cn,vn)=-1:vn=vn+1:cn=0:if vn=3 then print\"done.\":goto" + (rownum + 140) + " \n"
                + "if fh=-1 then goto" + (rownum + 30) + " \n"
                + "ac=-2:if fh=0 then ac=0 \n"
                + "f%(cn,vn)=fh:f%(cn+1,vn)=fl \n"
                + "if dr =1 then " + (rownum + 130) + " \n"
                + "for t = 1 to dr-1 \n"
                + "cn=cn+2 \n"
                + "f%(cn,vn)=ac:f%(cn+1,vn)=ac \n"
                + "next t \n"
                + "cn=cn+2: goto " + (rownum + 30) + " \n"
                + "rem let s rock";
        String[] rows = block.split("\\n");
        for (int t = 0; t < rows.length; t++) {
            rownum += 10;
            ret += "\n" + rownum + rows[t];
        }

        block = "l1=54272:l2=54279:l3=54286 \n"
                + "forj=l1 to 54296:poke j,0:next j \n"
                + "h1=l1+1:h2=l2+1:h3=l3+1 \n"
                + "v1=l1+4:v2=l2+4:v3=l3+4 \n"
                + "poke 54296,15 \n"
                + "poke v1+1,ad(s1):poke v1+2,sr(s1) \n"
                + "pokel1+2,il(s1):pokel1+3,ih(s1) \n"
                + "poke v2+1,ad(s2):poke v2+2,sr(s2) \n"
                + "pokel2+2,il(s2):pokel2+3,ih(s2) \n"
                + "poke v3+1,ad(s3):poke v3+2,sr(s3) \n"
                + "pokel3+2,il(s3):pokel3+3,ih(s3) \n"
                + "cn=0 \n"
                + "ti$=r$:t=ti \n"
                + "x1=f%(cn,0):y1=f%(cn+1,0):x2=f%(cn,1):y2=f%(cn+1,1):x3=f%(cn,2):y3=f%(cn+1,2) \n"
                + "ifx1 =-1 then goto "+(rownum+220)+" \n"
                + "ifx1>-2 then pokev1,wi(s1):if x1 > 0 then poke h1,x1:poke l1,y1:poke v1,wi(s1)+1 \n"
                + "ifx2>-2 then pokev2,wi(s2):if x2 > 0 then poke h2,x2:poke l2,y2:poke v2,wi(s2)+1 \n"
                + "ifx3>-2 then pokev3,wi(s3):if x3 > 0 then poke h3,x3:poke l3,y3:poke v3,wi(s3)+1 \n"
                + "cn=cn+2:t=t+4:rem the biggest t, the slower timing \n"
                + "ifti<t then "+(rownum+200)+" \n"
                + "goto "+(rownum+130)+" \n"
                + "poke54296,0:end \n";
        rows = block.split("\\n");
        for (int t = 0; t < rows.length; t++) {
            rownum += 10;
            ret += "\n" + rownum + rows[t];
        }

        return ret;
    }

    private static String getPropFromArgs(String prop, String[] args) {
        if (args == null || args.length == 0) {
            return "";
        }
        //prop starts with minus sign
        for (int t = 0; t < args.length; t++) {
            if (args[t].toLowerCase().startsWith(prop.toLowerCase())) {
                return args[t + 1].trim();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        if (args==null|| args.length==0){
            System.out.println("put at least the path of the music sheet file");
            System.exit(1);
        }
        String startsFrom = getPropFromArgs("-startingfrom", args);
        voices = getPropFromArgs("-voices", args);
        if (voices == null || voices.equals("")) {
            voices = "0,0,0";
        }
        
        if(!getPropFromArgs("-ot1",args).equals("")){
            octaveTranspose[0]=Integer.valueOf(getPropFromArgs("-ot1",args));
        }
        if(!getPropFromArgs("-ot2",args).equals("")){
            octaveTranspose[1]=Integer.valueOf(getPropFromArgs("-ot2",args));
        }
        if(!getPropFromArgs("-ot3",args).equals("")){
            octaveTranspose[2]=Integer.valueOf(getPropFromArgs("-ot3",args));
        }
        
        purgeVoices();
        if (startsFrom.equals("")) {
            startsFrom = "10";
        }
        rownum = Integer.valueOf(startsFrom);
        initArray();
        String filepath=args[args.length-1];
        //args[0]="c:\\tmp\\sirius.txt";
        if (filepath.startsWith("-")){
            System.out.println("put music sheet file as last argument");
            System.exit(1);
        }
        try {
            initVoicesNotes(filepath);

        } catch (IOException ex) {
            Logger.getLogger(Bastracker.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(getDefInstrumentsBlock() + getDataBlockHL());
            //System.out.println(debugInfo);
            //System.out.println(vnotes[0].size() + vnotes[1].size() + vnotes[2].size());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bastracker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bastracker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static class Dupla {

        String note;
        int duration;

        public Dupla(String note, int duration) {
            this.note = note;
            this.duration = duration;
        }

        public Dupla(String note, String duration) {
            setNote(note);
            setDuration(duration);
        }

        public String getNote() {
            return note.trim();
        }

        public int getNoteInt() {
            return Integer.valueOf(getNote());
        }

        public void setNote(String note) {
            this.note = note;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getDurationRevised(int tc) {
            return getDuration() / tc;
        }

        public void setDuration(String duration) {
            setDuration(Integer.valueOf(duration));
        }

        public boolean isTransitionDupla() {
            return this.getNote().equals("-1");
        }

        public int getDuplaLength() {
            return this.getNote().length() + ("" + this.getDuration()).length();
        }

        public int getFh() {
            int freq = getNoteInt();
            return freq / 256;
        }

        public int getFl() {
            return getNoteInt() - (getFh() * 256);
        }

        @Override
        public String toString() {
            return this.getNote() + "," + this.getDuration() + ",";
        }

    }

}
