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
  const a = input[0];
  const b = input[1];
          
   console.log(a+b);
   console.log(a-b);
   console.log(a*b);
   console.log(Math.floor(a/b));
   console.log(a%b);
  process.exit();
});