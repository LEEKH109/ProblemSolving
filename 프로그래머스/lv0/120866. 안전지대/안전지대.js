function solution(board) {
    // 첫 번째 풀이
    // let result = Array.from({length: board.length}, () => Array.from({length: board.length}, () => 0));
    // const n = board.length;
    // for(let i=0; i<n; i++){
    //     for(let j=0; j<n; j++){
    //         if(board[i][j] === 1){
    //             result[i][j] = 1;
    //             if(i-1 >= 0 && j-1 >= 0) result[i-1][j-1] = 1;
    //             if(i-1 >= 0) result[i-1][j] = 1;
    //             if(i-1 >= 0 && j+1 < n) result[i-1][j+1] = 1;
    //             if(j-1 >= 0) result[i][j-1] = 1;
    //             if(j+1 < n) result[i][j+1] = 1;
    //             if(i+1 < n && j-1 >= 0) result[i+1][j-1] = 1;
    //             if(i+1 < n) result[i+1][j] = 1;
    //             if(i+1 < n && j+1 < n) result[i+1][j+1] = 1;
    //         }
    //     }
    // }
    // let count = 0;
    // for (let a = 0; a < n; a++) {
    //     for (let b = 0; b < n; b++) {
    //         if (result[a][b] === 0) {
    //             count++;
    //         }
    //     }
    // }
    // return count;
    // 다른 분 풀이
    let outside = [[-1,0], [-1,-1], [-1,1], [0,-1],[0,1],[1,0], [1,-1], [1,1]];
    let safezone = 0;

    board.forEach((row, y, self) => row.forEach((it, x) => {
        if (it === 1) return false;
        return outside.some(([oy, ox]) => !!self[oy + y]?.[ox + x])
               ? false : safezone++;
    }));

    return safezone;
}
