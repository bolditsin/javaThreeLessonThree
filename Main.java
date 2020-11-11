package lessonThree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();
        //method3();
    }
//1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
    public static void method1() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Java\\file1.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int x;
        while((x = in.read()) != -1) {
            out.write(x);
        }
        byte[] b = out.toByteArray();
        System.out.println(Arrays.toString(b));
        in.close();
        out.close();
    }

//2.Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
public static void method2() throws IOException {
    ArrayList<InputStream> arrList = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
        arrList.add(new FileInputStream("C:\\Users\\Oldredcomp\\IdeaProjects\\javathree\\src\\lessonThree\\"+ i + ".txt"));
    }
    BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(arrList)));
    int a;
    while((a = in.read()) != -1) {
        System.out.print((char)a);
    }
    in.close();
}
//3.Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
public static void method3() throws IOException {
    final int PAGE_SIZE = 1800;
    RandomAccessFile raf = new RandomAccessFile("C:\\Java\\5.txt", "rw");
    Scanner sc = new Scanner(System.in);
    System.out.println("Choose page:");
    int p = sc.nextInt() - 1;
    raf.seek(p * PAGE_SIZE);
    for (int i = 0; i < PAGE_SIZE; i++) {
        System.out.print((char)raf.read());
    }
    raf.close();
}
}