import java.util.Scanner;

public class C045 {
    // C045:ページネーション
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO 총게시물 수, 페이지별 게시물 수, 표시할 페이지를 취득한다.
        int totalArticles = sc.nextInt();
        int articlesPerPage = sc.nextInt();
        int pageNow = sc.nextInt();

        // TODO 총 페이지 수를 구한다.
        int totalPages = getTotalPage(totalArticles, articlesPerPage);
//        System.out.println("debug > totalPage : " + totalPages);
        // TODO 표시할 페이지의 게시물 번호를 출력한다.
        printPageArticleNos(totalPages, pageNow, articlesPerPage, totalArticles);
    }
    //
    private static void printPageArticleNos(int totalPages, int pageNow, int articlesPerPage, int totalArticles) {
        StringBuilder sb = new StringBuilder();
        // 해당 페이지의 첫번 째 게시글 번호
        int firstArticleNo = (pageNow - 1) * articlesPerPage + 1;
        if(totalPages > pageNow){ // 마지막 페이지가 아닌 경우
            for(int i = 0; i < articlesPerPage; i++){
                sb.append(firstArticleNo + i).append(" ");
            }
        } else if (totalPages == pageNow) { // 마지막 페이지인 경우
            for(int i = firstArticleNo; i <= totalArticles; i++){
                sb.append(i).append(" ");
            }
        }else{
            sb.append("none");
        }
        System.out.println(sb.toString().trim());
    }

    private static int getTotalPage(int totalArticles, int articlesPerPage) {
        int result;
        if( totalArticles % articlesPerPage != 0){
            result = totalArticles / articlesPerPage + 1;
        }else{
            result = totalArticles / articlesPerPage;
        }
        return result;
    }
}
