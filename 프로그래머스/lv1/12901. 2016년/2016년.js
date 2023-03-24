function solution(a, b) {
    // 첫 번째 풀이
    let month = [{1 : 31},{2 : 29},{3 : 31},{4 : 30},{5 : 31},{6 : 30},
                {7 : 31},{8 : 31},{9 : 30},{10 : 31},{11 : 30},{12 : 31}]
    let week = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    // 이전 달 까지의 모든 일 수 + 1월 1일의 하루 빼기 + 이번달 일 수 b
    let totalDate = b - 1 + month.slice(0,a-1).reduce((acc, cur) => acc + Number(Object.values(cur)), 0);
    return week[totalDate%7]
}