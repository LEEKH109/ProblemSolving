function solution(keyinput, board) {
    let x=0, y=0;
    // for(el of keyinput){
    //     if(el === 'up' && Math.abs(y)<(board[1]/2) ) y++
    //     if(el === 'down' && Math.abs(y)<(board[1]/2) ) y--
    //     if(el === 'left' && Math.abs(x)<(board[0]/2) ) x--
    //     if(el === 'right' && Math.abs(x)<(board[0]/2) ) x++                 
    // }
    for (el of keyinput) {
        if (el === "right" && x + 1 < (board[0] / 2)) x++ 
        if (el === "left" && x - 1 > -(board[0] / 2)) x-- 
        if (el === "up" && y + 1 < (board[1] / 2)) y++
        if (el === "down" && y - 1 > -(board[1] / 2)) y--
    }
    return [x,y];
}