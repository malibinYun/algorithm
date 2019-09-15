////
//// Created by Malibin on 2019-09-07.
////
//
//#include <string>
//#include <vector>
//#include <iostream>
//
//using namespace std;
//
//vector<int> solution(vector<string> words, vector<string> queries) {
//
//    vector<int> answer;
////    string prefix, suffix;
//
//    for (string query: queries) {
//        int count = 0;
//        bool sameFlag = false;
//        //       prefix = "", suffix = "";
//        bool isPrefix = false, isSuffix = false, allWild = false;
//
//
//        if (query.find('?') == 0) {
//            isSuffix = true;
//
//            if (query[query.size() - 1] == '?') {
//                allWild = true;
//            }
////            for (char c: query) {
////                if (c == '?') {
////                    continue;
////                }
////                suffix += c;
////            }
//        } else {
//            isPrefix = true;
////            for (char c: query) {
////                if (c == '?') {
////                    continue;
////                }
////                prefix += c;
////            }
//        }
//
//
////        for (string word : words) {
////            if (query.size() == word.size()) {
////                if (prefix == "") { //접미사 대조
////
////                    for (int i = 0; i < suffix.size(); i++) {
////                        int size = word.size() - 1;
////                        sameFlag = word[size - i] == query[size - i];
////                    }
////                    if (sameFlag) {
////                        count++;
////                    }
////
////                } else {//접두사 대조
////
////                    for (int i = 0; i < prefix.size(); i++) {
////                        sameFlag = word[i] == query[i];
////                    }
////                    if (sameFlag) {
////                        count++;
////                    }
////                }
////            }
////        }
//        for (string word : words) {
//            if (query.size() == word.size()) {
//                if (allWild) {
//                    count++;
//                } else if (isSuffix) { //접미사 대조
//
//                    int size = word.size() - 1;
//                    for (int i = 0; i < word.size(); i++) {
//                        if (query[size - i] == '?') break;
//                        sameFlag = word[size - i] == query[size - i];
//                    }
//                    if (sameFlag) {
//                        count++;
//                    }
//
//                } else {//접두사 대조
//
//                    for (int i = 0; i < word.size(); i++) {
//                        if (query[i] == '?') break;
//                        sameFlag = word[i] == query[i];
//                    }
//                    if (sameFlag) {
//                        count++;
//                    }
//                }
//            }
//        }
//
//        answer.push_back(count);
//    }
//    return answer;
//}
//
//int main() {
//
//    vector<string> words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
//    vector<string> queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
//
//    for (int i :solution(words, queries)) {
//        cout << i << endl;
//    }
//
//    return 0;
//}