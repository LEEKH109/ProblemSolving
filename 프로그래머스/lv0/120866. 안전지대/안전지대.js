function solution(board) {
    let result = Array.from({length: board.length}, () => Array.from({length: board.length}, () => 0));
    const n = board.length;
    for(let i=0; i<n; i++){
        for(let j=0; j<n; j++){
            if(board[i][j] === 1){
                result[i][j] = 1;
                if(i-1 >= 0 && j-1 >= 0) result[i-1][j-1] = 1;
                if(i-1 >= 0) result[i-1][j] = 1;
                if(i-1 >= 0 && j+1 < n) result[i-1][j+1] = 1;
                if(j-1 >= 0) result[i][j-1] = 1;
                if(j+1 < n) result[i][j+1] = 1;
                if(i+1 < n && j-1 >= 0) result[i+1][j-1] = 1;
                if(i+1 < n) result[i+1][j] = 1;
                if(i+1 < n && j+1 < n) result[i+1][j+1] = 1;
            }
        }
    }
    let count = 0;
    for (let a = 0; a < n; a++) {
        for (let b = 0; b < n; b++) {
            if (result[a][b] === 0) {
                count++;
            }
        }
    }
    return count;
}
