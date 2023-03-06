const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    let printStar = ''
    for(i=0;i<input[0];i++){
        printStar = printStar+'*'
        console.log(printStar)
    }
});