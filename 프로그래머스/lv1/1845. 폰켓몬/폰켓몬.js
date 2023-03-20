function solution(nums) {
    let total = nums.length/2
    let filteredArr = [...new Set(nums)].length;
    return filteredArr > total ? total : filteredArr
}