import java.util.Scanner;

public class C045_GPT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalArticles = sc.nextInt();
        int articlesPerPage = sc.nextInt();
        int pageNumber = sc.nextInt();

        Pagination pagination = new Pagination(totalArticles, articlesPerPage, pageNumber);
        pagination.displayPageArticles();
    }
}

// 나랑 다르게 코딩한 부분 1. 객체지향으로 코드를 작성했다.
class Pagination{
    private int totalArticles;
    private int articlesPerPage;
    private int pageNumber;

    public Pagination(int totalArticles, int articlesPerPage, int pageNumber){
        this.totalArticles = totalArticles;
        this.articlesPerPage = articlesPerPage;
        this.pageNumber = pageNumber;
    }
    // Pagination객체에 설정된 필드를 바탕으로 현재 페이지의 게시물 번호를 출력해주는 함수
    public void displayPageArticles(){
        // 총 페이지 수의 계산
        int totalPages = calculateTotalPages();
        // 총 페이지 수를 넘어가는 페이지를 조회한다면 return "none"

        // 나랑 다르게 코딩한 부분 2. 결과 출력에 필요한 것이 정확히 무엇인지 알았다.
        // 페이지의 첫번 째 게시물 번호
        // 페이지의 마지막 게시물 번호
    }

    // 총 페이지수를 계산하는 함수
    private int calculateTotalPages() {
        return 0;
    }
}