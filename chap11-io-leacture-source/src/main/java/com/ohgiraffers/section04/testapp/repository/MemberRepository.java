package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 설명.
 *  데이터베이스(현재는 파일) 개념과 입출력을 위해 만드러진 계층이며 성공 데이터 또는 성공/실패 여부를 반환
 *   (지금과 같이 주로 컬렉션으로 데이터를 관리함)
 * */

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


    public Member findMemberBy(int memNo) {
        for (Member member : memberList) {
            if (member.getMemNo() == memNo) {
                return member;
            }
        }
        return null;
    }

    public int registMember(Member member) {
        int result = svaeMember(member);

        return result;
    }

    private int svaeMember(Member member) {
        ObjectOutputStream oos = null;
        int result = 0;

        try {
            oos = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file, true)));
            oos.writeObject(member);
            oos.flush();    //버퍼를 사용 하고 있어 Buffer에 있는 데이터를 강제 출력

            /* 설명. 파일과 memberList 동기화 */
            /* 설명. 1. MemberList에 add */
//            memberList.add(member);
            /* 설명. 2. 파일 입력 후 파일에서 다시 일겅와 동기화 */
            memberList.clear();
            loadMembers();
            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    public int findLastMemberNo() {
        return memberList.get(memberList.size() - 1).getMemNo();
    }
}
