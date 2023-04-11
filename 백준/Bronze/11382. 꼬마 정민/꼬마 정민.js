var readline = require('readline');

var rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line',function(answer) {
   var input = answer.split(' '),
      a = parseInt(input[0]),
      b = parseInt(input[1]);
      c = parseInt(input[2]);

   console.log(a+b+c);
   rl.close();
});