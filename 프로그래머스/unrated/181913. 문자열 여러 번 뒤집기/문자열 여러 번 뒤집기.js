function solution(my_string, queries) {
    let my_strArr = my_string.split('');

    for(const [start, end] of queries){
        let substring = my_strArr.slice(start, end+1).reverse();
        my_strArr = [...my_strArr.slice(0,start), ...substring, ...my_strArr.slice(end+1)];
    }

    return my_strArr.join('');
}