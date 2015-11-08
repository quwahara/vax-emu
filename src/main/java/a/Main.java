package a;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.err.println("Please set filename to argument.");
            System.exit(-1);
        }
        String name = args[0];
        Path path = Paths.get(name);
        if(!Files.exists(path)) {
            System.err.println("The file was not found.");
            System.exit(-1);
        }
        
        byte[] contents = Files.readAllBytes(path);
        String inHex = bytesToHex(contents);
        System.out.println(inHex);
    }
    
    // refs: http://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
