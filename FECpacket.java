import java.util.Arrays;

public class FECpacket
{
    int FEC_group;       // FEC-Gruppengröße
     
    byte[][] mediastack; // Puffer für Medienpakete
    byte[][] fecstack;   // Puffer für FEC-Pakete 
    int count = 0;
    int max = 15000;
    byte[] buf;
    int FECNr;
    
    
    // SENDER --------------------------------------
    public FECpacket(){
    	buf = new byte[max];
    }

    // RECEIVER ------------------------------------
    public FECpacket( int FEC_group){
    	
    	
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
     			buf[i]^=data[i];
     		}
     		
     		if(data_length > count){
     			count=data_length;
     		}
     	}
    	return;
    }
    
    // holt fertiges FEC-Paket, Rückgabe: Paketlänge 
    public int getdata( byte[] data){
    	for(int i = 0;i<count;i++){
    		data[i] = buf[i];
    		Arrays.fill(buf, (byte) 0);
    	}
    	
    	
    	return count;
    }
    
/*

    // ------------------------------------------------
    // *** RECEIVER *** 
    // ------------------------------------------------
    // speichert UDP-Payload, Nr. des Bildes
    public void rcvdata( int nr, byte[] data){
    	
    }

    // speichert FEC-Daten, Nr. eines Bildes der Gruppe    
    public void rcvfec( int nr, byte[] data){
    	
    }
    
    // übergibt vorhandenes/korrigiertes Paket oder Fehler (null)    
    public byte[] getjpeg( int nr){
    	
    	;
    }
    
    // für Statistik, Anzahl der korrigierten Pakete
    public int getNrCorrected(){
    	
    }
    */
}
