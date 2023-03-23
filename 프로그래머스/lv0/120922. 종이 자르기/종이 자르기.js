function solution(M, N) {
    if(M === 0) return N-1;
    if(N === 0) return M-1;
    return (M-1)+M*(N-1);
}