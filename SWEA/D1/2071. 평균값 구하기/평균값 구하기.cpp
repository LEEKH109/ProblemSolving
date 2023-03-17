#include <iostream>
#include <cmath>
using namespace std;
int main() {
    int T, n;
    cin >> T;
    for(int tc=1; tc<=T; tc++) {
        int sum = 0;
        for(int i=0; i<10; i++) {
            cin >> n;
            sum+=n;
        }
        cout << "#" << tc << " " << round(sum/10.0) << endl;
    }
}
