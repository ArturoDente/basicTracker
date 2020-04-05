# basicTracker
Java code to generate optimized Basic v2 code to play a song passed to java by a musical sheet written in a certain way

##Syntax: java -jar basicTracker-1.0-SNAPSHOT.jar [-startingfrom basicLineToStartFrom] [-voices commaSeparatedVoicesValues] [-ot1 octaveToTransposeVoice1] [-ot2 octaveToTransposeVoice2] [-ot3 octaveToTransposeVoice3] <filepath>

voices are:
0 Piano
1 Bass
3 Drum
4 Violin
5 Trumpet

##Rules for the musical sheet file
1) the file is composed by three blocks, one per voice. The blocks are separated by the row -1,-1
2) notes are rendered as NO,D , where N=notation in anglosaxon (C is "DO"), O= octave , D=duration (2 is the fastest. Use multiplies of 2)
3) you can put comments between <>. At the moment, a comment must be followed by a note

Example of a file (song: bad medicine): NOTE: you have to trim blank rows, they are here because github messes all, else

d4,4,d4,4,d4,4,d4,4,d4,4,d4,4,d4,4,d4,4

c4,4,c4,4,c4,4,c4,4,c4,4,c4,4,c4,4,c4,4

b3,4,b3,4,b3,4,b3,4,b3,4,b3,4,b3,4,b3,4

as3,4,as3,4,as3,4,as3,4,as3,4

f4,4,e4,4,d4,8

<endintro>f4,4,d4,8,d4,4,f4,4,d4,4,g4,12,f4,4,e4,4,d4,12

g4,4,g4,4,f4,4,g4,8,a4,8,f4,4,e4,4,c4,4,d4,12

<oh oho ho>a3,4,c4,4,d4,8

<2d time>f4,4,d4,8,d4,4,f4,4,d4,4,g4,12,f4,4,e4,4,d4,12

g4,4,g4,4,f4,4,g4,8,a4,8,f4,4,e4,4,c4,4,d4,12

<closing>c4,4,c4,4,c4,4,c4,4,c4,4,c4,4,c4,4,c4,4

b3,4,b3,4,b3,4,b3,4,b3,4,b3,4,b3,4,b3,4

f4,4,e4,4,d4,12

-1,-1

a3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,4

a3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,4

a3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,4

a3,4,a3,4,a3,4,a3,4,a3,4

f3,4,e3,4,d3,8

<endintro>a3,4,a3,8,a3,4,a3,4,a3,4,g3,4,g3,4,g3,4,a3,4,a3,4,a3,4,a3,4,a3,4

g3,4,g3,4,g3,4,g3,4,g3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,12

<oh oho ho>a2,4,c3,4,d3,8

<2d time>a3,4,a3,8,a3,4,a3,4,a3,4,g3,4,g3,4,g3,4,a3,4,a3,4,a3,4,a3,4,a3,4

g3,4,g3,4,g3,4,g3,4,g3,4,a3,4,a3,4,a3,4,a3,4,a3,4,a3,12

<closing>g3,4,g3,4,g3,4,g3,4,g3,4,g3,4,g3,4,g3,4

g3,4,g3,4,g3,4,g3,4,g3,4,g3,4,g3,4,g3,4

f3,4,e3,4,d3,12

-1,-1

0,132

-1,-1

