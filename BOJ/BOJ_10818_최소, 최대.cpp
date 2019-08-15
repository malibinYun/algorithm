
//문제
//        N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
//
//입력
//        첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
//        모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
//
//출력
//        첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
//

#include <iostream>

int maxCompare(int int1, int int2);

int minCompare(int int1, int int2);

using namespace std;

int main() {
    int max = -1000001;
    int min = 1000001;
    int count = 0;
    cin >> count;

    int *intArray = new int[count];
    for (int i = 0; i < count; i++) {
        cin >> intArray[i];
        max = maxCompare(max, intArray[i]);
        min = minCompare(min, intArray[i]);
    }

    cout << min << " " << max << endl;

    return 0;
}

int maxCompare(int int1, int int2) {
    return (int1 > int2) ? int1 : int2;
}

int minCompare(int int1, int int2) {
    return (int1 < int2) ? int1 : int2;
}