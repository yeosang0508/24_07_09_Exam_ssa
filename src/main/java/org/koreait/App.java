package org.koreait;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {

    List<Motivation> motivations = new ArrayList<>();
    Date now = new Date();

    public void run(Scanner scanner) {
        System.out.println("== 명언 앱 실행 ==");
        int lastId = 0;


        while (true) {
            System.out.print("명령어 ) ");
            String cmd = scanner.nextLine().trim();


            if (cmd.equals("종료")) {
                break;
            }

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine().trim();

                System.out.print("작가 : ");
                String author = scanner.nextLine().trim();

                int id = lastId + 1;

                lastId++;
                System.out.println(id + "번 명언이 등록되었습니다.");

                Motivation motivation = new Motivation(id, content, author,Util.Date());


                motivations.add(motivation);

            } else if (cmd.equals("목록")) {
                if (motivations.size() == 0) {
                    System.out.println("등록된 명언이 없습니다.");
                    continue;
                }
                System.out.println("번호   /   작가   /   명언");
                System.out.println("=================================");

                for (int i = motivations.size() - 1; i >= 0; i--) {
                    Motivation motivation = motivations.get(i);

                    System.out.println(motivation.getId() + "   /   " + motivation.getAuthor() + "   /   " + motivation.getContent());
                }


            } else if (cmd.startsWith("수정")) {
                if (motivations.size() == 0) {
                    System.out.println("등록된 명언이 없습니다.");
                    continue;
                }

                String[] str = cmd.split("");

                int id = Integer.parseInt(str[str.length - 1]);

                if (findId(id) == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                } else {
                    Motivation motivation = findId(id);

                    System.out.println("명언(기존) : " + motivation.getContent());
                    System.out.println("작가(기존) : " + motivation.getAuthor());
                    System.out.print("명언 : ");
                    String content = scanner.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = scanner.nextLine().trim();


                    motivation.setContent(content);
                    motivation.setAuthor(author);

                    System.out.println(id + "번 명언이 수정되었습니다.");
                }


            }else if(cmd.startsWith("상세보기")){
                if (motivations.size() == 0) {
                    System.out.println("등록된 명언이 없습니다.");
                    continue;
                }

                String[] str = cmd.split("");

                int id = Integer.parseInt(str[str.length - 1]);

                if (findId(id) == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;

                }else {
                    Motivation motivation = findId(id);
                    LocalDateTime now = LocalDateTime.now();


                    System.out.println("번호 : " + motivation.getId());
                    System.out.println("날짜 : " + motivation.getRegDate());
                    System.out.println("작가 : " + motivation.getAuthor());
                    System.out.println("내용 : " + motivation.getContent());

                }
            } else if(cmd.startsWith("삭제")) {
                if (motivations.size() == 0) {
                    System.out.println("등록된 명언이 없습니다.");
                    continue;
                }

                String[] str = cmd.split("");

                int id = Integer.parseInt(str[str.length - 1]);

                if (findId(id) == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                } else{
                    Motivation motivation = findId(id);

                    motivations.remove(motivation);

                    System.out.println(id + "번 명언이 삭제되었습니다.");
                }
            }else{
                System.out.println("명령어를 잘못입력하셨습니다. 다시 입력해주세요.");
                continue;
            }
        }

        System.out.println("== 명언 앱 종료 ==");
    }

    public Motivation findId(int id) {
        for (int i = 0; i < motivations.size(); i++) {
            Motivation motivation = motivations.get(i);

            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }
}
