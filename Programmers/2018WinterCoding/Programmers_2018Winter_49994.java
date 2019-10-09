// 방문 길이

//문제 설명
//게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
//
//U: 위쪽으로 한 칸 가기
//
//D: 아래쪽으로 한 칸 가기
//
//R: 오른쪽으로 한 칸 가기
//
//L: 왼쪽으로 한 칸 가기
//
//캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
//
//image
//
//예를 들어, ULURRDLLU로 명령했다면
//
//image
//
//1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.
//image
//
//8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.
//image
//
//이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다. 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다. (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)
//
//단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
//
//예를 들어, LULLLLLLU로 명령했다면
//
//image
//
//1번 명령어부터 6번 명령어대로 움직인 후, 7, 8번 명령어는 무시합니다. 다시 9번 명령어대로 움직입니다.
//image
//
//이때 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.
//
//명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.
//
//제한사항
//dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
//dirs의 길이는 500 이하의 자연수입니다.
//입출력 예
//dirs	answer
//ULURRDLLU	7
//LULLLLLLU	7
//입출력 예 설명
//입출력 예 #1
//문제의 예시와 같습니다.
//
//입출력 예 #2
//문제의 예시와 같습니다.

import java.util.ArrayList;

public class Programmers_2018Winter_49994 {

    private double x = 0d;
    private double y = 0d;
    private ArrayList<Location> memory = new ArrayList<>();

    public static void main(String[] args) {
        String stub1 = "ULURRDLLU";
        String stub2 = "LULLLLLLU";

        Programmers_2018Winter_49994 clazz = new Programmers_2018Winter_49994();

        System.out.println(clazz.solution(stub1));
    }

    public int solution(String dirs) {

        for (char c : dirs.toCharArray()) {

            switch (c) {
                case 'U':
                    y += 0.5;
                    if (y > 5) {
                        y = 5;
                        continue;
                    }
                    putRoadLocation();
                    y += 0.5;
                    break;

                case 'D':
                    y -= 0.5;
                    if (y < -5) {
                        y = -5;
                        continue;
                    }
                    putRoadLocation();
                    y -= 0.5;
                    break;

                case 'R':
                    x += 0.5;
                    if (x > 5) {
                        x = 5;
                        continue;
                    }
                    putRoadLocation();
                    x += 0.5;
                    break;

                case 'L':
                    x -= 0.5;
                    if (x < -5) {
                        x = -5;
                        continue;
                    }
                    putRoadLocation();
                    x -= 0.5;
                    break;
            }
        }

        return memory.size();
    }

    private void putRoadLocation() {
        Location road = new Location(x, y);
        if (!memory.contains(road)) {
            memory.add(road);
        }
    }

    class Location {
        private double x, y;

        Location(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Location tmp = (Location) o;
            return tmp.x == this.x && tmp.y == this.y;
        }
    }
}
