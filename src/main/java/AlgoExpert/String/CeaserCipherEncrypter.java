package AlgoExpert.String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CeaserCipherEncrypter {

    public String caesarCypherEncryptor(String str, int key){
        /*int ascii_a = (int) 'a';
        int ascii_z = (int) 'z';
        System.out.println("ascii of a: " + ascii_a);
        System.out.println("ascii of z: " + ascii_z);

        char char_a = (char) ascii_a;
        char char_z = (char) ascii_z;
        System.out.println("char of a: " + char_a);
        System.out.println("char of z: " + char_z);*/
        key = key % 26;
        StringBuffer result = new StringBuffer();
        for(char c: str.toCharArray()){
            //System.out.println(c);
            int ascii_c = c;
            int newChar = ascii_c + key;
            if ( ascii_c + key > 122 ){
                result.append((char) ( 96 + (newChar % 122)));
            }
            else {
                result.append((char) ( newChar ));
            }
        }

        return result.toString();
    }

    @Test
    public void caesarCypherEncrypterTest(){
        assertEquals("zab", caesarCypherEncryptor("xyz", 2));
        assertEquals("abc", caesarCypherEncryptor("abc", 0));
        assertEquals("def", caesarCypherEncryptor("abc", 3));
        assertEquals("cde", caesarCypherEncryptor("xyz", 5));
        assertEquals("abc", caesarCypherEncryptor("abc", 26));
        assertEquals("abc", caesarCypherEncryptor("abc", 52));
        assertEquals("abc", caesarCypherEncryptor("abc", 78));
    }

}
