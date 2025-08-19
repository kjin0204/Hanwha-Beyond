package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;
import com.ohgiraffers.section03.filterstream.dto.MyOutput;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {


        MemberDTO[] members = new MemberDTO[50];
        members[0] = new MemberDTO("user01", "pass01", "홍길동", "hong123@gmail.com", 25, '남');
        members[1] = new MemberDTO("user02", "pass02", "유관순", "korea31@gmail.com", 16, '남');
        members[2] = new MemberDTO("user03", "pass03", "홍길동", "kang@gmail.com", 38, '남');

        String path = "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt";
        File file = new File(path);

        ObjectOutputStream oos = null;
        try {
            if (!file.exists()) {
                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        path
                                )
                        )
                );
            } else {
                oos = new MyOutput(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        path,true
                                )
                        )
                );
            }

            for (int i = 0; i < 3; i++) {
                oos.writeObject(members[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        MemberDTO[] newMemebers = new MemberDTO[members.length];
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    path
                            )
                    )
            );

            int index = 0;
            while (true) {
                newMemebers[index++] = (MemberDTO) ois.readObject();
                System.out.println(newMemebers[index - 1]);
            }

        } catch (EOFException e) {
            System.out.println("회원 읽기 끝");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
