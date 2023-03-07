function solution(num_list) {
    // 첫번째 풀이
    // let odd = 0;
    // let even =0;
    // for(el of num_list){
    //     el%2===0 ? even++ : odd++
    // }
    // return [even, odd];
    // arr.filter 사용
    return [num_list.filter(el => el%2 === 0).length, num_list.filter(el => el%2 === 1).length];
    // reduce 사용
    // return list.reduce((acc, cur) => (cur & 1 ? acc[1]++ : acc[0]++, acc), [0, 0])
}