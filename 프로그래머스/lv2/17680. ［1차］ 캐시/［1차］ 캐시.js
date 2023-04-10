function solution(cacheSize, cities) {
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