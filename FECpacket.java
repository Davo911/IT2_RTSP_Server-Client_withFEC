import java.util.Arrays;

public class FECpacket
{
    int FEC_group;       // FEC-Gruppengröße
    byte[][] mediastack; // Puffer für Medienpakete
    byte[][] fecstack;   // Puffer für FEC-Pakete 
    int count = 0;
    int max = 15000;	 //max bytes
    int max_frames = 500;//max Bilder
    byte[] buf;
    int FECNr,corrected;
    
    
    
    // SENDER --------------------------------------
    public FECpacket(){
    	mediastack = new byte[max_frames][];
    	fecstack = new byte[max_frames][];
    	buf = new byte[max];
    }

    // RECEIVER ------------------------------------
    public FECpacket( int FECgroup){
    	buf = new byte[max];
    	mediastack = new byte[max_frames][];
    	fecstack = new byte[max_frames][];
    	FEC_group = FECgroup;
    }
        
    
    // ----------------------------------------------
    // *** SENDER *** 
    // ----------------------------------------------
    
    // speichert Nutzdaten zur FEC-Berechnung
    public void setdata( byte[] data, int data_length) {
    	for(int i=0;i<data_length;i++){
     		if (count == 0){
     			buf[i]=data[i];			
     		}else{//XOR
     			buf[i]^=(byte)data[i];
     		}
     	}
 		if(data_length > count){
 			count=data_length;
 		}
    	return;
    }
    
    // holt fertiges FEC-Paket, Rückgabe: Paketlänge 
    public int getdata( byte[] data){
    	int i;
    	for(i = 0;i<data.length;i++){
    		data[i] = buf[i];
    	}
    	return i;
    }
    


    // ------------------------------------------------
    // *** RECEIVER *** 
    // ------------------------------------------------
    // speichert UDP-Payload, Nr. des Bildes
    public void rcvdata( int nr, byte[] data){
    	mediastack[nr] = new byte[max];
    	for(int i = 0; i<data.length;i++) {
    		mediastack[nr][i] = data[i];
    	}
    }

    // speichert FEC-Daten, Nr. eines Bildes der Gruppe    
    public void rcvfec( int nr, byte[] data){
    	fecstack[nr] = new byte[max];
    	for(int i = 0; i<data.length;i++) {
    		fecstack[nr][i] = data[i];
    	}
    }
    
    // übergibt vorhandenes/korrigiertes Paket oder Fehler (null)    
    public byte[] getjpeg( int nr){

		if (mediastack[nr] == null){

			for (int i = 0; i < fecstack[]; i++) {

			}

		}else return mediastack[nr];
    	
    	/*
    	if(//mehr als 1 Paket in der Grp fehlt ) {
    		return null;
    	}else if(eins fehlt){
    		for(int i=0;i<Bildlänge;i++) {
    			//XOR aller in der grp befindlichen bilder, mit fec 
    		}
    		corrected++;
    		return //ergebnis
    	}
    	*/
    	
    }
    
    
    // für Statistik, Anzahl der korrigierten Pakete
    public int getNrCorrected(){
    	
    	return corrected;
    }
    
}
