const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line',function(e) {
   const input = e.split(' '),
      a = parseInt(input[0]),
      b = parseInt(input[1]);
        if(a > b) console.log('>');
        if(a < b) console.log('<');
        if(a === b) console.log('==');
   rl.close();
});