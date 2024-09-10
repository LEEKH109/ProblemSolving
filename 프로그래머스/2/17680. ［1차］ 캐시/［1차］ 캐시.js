function solution(cacheSize, cities) {
    // 첫 번째 풀이 시간 복잡도 O(n)
    if(cacheSize === 0) return cities.length*5;
    
    cities = cities.map(el => el.toLowerCase());
    let stack = Array(cacheSize).fill('');
    let time = 0;
    for(city of cities){
        if(stack.includes(city)){
            let test = stack.filter(el => el !== city)
            stack = [...test,city];
            time++;
        }else{
            stack = [...stack.slice(1),city];
            time+=5;
        }
    }
    
    return time;
//      // 다른 분의 풀이를 보고 리팩토링
//     const MISS = 5, HIT = 1;

//     if (cacheSize === 0) return MISS * cities.length;

//     let answer = 0,
//         cache = [];

//     cities.forEach(city => {
//         city = city.toLowerCase();

//         let idx = cache.indexOf(city);

//         if (idx > -1) {
//             cache.splice(idx, 1);
//             answer += HIT;
//         } else {
//             if (cache.length >= cacheSize) cache.shift();
//             answer += MISS;
//         }

//         cache.push(city);
//     });

//     return answer;
}

// 테스트 케이스2 예시
// [,,제주]5
// [,제주,판교]5
// [제주,판교,서울]5
// [판교,서울,제주]1
// [서울,제주,판교]1
// [제주,판교,서울]1
// [판교,서울,제주]1
// [서울,제주,판교]1
// [제주,판교,서울]1