const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line',function(e) {
       const input = parseInt(e);
        if (input>=90){console.log('A');}
        else if (input>=80){console.log('B');}
        else if (input>=70){console.log('C');}
        else if (input>=60){console.log('D');}
        else{console.log('F');}
   rl.close();
});