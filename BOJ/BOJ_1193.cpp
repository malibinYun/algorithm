#pragma warning(disable: 4819)
//
// Created by Malibin on 2019-08-19.
//

// 1193 분수 찾기
//
//문제
//      무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
//
//      1/1	1/2	1/3	1/4	1/5	…
//      2/1	2/2	2/3	2/4	…	…
//      3/1	3/2	3/3	…	…	…
//      4/1	4/2	…	…	…	…
//      5/1	…	…	…	…	…
//      …	…	…	…	…	…
//      이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
//
//      X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
//
//입력
//      첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
//
//출력
//      첫째 줄에 분수를 출력한다.
//
//예제 입출력
//      14 -> 2/4
#include <iostream>

using namespace std;

int main() {

    int input;
    cin >> input;

    int count = 1;
    bool isEven = false;
    while (input > count) {
        input -= count++;
        isEven = !isEven;
    }

    //cout << "input : " << input << " count : " << count << " isEven : " << isEven << endl << endl;

    int x, y;

    if (isEven) {
        x = 1;
        y = count;
        for (int i = 0; i < input - 1; i++) {
            x++;
            y--;
        }
    } else {
        x = count;
        y = 1;
        for (int i = 0; i < input - 1; i++) {
            x--;
            y++;
        }
    }

    cout << x << "/" << y << endl << endl;


    return 0;
}

// count = 대각선 몇 번째 라인인지
// input = 그 대각선의 몇 번째 인지
// isEven = 대각선이 위/아래 방향 순서 0 : 위 1: 아래