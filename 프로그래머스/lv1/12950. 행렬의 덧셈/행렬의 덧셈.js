function solution(arr1, arr2) {
    let resultArr = [];
    for(i = 0; i < arr1.length; i++){
      resultArr.push(arr1[i].map((x, y) => arr1[i][y] + arr2[i][y]));
    }
    return resultArr;
}