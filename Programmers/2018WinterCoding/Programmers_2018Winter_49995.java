// 쿠키 구입
//문제 설명
//과자를 바구니 단위로 파는 가게가 있습니다. 이 가게는 1번부터 N번까지 차례로 번호가 붙은 바구니 N개가 일렬로 나열해 놨습니다.
//
//철수는 두 아들에게 줄 과자를 사려합니다. 첫째 아들에게는 l번 바구니부터 m번 바구니까지, 둘째 아들에게는 m+1번 바구니부터 r번 바구니까지를 주려합니다. 단, 두 아들이 받을 과자 수는 같아야 합니다(1 <= l <= m, m+1 <= r <= N). 즉, A[i] 를 i번 바구니에 들어있는 과자 수라고 했을 때, A[l]+..+A[m] = A[m+1]+..+A[r] 를 만족해야 합니다.
//
//각 바구니 안에 들은 과자 수가 차례로 들은 배열 cookie가 주어질 때, 조건에 맞게 과자를 살 경우 한 명의 아들에게 줄 수 있는 가장 많은 과자 수를 return 하는 solution 함수를 완성해주세요. (단, 조건에 맞게 과자를 구매할 수 없다면 0을 return 합니다)
//
//제한사항
//cookie의 길이는 1 이상 2,000 이하입니다.
//cookie의 각각의 원소는 1 이상 500 이하인 자연수입니다.
//입출력 예
//cookie	result
//[1,1,2,3]	3
//[1,2,4,5]	0
//입출력 예 설명
//입출력 예 #1
//
//첫째 아들에게 2, 3번 바구니를, 둘째 아들에게 4번 바구니를 사주면 두 아들은 각각 과자 3개를 받습니다.
//
//입출력 예 #2
//
//주어진 조건에 맞게 과자를 살 방법이 없습니다.

public class Programmers_2018Winter_49995 {

    public static void main(String[] args) {
        int[] stub1 = {1, 1, 2, 3};
        int[] stub2 = {1, 2, 4, 5};
        int[] stub3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] stub4 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        int[] stub5 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; //29
        int[] stub6 = {1, 499, 500};
        int[] stub7 = {5, 5, 5, 5, 5, 5, 5, 10, 10, 10};
        int[] stub8 = new int[2000];
        for (int i = 0; i < 2000; i++) {
            stub8[i] = 500;
        }

        System.out.println(solution(stub1));
        System.out.println(solution(stub2));
    }

//    public static int solution(int[] cookie) {
//        int max = 0;
//
//        if (cookie.length == 1) {
//            return 0;
//        }
//        if (cookie.length == 2) {
//            return cookie[0] == cookie[1] ? cookie[0] : 0;
//        }
//
//        for (int m = 0; m < cookie.length - 1; m++) {
//            int n = m + 1;
//            int son1 = 0;
//            int son2 = cookie[n];
//
//            System.out.println("index changed");
//
//            for (int i = m; i >= 0; i--) {
//                son1 += cookie[i];
//
//                System.out.println("son1 : " + son1 + ", son2 : " + son2);
//                if (son1 == son2) {
//                    if (max < son1) {
//                        max = son1;
//                    }
//                }
//                if (son1 > son2) {
//                    if (n == cookie.length - 1) {
//                        break;
//                    }
//                    son2 += cookie[n + 1];
//                    n++;
//                    System.out.println("son1 : " + son1 + ", son2 : " + son2 + " son2 increased");
//                    if (son1 == son2) {
//                        if (max < son1) {
//                            max = son1;
//                        }
//                    }
//                }
//            }
//        }
//        return max;
//    }

    public static int solution(int[] cookie) {
        int max = 0;

        if (cookie.length < 2) {
            return 0;
        }
        if (cookie.length == 2) {
            return cookie[0] == cookie[1] ? cookie[0] : 0;
        }

        for (int i = 0; i < cookie.length - 1; i++) {
            int indexOfSon1 = i;
            int indexOfSon2 = i + 1;

            int son1 = cookie[indexOfSon1];
            int son2 = cookie[indexOfSon2];

            while (true) {
                if (son1 == son2) {
                    max = Math.max(son1, max);
                }

                if (indexOfSon1 > 0 && son1 <= son2) {
                    indexOfSon1--;
                    son1 += cookie[indexOfSon1];
                } else if (indexOfSon2 < cookie.length - 1 && son1 >= son2) {
                    indexOfSon2++;
                    son2 += cookie[indexOfSon2];
                } else {
                    break;
                }
            }

        }
        return max;
    }
}
