const readline = require("readline");
const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];
rl.on("line", (line) => {
  input = line.split(" ").map((value) => parseInt(value));
  rl.close();
});
 
rl.on("close", () => {
  const i = input[0];
           for(j=1; j<=9; j++){
               console.log(`${i} * ${j} = ${i*j}`)
           }
 
  process.exit();
});