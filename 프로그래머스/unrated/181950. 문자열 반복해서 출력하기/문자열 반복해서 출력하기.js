const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    str = '';
    for (i=0; i < input[1]; i++) {
        str+=input[0]
    }
    console.log(str)
});