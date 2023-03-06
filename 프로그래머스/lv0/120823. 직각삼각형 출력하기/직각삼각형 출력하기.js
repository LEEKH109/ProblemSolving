const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    // 첫번째 풀이
    // let printStar = ''
    // for(i=0;i<input[0];i++){
    //     printStar = printStar+'*'
    //     console.log(printStar)
    // }
    // 두번째 풀이 => .repeat() 사용
    for(i=1;i<=input[0];i++){
        console.log('*'.repeat(i))
    }
    
});