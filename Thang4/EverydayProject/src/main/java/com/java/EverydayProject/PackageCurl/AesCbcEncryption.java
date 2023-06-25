package com.java.EverydayProject.PackageCurl;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AesCbcEncryption {
    private static final String KEY = "mysecretpasswordmysecretpassword";
    private static final String IV = "mysecretpassword";

    public static String encrypt(String input) throws Exception {
        byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
        byte[] ivBytes = IV.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encrypted = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String input) throws Exception {
        byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
        byte[] ivBytes = IV.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, world!";
        String encrypted = encrypt(plaintext);
        String decrypted = decrypt(encrypted);

//        jh77Slbj23braMQtw0MtYA==

        System.out.println("Original text: " + plaintext);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}