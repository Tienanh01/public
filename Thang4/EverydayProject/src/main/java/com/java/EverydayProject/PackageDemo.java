package com.java.EverydayProject;

import com.java.EverydayProject.PackageCurl.AesCbcEncryption;

public class PackageDemo {
    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, world!";
        String encrypted = AesCbcEncryption.encrypt(plaintext);
        String decrypted = AesCbcEncryption.decrypt(encrypted);

//        jh77Slbj23braMQtw0MtYA==

        System.out.println("Original text: " + plaintext);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}
