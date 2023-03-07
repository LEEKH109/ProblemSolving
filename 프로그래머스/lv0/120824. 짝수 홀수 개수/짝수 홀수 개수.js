function solution(num_list) {
    let odd = 0;
    let even =0;
    for(el of num_list){
        el%2===0 ? even++ : odd++
    }
    return   [even, odd];
}