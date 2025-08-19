package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    /* 설명. 초기에 Member 파일이 없다면 만들어 더미데이터(dummy data)를 쌓는다. */
    private final List<Member> memberList = new ArrayList<>();
    private final String path = "src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat";
    private final File file = new File(path);

    public MemberRepository() {
        if (!file.exists()) {
            List<Member> defaultMemberList = new ArrayList<>();
            defaultMemberList.add(new Member(1, "user01", "pass01", 20, new String[]{"발레", "수영"}
                    , BloodType.A, AccountStatus.ACTIVE));
            defaultMemberList.add(new Member(2, "user02", "pass02", 10, new String[]{"게임", "영화시청"}
                    , BloodType.B, AccountStatus.ACTIVE));
            defaultMemberList.add(new Member(3, "user03", "pass03", 30, new String[]{"음악감상", "독서", "영상"}
                    , BloodType.AB, AccountStatus.ACTIVE));

            saveMembers(defaultMemberList);
        }
        loadMembers();
    }


    /* 설명. ArrayList<Member>를 받으면 파일로 컬렉션에 담긴 회원들을 출력하는 메소드(feat. 덮어씌우는 기능) */
    private void saveMembers(List<Member> members) {
        ObjectOutputStream oos = null;

        try {
            if (file.exists()) {
                oos = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file)));
            } else {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            }

            for (Member member : members) {
                oos.writeObject(member);
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
    }

    private void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 읽어오기 완료.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Member> findAllMemebers() {
        return memberList;
    }


}
